package Sort;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SortJobMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		System.setProperty("HADOOP_USER_NAME", "root");
		
		String[] filespath = {
				"hdfs://192.168.29.10:8020/datasets/Sort1.txt",
				"hdfs://192.168.29.10:8020/datasets/Sort2.txt",
		};
		
		String outputPath= "hdfs://192.168.29.10:8020/results/results3";
		
		Job job = Job.getInstance();
		job.setJarByClass(SortJobMain.class);
		job.setMapperClass(SortMapper.class);
		job.setReducerClass(SortReducer.class);
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		for(String path:filespath) {
			FileInputFormat.addInputPath(job, new Path(path));
		}
		
		FileOutputFormat.setOutputPath(job, new Path(outputPath)); 
		System.out.println("hadoop 开始运行！");
		long st = System.currentTimeMillis();
		boolean result = job.waitForCompletion(true);
		long et = System.currentTimeMillis();
		System.out.println("Mapreduce运行时间："+(et-st)/1000 + "秒");
		System.exit(result?0:1);
	}
}
