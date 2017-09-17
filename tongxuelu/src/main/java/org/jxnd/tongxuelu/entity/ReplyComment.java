package org.jxnd.tongxuelu.entity;

import java.io.Serializable;
import java.sql.Date;

public class ReplyComment implements Serializable{

	private static final long serialVersionUID = 1L;
    private Integer id;
    private String commentId;
    private String commentUserId;
    private String replyUserId;
    private String replyContent;
    private Date replyTime;
    private Integer deleteTime;
	public ReplyComment(Integer id, String commentId, String commentUserId,
			String replyUserId, String replyContent, Date replyTime,
			Integer deleteTime) {
		super();
		this.id = id;
		this.commentId = commentId;
		this.commentUserId = commentUserId;
		this.replyUserId = replyUserId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.deleteTime = deleteTime;
	}
	public ReplyComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}
	public String getReplyUserId() {
		return replyUserId;
	}
	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public Integer getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Integer deleteTime) {
		this.deleteTime = deleteTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ReplyComment [id=" + id + ", commentId=" + commentId
				+ ", commentUserId=" + commentUserId + ", replyUserId="
				+ replyUserId + ", replyContent=" + replyContent
				+ ", replyTime=" + replyTime + ", deleteTime=" + deleteTime
				+ "]";
	}
    
}
