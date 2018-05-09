package com.boot.service;

import java.util.List;
import java.util.Map;

import com.boot.dao.domain.Customer;

/**
 * 客户模块
 * @author lenovo
 *
 */
public interface CustomerService {
	
	/**
	 * 根据Id获取客户信息
	 * @param id
	 * @return
	 */
	public Customer selectCustomerById(int id);
	/**
	 * 新增客户
	 * @param customer
	 * @return
	 */
	public int insertCustomer(Customer customer);
	
	/**
	 * 修改客户信息
	 * @param customer
	 */
	public void updateCustomerInfo(Customer customer);
	
	/**
	 * 关联客户及联系人
	 * @param customerId
	 * @param contactId
	 */
	public void relateCustomerAndContact(int customerId, int contactId);
	
	public List<Map<String,Object>> selectCustomerContainContact(int startPage,int pageSize);
}
