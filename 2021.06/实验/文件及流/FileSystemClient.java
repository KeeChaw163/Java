package shiyan;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class FileSystemClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); //��ȡ����̨���˵�����
		//�ļ���������ʼ��
		FileOperator fo = new FileOperator();
		while(true) {
		     System.out.println("1--�����ļ�  2--ɾ���ļ�  3--�����ļ�  4--ִ���ļ�  exit--�˳�ϵͳ��");
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
		    	 System.out.println("λ��ָ��!��������ȷ��ָ�");
		    	 break;
		     }
		}
	}
}

	