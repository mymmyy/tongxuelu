package org.jxnd.tongxuelu.entity;

public class Picture {
	private Integer id;
	private String imgurl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Picture(Integer id, String imgurl) {
		super();
		this.id = id;
		this.imgurl = imgurl;
	}
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", imgurl=" + imgurl + "]";
	}
	
}
