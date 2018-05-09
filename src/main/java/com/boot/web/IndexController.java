package com.boot.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.boot.WebSecurityConfig;
import com.boot.dao.domain.User;
import com.boot.service.UserService;
import com.boot.utils.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/index")
public class IndexController {
	private static final String INDEX = "index";
	private static final String LOGIN = "login";
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value="/show")
    public String  getIndex() {
        return INDEX;
    }
	/**
	 * 登录，若成功，返回0，若密码错误，返回1，若账号不存在，返回2,报错返回error
	 * @param userId
	 * @param userPassword
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "登录接口",notes = "传入用户名和用户密码，若登陆成功返回0，密码错误返回1，账号不存在返回2，报错返回error")
	public Map login(
			@ApiParam(value = "用户名")@RequestParam String userName,
			@ApiParam(value = "用户密码")@RequestParam String userPassword) {
		
		Map jsonData = new HashMap();
		try {
			int state = userService.login(userName, userPassword);
			
			//如果登陆成功，设置session
			if(state == 0) {
				User userInfo = userService.selectInfoByName(userName);
				HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
				HttpSession session = request.getSession();
				session.setAttribute(WebSecurityConfig.SESSION_USERNAME,userName);
				session.setAttribute(WebSecurityConfig.SESSION_AUTHOR, userInfo.getUserAuthor());
				session.setAttribute(WebSecurityConfig.SESSION_DEPARTMENT, userInfo.getUserDepartment());
			}
			jsonData.put("state", state);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}

		return jsonData;
	}
	
	//注销登录，消除session
	@RequestMapping(value="/logout")
	public String logout() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		 HttpSession session = request.getSession();
		session.removeAttribute(WebSecurityConfig.SESSION_USERNAME);
		session.removeAttribute(WebSecurityConfig.SESSION_AUTHOR);
		session.removeAttribute(WebSecurityConfig.SESSION_DEPARTMENT);
		return "redirect:/index/login";
		
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
        return "test";
    }
}
