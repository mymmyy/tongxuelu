package org.jxnd.tongxuelu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu.entity.Picture;

public interface PictureMapper {
	int addPicture(@Param("id")int id,@Param("imgurl")String imgurl);
	
	List<Picture> getAllPicture();
	
	int deletePicture(@Param("id")int id);
	
	List<Picture> getPictureByPage(@Param("pageIndex")int pageIndex,@Param("size")int size);
	
	int getCount();
	
	
}
