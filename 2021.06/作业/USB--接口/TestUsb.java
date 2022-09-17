package zuoye1;

public class TestUsb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer c=new Computer();
		Usb uu=new FlashM();
		uu.run();
		uu=new Mouse();
		c.useUsb(uu);
		
	}

}
