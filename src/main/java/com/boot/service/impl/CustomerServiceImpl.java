package com.boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.domain.Customer;
import com.boot.dao.mapper.CustomerMapper;
import com.boot.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public int insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.insertCustomer(customer);
	}

	@Override
	public void updateCustomerInfo(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.updateCustomerInfo(customer);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void relateCustomerAndContact(int customerId, int contactId) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("customerId", customerId);
		map.put("contactId", contactId);
		customerMapper.relateCustomerAndContact(map);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map<String, Object>> selectCustomerContainContact(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = (startPage-1)*pageSize;
		map.put("start", start);
		map.put("pageSize",pageSize);
		return customerMapper.selectCustomerContainContact(map);
	}

	@Override
	public Customer selectCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerMapper.selectCustomerById(id);
	}

	@Override
	public List<Customer> selectCustomerWithoutContact() {
		// TODO Auto-generated method stub
		return customerMapper.selectCustomerWithoutContact();
	}

}
