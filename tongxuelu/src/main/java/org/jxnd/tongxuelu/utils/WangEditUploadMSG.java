package org.jxnd.tongxuelu.utils;

import java.util.Arrays;

public class WangEditUploadMSG {
	
	private int errno;
	
	private String[] data;
	
	public static WangEditUploadMSG getWangEditUploadMSGJson(int errno,String[] imgurl){
		WangEditUploadMSG wangEditUploadMSG = new WangEditUploadMSG();
		wangEditUploadMSG.setData(imgurl);
		wangEditUploadMSG.setErrno(errno);
		
		return wangEditUploadMSG;
	}
	
	
	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	@Override
	public String toString() {
		return "WangEditUploadMSG [errno=" + errno + ", data="
				+ Arrays.toString(data) + "]";
	}


	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}
	
	

}
