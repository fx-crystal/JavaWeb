package action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Peixundao;
import entity.Employee;
import entity.PageBean;
import entity.Peixun;

public class Peixueservlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
		Peixundao px=new Peixundao();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if ("querypx".equals(op)) {
			querypx(request, response);
		} else if ("addpx".equals(op)) {
			addpx(request, response);
		} else if ("delpx".equals(op)) {
			delpx(request, response);
		} else if ("updpx".equals(op)) {
			updpx(request, response);
		}
	}

	// �޸�
	private void updpx(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//pid pname zhuti zhongzhi ptime didian renyuan  ptipe]
		String pid=request.getParameter("pid");
		String pname=request.getParameter("pxnm");
		String zhuti=request.getParameter("pxzt");
		String zhongzhi=request.getParameter("pxzz");
		String ptime=request.getParameter("pxtime");
		String didian=request.getParameter("pxdd");
		String reyuan=request.getParameter("pxtry");
		String ptipe=request.getParameter("pxxx");
		int a=px.updatee(pname, zhuti, zhongzhi, ptime, didian, reyuan, ptipe, Integer.parseInt(pid));
		// Ȼ�����
		PrintWriter out = response.getWriter();
		out.print(a);
		out.close();
	}

	// ɾ��
	private void delpx(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pid=request.getParameter("pid");
		int a=px.delete(Integer.parseInt(pid));
		// Ȼ�����
		PrintWriter out = response.getWriter();
		out.print(a);
		out.close();
	}
	// ����
	private void addpx(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//pid pname zhuti zhongzhi ptime didian renyuan  ptipe]
		String pname=request.getParameter("pxnm");
		String zhuti=request.getParameter("pxzt");
		String zhongzhi=request.getParameter("pxzz");
		String ptime=request.getParameter("pxtime");
		String didian=request.getParameter("pxdd");
		String reyuan=request.getParameter("pxtry");
		String ptipe=request.getParameter("pxxx");
		int a=px.addee(pname, zhuti, zhongzhi, ptime, didian, reyuan, ptipe);
		// Ȼ�����
		PrintWriter out = response.getWriter();
		out.print(a);
		out.close();
	}

	// ��ѯ
	private void querypx(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String page=request.getParameter("page");//�ڼ�ҳ
		String rows=request.getParameter("rows");//ÿҳ����
		//������
		int rowcount=px.getRowcount();
		List<Peixun> list=px.query(Integer.parseInt(page),Integer.parseInt(rows));
		Gson gs=new Gson();
		PageBean da=new PageBean(rowcount,list);
		String json=gs.toJson(da);
		// Ȼ�����
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}

}
