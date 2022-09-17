package shiyan;

public class Person1 {
	String name;                          //姓名
    int age;                              //年龄
    String sex;             //性别
    
    
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
		System.out.println("该人的姓名为:"+name+",年龄为:"+age+",性别为:"+sex);
	}

	public void Person(String name,int age,String sex){
		System.out.println("该人的姓名为:"+name+",年龄为:"+age+",性别为:"+sex);
	}
	

}
