package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Employeedao;
import entity.Employee;
import entity.PageBean;

public class Ryservlet extends HttpServlet {
	
	Employeedao empdao=new Employeedao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String op=request.getParameter("op");
			if("queryemp".equals(op)){
			queryemp(request,response);	
			}else if("addemp".equals(op)){
				addemp(request,response);
			}else if("delemp".equals(op)){
				delemp(request,response);
			}else if("updemp".equals(op)){
				updemp(request,response);
			}
	}
	
	//修改
	private void updemp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String eid=request.getParameter("id");
		String ename=request.getParameter("name");
		String esex=request.getParameter("sex");
		String wenhua=request.getParameter("xueli");
		String shanggang=request.getParameter("chanjia");
		String partment=request.getParameter("types");
		String gongzhong=request.getParameter("gongzhong");
		int a=empdao.updemp(ename, esex, wenhua, shanggang, partment, gongzhong, Integer.parseInt(eid));
		PrintWriter out = response.getWriter();
		out.print(a);
		out.close();
		
	}

	//删除数据
	private void delemp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String eid=request.getParameter("eid");
		int a=empdao.delemp(Integer.parseInt(eid));
		PrintWriter out = response.getWriter();
		out.print(a);
		out.close();
	}

	//添加人员
	private void addemp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ename=request.getParameter("name");
		String esex=request.getParameter("sex");
		String wenhua=request.getParameter("xueli");
		String shanggang=request.getParameter("chanjia");
		String partment=request.getParameter("types");
		String gongzhong=request.getParameter("gongzhong");
		int a=empdao.addemp(ename, esex, wenhua, shanggang, partment, gongzhong);
		PrintWriter out = response.getWriter();
		out.print(a);
		out.close();	
	}

	//查询全部人员
	private void queryemp(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String yname=request.getParameter("yname");
		String page=request.getParameter("page");//第几页
		String rows=request.getParameter("rows");//每页几行
		//总行数
		int rowcount=empdao.getRowcount(yname);
		List<Employee> list=empdao.queryemp(yname,Integer.parseInt(page),Integer.parseInt(rows));
		Gson gs=new Gson();
		PageBean em=new PageBean(rowcount,list);
		String json=gs.toJson(em);
		// 然后输出
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();

	}

	


}
