package shiyan;
import java.util.Scanner;
public class TestDianQi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc=new Scanner(System.in);
		    int dianya;
		    String pinpai;
		    System.out.println("ÊäÈë±ùÏäµçÑ¹");
		    System.out.println("ÊäÈë±ùÏäÆ·ÅÆ");
		    dianya=sc.nextInt();
		    pinpai=sc.nextLine();
		    
		    BingXiiang bx = new  BingXiiang();
		    bx.work();
		    bx.fare();
			}


	}


