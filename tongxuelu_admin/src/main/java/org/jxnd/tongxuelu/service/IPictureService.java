package org.jxnd.tongxuelu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.Picture;
import org.springframework.stereotype.Service;

@Service
public interface IPictureService {
	int addPicture(int id,String img);
	
	List<Picture> getAllPicture();
	
	int deletePicture(int id);
	
	List<Picture> getPictureByPage(int pageIndex,int size);
	
	int getCount();
}
