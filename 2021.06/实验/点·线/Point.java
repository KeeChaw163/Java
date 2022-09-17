package zuoye;

public class Point {
	int x;
	int y;
	public void showWeiZhi(int mx,int my) {
		this.x=mx;
		this.y=my;
		System.out.println("ÒÆ¶¯µãÎª£º"+"("+this.x+","+this.y+")");
	}
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
