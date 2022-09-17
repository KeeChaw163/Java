package lianxi;

public class YuanZhu {
	//定义三个面
		private Yuan shang;
		private Yuan xia;
		private Rectangle ce;
		//定义圆柱的面积和体积
		public double getTiJi()
		{
			return this.xia.getArea()*this.ce.getWideth();
		}
		public double getBiaoMianJi()
		{
			return this.xia.getArea()*2+this.ce.getArea();
		}
		//展示
		public void show()
		{
			System.out.println("圆柱的体积为："+this.getTiJi());
			System.out.println("圆柱的表面积为："+this.getBiaoMianJi());
		}
		//构造方法
		public YuanZhu( Yuan shang, Yuan xia,Rectangle ce)
		{
			super();
			this.shang=shang;
			this.xia=xia;
			this.ce=ce;
		}

}
