package Dup;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DupMain {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		System.setProperty("HADOOP_USER_NAME", "root");
		
		Job job = Job.getInstance();
		job.setJarByClass(DupMain.class);
		job.setMapperClass(DupMapper.class);
		job.setReducerClass(DupReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		String[] filespath = {
				"hdfs://192.168.29.10:8020/datasets/duplicate1.txt",
				"hdfs://192.168.29.10:8020/datasets/duplicate2.txt",
		};
		
		String outputPath= "hdfs://192.168.29.10:8020/results/results2";
		
		for(int i =0;i<filespath.length;i++) {
			FileInputFormat.addInputPath(job, new Path(filespath[i]));
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
