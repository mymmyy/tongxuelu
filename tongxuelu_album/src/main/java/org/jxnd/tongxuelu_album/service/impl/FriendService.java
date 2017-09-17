package org.jxnd.tongxuelu_album.service.impl;

import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.dao.FriendMapper;
import org.jxnd.tongxuelu_album.entity.Friend;
import org.jxnd.tongxuelu_album.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mym on 2017/9/14.
 */
@Service
public class FriendService implements IFriendService{

    @Autowired
    private FriendMapper friendMapper;

    /**
     * 根据用户id查询用户，注：为了信息安全只查询部分信息
     *
     * @param userId
     * @return
     */
    @Override
    public User selectUserByUserId(String userId) {
        return friendMapper.selectUserByUserId(userId);
    }

    /**
     * 根据当前登陆用户和查询用户查好友信息
     *
     * @return
     */
    @Override
    public Friend selectFriendByMyIdAndFriendId(Friend findFriend) {
        return friendMapper.selectFriendByMyIdAndFriendId(findFriend);
    }

    /**
     * 查询用户的所有好友
     *
     * @param userId
     * @return
     */
    @Override
    public List<Friend> getAllByMyId(String userId) {
        return friendMapper.getAllByMyId(userId);
    }


}
