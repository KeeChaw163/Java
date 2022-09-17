package chengji;

public class StudentScore {
	private Student stu;
	private Score sco;
	
	public void show(){
		System.out.println("Ñ§Éú³É¼¨£º"+this.stu.getName()+this.stu.getSex()+this.sco.average());
	}

}
