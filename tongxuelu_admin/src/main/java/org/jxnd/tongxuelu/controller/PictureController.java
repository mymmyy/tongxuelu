package org.jxnd.tongxuelu.controller;

import java.util.List;

import org.jxnd.tongxuelu.entity.FtpConfig;
import org.jxnd.tongxuelu.entity.Picture;
import org.jxnd.tongxuelu.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/PictureController")
public class PictureController {
	
	@Autowired
	private IPictureService pic;
	
	@Autowired
	private FtpConfig ftpConfig;
	
	@RequestMapping("/getAllPicture")
	@ResponseBody
	public MSG getAllPicture(){
		List<Picture> list=pic.getAllPicture();
		for(Picture Pics:list){
			Pics.setImgurl(ftpConfig.getIMAGE_BASE_URL()+Pics.getImgurl());
		}
		return MSG.success().add("list", list);
	}
	
	@ResponseBody
	@RequestMapping("/getCount")
	public int getCount(){
		int j=pic.getCount();
		return j;
	}
	
	@ResponseBody
	@RequestMapping("/getPictureByPage")
	public MSG getPictureByPage(int pageIndex,int size){
		List<Picture> list=pic.getPictureByPage(pageIndex, size);
		for(Picture Pics:list){
			Pics.setImgurl(ftpConfig.getIMAGE_BASE_URL()+Pics.getImgurl());
		}
		return MSG.success().add("list", list);
	}
	
	@ResponseBody
	@RequestMapping("/deletePicture")
	public int deletePicture(int id){
		return pic.deletePicture(id);
	}

}
