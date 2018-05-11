package com.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.domain.Dynamics;
import com.boot.dao.mapper.DynamicsMapper;
import com.boot.service.DynamicsService;
import com.boot.utils.Utils;

@Service
public class DynamicsServiceImpl implements DynamicsService{

	@Autowired
	private DynamicsMapper dynamicsMapper;

	@Override
	public int insertDynamics(int logContent, int logNumber) {
		// TODO Auto-generated method stub
		Dynamics dynamics = new Dynamics();
		dynamics.setLogUserName(Utils.getCurrentUser());
		dynamics.setLogContent(logContent);
		dynamics.setLogNumber(logNumber);
		return dynamicsMapper.insertDynamics(dynamics);
	}
	


}
