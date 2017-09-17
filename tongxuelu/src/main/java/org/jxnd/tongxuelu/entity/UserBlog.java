package org.jxnd.tongxuelu.entity;

import java.sql.Date;
public class UserBlog {
    private String blogId;

    private Integer categoryId;

    private String blogTitle;

    private Date releaseTime;

    private Integer deleteState;

    private String userId;

    private String blogContent;
    
    private BlogCategory blogCategory;
    
    private User user;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BlogCategory getBlogCategory() {
		return blogCategory;
	}

	public void setBlogCategory(BlogCategory blogCategory) {
		this.blogCategory = blogCategory;
	}

	public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId == null ? null : blogId.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }

	

	public UserBlog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBlog(String blogId, Integer categoryId, String blogTitle,
			Date releaseTime, Integer deleteState, String userId,
			String blogContent) {
		super();
		this.blogId = blogId;
		this.categoryId = categoryId;
		this.blogTitle = blogTitle;
		this.releaseTime = releaseTime;
		this.deleteState = deleteState;
		this.userId = userId;
		this.blogContent = blogContent;
	}
	
	

	public UserBlog(String blogId, Integer categoryId, String blogTitle,
			Date releaseTime, Integer deleteState, String userId,
			String blogContent, BlogCategory blogCategory, User user) {
		super();
		this.blogId = blogId;
		this.categoryId = categoryId;
		this.blogTitle = blogTitle;
		this.releaseTime = releaseTime;
		this.deleteState = deleteState;
		this.userId = userId;
		this.blogContent = blogContent;
		this.blogCategory = blogCategory;
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserBlog [blogId=" + blogId + ", categoryId=" + categoryId
				+ ", blogTitle=" + blogTitle + ", releaseTime=" + releaseTime
				+ ", deleteState=" + deleteState + ", userId=" + userId
				+ ", blogContent=" + blogContent + ", blogCategory="
				+ blogCategory + ", user=" + user + "]";
	}

	
    
	
	
}