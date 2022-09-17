package zuoye;

public class XianZ {
	Point start;
	Point end;
	public XianZ(Point start,Point end) {
		super();
		this.start=start;
		this.end=end;
	}
	public XianZ(int x,int y,int x1,int y1) {
		super();
		start=new Point(x,y);
		end=new Point(x1,y1);
	}
}
