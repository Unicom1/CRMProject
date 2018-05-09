package com.boot.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.dao.domain.Contact;
import com.boot.service.ContactService;
import com.boot.utils.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/Contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/addContact",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增联系人接口",notes = "新增联系人，但注意id,createUser,createTime不要传，若成功，返回0，报错返回error")
	public Map addContact(@ApiParam(value="联系人信息")@RequestBody Contact contact) {
		Map jsonData = new HashMap();
		
		try {
			contact.setContactCreateUser(Utils.getCurrentUser());
			contactService.insertContact(contact);
			jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/changeContactInfo",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "编辑联系人接口",notes = "编辑联系人，但注意id信息不要传，若成功，返回0，报错返回error")
	public Map changeContactInfo(@ApiParam(value="编辑联系人信息")@RequestBody Contact contact) {
		Map jsonData = new HashMap();
		
		try {
			contactService.updateContactInfo(contact);
			jsonData.put("state",0);
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state", Utils.ERROR);
		}
		return jsonData;
	}
}
