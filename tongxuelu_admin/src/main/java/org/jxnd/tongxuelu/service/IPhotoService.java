package org.jxnd.tongxuelu.service;

import java.util.List;

import org.jxnd.tongxuelu.entity.Photo;
import org.springframework.stereotype.Service;

@Service
public interface IPhotoService {
	int deletePhoto(int photoId);
    
    List<Photo> getAllPhoto(int pageIndex,int size);
    
    int getCount();

}
