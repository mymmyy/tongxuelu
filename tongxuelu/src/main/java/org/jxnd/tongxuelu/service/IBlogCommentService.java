package org.jxnd.tongxuelu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.BlogComment;
import org.jxnd.tongxuelu.entity.ReplyComment;

public interface IBlogCommentService {
	  /**
	    * @author Administrator
	    * @see 查询博客评论以及评论回复
	    * @return ：List<BlogComment>
	    * @param 
	    * */
	  public List<BlogComment> selectAllCommentAndReply(@Param("blogId")String blogId) throws Exception;
	 
	//添加评论
   public boolean addComment(BlogComment blogComment) throws Exception;
   
   //添加回复
   public boolean addReply(ReplyComment replyComment) throws Exception;
   
   //删除评论
   public boolean deleteComment(Integer id) throws Exception;
   
   /*//删除回复
   public boolean deleteReply(Integer commentId) throws Exception;*/
}
