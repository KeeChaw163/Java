package lianxi;

import java.util.Scanner;

public class TestHeZi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入长，宽，高三个数：");	
	    double x,y,z;
		Scanner scan = new Scanner(System.in);
	    x=scan.nextDouble();
	    y=scan.nextDouble();
	    z=scan.nextDouble();
	    Rectangle rs,rx,rz,ry,rq,rh;
	    rs = new Rectangle(x,y);
	    rx = new Rectangle(x,y);
	    
	    rz = new Rectangle(x,z);
	    ry = new Rectangle(x,z);
	    
	    rs = new Rectangle(y,z);
	    rs = new Rectangle(y,z);
	    Box box1 = new Box(new Rectangle(x,y),new Rectangle(x,y),new Rectangle(x,z),new Rectangle(x,z),new Rectangle(y,z),new Rectangle(y,z));
	    box1.show();
	}

}
