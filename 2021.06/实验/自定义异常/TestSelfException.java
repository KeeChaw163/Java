package shiyan;

public class TestSelfException {
	
	//�����������Ͳ�������100�����׳��Զ����쳣
	public void getNum(int i) throws Exception{
		if(i>100) {
			throw new Exception("���Ͳ������ܴ���100!");
		}else {
			System.out.println("����Ĳ����ǣ�"+i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSelfException tse = new TestSelfException();
		int num = 99;
		//���÷�������99�������׳��쳣
		try {
			tse.getNum(num);;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("num="+num);
			num=101;
		}
		//���÷���������101���׳��쳣
		try {
			tse.getNum(num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("num = "+num);
		}
	}

}
