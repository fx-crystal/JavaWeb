
package edu.tinzel.ssm.service;

import java.util.List;
import java.util.Map;

import edu.tinzel.ssm.entity.Department;

public interface DepartmentService {
		//��ѯ
		public List<Department> query(Map map);
		//��ѯ����
		public List<Department> bumen();
		// ��ȡ������
		public int getRowcount();
		//����
		public int addtype(Department department);
		//�޸�
		public int updtype(Department department);
		//ɾ��
		public int deltye(int id );
}
