package org.jxnd.tongxuelu.entity;

import java.io.Serializable;

public class Friend implements Serializable{
	private static final long serialVersionUID = 1L;
   private Integer fId;
   private String myId;
   private String friendId;
   private String comment;
   private User user;
   
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Friend(Integer fId, String myId, String friendId, String comment) {
	super();
	this.fId = fId;
	this.myId = myId;
	this.friendId = friendId;
	this.comment = comment;
}
public Friend() {
	super();
	// TODO Auto-generated constructor stub
}

public Friend(Integer fId, String myId, String friendId, String comment,
		User user) {
	super();
	this.fId = fId;
	this.myId = myId;
	this.friendId = friendId;
	this.comment = comment;
	this.user = user;
}
public Integer getfId() {
	return fId;
}
public void setfId(Integer fId) {
	this.fId = fId;
}
public String getMyId() {
	return myId;
}
public void setMyId(String myId) {
	this.myId = myId;
}
public String getFriendId() {
	return friendId;
}
public void setFriendId(String friendId) {
	this.friendId = friendId;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
@Override
public String toString() {
	return "Friend [fId=" + fId + ", myId=" + myId + ", friendId=" + friendId
			+ ", comment=" + comment + ", user=" + user + "]";
}

   
}
