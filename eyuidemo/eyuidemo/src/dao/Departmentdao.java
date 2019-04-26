package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Department;

public class Departmentdao {
	//查询
	//[id Dname Dtime Dcount Dtype]
	public List<Department> query(int page, int rows){
	Connection conn=DBHelper.getConn();
	String sql= "select top " + rows
	+ " * from Department where id not in (select top " + (page - 1)
	* rows + " id from Department)";
	List<Department> list=new ArrayList<Department>();
	try {
		Statement stmt=conn.createStatement();
		ResultSet rst=stmt.executeQuery(sql);
		while(rst.next()){
			Department d=new Department();
			d.setId(rst.getInt("id"));
			d.setDname(rst.getString("Dname"));
			d.setDtime(rst.getString("Dtime"));
			d.setDcount(rst.getInt("Dcount"));
			d.setDtype(rst.getString("Dtype"));
			list.add(d);
		}
		return list;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	//查询部门
	public List<Department> bumen(){
		Connection conn=DBHelper.getConn();
		String sql="select * from Department ";
		List<Department> list=new ArrayList<Department>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while(rst.next()){
				Department d=new Department();
				d.setId(rst.getInt("id"));
				d.setDname(rst.getString("Dname"));
				d.setDtime(rst.getString("Dtime"));
				d.setDcount(rst.getInt("Dcount"));
				d.setDtype(rst.getString("Dtype"));
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	// 获取总行数
	public int getRowcount() {

		Connection conn = DBHelper.getConn();
		String sql = "select count(*) from Department";
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

	//增加
	public int addtype( String dname,String dtime,int dcount,String dtype){
		Connection conn=DBHelper.getConn();
		String sql="insert Department values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, dname);
			ps.setString(2, dtime);
			ps.setInt(3, dcount);
			ps.setString(4, dtype);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//修改
	public int updtype(String dname,String dtime,int dcount,String dtype,int id ){
		Connection conn=DBHelper.getConn();
		String sql="update Department set Dname=?,Dtime=?,Dcount=?,Dtype=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, dname);
			ps.setString(2, dtime);
			ps.setInt(3, dcount);
			ps.setString(4, dtype);
			ps.setInt(5, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//删除
	public int deltye(int id ){
		Connection conn=DBHelper.getConn();
		String sql="delete from Department where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}