package entity;

import java.util.List;

//��ҳ����
public class PageBean {

	private int total;// ������
	private List rows;// ���ݼ���

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
