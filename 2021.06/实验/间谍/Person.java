package shiyan;

public class Person {
	 private String name;
     private Integer age;
     private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
     void learn()
     {
    	 System.out.println("������"+this.getName());
    	 System.out.println("���䣺"+this.getAge());
    	 System.out.println("�Ա�"+this.getGender());
    	 System.out.println("learning...");
     }
     

}
