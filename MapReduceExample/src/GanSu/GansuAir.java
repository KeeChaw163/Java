package GanSu;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class GansuAir {
	static class GansuMapper extends Mapper<LongWritable, Text, Text, Text>{

		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String name = value.toString();
			context.write(new Text(name), new Text(""));
		}
	}
    static class AirMapper extends Mapper<LongWritable, Text, Text, Text>{
    	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] lines = value.toString().split(" ");
		context.write(new Text(lines[0]),new Text(lines[1]));
		}
	}
}
