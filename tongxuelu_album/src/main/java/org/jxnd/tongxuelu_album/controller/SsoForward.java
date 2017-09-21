package org.jxnd.tongxuelu_album.controller;

import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.utils.SSOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by mym on 2017/9/15.
 * sso跳转处理的controller
 */
@Controller
@RequestMapping("/tongxuelu_album/SsoForward")  //标识是本系统的sso转发
public class SsoForward {

    /**
     * 去个人空间的转发
     */
    @RequestMapping("/toPersonalSpace")
    public String toPersonalSpace(HttpServletRequest request){
        String sessionID = request.getRequestedSessionId();
        User existUser = (User) request.getSession().getAttribute("existUser");


/*        System.out.println("getRequestURI:"+request.getRequestURI());
        System.out.println("getServerPort:"+request.getServerPort());
        System.out.println("getRemoteUser:"+request.getRemoteUser());
        System.out.println("getContextPath:"+request.getContextPath());
        System.out.println("getRemoteAddr:"+request.getRemoteAddr());
        System.out.println("getRemoteHost:"+request.getRemoteHost());*/



        return "redirect:"+"http://"+SSOUtil.getHostName(request)+
                "/tongxuelu/space/homepage/"+existUser.getUserId()+
                "?sessionId="+request.getRequestedSessionId()+"&current="+new Date().getTime();

    }


    /**
     * 去文章列表页
     */
    @RequestMapping("/toPersonalArticle")
    public String toPersonalArticle(HttpServletRequest request){
        User existUser = (User) request.getSession().getAttribute("existUser");
        return "redirect:"+"http://"+SSOUtil.getHostName(request)+
                "/tongxuelu/chenbo/list"+
                "?sessionId="+request.getRequestedSessionId()+"&current="+new Date().getTime();
    }


    /**
     * 去留言板
     */
    @RequestMapping("/toPersonalLeaveWord")
    public String toPersonalLeaveWord(HttpServletRequest request){
        User existUser = (User) request.getSession().getAttribute("existUser");
        return "redirect:"+"http://"+SSOUtil.getHostName(request)+
                "/tongxuelu/space/leaveWord/"+existUser.getUserId()+
                "?sessionId="+request.getRequestedSessionId()+"&current="+new Date().getTime();
        //return "redirect:getLink?sessionId="+request.getRequestedSessionId();
    }


    /**
     * 查看我的好友
     */
    @RequestMapping("toPersonalFriend")
    public String toPersonalFriend(HttpServletRequest request){
        User existUser = (User) request.getSession().getAttribute("existUser");
        return "redirect:"+"http://"+SSOUtil.getHostName(request)+
                "/tongxuelu/space/myFriend/"+existUser.getUserId()+
                "?sessionId="+request.getRequestedSessionId()+"&current="+new Date().getTime();
    }


}
