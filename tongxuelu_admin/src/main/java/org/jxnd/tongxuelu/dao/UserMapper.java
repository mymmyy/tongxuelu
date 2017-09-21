package org.jxnd.tongxuelu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu.entity.UserExample;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //================================自增方法=================
    /**
     * 根据激活码查找用户
     */
	User selectUserByActiveCode(String activeCode);
	
	
	/**
	 * 根据用户名密码查找用户
	 *title:getUserIdAndPwd
	 *@param userId
	 *@param password
	 *@return 一个用户
	 */
	User getUserIdAndPwd(@Param("userId")String userId,@Param("password")String password);
    
	int updateHead(User user);
	
	int getAllUserCount();
	
	List<User> selectUserAll();
	
	int deleteUser(String userId);
	
	List<User> getUserByPage(@Param("pageIndex")int pageIndex,@Param("size")int size);
	
	int getUserCount();
	
	
    
}