package zuoye1;

public class Mouse implements Usb {
	String name="鼠标";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.name);
	}
	public void pingpai() {
		System.out.println("这个鼠标是FASHION的！");
	}
}
