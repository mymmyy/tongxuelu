package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.dao.PhotoMapper;
import org.jxnd.tongxuelu.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements IPhotoService {
	
	@Autowired
	private PhotoMapper photo;

	public int deletePhoto(int photoId) {
		return photo.deletePhoto(photoId);
	}

	@Override
	public List<Photo> getAllPhoto(int pageIndex, int size) {
		pageIndex=(pageIndex-1)*size;
		return photo.getAllPhoto(pageIndex, size);
	}

	@Override
	public int getCount() {
		return photo.getCount();
	}

}
