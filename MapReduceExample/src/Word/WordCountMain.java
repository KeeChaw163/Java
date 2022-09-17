package Word;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCountMain {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
		System.setProperty("HADOOP_USER_NAME", "root");
		String[] otherArgs = {"hdfs://192.168.29.10:8020/datasets/news1.txt",
				"hdfs://192.168.29.10:8020/datasets/news2.txt",
			"hdfs://192.168.29.10:8020/results/results1"	
		};
		WordCountJob.jobConfig(otherArgs);
	}
}
