   package shouyinji;

   public abstract class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Battery nanfu = new Battery();  //������صĶ���
		 nanfu.dianliang =100;
		 System.out.println("���ڵ�صĵ���Ϊ100");
		 Radio radio = new Radio();  //�����������Ķ���
		 radio.openRadio(nanfu); //��������
		 System.out.println("��������ʼʹ�����ڵ��");
		 System.out.println("Ŀǰ���ڵ�صĵ�����:"+nanfu.dianliang);
	}
   }
	
