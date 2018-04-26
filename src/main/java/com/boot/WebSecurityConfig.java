package com.boot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//拦截器暂不启动，否则接口无法测试
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter{

	public final static String SESSION_USERNAME = "userName";//用户名
	public final static String SESSION_AUTHOR="userAuthor";//用户权限，0为管理员，1为总经理，2为部门经理，3为部门工作人员
	public final static String SESSION_DEPARTMENT="userDepartment";//部门，0为销售部，1为产品部，2为财务部

	
	 @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }
	 
	 //拦截器，判断是否有登陆，若没有则返回登录页面
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置,springboot默认error页面为/error，暂时不需自定义error页面
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/index/login");
        addInterceptor.excludePathPatterns("/index/register");
        addInterceptor.excludePathPatterns("/index/logout");
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
     }
    
    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            HttpSession session = request.getSession();
            if (session.getAttribute(SESSION_USERNAME) != null)
                return true;

            // 跳转登录
            String url = "/index/login";
            response.sendRedirect(url);
            return false;
        }
    }

}
