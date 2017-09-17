package org.jxnd.tongxuelu_album.controller;

import org.jxnd.tongxuelu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mym on 2017/9/12.
 * 首页的controller
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        System.out.println("into index.html!");

        User existUser = (User) request.getSession().getAttribute("existUser");

        if(existUser == null){
            return "/login.ftl";
        }

        return "redirect:/AlbumController/list/"+existUser.getUserId()+"/1";
    }


    /**
     * 注销的方法
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){

        request.getSession().invalidate();

        return "redirect:/index.html";
    }

    @RequestMapping("/login")
    public String login(){
        return "/login.ftl";
    }



}
