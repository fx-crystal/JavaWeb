package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Departmentdao;
import entity.Department;
import entity.PageBean;

public class Typeservlet extends HttpServlet {

	Departmentdao dep=new Departmentdao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//合并请求
			this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String op=request.getParameter("op");
			if("tyquery".equals(op)){
				tyquery(request,response);
			}else if("tyadd".equals(op)){
				tyadd(request,response);
			}else if("tydel".equals(op)){
				tydel(request,response);
			}else if("tyupd".equals(op)){
				tyupd(request,response);
			}else if("bumen".equals(op)){
				bumen(request,response);
			}
	}
	//请求部门名
	private void bumen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Department> list=dep.bumen();
		Gson gs=new Gson();
		String json=gs.toJson(list);
		PrintWriter out=response.getWriter();
		out.print(json);
		out.close();
	}
	//修改部门
	private void tyupd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tpid=request.getParameter("tpid");
		String dname=request.getParameter("tyname");
		String dtime=request.getParameter("tytime");
		String dcount=request.getParameter("tycot");
		String dtype=request.getParameter("tybz");
		int a=dep.updtype(dname, dtime, Integer.parseInt(dcount), dtype, Integer.parseInt(tpid));
		PrintWriter out=response.getWriter();
		out.print(a);
		out.close();
		
	}
	//删除部门
	private void tydel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tpid=request.getParameter("tpid");
		int a=dep.deltye(Integer.parseInt(tpid));
		PrintWriter out=response.getWriter();
		out.print(a);
		out.close();
		
	}
	//添加部门
	private void tyadd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//[id dname dtime dcount dtype]
		String dname=request.getParameter("tyname");
		String dtime=request.getParameter("tytime");
		String dcount=request.getParameter("tycot");
		String dtype=request.getParameter("tybz");
		int a=dep.addtype(dname, dtime, Integer.parseInt(dcount), dtype);
		PrintWriter out=response.getWriter();
		out.print(a);
		out.close();
		
	}
	//查询部门
	private void tyquery(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String page=request.getParameter("page");//第几页
		String rows=request.getParameter("rows");//每页多少行
		int count=dep.getRowcount();
		List<Department> list=dep.query(Integer.parseInt(page),Integer.parseInt(rows));
		Gson gs=new Gson();
		PageBean en=new PageBean( count, list);
		String json=gs.toJson(en);
		PrintWriter out=response.getWriter();
		out.print(json);
		out.close();
	}

}
