package org.jxnd.tongxuelu_album.service;

import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.entity.Friend;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mym on 2017/9/14.
 * 好友service接口
 */
@Service
public interface IFriendService {

    /**
     * 根据用户id查询用户，注：为了信息安全只查询部分信息
     * @param userId
     * @return
     */
    User selectUserByUserId(String userId);


    /**
     * 根据当前登陆用户和查询用户查好友信息
     * @param findFriend
     * @return
     */
    Friend selectFriendByMyIdAndFriendId(Friend findFriend);

    /**
     * 查询用户的所有好友
     * @param userId
     * @return
     */
    List<Friend> getAllByMyId(String userId);
}
