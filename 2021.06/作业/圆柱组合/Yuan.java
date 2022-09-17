package lianxi;

public class Yuan {
	private double r;

	public double getR() {
		return this.r;
	}

	public void setR(double r) {
		if(r>0)
			this.r = r;
	}
	public double getArea(){
    	return this.r*this.r*Math.PI;
    }
	public double getZhouChang() {
		return 2*this.r*Math.PI;
	}
	public void show(){
	    System.out.println("Բ�İ뾶�ǣ�"+this.getR());
	    System.out.println("Բ������ǣ�"+this.getArea());
	    System.out.println("Բ���ܳ��ǣ�"+this.getZhouChang());
	}
	public Yuan(double r) {
		super();
		this.setR(r);
	}

}
