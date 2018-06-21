package com.boot.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.dao.domain.Product;
import com.boot.service.ProductService;
import com.boot.utils.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/Product")
public class ProductContoller {

	@Autowired
	private ProductService productService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/addProduct",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增产品接口",notes = "新增产品，但注意id不要传，若成功，返回0，报错返回error")
	public Map addProduct(@ApiParam(value="产品信息")@RequestBody Product product) {
		Map jsonData = new HashMap();
		try {
			productService.insertProduct(product);
			jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/getProductById",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据ID获取产品接口",notes = "根据ID获取产品信息若成功，返回0，报错返回error")
	public Map getProductInfoById(@ApiParam(value = "商机ID")@RequestParam int productId) {
		Map jsonData = new HashMap();
		try {
			Product product = productService.selectProductById(productId);
			jsonData.put("state",0);
			jsonData.put("aaData", product);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	} 
}
