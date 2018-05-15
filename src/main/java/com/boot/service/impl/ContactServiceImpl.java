package com.boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.domain.Contact;
import com.boot.dao.mapper.ContactMapper;
import com.boot.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactMapper contactMapper;
	
	@Override
	public Contact selectContactById(int id) {
		// TODO Auto-generated method stub
		return contactMapper.selectContactById(id);
	}
	
	@Override
	public int insertContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactMapper.insertContact(contact);
	}

	@Override
	public void updateContactInfo(Contact contact) {
		// TODO Auto-generated method stub
		contactMapper.updateContactInfo(contact);
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Map<String, Object>> selectContactContainCustomer(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = (startPage-1)*pageSize;
		map.put("start", start);
		map.put("pageSize",pageSize);
		return contactMapper.selectContactContainCustomer(map);
	}

	@Override
	public List<Contact> selectContactWithoutCustomer() {
		// TODO Auto-generated method stub
		return contactMapper.selectContactWithoutCustomer();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Map<String, Object>> queryContact(int startPage, int pageSize, String contactName) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = (startPage-1)*pageSize;
		map.put("start", start);
		map.put("pageSize",pageSize);
		if(contactName != null) {
			map.put("contactName", contactName);
		}
		return contactMapper.queryContact(map);
	}





}
