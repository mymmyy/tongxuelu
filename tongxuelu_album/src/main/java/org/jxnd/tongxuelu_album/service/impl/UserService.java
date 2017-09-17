package org.jxnd.tongxuelu_album.service.impl;

import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.dao.UserMapper;
import org.jxnd.tongxuelu_album.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mym on 2017/9/11.
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;


    /**
     * 根据用户账号和密码查询
     * @param userId
     * @param password
     * @return
     */
    @Override
    public User getUserIdAndPwd(String userId, String password) {
        return userMapper.getUserIdAndPwd(userId,password);
    }
}
