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

public class Team2 {
	static class TeamMapper2 extends Mapper<LongWritable,Text,Text,IntWritable>{
		public void map(LongWritable key,Text values,Context context) throws IOException, InterruptedException {
			if (key.toString().equals("0"))
				return;
			String [] sex_count = values.toString().trim().split(",");
			if(sex_count!=null && sex_count.length > 38  && sex_count[38] != null && !sex_count[38].equals("") && (sex_count[38].equals("男性") || sex_count[38].equals("女性"))) 
				context.write(new Text(sex_count[38]), new IntWritable(1));
		}
	}
						
	static class TeamReducer2 extends Reducer<Text,IntWritable,Text,IntWritable>{
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
		
		String outputPath= "hdfs://192.168.29.10:8020/results/results10";
		// 创建job和任务入口
		// job：map函数和reduce函数组织起来的组件
		Job job = Job.getInstance();
		job.setJobName("2.统计男性、女性购买汽车的总数量:");
		job.setJarByClass(Team2.class);
		job.setMapperClass(Team2.TeamMapper2.class);
		job.setReducerClass(Team2.TeamReducer2.class);
		// 设置map、reduce输出类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		// 指定job输入输出
		FileInputFormat.setInputPaths(job, new Path(filespath));
		FileOutputFormat.setOutputPath(job, new Path(outputPath)); 
		// 执行job
		System.out.println("2.统计男性、女性购买汽车的总数量:");
		System.out.println("MR开始运行***********************************************");
		long st = System.currentTimeMillis();
		boolean result = job.waitForCompletion(true);
		long et = System.currentTimeMillis();
		System.out.println("Mapreduce运行时间："+(et-st)/1000 + "秒");
		System.exit(result?0:1);
	}
}
