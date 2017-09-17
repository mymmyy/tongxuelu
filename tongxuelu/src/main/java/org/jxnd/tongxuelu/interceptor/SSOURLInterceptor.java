package org.jxnd.tongxuelu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxnd.tongxuelu.entity.FtpConfig;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu.service.IRedisCache;
import org.jxnd.tongxuelu.utils.SSOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 拦截SSO单点登陆的URL
 *<p>Title:SSOURLInterceptor</p>
 *@author mym
 *@date 2017-9-16上午11:23:35
 *@version
 */
public class SSOURLInterceptor extends HandlerInterceptorAdapter {

	/*
	 * 个人空间  existUser
	 * /tongxuelu/space/homepage/maoyuanming?sessionId=03C88F9742778C683ED8941634AEC0A4
	 * 我的文章 existUser
	 * /tongxuelu/chenbo/list?sessionId=03C88F9742778C683ED8941634AEC0A4
	 * 留言板 existUser
	 * /tongxuelu/space/leaveWord/maoyuanming?sessionId=D2C5278A6FDA72E8C2FDC09B8C5B7E32
	 * 我的好友 existUser
	 * /tongxuelu/space/myFriend/maoyuanming?sessionId=D2C5278A6FDA72E8C2FDC09B8C5B7E32
	 */
	
	
	@Autowired
	private IRedisCache iRedisCache;		//redis操作接口
	
	@Autowired
	private FtpConfig ftpConfig;			//由于可能要重新设置session中的user，所以要把user的imgurl进行更换
	
	
	
	
	/**
	 * 前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler){
		System.out.println("进入了拦截器！");
		
		String sessionId = request.getParameter("sessionId");
		if(sessionId == null){
			//如果没有sessionId这个参数，说明不是sso登陆，不需要拦截操作，直接放过
			return true;
		}
		
		

		
		
		//说明是要查询existUser
		User existUser = (User) request.getSession().getAttribute("existUser");
		if(existUser == null){
			//不存在就去查redis，有异常一定要捕获，让程序继续运行
			try {
				existUser = iRedisCache.getCache(sessionId);
				System.out.println("param:"+sessionId+"---own："+request.getRequestedSessionId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(existUser != null){
				existUser.setImgurl(ftpConfig.getIMAGE_BASE_URL()+existUser.getImgurl());
				request.getSession().setAttribute("existUser", existUser);
			}
		}
		
		
		
		/*		
		//0.由于不通链接判断的用户是不同的，就不多做一个拦截器，统一在这里处理
		//所以先要判断url连接是什么
		String thisUri = request.getRequestURI();
		  if(thisUri.startsWith("/tongxuelu/space/homepage")){
			
			//说明是要查询existUser
			User existUser = (User) request.getSession().getAttribute("existUser");
			if(existUser == null){
				//不存在就去查redis，有异常一定要捕获，让程序继续运行
				try {
					existUser = iRedisCache.getCache(sessionId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(existUser != null){
					existUser.setImgurl(ftpConfig.getIMAGE_BASE_URL()+existUser.getImgurl());
					request.getSession().setAttribute("existUser", existUser);
				}
			}
			
		}else{
			//说明要查询的是spaceUser
			User spaceUser = (User) request.getSession().getAttribute("spaceUser");
			if(spaceUser == null){
				//不存在就去查redis有异常一定要捕获，让程序继续运行
				try {
					spaceUser = iRedisCache.getCache(sessionId);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(spaceUser != null){
					spaceUser.setImgurl(ftpConfig.getIMAGE_BASE_URL()+spaceUser.getImgurl());
					request.getSession().setAttribute("spaceUser", spaceUser);
				}
			}
		}*/
		
		
		//return true 放它过
		return true;
	}

	/**
	 * 请求后
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	

}
