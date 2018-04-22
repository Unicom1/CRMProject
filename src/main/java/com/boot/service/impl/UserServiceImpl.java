package com.boot.service.impl;

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
}
