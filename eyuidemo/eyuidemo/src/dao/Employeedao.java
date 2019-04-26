package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

public class Employeedao {
	// 查询
	public List<Employee> queryemp(String yname,int page, int rows) {
		Connection conn = DBHelper.getConn();
		String sql ;
		if(yname.length()==0){sql= "select top " + rows
			+ " * from Employee where Eid not in (select top " + (page - 1)
			* rows + " Eid from Employee )";}
		else{
			sql= "select top " + rows
			+ " * from Employee where Eid not in (select top " + (page - 1)
			* rows + " Eid from Employee ) and Ename like '%" + yname + "%'";	
			}
		List<Employee> list = new ArrayList<Employee>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			while (rst.next()) {
				Employee e = new Employee();
				e.setEid(rst.getInt("Eid"));
				e.setEname(rst.getString("Ename"));
				e.setEsex(rst.getString("Esex"));
				e.setWenhua(rst.getString("wenhua"));
				e.setShanggang(rst.getString("shanggang"));
				e.setPartment(rst.getString("partment"));
				e.setGongzhong(rst.getString("gongzhong"));
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 获取总行数
	public int getRowcount(String yname) {

		Connection conn = DBHelper.getConn();
		String sql;
		if (yname.length() == 0) {
			sql = "select count(*) from Employee";
		} else {
			sql = "select count(*) from Employee where Ename like '%" + yname + "%'";
		}
		int rowcount = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			if (rst.next()) {
				rowcount = rst.getInt(1);

			}
			return rowcount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 增加
	public int addemp(String ename, String esex, String wenhua,
			String shanggang, String partment, String gongzhong) {
		Connection conn = DBHelper.getConn();
		String sql = "insert Employee values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, esex);
			ps.setString(3, wenhua);
			ps.setString(4, shanggang);
			ps.setString(5, partment);
			ps.setString(6, gongzhong);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 修改
	public int updemp(String ename, String esex, String wenhua,
			String shanggang, String partment, String gongzhong, int eid) {
		Connection conn = DBHelper.getConn();
		String sql = "update Employee set Ename=?,Esex=?, wenhua=?,shanggang=?,partment=?,gongzhong=? where Eid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, esex);
			ps.setString(3, wenhua);
			ps.setString(4, shanggang);
			ps.setString(5, partment);
			ps.setString(6, gongzhong);
			ps.setInt(7, eid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 删除
	public int delemp(int eid) {
		Connection conn = DBHelper.getConn();
		String sql = "delete from Employee where Eid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
