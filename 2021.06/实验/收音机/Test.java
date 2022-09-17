   package shouyinji;

   public abstract class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Battery nanfu = new Battery();  //创建电池的对象
		 nanfu.dianliang =100;
		 System.out.println("南孚电池的电量为100");
		 Radio radio = new Radio();  //创建收音机的对象
		 radio.openRadio(nanfu); //打开收音机
		 System.out.println("收音机开始使用南孚电池");
		 System.out.println("目前南孚电池的电量是:"+nanfu.dianliang);
	}
   }
	
