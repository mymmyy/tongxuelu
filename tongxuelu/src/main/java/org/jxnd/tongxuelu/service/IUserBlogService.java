package org.jxnd.tongxuelu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.UserBlog;
import org.springframework.stereotype.Service;

@Service
public interface IUserBlogService {
	/**
	 * 添加博客
	 * @param record 用户博客
	 * @return
	 */
	 int addArticle(UserBlog record);
	 /**
	  * 通过用户id取得所有博客
	  * @param user_id 用户id
	  * @param pn 页码
	  * @param size 一页记录
	  * @param deleteState 删除状态
	  * @return
	  */
	 List<UserBlog> getAllUserBlogByUserId(String user_id,int pn,int size,int deleteState);
	 /**
	  * 通过博客id取得博客
	  * @param blogId 博客id
	  * @return
	  */
	 UserBlog getUserBlogByBlogId(String blogId);
	 /**
	  * 取得所有的博客
	  * @param pn 页码
	  * @param size 一页记录
	  * @return
	  */
	 List<UserBlog> getAllUserBlog(int pn,int size);
	 /**
	  * 通过类别id取得博客
	  * @param categoryId 类别id
	  * @param pn 页码
	  * @param size 一页记录
	  * @return
	  */
	 List<UserBlog> getAllUserBlogByCategoryId(int categoryId,int pn,int size);
	 /**
	  * 统计博客数量
	  * @param userId 用户id
	  * @param categoryId 类别id
	  * @return
	  */
	 int getAllUserBlogCount(String userId,int categoryId);
	 /**
	  * 修改用户博客
	  * @param userBlog 用户博客
	  * @return
	  */
	 int updateUserBlogByBlogId(UserBlog userBlog);
	 /**
	  * 博客模糊查询
	  * @param userId 用户id
	  * @param categoryId 类别id
	  * @param blogTitle 博客标题
	  * @param pn 页码
	  * @param size 一页记录
	  * @return
	  */
	 List<UserBlog> getAllUserBlogWithLike(String msg,int pn,int size);
}
