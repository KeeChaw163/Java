package zuoye1;
import java.util.Scanner;
public class TestJiaoTong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("小轿车的参数和公交车的特点:");
		int renshu;  
		int youliang;
		String tedian;
		renshu=sc.nextInt();
		youliang=sc.nextInt();
		tedian=sc.next();
		JiaoTong Car =new Car();
		Car.show();
		JiaoTong Bus=new Bus();
		Bus.show();
	}

}
