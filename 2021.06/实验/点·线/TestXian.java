package zuoye;
import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���û���������������꣺");
        Scanner scan = new Scanner(System.in);
        int x,y,x1,y1;
        x=scan.nextInt();
        y=scan.nextInt();
        x1=scan.nextInt();
        y1=scan.nextInt();
        Xian xi = new Xian(x,y,x1,y1);
        xi.show();
	}

}
