package GanSu;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import GanSu.GansuAir.AirMapper;
import GanSu.GansuAir.GansuMapper;


public class GanSuMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("HADOOP_USER_NAME", "root");
		
		String[] filespath = {
				"hdfs://192.168.29.10:8020/datasets/gansu.txt",
				"hdfs://192.168.29.10:8020/datasets/gansu_airports.txt",
		};
		
		String outputPath= "hdfs://192.168.29.10:8020/results/results5";
		Job job = Job.getInstance();
		job.setJarByClass(GanSuMain.class);
		MultipleInputs.addInputPath(job,  new Path(filespath[0]), TextInputFormat.class,GansuMapper.class);
		MultipleInputs.addInputPath(job,  new Path(filespath[1]), TextInputFormat.class,AirMapper.class);
		FileOutputFormat.setOutputPath(job, new Path(outputPath));
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setReducerClass(GanSuReducer.class);
		System.out.println("hadoop 开始运行！");
		long st = System.currentTimeMillis();
		boolean result = job.waitForCompletion(true);
		long et = System.currentTimeMillis();
		System.out.println("Mapreduce运行时间："+(et-st)/1000 + "秒");
		System.exit(result?0:1);
	}

}
