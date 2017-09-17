package org.jxnd.tongxuelu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.Friend;

public interface FriendDAOMapper {
	//查询
    public List<Friend> selectFriend(@Param("myId")String myId,@Param("start")int start,@Param("end")int end) throws Exception;
    //添加
    public int addFriend(Friend friend) throws Exception;
    //删除
    public int deleteFriend(@Param("fId")int fId) throws Exception;
    //查询
    public int selectCount(@Param("myId")String myId) throws Exception;
    //更新备注
    public int updateName(@Param("comment")String comment,@Param("fId")int fId) throws Exception;
    //查询是否为好友
    public int selectIsFriend(@Param("myId")String myId,@Param("friendId")String friendId) throws Exception;
    //查询所有好友信息
    List<Friend> selectAllFriendInfo(@Param("myId")String myId,@Param("start")int start,@Param("end")int end);
}
