package org.jxnd.tongxuelu.service;

import java.util.List;

import javax.mail.MessagingException;

import org.jxnd.tongxuelu.entity.User;
import org.springframework.stereotype.Service;

/**
 * 用户模块接口
 *<p>Title:IUserService</p>
 *@author mym
 *@date 2017-9-4下午6:48:33
 *@version 1.0
 */
@Service
public interface IUserService {

	/**
	 * 查找所有用户
	 *@return 用户list
	 */
	List<User> findAll();

	/**
	 * 根据userId查询
	 *title:selectUserByUserId
	 *@param userId
	 *@return 查询的用户
	 */
	User selectUserByUserId(String userId);

	/**
	 * 注册用户
	 *title:register
	 *@param user
	 *@throws MessagingException
	 */
	int register(User user);

	
	/**
	 * 根据激活码查找用户
	 *title:selectUserByActiveCode
	 *@param activeCode
	 *@return 用户
	 */
	User selectUserByActiveCode(String activeCode);

	/**
	 * 激活用户
	 *title:activeUser
	 *@param existUser
	 */
	int activeUser(User existUser);
	
	
	/**
	 * 根据用户名密码查询用户
	 *title:getUserIdAndPwd
	 *@param userId
	 *@param password
	 *@return
	 */
	User getUserIdAndPwd(String userId,String password);

	int updateHead(User user);
	
	int getAllUserCount();
	
	int updateUserInfo(User user);
}
