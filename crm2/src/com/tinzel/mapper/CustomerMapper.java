package com.tinzel.mapper;

import java.util.List;

import com.tinzel.pojo.Customer;
import com.tinzel.pojo.QueryVo;

public interface CustomerMapper {
	//查询总条数
	public Integer customerCount(QueryVo vo);
	//查询分页的结果集
	public List<Customer> selectCusListByQueryVo(QueryVo vo);
	//通过ID查询客户
	public Customer selectCustomerById(Integer id);
	//修改客户通过Id
	public void  updateCusById(Customer customer);
	//删除
	public void deleteCustomerById(Integer id);
}
