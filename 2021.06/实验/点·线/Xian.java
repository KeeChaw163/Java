package zuoye;

public class Xian extends Point {
	 //��ʼ��Ϊ���࣬�¶�����ֹ��
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
		System.out.println("�ƶ��ĳ���Ϊ��"+"("+this.getXX()+","+this.getYY()+")");
		System.out.println("ֱ�ߵĳ���Ϊ��"+this.getChang());
	}
	public Xian(int x,int y,int x1,int y1) {
   	 super(x,y);//�̳���ʼ��
   	 x1 = this.x;//��ֹ��
   	 y1 = this.y;
    }
	
}
