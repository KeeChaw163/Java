package lianxi;

public class YuanZhu {
	//����������
		private Yuan shang;
		private Yuan xia;
		private Rectangle ce;
		//����Բ������������
		public double getTiJi()
		{
			return this.xia.getArea()*this.ce.getWideth();
		}
		public double getBiaoMianJi()
		{
			return this.xia.getArea()*2+this.ce.getArea();
		}
		//չʾ
		public void show()
		{
			System.out.println("Բ�������Ϊ��"+this.getTiJi());
			System.out.println("Բ���ı����Ϊ��"+this.getBiaoMianJi());
		}
		//���췽��
		public YuanZhu( Yuan shang, Yuan xia,Rectangle ce)
		{
			super();
			this.shang=shang;
			this.xia=xia;
			this.ce=ce;
		}

}
