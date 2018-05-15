package com.boot.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dao.domain.Customer;

@Mapper
public interface CustomerMapper {
	
	public Customer selectCustomerById(int id);
	/**
	 * 插入客户信息
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
	 * 客户关联联系人
	 * @param map
	 */
	@SuppressWarnings("rawtypes")
	public void relateCustomerAndContact(Map map);
	
	/**
	 * 分页获取客户，包含联系人信息
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map<String,Object>> selectCustomerContainContact(Map map);
	
	/**
	 * 获取尚未关联联系人的客户
	 * @return
	 */
	public List<Customer> selectCustomerWithoutContact();
	
	/**
	 * 搜索客户
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map<String,Object>> queryCustomer(Map map);
}
