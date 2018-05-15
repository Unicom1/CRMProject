package com.boot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.domain.Opportunity;
import com.boot.dao.mapper.OpportunityMapper;
import com.boot.service.OpportunityService;

@Service
public class OpportunityServiceImpl implements OpportunityService{

	@Autowired
	private OpportunityMapper opportunityMapper;
	@Override
	public int insertOpportunity(Opportunity oppirtunity) {
		// TODO Auto-generated method stub
		return opportunityMapper.insertOpportunity(oppirtunity);
	}
	
	@Override
	public void updateOppoInfo(Opportunity oppo) {
		// TODO Auto-generated method stub
		opportunityMapper.updateOppoInfo(oppo);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Opportunity> selectAllOppo(int startPage,int pageSize,String bussessName) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int start = (startPage-1)*pageSize;
		map.put("start", start);
		map.put("pageSize",pageSize);
		if(bussessName != null) {
			map.put("bussessName", bussessName);
		}
		return opportunityMapper.selectAllOppo(map);
	}

	@Override
	public Opportunity selectOppoById(int id) {
		// TODO Auto-generated method stub
		return opportunityMapper.selectOppoById(id);
	}

}
