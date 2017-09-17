package org.jxnd.tongxuelu_album.service;

import org.jxnd.tongxuelu.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by mym on 2017/9/11.
 */
@Service
public interface IUserService {

    /**
     * 根据用户账号和密码查询用户
     * @param userId
     * @param password
     * @return
     */
    User getUserIdAndPwd(String userId, String password);
}
