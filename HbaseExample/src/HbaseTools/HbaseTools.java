package HbaseTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.ColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.FamilyFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.ValueFilter;
import org.apache.hadoop.hbase.util.Bytes;


public class HbaseTools {

	private static Configuration conf;
	private static Connection con;
	private static Admin admin;

	public static void main(String[] args) throws IOException {
		init();
		// isTableExist("Student");
		// createTable("Student2", new String[] {"Info","Grade"});
		// addColumnFamily("Student1","class");
		// putTable("Student1", "row1", "Info", "name", "ZICHAO"); /*单条数据-插入*/
		/*多条数据-插入*/
		/*  putTables("Student1", new String[] { "row1", "Grade", "major", "Big Data",
		  "row1", "class", "year", "2020", "row2", "Info", "sex", "male",
		  "row2","Grade", "major", "JAVA", "row2", "class", "year", "2021" });
		*/
		// deleteColumnFamily("Student1","class");
		// deleteTable("Student2");
		// getInfo("Student1", "row1", "Info", "");
		// scanInfo("Student1", "Info", "");
		// filterByRK("Student1","row2");
		// filterRKValue("Student1","row1");
		// filterCFValue("Student1","Info");
		// filterColumnValue("Student1","maj");
		// filterValue("Student1","Big Data");
		close();
	}
	
	//按值value过滤查询
	public static void filterValue(String tableName, String valueKeyText) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		Table table = con.getTable(tb);
		Scan scan = new Scan();
		BinaryComparator bc = new BinaryComparator(Bytes.toBytes(valueKeyText));
		Filter filter = new ValueFilter(CompareOperator.EQUAL,bc);
		scan.setFilter(filter);
		ResultScanner results = table.getScanner(scan);
		for(Result result:results) {
			Cell[] cells = result.rawCells();
			printRecoder(cells);
		}
		table.close();
	}
	
	//按列限定符关键字过滤查询
	public static void filterColumnValue(String tableName, String columnKeyText) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		Table table = con.getTable(tb);
		Scan scan = new Scan();
		Filter filter = new ColumnPrefixFilter(Bytes.toBytes(columnKeyText));
		scan.setFilter(filter);
		ResultScanner results = table.getScanner(scan);
		for(Result result:results) {
			Cell[] cells = result.rawCells();
			printRecoder(cells);
		}
		table.close();
	}
	
	//按列簇名称CF过滤查询
	public static void filterCFValue(String tableName, String cfKeyText) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		Table table = con.getTable(tb);
		Scan scan = new Scan();
		BinaryComparator bc = new BinaryComparator(Bytes.toBytes(cfKeyText));
		Filter filter = new FamilyFilter(CompareOperator.EQUAL,bc);
		scan.setFilter(filter);
		ResultScanner results = table.getScanner(scan);
		for(Result result:results) {
			Cell[] cells = result.rawCells();
			printRecoder(cells);
		}
		table.close();
	}
	
	//按行键关键字过滤查询（可多行）
	public static void filterRKValue(String tableName, String rKeyText) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		Table table = con.getTable(tb);
		Scan scan = new Scan();
		Filter filter = new PrefixFilter(Bytes.toBytes(rKeyText));
		scan.setFilter(filter);
		ResultScanner results = table.getScanner(scan);
		for(Result result:results) {
			Cell[] cells = result.rawCells();
			printRecoder(cells);
		}
		table.close();
	}
	
	//按行键名称RK过滤查询（一行）
	public static void filterByRK(String tableName, String rk) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		Table table = con.getTable(tb);
		Scan scan = new Scan();
		BinaryComparator bc = new BinaryComparator(Bytes.toBytes(rk));
		Filter filter = new RowFilter(CompareOperator.EQUAL,bc);
		scan.setFilter(filter);
		ResultScanner results = table.getScanner(scan);
		for(Result result:results) {
			Cell[] cells = result.rawCells();
			printRecoder(cells);
		}
		table.close();	
	}
	
	// scan查询
	public static void scanInfo(String tableName, String cf, String qu) throws IOException{
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		Table table = con.getTable(tb);
		Scan scan = new Scan();
		if (!cf.equals("") && !cf.equals(null)) {
			if (!qu.equals("") && !qu.equals(null)) {
				scan.addColumn(Bytes.toBytes(cf), Bytes.toBytes(qu));
			} else {
				scan.addFamily((Bytes.toBytes(cf)));
			}
		}
		ResultScanner results = table.getScanner(scan);
		for(Result result:results) {
			Cell[] cells = result.rawCells();
			printRecoder(cells);
		}
		table.close();
	}

	// get查询
	public static void getInfo(String tableName, String rk, String cf, String qu) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		Get get = new Get(Bytes.toBytes(rk));
		Table table = con.getTable(tb);
		if (!cf.equals("") && !cf.equals(null)) {
			if (!qu.equals("") && !qu.equals(null)) {
				get.addColumn(Bytes.toBytes(cf), Bytes.toBytes(qu));
			} else {
				get.addFamily((Bytes.toBytes(cf)));
			}
		}
		Result result = table.get(get);
		Cell[] cells = result.rawCells();
		printRecoder(cells);
		table.close();
	}

	// 查询打印
	public static void printRecoder(Cell[] cells) {
		for(Cell cell:cells) {
			System.out.println("*****************************");
			System.out.println("行键[" + new String(CellUtil.cloneRow(cell)) + "]");
			System.out.println("列簇[" + new String(CellUtil.cloneFamily(cell)) + "]");
			System.out.println("列限定符[" + new String(CellUtil.cloneQualifier(cell)) + "]");
			System.out.println("值[" + new String(CellUtil.cloneValue(cell)) + "]");
			System.out.println("时间戳[" + cell.getTimestamp() +"]");
			System.out.println("*****************************");
		}
	}
	
	// 删除表
	public static void deleteTable(String tableName) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		admin.disableTable(tb);
		admin.deleteTable(tb);
		System.out.println("表[" + tb + "]删除成功");
	}

	// 删除列簇
	public static void deleteColumnFamily(String tableName, String cf) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		admin.deleteColumnFamily(tb, Bytes.toBytes(cf));
		System.out.println("列簇[" + cf + "]删除成功");
	}

	// 插入数据（多条）
	public static void putTables(String tableName, String[] args) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		int n = 0;
		for (int j = 0; j <= args.length; n++) {
			String rk = args[0 + (4 * n)];
			String cf = args[1 + (4 * n)];
			String qu = args[2 + (4 * n)];
			String value = args[3 + (4 * n)];
			Table table = con.getTable(TableName.valueOf(tableName));
			Put put = new Put(Bytes.toBytes(rk));
			put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(qu), Bytes.toBytes(value));
			table.put(put);
			System.out.println("表[" + tableName + "]中加rowkey=[" + rk + "],Column=[" + cf + ":" + qu + "],value=[" + value + "].");
			table.close();
		}
	}

	// 插入数据（单条）
	public static void putTable(String tableName, String rk, String cf, String qu, String value) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		Table table = con.getTable(TableName.valueOf(tableName));
		Put put = new Put(Bytes.toBytes(rk));
		put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(qu), Bytes.toBytes(value));
		table.put(put);
		System.out.println("表[" + tableName + "]中加rowKey=[" + rk + "],Column=[" + cf + ":" + qu + "],value=[" + value + "].");
		table.close();
	}

	// 新增列簇
	public static void addColumnFamily(String tableName, String cf) throws IOException {
		if (!isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]不存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		ColumnFamilyDescriptor cfd = ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(cf)).build();
		admin.addColumnFamily(tb, cfd);
		System.out.println("列簇[" + cfd + "]添加成功");
	}

	// 创建表
	public static void createTable(String tableName, String[] cfs) throws IOException {
		if (isTableExist(tableName)) {
			System.out.println("表[" + tableName + "]存在");
			return;
		}
		TableName tb = TableName.valueOf(tableName);
		List<ColumnFamilyDescriptor> list = new ArrayList<>();
		TableDescriptorBuilder tdb = TableDescriptorBuilder.newBuilder(tb);
		for (String cf : cfs) {
			ColumnFamilyDescriptor cfd = ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(cf)).build();
			list.add(cfd);
		}
		TableDescriptor td = tdb.setColumnFamilies(list).build();
		admin.createTable(td);
		System.out.println("表[" + tableName + "]创建成功！");

	}

	// 初始化连接
	public static void init() {
		conf = HBaseConfiguration.create();
		conf.set("hbase.rootdir", "hdfs://192.168.29.10:8020/hbase");
		conf.set("hbase.master", "hdfs://192.168.29.10:16010");
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		conf.set("hbase.zookeeper.quorum", "master,slave1,slave2");
		try {
			con = ConnectionFactory.createConnection(conf);
			admin = con.getAdmin();
		} catch (IOException e) {
			System.out.println("连接异常！");
			e.printStackTrace();
		}
	}

	// 关闭连接
	public static void close() throws IOException {
		if (admin != null) {
			admin.close();
		}
		if (con != null) {
			con.close();
		}
	}

	// 表是否存在
	public static boolean isTableExist(String tableName) throws IOException {
		TableName tb = TableName.valueOf(tableName);
		if (admin.tableExists(tb)) {
			System.out.println("表[" + tableName + "]存在");
			return true;
		} else {
			System.out.println("表[" + tableName + "]不存在");
			return false;
		}
	}
}
