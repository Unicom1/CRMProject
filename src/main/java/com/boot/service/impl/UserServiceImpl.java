package com.boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.domain.User;
import com.boot.dao.mapper.UserMapper;
import com.boot.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(userId);
	}

	@Override
	public String selectPassByName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.selectPassByName(userName);
	}
	
	@Override
	public User selectInfoByName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.selectInfoByName(userName);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<User> selectAllUserByPage(int startPage,int pageSize) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = (startPage-1)*pageSize;
		map.put("start", start);
		map.put("pageSize",pageSize);
		return userMapper.selectAllUser(map);
	}
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}
	
	@Override
	public void updateUserInfo(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUserInfo(user);
	}
	
	@Override
	public void deleteUserByUserName(String userName) {
		// TODO Auto-generated method stub
		userMapper.deleteUserByUserName(userName);
	}
	
	@Override
	public int login(String userName, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		String getPass = selectPassByName(userName);
		
		if(getPass == null) {
			return 2;
		} else if(getPass.equals(userPassword)) {
			return 0;
		} 
		return 1;
	}












}
