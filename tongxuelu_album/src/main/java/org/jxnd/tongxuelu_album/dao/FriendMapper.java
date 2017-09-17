package org.jxnd.tongxuelu_album.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.entity.Friend;
import org.jxnd.tongxuelu_album.entity.FriendExample;

public interface FriendMapper {
    long countByExample(FriendExample example);

    int deleteByExample(FriendExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(Friend record);

    int insertSelective(Friend record);

    List<Friend> selectByExample(FriendExample example);

    Friend selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByExample(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);

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