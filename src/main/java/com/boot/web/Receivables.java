package com.boot.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/Receivables")
public class Receivables {
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/addReceivable",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增收款单接口",notes = "新增收款单")
	public Map addReceivable(@ApiParam(value="收款单信息信息")@RequestParam int id) {
		Map jsonData = new HashMap();
		try {
		
		
		} catch (Exception e) {
		
		}
		return jsonData;
	}
}
