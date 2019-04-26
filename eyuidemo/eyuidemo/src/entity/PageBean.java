package entity;

import java.util.List;

//分页工具
public class PageBean {

	private int total;// 总行数
	private List rows;// 数据集合

	public PageBean(int total, List data) {
		this.total = total;
		this.rows = data;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
