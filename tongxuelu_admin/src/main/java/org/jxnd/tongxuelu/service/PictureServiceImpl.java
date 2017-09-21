package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.dao.PictureMapper;
import org.jxnd.tongxuelu.entity.Picture;
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
	@Override
	public List<Picture> getAllPicture() {
		return pictureMapper.getAllPicture();
	}
	@Override
	public int deletePicture(int id) {
		return pictureMapper.deletePicture(id);
	}
	@Override
	public List<Picture> getPictureByPage(int pageIndex, int size) {
		pageIndex=(pageIndex-1)*size;
		return pictureMapper.getPictureByPage(pageIndex, size);
	}
	@Override
	public int getCount() {
		return pictureMapper.getCount();
	}

}
