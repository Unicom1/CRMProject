package com.boot.service;

import java.util.List;

import com.boot.dao.domain.Opportunity;

public interface OpportunityService {

	/**
	 * 插入商机
	 * @param oppirtunity
	 * @return
	 */
	public int insertOpportunity(Opportunity oppirtunity);
	
	/**
	 * 修改商机信息
	 * @param oppo
	 */
	public void updateOppoInfo(Opportunity oppo);
	
	/**
	 * 获取所有商机
	 * @return
	 */
	public List<Opportunity> selectAllOppo(int startPage,int pageSize,String bussessName);
	
	/**
	 * 根据ID获取商机信息
	 * @param id
	 * @return
	 */
	public Opportunity selectOppoById(int id);
}
