package com.tinzel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tinzel.pojo.BaseDict;
import com.tinzel.pojo.Customer;
import com.tinzel.pojo.QueryVo;
import com.tinzel.service.BaseDictService;
import com.tinzel.service.CustomerService;
import com.tinzel.utils.Page;

/**
 * 客户管理
 * @author Administrator
 *
 */
@Controller
public class CustomerController {
	@Autowired
	private BaseDictService baseDictService;
	@Autowired 
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode("002");
		List<BaseDict>	industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		model.addAttribute("fromType",fromType );
		model.addAttribute("industryType",industryType );
		model.addAttribute("levelType",levelType );
		
		//通过四个条件，查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		System.out.println("123");
		model.addAttribute("page", page);
		System.out.println("123"); 
		
		return "customer";
	}
	
	//修改页面
	//返回customer json格式的字符串
	@RequestMapping(value="customer/edit.action")
	@ResponseBody
	public Customer edit(Integer id){
		Customer customer = customerService.selectCustomerById(id);
		System.out.println(customer);
		return  customerService.selectCustomerById(id);
		
	}
	
	@RequestMapping(value="customer/update.action")
	@ResponseBody
	public String update(Customer customer) {
		customerService.updateCusById(customer);
		return "OK";
		
	}
	
	//删除
	@ResponseBody
	@RequestMapping(value="customer/delete.action")
	public String delete(Integer id) {
		customerService.deleteCustomerById(id);
		return "OK";
		
	}

}
