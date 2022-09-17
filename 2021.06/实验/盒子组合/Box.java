package lianxi;

public class Box {
	    private Rectangle shang;
	    private Rectangle xia;
	    private Rectangle zuo;
	    private Rectangle you;
	    private Rectangle qian;
	    private Rectangle hou;
	    public double getTiJi()
	    {
	    	return this.xia.getArea()*this.qian.getWideth();
	    }
	    public double getBiaoMianJi()
	    {
	    	return (this.xia.getArea()+this.qian.getArea()+this.zuo.getArea())*2;
	    }
	    public void show()
	    {
	    	System.out.println("长方体的体积为："+this.getTiJi());
	    	System.out.println("长方体的表面积为："+this.getBiaoMianJi());
	    }
	    public Box( Rectangle shang, Rectangle xia, Rectangle zuo, Rectangle you, Rectangle qian, Rectangle hou)
	    {
	    	super();
	    	this.shang=shang;
	    	this.xia =xia;
	    	this.zuo =zuo;
	    	this.you =you;
	    	this.qian =qian;
	    	this.hou =hou;
	    }
	}


