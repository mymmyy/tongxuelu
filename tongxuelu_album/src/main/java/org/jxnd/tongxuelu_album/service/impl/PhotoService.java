package org.jxnd.tongxuelu_album.service.impl;

import org.jxnd.tongxuelu_album.dao.PhotoMapper;
import org.jxnd.tongxuelu_album.entity.Album;
import org.jxnd.tongxuelu_album.entity.FtpConfig;
import org.jxnd.tongxuelu_album.entity.Photo;
import org.jxnd.tongxuelu_album.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mym on 2017/9/13.
 */
@Service
public class PhotoService implements IPhotoService{

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private FtpConfig ftpConfig;


    /**
     * 批量保存（插入）
     *
     * @param photoList
     */
    @Override
    public void savePhotoList(List<Photo> photoList) {
        photoMapper.savePhotoList(photoList);
    }

    /**
     * 根据albumId查所有照片
     *
     * @param albumId
     * @return
     */
    @Override
    public List<Photo> findAllByAlbumId(Integer albumId) {

        List<Photo> photos = photoMapper.selectByAlbumId(albumId);

        for(Photo photo:photos){
            photo.setPhotoUrl(ftpConfig.getIMAGE_BASE_URL()+photo.getPhotoUrl());
        }
        return photos;
    }

    /**
     * 根据用户查询所有相片
     *
     * @param userId
     * @return
     */
    @Override
    public List<Photo> findAllByUserId(String userId) {
        List<Photo> photos = photoMapper.selectAllByUserId(userId);
        for(Photo photo:photos){
            photo.setPhotoUrl(ftpConfig.getIMAGE_BASE_URL()+photo.getPhotoUrl());
        }
        return photos;
    }

    /**
     * 根据photoId删除图片,实际上就是修改图片状态
     *
     * @param photoId
     * @return
     */
    @Override
    public int deleteByPhotoId(Integer photoId) {
        return photoMapper.deleteByPrimaryKey(photoId);
    }

    /**
     * 修改所属相册
     *
     * @param albumId
     * @param photoId
     */
    @Override
    public void updateBelongAlbum(Integer albumId, Integer photoId) {
        Photo photo = new Photo();
        photo.setAlbumId(albumId);
        photo.setPhotoId(photoId);
        photoMapper.updateByPrimaryKeySelective(photo);
    }

    /**
     * 批量删除
     *
     * @param photoId
     */
    @Override
    public void deletePhotoByBatch(Integer[] photoId) {
        photoMapper.deletePhotoByBatch(photoId);
    }


}
