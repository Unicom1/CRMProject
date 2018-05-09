package com.boot.service.impl;

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
	public int insertContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactMapper.insertContact(contact);
	}

	@Override
	public void updateContactInfo(Contact contact) {
		// TODO Auto-generated method stub
		contactMapper.updateContactInfo(contact);
		
	}

}
