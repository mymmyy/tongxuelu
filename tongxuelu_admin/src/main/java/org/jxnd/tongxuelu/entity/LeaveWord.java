package org.jxnd.tongxuelu.entity;

import java.io.Serializable;
import java.sql.Date;


public class LeaveWord implements Serializable{
   private static final long serialVersionUID = 1L;
   private Integer leaveWordId;
   private String userId;
   private String leaveUserId;
   private String LeaveWordContent;
   private Date leaveWordTime;
   private Integer isNameHidden;
   private int deleteState;
	public LeaveWord(Integer leaveWordId, String userId, String leaveUserId,
		String leaveWordContent, Date leaveWordTime, Integer isNameHidden,
		int deleteState) {
	super();
	this.leaveWordId = leaveWordId;
	this.userId = userId;
	this.leaveUserId = leaveUserId;
	this.LeaveWordContent = leaveWordContent;
	this.leaveWordTime = leaveWordTime;
	this.isNameHidden = isNameHidden;
	this.deleteState = deleteState;
}

	public LeaveWord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getLeaveWordId() {
		return leaveWordId;
	}
	public void setLeaveWordId(Integer leaveWordId) {
		this.leaveWordId = leaveWordId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLeaveUserId() {
		return leaveUserId;
	}

	public void setLeaveUserId(String leaveUserId) {
		this.leaveUserId = leaveUserId;
	}

	public String getLeaveWordContent() {
		return LeaveWordContent;
	}
	public void setLeaveWordContent(String leaveWordContent) {
		LeaveWordContent = leaveWordContent;
	}
	public Date getLeaveWordTime() {
		return leaveWordTime;
	}
	public void setLeaveWordTime(Date leaveWordTime) {
		this.leaveWordTime = leaveWordTime;
	}
	public Integer getIsNameHidden() {
		return isNameHidden;
	}
	public void setIsNameHidden(Integer isNameHidden) {
		this.isNameHidden = isNameHidden;
	}
	public int getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(int deleteState) {
		this.deleteState = deleteState;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "LeaveWord [leaveWordId=" + leaveWordId + ", userId=" + userId
				+ ", leaveUserId=" + leaveUserId + ", LeaveWordContent="
				+ LeaveWordContent + ", leaveWordTime=" + leaveWordTime
				+ ", isNameHidden=" + isNameHidden + ", deleteState=" + deleteState
				+ "]";
	}
    
   
	
	
    
   
}
