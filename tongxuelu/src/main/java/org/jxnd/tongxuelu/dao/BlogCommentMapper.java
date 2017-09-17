package org.jxnd.tongxuelu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;
import org.jxnd.tongxuelu.entity.BlogComment;
import org.jxnd.tongxuelu.entity.ReplyComment;

public interface BlogCommentMapper {
   /**
    * @author Administrator
    * @see 查询博客评论以及评论回复
    * @return ：List<BlogComment>
    * @param 
    * */
   public List<BlogComment> selectAllCommentAndReply(@Param("blogId")String blogId) throws Exception;
   
   //添加评论
   public int addComment(BlogComment blogComment) throws Exception;
   
   //添加回复
   public int addReply(ReplyComment replyComment) throws Exception;
   
   //删除评论
   public int deleteComment(Integer id) throws Exception;
   
   //删除回复
   public int deleteReply(Integer commentId) throws Exception;
   
}
