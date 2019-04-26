
package edu.tinzel.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.tinzel.ssm.dao.DepartmentMapper;
import edu.tinzel.ssm.entity.Department;
import edu.tinzel.ssm.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Resource
	private DepartmentMapper departmentMapper;
	
	/* (non-Javadoc)
	 * @see edu.tinzel.ssm.service.DepartmentService#query(java.util.Map)
	 */
	@Override
	public List<Department> query(Map map) {
		// TODO Auto-generated method stub
		return departmentMapper.query(map);
	}

	/* (non-Javadoc)
	 * @see edu.tinzel.ssm.service.DepartmentService#bumen()
	 */
	@Override
	public List<Department> bumen() {
		// TODO Auto-generated method stub
		return departmentMapper.bumen();
	}

	/* (non-Javadoc)
	 * @see edu.tinzel.ssm.service.DepartmentService#getRowcount()
	 */
	@Override
	public int getRowcount() {
		// TODO Auto-generated method stub
		return departmentMapper.getRowcount();
	}


	/* (non-Javadoc)
	 * @see edu.tinzel.ssm.service.DepartmentService#updtype(edu.tinzel.ssm.entity.Department)
	 */
	@Override
	public int updtype(Department department) {
		// TODO Auto-generated method stub
		return departmentMapper.updtype(department);
	}

	/* (non-Javadoc)
	 * @see edu.tinzel.ssm.service.DepartmentService#deltye(int)
	 */
	@Override
	public int deltye(int id) {
		// TODO Auto-generated method stub
		return departmentMapper.deltye(id);
	}

	/* (non-Javadoc)
	 * @see edu.tinzel.ssm.service.DepartmentService#addtype(edu.tinzel.ssm.entity.Department)
	 */
	@Override
	public int addtype(Department department) {
		// TODO Auto-generated method stub
		
		return departmentMapper.addtype(department);
	}

}
