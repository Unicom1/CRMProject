package com.boot.service;

import com.boot.dao.domain.Dynamics;

public interface DynamicsService {

	/**
	 * 插入动态日志
	 * @param logContent
	 * @param logNumber
	 * @return
	 */
	public int insertDynamics(int logContent,int logNumber);
}
