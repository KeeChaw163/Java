package shiyan;

public class Person1 {
	String name;                          //����
    int age;                              //����
    String sex;             //�Ա�
    
    
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>0&&age<200)
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "Person1 [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public void Person1() {
		System.out.println("���˵�����Ϊ:"+name+",����Ϊ:"+age+",�Ա�Ϊ:"+sex);
	}

	public void Person(String name,int age,String sex){
		System.out.println("���˵�����Ϊ:"+name+",����Ϊ:"+age+",�Ա�Ϊ:"+sex);
	}
	

}
