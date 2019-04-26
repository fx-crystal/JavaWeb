
package edu.tinzel.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntBinaryOperator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import edu.tinzel.ssm.entity.Department;
import edu.tinzel.ssm.service.DepartmentService;

@Controller
public class DepartmentController {
	@Resource
	private DepartmentService departmentService;
	@RequestMapping("list.action")
	public void query(HttpServletResponse response,String page,String rows){
		int allrows=departmentService.getRowcount();
		int b=Integer.parseInt(rows);
		int p=Integer.parseInt(page);
		int c=(p-1)*b;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("currentpage", c);
		map.put("pagerow", b);
		List<Department> list=departmentService.query(map);
		Gson gson=new Gson();
		String json = gson.toJson(list);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("add.action")
	public void addDepartment(Department department,HttpServletResponse response){
		int i=departmentService.addtype(department);
		Gson gson=new Gson();
		String jString=gson.toJson(i);
		try {
			response.getWriter().write(jString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("delete.action")
	public void delteDepartment (HttpServletResponse response,int id) {
		int i=departmentService.deltye(id);
		Gson gson=new Gson();
		String jString=gson.toJson(i);
		try {
			response.getWriter().write(jString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("update.action")
	public void update (HttpServletResponse response,Department department) {
		int i=departmentService.updtype(department);
		Gson gson=new Gson();
		String jString=gson.toJson(i);
		try {
			response.getWriter().write(jString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("bumen.action")
	public void bumen (HttpServletResponse response) {
		List<Department> bumen = departmentService.bumen();
		Gson gson=new Gson();
		String jString=gson.toJson(bumen);
		try {
			response.getWriter().write(jString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
