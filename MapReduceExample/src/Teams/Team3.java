package Teams;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Team3 {
	static class TeamMapper3 extends Mapper<LongWritable,Text,Text,LongWritable>{
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    		String lines[] = value.toString().trim().split(",");
            if (null != lines && lines.length > 1&& !lines[0].isEmpty()) {
                if (lines[0].equals("山西省")) {
                    context.write(new Text(lines[1]), new LongWritable(1));
                    }
            }
		}
	}
	
	static class TeamReducer3 extends Reducer<Text,LongWritable,Text,DoubleWritable>{
        double all = 0;
        Map<String,Long> maps = new HashMap<String,Long>();
        public void reduce(Text key, Iterable<LongWritable> values, Context context) throws
                IOException, InterruptedException {
            long count = (long)0;
            for (LongWritable value : values) {
                count += value.get();
            }
            all += count;
            maps.put(key.toString(),count);
        }

        public void cleanup(
                org.apache.hadoop.mapreduce.Reducer<Text,LongWritable,Text, DoubleWritable>.Context context
        ) throws IOException, InterruptedException {
            Set<String> keySet = maps.keySet();
            for (String str : keySet) {
                long value = maps.get(str);
                double bili = (value/all*100);
                BigDecimal bigDecimal = new BigDecimal(bili);
                @SuppressWarnings("deprecation")
				double f1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                context.write(new Text(str),new DoubleWritable(f1));
            }
        }
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		System.setProperty("HADOOP_USER_NAME", "root");
		String filespath = "hdfs://192.168.29.10:8020/datasets/shanxi_cars.csv";
		
		String outputPath= "hdfs://192.168.29.10:8020/results/results12";
		// 创建job和任务入口
		// job：map函数和reduce函数组织起来的组件
		Job job = Job.getInstance();
		job.setJobName("3.统计不同月份的汽车销量占比 :");
		job.setJarByClass(Team3.class);
		job.setMapperClass(Team3.TeamMapper3.class);
		job.setReducerClass(Team3.TeamReducer3.class);
		// 设置map、reduce输出类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		// 指定job输入输出
		FileInputFormat.setInputPaths(job, new Path(filespath));
		FileOutputFormat.setOutputPath(job, new Path(outputPath)); 
		// 执行job
		System.out.println("3.统计不同月份的汽车销量占比 :");
		System.out.println("MR开始运行***********************************************");
		long st = System.currentTimeMillis();
		boolean result = job.waitForCompletion(true);
		long et = System.currentTimeMillis();
		System.out.println("Mapreduce运行时间："+(et-st)/1000 + "秒");
		System.exit(result?0:1);
	}
}
