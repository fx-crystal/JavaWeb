package com.tinzel.service;

import com.tinzel.pojo.Customer;
import com.tinzel.pojo.QueryVo;
import com.tinzel.utils.Page;

public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	public Customer selectCustomerById(Integer id);
	public void updateCusById(Customer customer);	
	public void deleteCustomerById(Integer id);
	
}
