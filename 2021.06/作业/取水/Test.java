   package qushui;
   import java.util.Scanner;
   public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		 Water water = new Water();  //����ȡˮ��Ķ���
		 Well well = new Well();  //����ˮ���Ķ���
		 well.openWell1(water); //��1��ˮ��
		 well.openWell2(water);//��2��ˮ��
		 well.openWell3(water);//��3��ˮ��
		 System.out.println("1��ˮ����ʼ��ȡˮ");
		 System.out.println("Ŀǰ1��ˮ����ˮ����:"+water.shuiliang1);
		 System.out.println("2��ˮ����ʼ��ȡˮ");
		 System.out.println("Ŀǰ2��ˮ����ˮ����:"+water.shuiliang2);
		 System.out.println("3��ˮ����ʼ��ȡˮ");
		 System.out.println("Ŀǰ3��ˮ����ˮ����:"+water.shuiliang3);
		 
		 
		 
	}

}
