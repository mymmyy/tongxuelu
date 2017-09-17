package org.jxnd.tongxuelu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.jxnd.tongxuelu.entity.UserBlog;
import org.jxnd.tongxuelu.entity.UserBlogExample;

public interface UserBlogMapper {
    long countByExample(UserBlogExample example);

    int deleteByExample(UserBlogExample example);

    int deleteByPrimaryKey(String blogId);

    int addArticle(UserBlog record);

    int insertSelective(UserBlog record);

    List<UserBlog> selectByExampleWithBLOBs(UserBlogExample example);

    List<UserBlog> selectByExample(UserBlogExample example);

    UserBlog selectByPrimaryKey(String blogId);

    int updateByExampleSelective(@Param("record") UserBlog record, @Param("example") UserBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") UserBlog record, @Param("example") UserBlogExample example);

    int updateByExample(@Param("record") UserBlog record, @Param("example") UserBlogExample example);

    int updateByPrimaryKeySelective(UserBlog record);

    int updateByPrimaryKeyWithBLOBs(UserBlog record);

    int updateByPrimaryKey(UserBlog record);
    
    List<UserBlog> getAllUserBlog(@Param("pn")int pn,@Param("size")int size);
    
    List<UserBlog> getAllUserBlogByUserId(@Param("userId")String userId,@Param("pn")int pn,@Param("size")int size,@Param("deleteState")int deleteState);
    
    List<UserBlog> getAllUserBlogByCategoryId(@Param("categoryId")int categoryId,@Param("pn")int pn,@Param("size")int size);
    
    UserBlog getUserBlogByBlogId(@Param("blogId")String blogId);
    
    int getAllUserBlogCount(@Param("userId")String userId,@Param("categoryId")int categoryId);
    
    int updateUserBlogByBlogId(UserBlog userBlog);
    
    List<UserBlog> getAllUserBlogWithLike(@Param("msg")String msg,@Param("pn")int pn,@Param("size")int size);
}