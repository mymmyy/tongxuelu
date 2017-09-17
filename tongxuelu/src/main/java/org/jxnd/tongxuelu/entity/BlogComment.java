package org.jxnd.tongxuelu.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class BlogComment implements Serializable{
	private static final long serialVersionUID = 1L;
   private Integer id; 
   private String blogId;
   private String userId;
   private String commentUserId;
   private String commentContent;
   private Date commentTime;
   private Integer deleteState;
   private List<ReplyComment> replyList;
   
	public BlogComment(Integer id, String blogId, String userId,
		String commentUserId, String commentContent, Date commentTime,
		Integer deleteState, List<ReplyComment> replyList) {
	super();
	this.id = id;
	this.blogId = blogId;
	this.userId = userId;
	this.commentUserId = commentUserId;
	this.commentContent = commentContent;
	this.commentTime = commentTime;
	this.deleteState = deleteState;
	this.replyList = replyList;
}
	public BlogComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public Integer getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(Integer deleteState) {
		this.deleteState = deleteState;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<ReplyComment> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ReplyComment> replyList) {
		this.replyList = replyList;
	}
	@Override
	public String toString() {
		return "BlogComment [id=" + id + ", blogId=" + blogId + ", userId="
				+ userId + ", commentUserId=" + commentUserId
				+ ", commentContent=" + commentContent + ", commentTime="
				+ commentTime + ", deleteState=" + deleteState + ", replyList="
				+ replyList + "]";
	}
	
	
   
   
}
