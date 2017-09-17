package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.dao.BlogCommentMapper;
import org.jxnd.tongxuelu.entity.BlogComment;
import org.jxnd.tongxuelu.entity.ReplyComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogCommentServiceImpl implements IBlogCommentService{
	
    @Autowired
	public BlogCommentMapper blogCommentMapper;
    
	@Override
	public List<BlogComment> selectAllCommentAndReply(String blogId)
			throws Exception {
		List<BlogComment> list = this.blogCommentMapper.selectAllCommentAndReply(blogId);
		return list;
	}
	
	//添加评论
   public boolean addComment(BlogComment blogComment) throws Exception{
	   boolean flag = false;
	   if(this.blogCommentMapper.addComment(blogComment)>0){
		   flag = true;
	   }
	   return flag;
	   
   }
   
   //添加回复
   public boolean addReply(ReplyComment replyComment) throws Exception{
	   boolean flag = false;
	   if(this.blogCommentMapper.addReply(replyComment)>0){
		   flag = true;
	   }
	   return flag;
   }
   
   //删除评论(以及回复)
   public boolean deleteComment(Integer id) throws Exception{
	   boolean flag = false;
	   int count = this.blogCommentMapper.deleteComment(id);
	   int count2 = this.blogCommentMapper.deleteReply(id);
	   if(count>0 && count2>0){
		   flag = true;
	   }
	   return flag;
   }
   
   /*//删除回复
   public boolean deleteReply(Integer commentId) throws Exception{
	   boolean flag = false;
	   if(this.blogCommentMapper.deleteReply(commentId)>0){
		   flag = true;
	   }
	   return flag;
   }*/
	
	
      
}
