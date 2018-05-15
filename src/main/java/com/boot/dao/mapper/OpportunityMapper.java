package com.boot.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dao.domain.Opportunity;

@Mapper
public interface OpportunityMapper {

	/**
	 * 插入商机
	 * @param opportunity
	 * @return
	 */
	public int insertOpportunity(Opportunity opportunity);
	
	/**
	 * 修改商机信息
	 * @param oppo
	 */
	public void updateOppoInfo(Opportunity oppo);
	
	/**
	 * 获取所有商机
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Opportunity> selectAllOppo(Map map);
	
	/**
	 * 根据ID获取某个商机信息
	 * @param id
	 * @return
	 */
	public Opportunity selectOppoById(int id);
}
