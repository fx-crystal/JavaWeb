package entity;

public class Department {
	//[id dname dtime dcount dtype]
	private int id;  //部门编号
	private String dname;  //部门名
	private String dtime; //创建时间
	private int dcount;//部门人数
	private String dtype;	//备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public int getDcount() {
		return dcount;
	}
	public void setDcount(int dcount) {
		this.dcount = dcount;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	
	
}
