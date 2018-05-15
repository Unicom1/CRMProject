package com.boot.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dao.domain.Contact;

@Mapper
public interface ContactMapper {
	
	/**
	 * 根据联系人id获取联系人信息
	 * @param id
	 * @return
	 */
	public Contact selectContactById(int id);
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
	
	/**
	 * 分页获取联系人，包含所属客户
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map<String,Object>> selectContactContainCustomer(Map map);
	
	/**
	 * 获取尚未关联客户的联系人
	 * @return
	 */
	public List<Contact> selectContactWithoutCustomer();
	
	/**
	 * 搜索联系人
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map<String,Object>> queryContact(Map map);
}
