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

import com.boot.dao.domain.Customer;
import com.boot.service.CustomerService;
import com.boot.service.DynamicsService;
import com.boot.utils.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DynamicsService dynamicsService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/selectCustomerById",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据客户ID查询客户信息",notes = "获取成功，返回0及相关信息，报错返回error")
	public Map selectCustomerById(@ApiParam(value = "客户ID")@RequestParam int customerId) {
		Map jsonData = new HashMap();
		try {
			Customer customer  = customerService.selectCustomerById(customerId);
			jsonData.put("state",0);
			jsonData.put("aaData", customer);
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/addCustomer",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增客户接口",notes = "新增客户，但注意id,createTime,cResponsible信息不要传，若成功，返回0，报错返回error")
	public Map addCustomer(@ApiParam(value="客户信息")@RequestBody Customer customer) {
		Map jsonData = new HashMap();
		
		try {
			customer.setcResponsible(Utils.getCurrentUser());
			customerService.insertCustomer(customer);
			dynamicsService.insertDynamics(0, customer.getId());
			jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/changeCustomerInfo",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "修改客户信息接口",notes = "修改客户信息，但createTime信息不要传，若成功，返回0，报错返回error")
	public Map changeCustomerInfo(@ApiParam(value="客户信息")@RequestBody Customer customer) {
		Map jsonData = new HashMap();
		try {
			customerService.updateCustomerInfo(customer);
			jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/relateCustomerAndContact",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "关联客户与联系人接口",notes = "关联客户与联系人接口，若成功，返回0，报错返回error")
	public Map relateCustomerAndContact(
			@ApiParam(value = "客户ID")@RequestParam int customerId,
			@ApiParam(value = "联系人ID")@RequestParam int contactId) {
		Map jsonData = new HashMap();
		try {
			customerService.relateCustomerAndContact(customerId, contactId);
			jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/selectCustomerContainContactList",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "分页获取客户，包含联系人",notes = "获取成功，返回0，报错返回error")
	public Map selectCustomerContainContactList(@ApiParam(value = "页数")@RequestParam int startPage,
			@ApiParam(value = "每页显示条数")@RequestParam int pageSize) {
		Map jsonData = new HashMap();
		try {
			List<Map<String,Object>> customerList = customerService.selectCustomerContainContact(startPage, pageSize);
			jsonData.put("state", 0);
			jsonData.put("aaData", customerList);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/selectCustomerWithoutContact",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "获取尚未关联联系人的客户",notes = "获取成功，返回0，报错返回error")
	public Map selectCustomerWithoutContact() {
		Map jsonData = new HashMap();
		try {
			List<Customer> customerList = customerService.selectCustomerWithoutContact();
			jsonData.put("state",0);
			jsonData.put("aaData",customerList);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/queryCustomerList",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "分页搜索客户",notes = "搜索客户，若不传入客户名则默认获取所有客户,成功，返回0，报错返回error")
	public Map queryCustomerList(@ApiParam(value = "页数")@RequestParam int startPage,
			@ApiParam(value = "每页显示条数")@RequestParam int pageSize,
			@ApiParam(value = "客户名")@RequestParam(required=false) String cName	) {
		Map jsonData = new HashMap();
		try {
			List<Map<String,Object>> customerList = customerService.queryCustomer(startPage, pageSize, cName);
			jsonData.put("state", 0);
			jsonData.put("aaData", customerList);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
}
