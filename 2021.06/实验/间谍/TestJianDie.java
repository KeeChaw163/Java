package shiyan;

public class TestJianDie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Person person1=new Spy();
		    
		    person1.setAge(19);
		    person1.setGender("��");
		    person1.setName("��־��");
		    
		    person1.learn();
		    
		    if(person1 instanceof SpySkills) {
		    	SpySkills spyer = (SpySkills)person1;
		    	spyer.tou();
		    	spyer.pomima();
		    }
		    if(person1 instanceof Driver) {
		    	Driver driver=(Driver)person1;
		    	driver.driveCar();  //��������
		    }
		    if(person1 instanceof Teacher) {
		    	Teacher teacher=(Teacher)person1;
		    	teacher.teach();
		    }
	}
}


