   package chengji;
   import java.util.*;
   public class Test {
	   public static void main(String[] args) {
			// TODO Auto-generated method stub
		    String name;
		    String sex;
		    double sco1;
			double sco2;
			double sco3;
			double sco4;
			double sco5;
	        Scanner scan = new Scanner(System.in);
	        System.out.println("学生信息：");
	        name=scan.next();
	        sex=scan.next();
	        sco1=scan.nextInt();
	        sco2=scan.nextInt();
	        sco3=scan.nextInt();
	        sco4=scan.nextInt();
	        sco5=scan.nextInt();
	        StudentScore ss=new StudentScore();
	        ss.show();
	   
   
       }
    }