package com.boot.service;

import com.boot.dao.domain.User;

public interface UserService {
	User selectUserById(Integer userId);
}
