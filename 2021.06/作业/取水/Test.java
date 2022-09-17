   package qushui;
   import java.util.Scanner;
   public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		 Water water = new Water();  //创建取水点的对象
		 Well well = new Well();  //创建水井的对象
		 well.openWell1(water); //打开1号水井
		 well.openWell2(water);//打开2号水井
		 well.openWell3(water);//打开3号水井
		 System.out.println("1号水井开始被取水");
		 System.out.println("目前1号水井的水量是:"+water.shuiliang1);
		 System.out.println("2号水井开始被取水");
		 System.out.println("目前2号水井的水量是:"+water.shuiliang2);
		 System.out.println("3号水井开始被取水");
		 System.out.println("目前3号水井的水量是:"+water.shuiliang3);
		 
		 
		 
	}

}
