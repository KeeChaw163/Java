package shiyan;

public class BingXiiang  extends DianQi{
	private int dianya;
    private String pingpai;
	public int getDianya() {
		return dianya;
	}
	public void setDianya(int dianya) {
		this.dianya = dianya;
	}
	public String getPingpai() {
		return pingpai;
	}
	public void setPingpai(String pingpai) {
		this.pingpai = pingpai;
	}
	public void Bingxiiang() {
		this.dianya = dianya;
		this.pingpai = pingpai;
	}
	@Override 
	public void work(){
		System.out.println("����Ʒ��Ϊ��"+this.getPingpai()+"���ڹ�����");
	}
	public void fare(){
		System.out.println("���ڷ���!");
	}

}
