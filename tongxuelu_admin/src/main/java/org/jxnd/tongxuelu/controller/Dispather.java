package org.jxnd.tongxuelu.controller;

import javax.servlet.http.HttpSession;

import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu.service.IUserService;
import org.jxnd.tongxuelu.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * @see 用于访问静态页面
 * **/
@Controller
public class Dispather{

   @Autowired
   private IUserService iUserService;
   /**
    * @author Administrator
    * @see 用于获取个人空间中的静态页面
    * **/
   @RequestMapping("/space/{url}/{userId}")
   public String  getSpaceJsp(@PathVariable("url")String url,@PathVariable("userId")String userId,HttpSession httpSession){
	   User spaceUser = (User)httpSession.getAttribute("spaceUser"); 
	   //判断是否存在userId这个用户
	   if((spaceUser = this.iUserService.selectUserByUserId(userId)) == null){
		   return "space/404";
	   }else{
		   httpSession.setAttribute("spaceUser", spaceUser);//设置
		   return "space/"+url;
	   }  

   }
   @RequestMapping("/logwrite/{url}")
   public String  getSpace(@PathVariable("url")String url){
	   return "space/"+url;

   }
   /**
    * @author Administrator
    * @see 用于获取登录以及注册等静态页面
    * */
   @RequestMapping("/chenbo/{url}")
   public String getIndexJsp(@PathVariable("url")String url,HttpSession session){
	   /**
	    * 用于模拟登录之后的session中的existUser
	    * */
	   return url;
   }
}
