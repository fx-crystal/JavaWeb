package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Peixun;

public class Peixundao {

	// Pid Pname zhuti zongzhi ptime didian renyuan type]
	public List<Peixun> query(int page, int rows) {
		Connection conn = DBHelper.getConn();
		List<Peixun> list = new ArrayList<Peixun>();
		String sql = "select top " + rows
				+ " * from Peixun where Pid not in (select top " + (page - 1)
				* rows + " Pid from Peixun)";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			while (rst.next()) {
				Peixun p = new Peixun();
				p.setPid(rst.getInt("Pid"));
				p.setPname(rst.getString("Pname"));
				p.setZhuti(rst.getString("zhuti"));
				p.setZongzhi(rst.getString("zongzhi"));
				p.setPtime(rst.getString("ptime"));
				p.setDidian(rst.getString("didian"));
				p.setRenyuan(rst.getString("renyuan"));
				p.setPtipe(rst.getString("type"));
				list.add(p);
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
	public int getRowcount() {

		Connection conn = DBHelper.getConn();
		String sql = "select count(*) from Peixun";
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

	// 添加
	public int addee(String pname, String zhuti, String zongzhi, String ptime,
			String didian, String renyuan, String ptiype) {
		Connection conn = DBHelper.getConn();
		String sql = "insert Peixun values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setString(2, zhuti);
			ps.setString(3, zongzhi);
			ps.setString(4, ptime);
			ps.setString(5, didian);
			ps.setString(6, renyuan);
			ps.setString(7, ptiype);
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
	public int updatee(String pname, String zhuti, String zongzhi,
			String ptime, String didian, String renyuan, String ptiype, int pid) {
		Connection conn = DBHelper.getConn();
		String sql = "update Peixun set Pname=?,zhuti=?,zongzhi=?,ptime=?,didian=?,renyuan=?,[type]=? where Pid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setString(2, zhuti);
			ps.setString(3, zongzhi);
			ps.setString(4, ptime);
			ps.setString(5, didian);
			ps.setString(6, renyuan);
			ps.setString(7, ptiype);
			ps.setInt(8, pid);
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
	public int delete(int pid) {
		Connection conn = DBHelper.getConn();
		String sql = "delete from Peixun where pid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
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