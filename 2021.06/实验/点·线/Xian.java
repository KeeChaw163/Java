package zuoye;

public class Xian extends Point {
	 //起始点为父类，新定义终止点
     int x;
     int y;
	public double getXX() {
		return Xian.this.x-Xian.super.x;
	}
	public double getYY() {
		return Xian.this.y-Xian.super.y;
	}
	public double getChang() {
		return Math.sqrt(this.getXX()*this.getXX()+this.getYY()*this.getYY());
	}
	public void show() {
		System.out.println("移动的长度为："+"("+this.getXX()+","+this.getYY()+")");
		System.out.println("直线的长度为："+this.getChang());
	}
	public Xian(int x,int y,int x1,int y1) {
   	 super(x,y);//继承起始点
   	 x1 = this.x;//终止点
   	 y1 = this.y;
    }
	
}
