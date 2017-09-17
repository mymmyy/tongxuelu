package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.dao.UserBlogMapper;
import org.jxnd.tongxuelu.entity.UserBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserBlogServiceImpl implements IUserBlogService {
	@Autowired
	private UserBlogMapper userBlogMapper; 
	@Override
	public int addArticle(UserBlog record) {
		return userBlogMapper.addArticle(record);
	}
	@Override
	public List<UserBlog> getAllUserBlogByUserId(String user_id,int pn,int size,int deleteState) {
		return userBlogMapper.getAllUserBlogByUserId(user_id,pn,size,deleteState);
	}
	@Override
	public UserBlog getUserBlogByBlogId(String blogId) {
		// TODO Auto-generated method stub
		return userBlogMapper.getUserBlogByBlogId(blogId);
	}
	@Override
	public List<UserBlog> getAllUserBlog(int pn,int size) {
		// TODO Auto-generated method stub
		return userBlogMapper.getAllUserBlog(pn,size);
	}
	@Override
	public List<UserBlog> getAllUserBlogByCategoryId(int categoryId,int pn,int size) {
		// TODO Auto-generated method stub
		return userBlogMapper.getAllUserBlogByCategoryId(categoryId,pn,size);
	}
	@Override
	public int getAllUserBlogCount(String userId, int categoryId) {
		// TODO Auto-generated method stub
		return userBlogMapper.getAllUserBlogCount(userId, categoryId);
	}
	@Override
	public int updateUserBlogByBlogId(UserBlog userBlog) {
		// TODO Auto-generated method stub
		return userBlogMapper.updateUserBlogByBlogId(userBlog);
	}
	@Override
	public List<UserBlog> getAllUserBlogWithLike(String msg, int pn, int size) {
		// TODO Auto-generated method stub
		return userBlogMapper.getAllUserBlogWithLike(msg, pn, size);
	}

}
