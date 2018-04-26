package com.boot.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dao.domain.User;



@Mapper
public interface UserMapper {
	public User selectUserById(Integer userId);
	
	/**
	 * 登录，根据用户名返回密码
	 * @param userId
	 * @return
	 */
	public String selectPassByName(String userName);
	
	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @return
	 */
	public User selectInfoByName(String userName);
	
	/**
	 * 可进行分页获取所有用户信息
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<User> selectAllUser(Map map);
	
	/**
	 * 插入用户信息
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUserInfo(User user);
	
	/**
	 * 删除用户
	 * @param userName
	 */
	public void deleteUserByUserName(String userName);
}
