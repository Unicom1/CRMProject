package com.boot.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.boot.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/index")
public class IndexController {
	private static final String INDEX = "index";
	
	@Autowired
	private UserService userService;
	
/*	@RequestMapping(value="/show",method = RequestMethod.GET)
    public ModelAndView  getIndex() {
        //return INDEX;
		ModelAndView mv = new ModelAndView("index"); 
        return mv;
    }*/
	
	@RequestMapping(value="/show",method = RequestMethod.GET)
    public String  getIndex() {
        return INDEX;
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/user",method = RequestMethod.GET)
	@ResponseBody //如果需要返回json或者xml或者自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解
	@ApiOperation(value = "测试接口",notes = "这个接口通过输入一个用户ID，返回用户名信息")
	public Map getUserInfo(
			@ApiParam(value = "用户ID")
			@RequestParam int userId) {//获取json对象用RequestBody
		System.out.println(userId);
		String userName = userService.selectUserById(userId).getUserName();
		Map jsonData = new HashMap();
		jsonData.put("userName", userName);
		return jsonData;
	}
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	@ApiOperation(value = "测试接口",notes = "仅仅是测试")
    public String test() {
		System.out.println("a");
        return "xxx";
    }
}
