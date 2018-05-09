package com.boot.service;

import com.boot.dao.domain.Contact;

/**
 * 联系人模块
 * @author lenovo
 *
 */
public interface ContactService {
	
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
}
