/*6面组成盒子-2010.04.15
 * 黄志超
 */
package lianxi;

public class Rectangle {
    private double length;
    private double wideth;
	public double getLength() {
		return this.length;
	}
	public void setLength(double length) {
		if(length>0)
			this.length = length;
	}
	public double getWideth() {
		return this.wideth;
	}
	public void setWideth(double wideth) {
		if(wideth>0)
			this.wideth = wideth;
	}
    public double getArea()
    {
    	return this.length*this.wideth;
    }
    public double getZhouChang()
    {
    	return (this.wideth+this.length)*2;
    }
    public void show()
    {
    	System.out.println("矩形的长是："+this.getLength());
    	System.out.println("矩形的宽是："+this.getWideth());
    	System.out.println("矩形的面积是："+this.getArea());
    	System.out.println("矩形的周长是："+this.getZhouChang());
    }
    public Rectangle(double length,double wideth)
    {
    	super();
    	this.setLength(length);
    	this.setWideth(wideth);
    }
}
