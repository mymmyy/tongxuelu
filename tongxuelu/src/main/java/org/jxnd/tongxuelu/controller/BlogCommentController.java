package org.jxnd.tongxuelu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jxnd.tongxuelu.entity.BlogComment;
import org.jxnd.tongxuelu.entity.ReplyComment;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu.service.IBlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BlogCommentController {
	@Autowired
	public IBlogCommentService dao;//只能注入接口
	
	/**
	 * @author Administrator
	 * @param 博客ID
	 * @see 查询博客文章的评论以及回复
	 * */
	@ResponseBody
	@RequestMapping("/selectAllComment")
    public MSG selectAllComment(String blogId){
		MSG msg = MSG.fail();
		try {
			List<BlogComment> list = this.dao.selectAllCommentAndReply(blogId);
			msg = MSG.success().add("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	//评论
	@ResponseBody
	@RequestMapping("/addComment")
	public MSG addComment(BlogComment blogComment,HttpSession session){
		MSG msg = MSG.fail();
		User user = (User)session.getAttribute("existUser");
		if(user==null){//如果没有登录
			msg = MSG.success();
			msg.add("isLogin", "0");
		}
		else{
			blogComment.setCommentUserId(user.getUserId());
			blogComment.setCommentTime(new java.sql.Date(new Date().getTime()));
			try {
				if(this.dao.addComment(blogComment)){
					msg = MSG.success();
					msg.add("isLogin", "1");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return msg;
	}
	
	//添加回复
	@ResponseBody
	@RequestMapping("/addReply")
	public MSG addReply(ReplyComment replyComment,HttpSession session){
		MSG msg = MSG.fail();
		User user = (User)session.getAttribute("existUser");
		if(user==null){//如果没有登录
			msg = MSG.success();
			msg.add("isLogin", "0");
		}else{
			replyComment.setReplyUserId(user.getUserId());
			replyComment.setReplyTime(new java.sql.Date(new Date().getTime()));
			try {
				if(this.dao.addReply(replyComment)){
					msg = MSG.success();
					msg.add("isLogin", "1");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return msg;
	}
	
	/**
	 * @author Administrator
	 * @param BlogComment实体类
	 * @return MSG
	 * @see 删除评论以及下方的回复(作者权限)
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/space/deleteComment")
	public MSG deleteComment(int id){
		MSG msg = MSG.fail();
		try {
			if(this.dao.deleteComment(id)){
				msg = MSG.success();
				System.out.println("删除评论成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
}
