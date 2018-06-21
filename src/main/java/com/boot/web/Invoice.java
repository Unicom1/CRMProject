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
@RequestMapping("/Invoice")
public class Invoice {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/addInvoice",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增发票接口",notes = "新增发票")
	public Map addInvoice(@ApiParam(value="发票信息")@RequestParam int id) {
		Map jsonData = new HashMap();
		try {
		
		
		} catch (Exception e) {
		
		}
		return jsonData;
	}
}
