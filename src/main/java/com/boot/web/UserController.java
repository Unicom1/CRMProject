package com.boot.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/User")
public class UserController {
	
	private static final String USERMANAGEMENT = "userManagement";
	private static final String ADDUSER = "addUser";
	
	@RequestMapping(value="/userManagementPage")
	public String getUserManagementPage() {
		return USERMANAGEMENT;
	}
	
	@RequestMapping(value="/addUserPage")
	public String getAddUserPage() {
		return ADDUSER;
	}
	
	@Autowired
	private UserService userService;
	

	
	/**
	 * 新增用户，若成功，返回0，用户已存在，返回1，注册失败，返回2，报错返回error
	 * @param user
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增用户接口",notes = "新增用户，但注意id信息不要传，若成功，返回0，用户已存在，返回1，注册失败，返回2，报错返回error")
	public Map addUser(@ApiParam(value="用户信息")@RequestBody User user) {
		
		Map jsonData = new HashMap();
		
		try {
			User userInfo = userService.selectInfoByName(user.getUserName());
			
			
			//用户已存在，无法注册
			if(userInfo != null && userInfo.getId()>0) {
				jsonData.put("state",1);
				return jsonData;
			}
			
			userService.insertUser(user);
			
			//插入成功
			if(user.getId()> 0) {
				jsonData.put("state",0);
			} else {
				//插入失败
				jsonData.put("state", 2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		
		return jsonData;

	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/changeUserInfo",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "修改用户信息接口",notes = "注意，ID不可传入，修改若成功，返回0，报错返回error")
	public Map changeUserInfo(@ApiParam(value="需要修改的用户信息")@RequestBody User user) {
		
		Map jsonData = new HashMap();
		try {
			userService.updateUserInfo(user);
			jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/changeUserPass",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "用户修改用户密码",notes = "修改若成功，返回0，若旧密码错误，返回1，报错返回error")
	public Map userChangePass(
			@ApiParam(value = "用户旧密码")@RequestParam String oldPass,
			@ApiParam(value = "用户新密码")@RequestParam String newPass) {
		Map jsonData = new HashMap();
		try {
			 HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			 HttpSession session = request.getSession();
			 String userName = session.getAttribute(WebSecurityConfig.SESSION_USERNAME).toString();
			 
			 //获取用户原密码
			 String userPass = userService.selectInfoByName(userName).getUserPassword();
			//若用户输入的旧密码错误
			 if(!userPass.equals(oldPass)) {
				 jsonData.put("state",1);
				 return jsonData;
			 }
			 
			 User user = new User();
			 user.setUserName(userName);
			 user.setUserPassword(newPass);
			 userService.updateUserInfo(user);
			 jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/adminChangeUserPass",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "管理员修改用户密码",notes = "修改若成功，返回0，若旧密码错误，返回1，报错返回error")
	public Map adminChangeUserPass(
			@ApiParam(value = "用户名")@RequestParam String userName,
			@ApiParam(value = "用户新密码")@RequestParam String userPass) {
		Map jsonData = new HashMap();
		try {
			 
			 User user = new User();
			 user.setUserName(userName);
			 user.setUserPassword(userPass);
			 userService.updateUserInfo(user);
			 jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/deleteUser",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "删除用户",notes = "删除若成功，返回0，报错返回error")
	public Map deleteUser(@ApiParam(value = "用户名")@RequestParam String userName) {
		Map jsonData = new HashMap();
		try {
			userService.deleteUserByUserName(userName);
			jsonData.put("state",0);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/selectAllUserByPage",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "分页获取用户",notes = "获取成功，返回0，报错返回error")
	public Map selectAllUserByPage(@ApiParam(value = "页数")@RequestParam int startPage,
			@ApiParam(value = "每页显示条数")@RequestParam int pageSize) {
		Map jsonData = new HashMap();
		try {
			List<User> userList = userService.selectAllUserByPage(startPage, pageSize);
			jsonData.put("state", 0);
			jsonData.put("aaData", userList);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.put("state",Utils.ERROR);
		}
		return jsonData;
		
	}
}


