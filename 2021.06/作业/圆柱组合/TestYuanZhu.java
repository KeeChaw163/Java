package lianxi;
import java.util.Scanner;
//调用系统的输入类
public class TestYuanZhu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("请输入圆柱的半径和高：");
			Scanner scan = new Scanner(System.in);
			//定义圆柱半径，高，半径算周长得侧面的长
			double b,g,z;
		    b=scan.nextDouble();
		    g=scan.nextDouble();
		    z=Math.PI*b*2;
		    Rectangle rc;
		    Yuan ys;
		    Yuan yx;
		    rc=new Rectangle(z,g);
		    
		    ys=new Yuan(b);
		    
		    yx=new Yuan(b);
			
			YuanZhu yuanzhu1=new YuanZhu(new Yuan(b),new Yuan(b),new Rectangle(z,g));
			yuanzhu1.show();

	}

}
