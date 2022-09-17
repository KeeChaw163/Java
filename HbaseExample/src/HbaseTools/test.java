package HbaseTools;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class test {
	
	private static Configuration conf;
	private static Connection con;
	private static Admin admin;
	
	public static void main(String[] args) throws IOException {	
		conf = HBaseConfiguration.create();
		conf.set("hbase.rootdir", "hdfs://192.168.29.10:8020/hbase");
		conf.set("hbase.master", "hdfs://192.168.29.10:16010");
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		conf.set("hbase.zookeeper.quorum", "master,slave1,slave2");
		con = ConnectionFactory.createConnection(conf);
		admin = con.getAdmin();
		String tn = "Student3";
		TableName arg0 = TableName.valueOf(tn);
		if(admin.tableExists(arg0)) {
			System.out.println("表存在");
		}else {
			System.out.println( "表不存在");
		}
		con.close();
		
	}
}
