package lianxi;
import java.util.Scanner;
//����ϵͳ��������
public class TestYuanZhu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("������Բ���İ뾶�͸ߣ�");
			Scanner scan = new Scanner(System.in);
			//����Բ���뾶���ߣ��뾶���ܳ��ò���ĳ�
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
