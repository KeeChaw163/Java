package shiyan;

public class Student extends Person1{
	  String xuehao;
	  
	    @Override
	public String toString() {
		return "Student [xuehao=" + xuehao + ",toString()="+super.toString()+"]";
	}
		public void wan(){
	    	System.out.println("Сѧ��ϲ���棡");
	    }
	    public void Person(String name,int age,String sex){
			System.out.println("��Сѧ��������Ϊ:"+name+",����Ϊ:"+age+",�Ա�Ϊ:"+sex);
		}

}
