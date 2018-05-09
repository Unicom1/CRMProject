package com.boot.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dao.domain.Contact;

@Mapper
public interface ContactMapper {
	
	/**
	 * 插入联系人信息
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
