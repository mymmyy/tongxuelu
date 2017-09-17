package org.jxnd.tongxuelu.service;

import org.jxnd.tongxuelu.dao.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements IPictureService {
	@Autowired
	PictureMapper pictureMapper;
	@Override
	public int addPicture(int id, String imgurl) {
		return pictureMapper.addPicture(id, imgurl);
	}

}
