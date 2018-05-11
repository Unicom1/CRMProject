package com.boot.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dao.domain.Dynamics;

@Mapper
public interface DynamicsMapper {
	
	/**
	 * 插入日志动态
	 * @param dynamics
	 * @return
	 */
	public int insertDynamics(Dynamics dynamics);
}
