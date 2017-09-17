package org.jxnd.tongxuelu_album.service;

import org.jxnd.tongxuelu_album.entity.Album;
import org.jxnd.tongxuelu_album.entity.Photo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mym on 2017/9/13.
 */
@Service
public interface IPhotoService {

    /**
     * 批量保存（插入）
     * @param photoList
     */
    void savePhotoList(List<Photo> photoList);

    /**
     * 根据albumId查所有照片
     * @param albumId
     * @return
     */
    List<Photo> findAllByAlbumId(Integer albumId);

    /**
     * 根据用户查询所有相片
     * @param userId
     * @return
     */
    List<Photo> findAllByUserId(String userId);

    /**
     * 根据photoId删除图片
     * @param photoId
     * @return
     */
    int deleteByPhotoId(Integer photoId);

    /**
     * 修改所属相册
     * @param albumId
     * @param photoId
     */
    void updateBelongAlbum(Integer albumId, Integer photoId);

    /**
     * 批量删除
     * @param photoId
     */
    void deletePhotoByBatch(Integer[] photoId);


}
