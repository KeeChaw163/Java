package Rectangle;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class RectangleMain {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		System.setProperty("HADOOP_USER_NAME", "root");
		
		String filePath = "hdfs://192.168.29.10:8020/datasets/rectangle.txt";
		String outputPath = "hdfs://192.168.29.10:8020/results/results4";
		
		Job job =Job.getInstance();
		job.setJarByClass(RectangleMain.class);
		job.setMapperClass(RectangleMapper.class);
		job.setReducerClass(RectangleReducer.class);
		job.setMapOutputKeyClass(RectangleWritable.class);
		job.setMapOutputValueClass(NullWritable.class);
		job.setNumReduceTasks(2);
		job.setPartitionerClass(RectanglePartitioner.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(filePath));
		FileOutputFormat.setOutputPath(job, new Path(outputPath));
		// 执行job
		System.out.println("MR开始运行***********************************************");
		long startTime = System.currentTimeMillis();
		boolean result = job.waitForCompletion(true);
		long endTime = System.currentTimeMillis();
		System.out.println("MR运行时间：" + (endTime - startTime) / 1000 + "秒");
		System.exit(result ? 0 : 1);
		
	}
}
