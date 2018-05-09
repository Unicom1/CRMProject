package com.boot.service;

import java.util.List;
import java.util.Map;

import com.boot.dao.domain.User;
/**
 * 用户模块
 * @author lenovo
 *
 */
public interface UserService {
	public User selectUserById(Integer userId);
	
	/**
	 * 根据用户名获取用户密码
	 * @param userName
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
	 * 获取所有用户信息，分页
	 * @param map
	 * @return
	 */
	public List<User> selectAllUserByPage(int startPage,int pageSize);
	
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
	/**
	 * 登录，若成功，返回0，若密码错误，返回1，若账号不存在，返回2
	 * @param userId
	 * @param userPassword
	 * @return
	 */
	public int login(String userName,String userPassword) throws Exception;
 }
