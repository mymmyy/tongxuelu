package org.jxnd.tongxuelu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.Friend;

public interface IFriendService {
	//查询
    public List<Friend> selectFriend(String myId,int start,int end) throws Exception;
    //添加
    public boolean addFriend(Friend friend) throws Exception;
    //删除
    public boolean deleteFriend(int fId) throws Exception;
    //查询
    public int selectCount(String myId) throws Exception;
   //查询是否为好友
    public boolean selectIsFriend(String myId,String friendId) throws Exception;
    //更新备注
    public boolean updateName(String comment,int fId) throws Exception;
    
    List<Friend> selectAllFriendInfo(String myId,int start,int end);
}
