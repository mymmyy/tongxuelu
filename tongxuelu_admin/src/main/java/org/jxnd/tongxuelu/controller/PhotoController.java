package org.jxnd.tongxuelu.controller;

import java.util.List;

import org.jxnd.tongxuelu.entity.FtpConfig;
import org.jxnd.tongxuelu.entity.InsertPic;
import org.jxnd.tongxuelu.entity.Photo;
import org.jxnd.tongxuelu.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/PhotoController")
public class PhotoController {
	
	@Autowired
	private IPhotoService iPhon;
	
	@Autowired
	private FtpConfig ftpConfig;
	
	/*获取所有photo中的数据条数*/
	@ResponseBody
	@RequestMapping("/getCount")
	public int getCount(){
		int j=iPhon.getCount();
		return j;
	}
	
	/*分页获取数据*/
	@ResponseBody
	@RequestMapping("/getAllPhoto")
	public MSG getAllPhoto(int pageIndex,int size){
		List<Photo> list=iPhon.getAllPhoto(pageIndex, size);
		String baseUrl = ftpConfig.getIMAGE_BASE_URL().split("images")[0];
		baseUrl = baseUrl+"album_images";
		for(Photo pho:list){
			pho.setPhotoUrl(baseUrl+pho.getPhotoUrl());
		}
		return MSG.success().add("list", list);
	}
	
	/*删除图片*/
	@ResponseBody
	@RequestMapping("/deletePhoto")
	public int deletePhoto(int photoId){
		return iPhon.deletePhoto(photoId);
	}

}
