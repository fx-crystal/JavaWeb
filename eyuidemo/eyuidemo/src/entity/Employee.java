package entity;

public class Employee {
   //[eid ename esex wenhua shanggang partment gongzhong]
	private int eid;  //编号
	private String ename;  //姓名
	private String esex;  //性别
	private String wenhua;  //部门
	private String shanggang;   //工作时间
	private String partment;   //学历
	private String gongzhong;   // 工种
	private String yname;
	
	public String getYname() {
		return yname;
	}
	public void setYname(String yname) {
		this.yname = yname;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public String getWenhua() {
		return wenhua;
	}
	public void setWenhua(String wenhua) {
		this.wenhua = wenhua;
	}
	public String getShanggang() {
		return shanggang;
	}
	public void setShanggang(String shanggang) {
		this.shanggang = shanggang;
	}
	public String getPartment() {
		return partment;
	}
	public void setPartment(String partment) {
		this.partment = partment;
	}
	public String getGongzhong() {
		return gongzhong;
	}
	public void setGongzhong(String gongzhong) {
		this.gongzhong = gongzhong;
	}
	
	
}
