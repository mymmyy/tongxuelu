package org.jxnd.tongxuelu.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.jxnd.tongxuelu.utils.SSOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 专用于SSO跳转其他子系统的转发器
 *<p>Title:SsoForwardController</p>
 *@author mym
 *@date 2017-9-16上午10:07:16
 *@version 1.0
 */

@RequestMapping("/SsoForwardController")
@Controller
public class SsoForwardController {
	
	
	/**
	 * 转发到相册空间
	 */
	@RequestMapping("/toAlbumSpace")
	public String toAlbumSpace(HttpServletRequest request){
		
        return "redirect:"+"http://"+SSOUtil.getHostName(request)+
                "/index"+
                "?sessionId="+request.getRequestedSessionId()+"&current="+new Date().getTime();
	}
	
	

}
