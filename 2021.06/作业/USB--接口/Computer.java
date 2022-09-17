package zuoye1;

public class Computer {
	public void useUsb(Usb u) {
		System.out.println("计算机USB接口连接一个USB设备");
		u.run();
		Mouse m=new Mouse();
		m.pingpai();
		Mobile mo=new Mobile();
		mo.run();
	}

}
