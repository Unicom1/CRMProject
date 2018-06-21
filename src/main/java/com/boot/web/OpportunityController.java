package com.boot.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.dao.domain.Opportunity;
import com.boot.service.DynamicsService;
import com.boot.service.OpportunityService;
import com.boot.utils.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/Opportunity")
public class OpportunityController {
	
	@Autowired
	private OpportunityService opportunityService; 
	
	@Autowired
	private DynamicsService dynamicsService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/addOpportunity",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增商机接口",notes = "新增商机，但注意id,createTime,responsible不要传，若成功，返回0，报错返回error")
	public Map addOpportunity (@ApiParam(value="商机信息")@RequestBody Opportunity opportunity) {
		Map jsonData = new HashMap();
		
		try {
			opportunity.setBussessResponsible(Utils.getCurrentUser());
			opportunityService.insertOpportunity(opportunity);
			dynamicsService.insertDynamics(1, opportunity.getId());
			jsonData.put("state",0);
			jsonData.put("message", "新增商机成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
			jsonData.put("message", "系统报错，请联系管理员");
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/changeOppoInfo",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "修改商机信息接口",notes = "修改商机，但注意createTime,responsible不要传，若成功，返回0，报错返回error")
	public Map changeOppoInfo(@ApiParam(value="商机信息")@RequestBody Opportunity oppo) {
		Map jsonData = new HashMap();
		try {
			opportunityService.updateOppoInfo(oppo);
			jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/getAllOppo",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "获取所有商机接口",notes = "获取所有商机,如果不传入参数，则获取所有商机，若传入商机名，则是搜索商机，若成功，返回0，报错返回error")
	public Map getAllOppo(
			@ApiParam(value = "页数")@RequestParam int startPage,
			@ApiParam(value = "每页显示条数")@RequestParam int pageSize,
			@ApiParam(value = "商机名")@RequestParam(required=false) String bussessName) {
		Map jsonData = new HashMap();
		try {
			List<Opportunity> oppoList = opportunityService.selectAllOppo(startPage,pageSize,bussessName);
			jsonData.put("state",0);
			jsonData.put("aaData",oppoList);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/getOppoInfoById",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据ID获取商机接口",notes = "根据Id获取商机，若成功，返回0，报错返回error")
	public Map getOppoInfoById(@ApiParam(value = "商机ID")@RequestParam int oppoId) {
		Map jsonData = new HashMap();
		try {
			Opportunity oppo = opportunityService.selectOppoById(oppoId);
			jsonData.put("state",0);
			jsonData.put("aaData", oppo);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
}
