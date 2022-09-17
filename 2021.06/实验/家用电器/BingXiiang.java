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
		System.out.println("电器品牌为："+this.getPingpai()+"正在工作！");
	}
	public void fare(){
		System.out.println("正在发热!");
	}

}
