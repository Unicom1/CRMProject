package com.boot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.boot.WebSecurityConfig;

public class Utils {
	public final static String ERROR = "error";
	
	public String getCurrentTime () {
		 Date d = new Date();
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     return sdf.format(d);
	}
	
	//获取当前操作者session
	public static String getCurrentUser () {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		String currentUserName;
		if(session.getAttribute(WebSecurityConfig.SESSION_USERNAME) != null) {
			currentUserName = session.getAttribute(WebSecurityConfig.SESSION_USERNAME).toString();
		} else {
			currentUserName = "null";
		}
		return currentUserName;
	}
}
