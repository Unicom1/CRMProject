package com.boot.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dao.domain.User;



@Mapper
public interface UserMapper {
	public User selectUserById(Integer userId);
}
