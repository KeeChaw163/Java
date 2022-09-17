package shiyan;

public class TestSelfException {
	
	//如果传入的整型参数大于100，则抛出自定义异常
	public void getNum(int i) throws Exception{
		if(i>100) {
			throw new Exception("整型参数不能大于100!");
		}else {
			System.out.println("传入的参数是："+i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSelfException tse = new TestSelfException();
		int num = 99;
		//调用方法传入99，不会抛出异常
		try {
			tse.getNum(num);;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("num="+num);
			num=101;
		}
		//调用方法，传入101，抛出异常
		try {
			tse.getNum(num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("num = "+num);
		}
	}

}
