package Teams;

import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Team5 {
	static class TeamMapper5 extends Mapper<LongWritable, Text, Text, IntWritable> {
		public void map(LongWritable key,Text values,Context context) throws IOException, InterruptedException {
			if (key.toString().equals("0"))
				return;
			String [] car_count = values.toString().trim().split(",");
			if( car_count!=null && car_count.length > 11  && car_count[2] != null && car_count[1] != null && !car_count[1].equals("")&& !car_count[2].equals("")) 
				context.write(new Text(car_count[2]+'\t'+car_count[1]), new IntWritable(1));
		}
	}
	
	
	static class TeamReducer5 extends Reducer<Text,IntWritable,Text,IntWritable>{
		public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable v : values) {
				sum = sum + v.get();
			}
			context.write(key, new IntWritable(sum));
		}
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		System.setProperty("HADOOP_USER_NAME", "root");
		String filespath = "hdfs://192.168.29.10:8020/datasets/shanxi_cars.csv";
		
		String outputPath= "hdfs://192.168.29.10:8020/results/results14";
		// 创建job和任务入口
		// job：map函数和reduce函数组织起来的组件
		Job job = Job.getInstance();
		job.setJobName("5.统计不同城市不同月份的汽车总销量:");
		job.setJarByClass(Team5.class);
		job.setMapperClass(Team5.TeamMapper5.class);
		job.setReducerClass(Team5.TeamReducer5.class);
		// 设置map、reduce输出类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		// 指定job输入输出
		FileInputFormat.setInputPaths(job, new Path(filespath));
		FileOutputFormat.setOutputPath(job, new Path(outputPath)); 
		// 执行job
		System.out.println("5.统计不同城市不同月份的汽车总销量:");
		System.out.println("MR开始运行***********************************************");
		long st = System.currentTimeMillis();
		boolean result = job.waitForCompletion(true);
		long et = System.currentTimeMillis();
		System.out.println("Mapreduce运行时间："+(et-st)/1000 + "秒");
		System.exit(result?0:1);
	}
}
