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
	    System.out.println("圆的半径是："+this.getR());
	    System.out.println("圆的面积是："+this.getArea());
	    System.out.println("圆的周长是："+this.getZhouChang());
	}
	public Yuan(double r) {
		super();
		this.setR(r);
	}

}
