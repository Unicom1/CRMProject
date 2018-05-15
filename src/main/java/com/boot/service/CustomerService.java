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
	
	/**
	 * 分页获取客户，包含联系人
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	public List<Map<String,Object>> selectCustomerContainContact(int startPage,int pageSize);
	
	/**
	 * 获取尚未关联客户的联系人
	 * @return
	 */
	public List<Customer> selectCustomerWithoutContact();
	
	/**
	 * 搜索客户
	 * @param startPage
	 * @param pageSize
	 * @param cName
	 * @return
	 */
	public List<Map<String,Object>> queryCustomer(int startPage,int pageSize,String cName);
}
