package org.jxnd.tongxuelu.controller;

import java.util.List;

import org.jxnd.tongxuelu.entity.FtpConfig;
import org.jxnd.tongxuelu.entity.InsertPic;
import org.jxnd.tongxuelu.service.InsertPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/InsertPicController")
public class InsertPicController {
	@Autowired
	private InsertPicService inser;
	
	@Autowired
	private FtpConfig ftpConfig;
	
	@RequestMapping("/getAllPic")
	@ResponseBody
	public MSG getAllPic(){
		List<InsertPic> list=inser.getAllPic();
		for(InsertPic insertPic:list){
			insertPic.setImgurl(ftpConfig.getIMAGE_BASE_URL()+"_album"+insertPic.getImgurl());
			System.out.println("修改后："+insertPic.getImgurl());
		}
		return MSG.success().add("list", list);
	}

}
