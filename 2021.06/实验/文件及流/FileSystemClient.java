package shiyan;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class FileSystemClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); //获取控制台输人的内容
		//文件处理对象初始化
		FileOperator fo = new FileOperator();
		while(true) {
		     System.out.println("1--创建文件  2--删除文件  3--复制文件  4--执行文件  exit--退出系统：");
		     switch (scan.nextLine()){
		     case"1":
		 		fo.createFile(scan);
		 		break;
		     case"2":
		    	 fo.delFile(scan);
		    	 break;
		     case"3":
		    	 fo.copyFile(scan);
		    	 break;
		     case"4":
		    	 fo.execFile(scan);
		    	 break;
		     case"exit":
		    	 System.exit(0);
		    	 break;
		     default:
		    	 System.out.println("位置指令!请输入正确的指令：");
		    	 break;
		     }
		}
	}
}

	