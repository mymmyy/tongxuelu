package org.jxnd.tongxuelu.service;

import java.util.List;

import javax.mail.MessagingException;

import org.jxnd.tongxuelu.dao.UserMapper;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService的一个实现类
 *<p>Title:UserServiceImpl</p>
 *@date 2017-9-4 7:58:05
 *@version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		return userMapper.selectByExample(null);
	}

	/**
	 * 根据userId获取用户
	 */
	@Override
	public User selectUserByUserId(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	/**
	 * 注册用户
	 * @throws MessagingException 
	 */
	@Override
	public int register(User user){
		//调用方法进行注册	
		return userMapper.insertSelective(user);		
	}

	
	/**
	 * 根据激活码查找用户
	 */
	@Override
	public User selectUserByActiveCode(String activeCode) {
		return  userMapper.selectUserByActiveCode(activeCode);
	}

	/**
	 * 激活用户
	 */
	@Override
	public int activeUser(User existUser) {
		int result = -1;		//激活结果
		long time = System.currentTimeMillis() - existUser.getRegisterTime().getTime();
        //判断是否过了激活时间 24*60*60*1000 小时*分钟*秒*毫秒   这里限定24小时
        if(time > 24*60*60*1000){
        	return result;
        }
        
        result = userMapper.updateByPrimaryKey(existUser);
        
        //如果用户不能被激活，则该用户被删除
        if(result < 0){
        	userMapper.deleteByPrimaryKey(existUser.getUserId());
        }
        
		return result;
	}
	
	
	/**
	 * 根据用户名密码查询用户
	 */
	@Override
	public User getUserIdAndPwd(String userId, String password) {
		return userMapper.getUserIdAndPwd(userId, password);
	}
	
	/**
	 * 修改头像地址
	 */
	@Override
	public int updateHead(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateHead(user);
	}

	@Override
	public int getAllUserCount() {
		// TODO Auto-generated method stub
		return userMapper.getAllUserCount();
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserInfo(user);
	}
	
	
	


}
