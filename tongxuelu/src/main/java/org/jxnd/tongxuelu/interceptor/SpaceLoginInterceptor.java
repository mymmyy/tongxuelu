package org.jxnd.tongxuelu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 进入space的拦截器，代替controller包中的SpaceFilter功能，没有增删任何功能
 *<p>Title:SpaceLoginInterceptor</p>
 *@author mym
 *@date 2017-9-16下午5:30:41
 *@version
 */
public class SpaceLoginInterceptor extends HandlerInterceptorAdapter {

	/**
	 * controller请求前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			// place your code here
		  
	        HttpSession session = request.getSession();
	   
	        //如果用户没有登录
	        if(session.getAttribute("existUser")==null){
	        	response.sendRedirect("/tongxuelu/user/toLogin");		//重定向到登陆controller
	        	
	        	return false;		//不让走
	        }
	        
	        
			// pass the request along the filter chain
		
		
		return true;   //放过
	}

	
	//后两个方法不管
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	
	
	
}
