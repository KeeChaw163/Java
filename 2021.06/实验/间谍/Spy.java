package shiyan;

public class Spy  extends Person implements SpySkills,Driver,Teacher{
	@Override
	public void teach(){
		System.out.println("Teaching Geography...");
	}
	@Override
	public void driveCar() {
		System.out.println("Driving for escape...");
	}
	@Override
	public void tou() {
		System.out.println("tou...");
	}
	@Override
	public void pomima() {
		System.out.println("pomima...");
	}
	public void Computer() {
		System.out.println("Operating computer...");
	}

}
