package com.boot.service;

import java.util.List;
import java.util.Map;

import com.boot.dao.domain.Contact;

/**
 * 联系人模块
 * @author lenovo
 *
 */
public interface ContactService {
	
	public Contact selectContactById(int id);
	/**
	 * 新增联系人
	 * @param contact
	 * @return
	 */
	public int insertContact(Contact contact);
	
	/**
	 * 修改联系人信息
	 * @param contact
	 */
	public void updateContactInfo(Contact contact);
	
	/**
	 * 分页获取联系人，包含所属客户
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	public List<Map<String,Object>> selectContactContainCustomer(int startPage,int pageSize);
	
	/**
	 * 获取尚未关联客户的联系人
	 * @return
	 */
	public List<Contact> selectContactWithoutCustomer();
	
	/**
	 * 搜索联系人
	 * @param startPage
	 * @param pageSize
	 * @param contactName
	 * @return
	 */
	public List<Map<String,Object>> queryContact(int startPage,int pageSize,String contactName);
}
