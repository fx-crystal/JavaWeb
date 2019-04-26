package entity;

public class Peixun {
	//pid pname zhuti zhongzhi ptime didian renyuan  ptipe]
	private int pid;      //编号
	private String pname;  //培训人
	private String zhuti; //主题
	private String zongzhi; // 宗旨
	private String ptime;  //培训时间
	private String didian;  //地点
	private String renyuan;  //人员 
	private String ptipe;   //备注信息
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getZhuti() {
		return zhuti;
	}
	public void setZhuti(String zhuti) {
		this.zhuti = zhuti;
	}

	public String getZongzhi() {
		return zongzhi;
	}
	public void setZongzhi(String zongzhi) {
		this.zongzhi = zongzhi;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getDidian() {
		return didian;
	}
	public void setDidian(String didian) {
		this.didian = didian;
	}
	public String getRenyuan() {
		return renyuan;
	}
	public void setRenyuan(String renyuan) {
		this.renyuan = renyuan;
	}
	public String getPtipe() {
		return ptipe;
	}
	public void setPtipe(String ptipe) {
		this.ptipe = ptipe;
	}
	
}
