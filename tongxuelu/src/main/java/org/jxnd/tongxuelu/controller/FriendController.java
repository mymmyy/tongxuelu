package org.jxnd.tongxuelu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jxnd.tongxuelu.entity.Friend;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private IFriendService dao;
    
    //添加我的好友
    @ResponseBody
    @RequestMapping("/add")
    public MSG addFriend(Friend friend,HttpSession session){
    	MSG msg = MSG.fail();
    	User user = (User)session.getAttribute("existUser");
    	User spaceUser = (User)session.getAttribute("spaceUser");
        friend.setFriendId(spaceUser.getUserId());
    	friend.setMyId(user.getUserId());
    	try {
			if(this.dao.addFriend(friend)){
				msg = MSG.success();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }    
    //查询好友
    @ResponseBody
    @RequestMapping("/select")
    public MSG selectFriend(int start,int end,HttpSession session){
    	MSG msg = MSG.fail();
    	User user = (User)session.getAttribute("spaceUser");
    	try {
			List<Friend> list = this.dao.selectFriend(user.getUserId(),start,end);
			msg = MSG.success();
			msg.add("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }
    
    @ResponseBody
    @RequestMapping("/selectFriendInfo")
    public MSG selectFriendInfo(int start,int end,HttpSession session){
    	MSG msg = MSG.fail();
    	User user = (User)session.getAttribute("spaceUser");
    	try {
			List<Friend> list = this.dao.selectAllFriendInfo(user.getUserId(),start,end);
			msg = MSG.success();
			msg.add("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }
    
    //删除好友
    @ResponseBody
    @RequestMapping("/delete")
    public MSG deleteFriend(int fId){
    	MSG msg = MSG.fail();
    	try {
    		if(this.dao.deleteFriend(fId)){
				msg = MSG.success();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }
    
    //查询好友数量
    @ResponseBody
    @RequestMapping("/selectCount")
    public MSG SelectCountFriend(HttpSession session){
    	MSG msg = MSG.fail();
    	User user = (User)session.getAttribute("spaceUser");
    	try {
    		int count = this.dao.selectCount(user.getUserId());
    		msg = MSG.success();
    		msg.add("count", count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }
    
    //更新好友备注
    @ResponseBody
    @RequestMapping("/updateName")
    public MSG updateName(String comment,int fId){
    	MSG msg = MSG.fail();
    	try {
			if(this.dao.updateName(comment, fId)){
				msg = MSG.success();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }
    
    //查询是否为好友
    @ResponseBody
    @RequestMapping("/selctIsFriend")
    public MSG selectIsFriend(HttpSession session){
    	MSG msg = MSG.fail();
    	User user = (User)session.getAttribute("existUser");
    	User spaceUser = (User)session.getAttribute("spaceUser");
    	try {
    		boolean flag = this.dao.selectIsFriend(user.getUserId(), spaceUser.getUserId());
			if(flag){
				msg = MSG.success();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msg;
    }
    
}
