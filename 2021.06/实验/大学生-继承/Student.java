package shiyan;

public class Student extends Person1{
	  String xuehao;
	  
	    @Override
	public String toString() {
		return "Student [xuehao=" + xuehao + ",toString()="+super.toString()+"]";
	}
		public void wan(){
	    	System.out.println("小学生喜欢玩！");
	    }
	    public void Person(String name,int age,String sex){
			System.out.println("该小学生的姓名为:"+name+",年龄为:"+age+",性别为:"+sex);
		}

}
