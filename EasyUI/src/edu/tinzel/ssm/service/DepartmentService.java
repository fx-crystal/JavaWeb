
package edu.tinzel.ssm.service;

import java.util.List;
import java.util.Map;

import edu.tinzel.ssm.entity.Department;

public interface DepartmentService {
		//查询
		public List<Department> query(Map map);
		//查询部门
		public List<Department> bumen();
		// 获取总行数
		public int getRowcount();
		//增加
		public int addtype(Department department);
		//修改
		public int updtype(Department department);
		//删除
		public int deltye(int id );
}
