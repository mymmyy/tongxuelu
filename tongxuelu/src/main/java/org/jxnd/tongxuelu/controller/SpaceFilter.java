package org.jxnd.tongxuelu.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SpaceFilter
 */
public class SpaceFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SpaceFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		   HttpServletRequest req = (HttpServletRequest)request;
	        HttpSession session = req.getSession();
	        HttpServletResponse res = (HttpServletResponse)response;
	        //如果用户没有登录
	        if(session.getAttribute("existUser")==null){
	        	 req.getRequestDispatcher("/user/toLogin").forward(req, res);
	        }else{
	        	chain.doFilter(request, response);
	        }
			// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
