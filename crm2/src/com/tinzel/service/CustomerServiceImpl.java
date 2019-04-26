package com.tinzel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 客户管理
 * @author Administrator
 *
 */

import com.tinzel.mapper.CustomerMapper;
import com.tinzel.pojo.Customer;
import com.tinzel.pojo.QueryVo;
import com.tinzel.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	//通过四个条件，查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page = new Page<Customer>();
		//每页数
		page.setSize(5);
		vo.setSize(5);
		//判断VO的当前页是否为空
		if(null!=vo){
			if(null!=vo.getPage()){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if(null!= vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null!= vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null!= vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null!= vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			page.setTotal(customerMapper.customerCount(vo));
			page.setRows(customerMapper.selectCusListByQueryVo(vo));
		}
	
		return page;
		
	}
	@Override
	public Customer selectCustomerById(Integer id) {
		
		return customerMapper.selectCustomerById(id);
	}
	@Override
	public void updateCusById(Customer customer) {
		customerMapper.updateCusById(customer);
		System.out.println("123");
	}
	@Override
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
	}
	

}
