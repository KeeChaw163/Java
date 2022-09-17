package zuoye1;

public class Mobile implements Usb {
	String name="手机";
	   String logo = "HUAWEI";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(""+name);
		System.out.println("该手机品牌："+logo);
		System.out.println("该手机正在充电");

	}

}
