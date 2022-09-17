package zuoye1;

public class Car extends JiaoTong{
	int renshu;  //可以坐几个人
	int youliang;
	public int getRenshu() {
		return renshu;
	}
	public void setRenshu(int renshu) {
		if(renshu>=1&&renshu<10)
		this.renshu = renshu;
	}
	public int getYouliang() {
		return youliang;
	}
	public void setYouliang(int youliang) {
		if(youliang>0&&youliang<200)
		this.youliang = youliang;
	}
	public  void show() {
		System.out.println("人数："+this.renshu);
		System.out.println("油量："+this.youliang);
	}
	
}
