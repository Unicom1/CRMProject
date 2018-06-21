package com.boot.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.dao.domain.Product;
import com.boot.utils.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/Payments")
public class Payments {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/addPayment",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增回款单接口",notes = "新增回款单")
	public Map addPayment(@ApiParam(value="回款单信息信息")@RequestParam int id) {
		Map jsonData = new HashMap();
		try {
		
		
		} catch (Exception e) {
		
		}
		return jsonData;
	}
}
