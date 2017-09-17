package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.dao.FriendDAOMapper;
import org.jxnd.tongxuelu.entity.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements IFriendService{
	
	@Autowired
	private FriendDAOMapper friendDAOMapper;
	//查询
    public List<Friend> selectFriend(String myId,int start,int end) throws Exception{
    	List<Friend> list = this.friendDAOMapper.selectFriend(myId,start, end);
    	return list;
    }
    //添加
    public boolean addFriend(Friend friend) throws Exception{
    	boolean flag = false;
    	if(this.friendDAOMapper.addFriend(friend)>0){
    		flag = true;
    	} 
    	return flag;
    }
    //删除
    public boolean deleteFriend(int fId) throws Exception{
    	boolean flag = false;
    	if(this.friendDAOMapper.deleteFriend(fId)>0){
    		flag = true;
    	} 
    	return flag;
    }
    //查询
    public int selectCount(String myId) throws Exception{
    	int count = 0;
    	count = this.friendDAOMapper.selectCount(myId);
    	return count;
    }
    //修改备注
    public boolean updateName(String comment,int fId) throws Exception{
    	boolean flag = false;
    	if(this.friendDAOMapper.updateName(comment, fId)>0){
    		flag = true;
    	}
    	return flag;
    }
    //查询是否为好友
    public boolean selectIsFriend(String myId,String friendId) throws Exception{
    	boolean flag = false;
    	int count = this.friendDAOMapper.selectIsFriend(myId, friendId);
    	if(count>0){
    		flag = true;
    	}
    	return flag;
    }
	@Override
	public List<Friend> selectAllFriendInfo(String myId,int start, int end) {
		// TODO Auto-generated method stub
		return friendDAOMapper.selectAllFriendInfo(myId,start, end);
	}
}
