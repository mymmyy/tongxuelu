package org.jxnd.tongxuelu.dao;

import org.apache.ibatis.annotations.Param;

public interface PictureMapper {
	int addPicture(@Param("id")int id,@Param("imgurl")String imgurl);
}
