package zuoye1;

public class Computer {
	public void useUsb(Usb u) {
		System.out.println("�����USB�ӿ�����һ��USB�豸");
		u.run();
		Mouse m=new Mouse();
		m.pingpai();
		Mobile mo=new Mobile();
		mo.run();
	}

}
