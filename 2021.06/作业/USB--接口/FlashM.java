package zuoye1;

public class FlashM implements Usb {
	String name="我的优盘";
	private int zcunchu=128;
	private int ycunchu=56;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZcunchu() {
			return zcunchu;
	}
	public void setZcunchu(int zcunchu) {
		if(zcunchu>0&&zcunchu<1024)
			this.zcunchu = zcunchu;
	}
	public int getYcunchu() {
		return this.ycunchu;
	}
	public void setYcunchu(int ycunchu) {
		if(ycunchu>0&&ycunchu<999)
			this.ycunchu = ycunchu;
	}
	public int ReadShuJu() {
		int shujuliang=5;
		return shujuliang;
	}
	public int WriteShuJu(int shujuliang) {
		return shujuliang;
	}
	public void show(int Zcunchu,int Ycunchu) {
		System.out.println("总存储容量："+this.getZcunchu()+"已用容量:"+this.getYcunchu());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.name);
		System.out.println("总存储容量："+this.getZcunchu()+"已用容量:"+this.getYcunchu());
	}
	

}
