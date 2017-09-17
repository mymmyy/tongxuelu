package org.jxnd.tongxuelu_album.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu_album.entity.Album;
import org.jxnd.tongxuelu_album.entity.Photo;
import org.jxnd.tongxuelu_album.entity.PhotoExample;

public interface PhotoMapper {
    long countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(Integer photoId);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(Integer photoId);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);


    /**
     * 根据外键删除
     * @param albumId
     */
    void deleteByForeignKey(Integer albumId);

    /**
     * 批量插入
     * @param photoList
     */
    void savePhotoList(List<Photo> photoList);

    /**
     * 根据albumId查询所有
     * @param albumId
     * @return
     */
    List<Photo> selectByAlbumId(Integer albumId);

    /**
     * 根据userId查询所有
     * @param userId
     * @return
     */
    List<Photo> selectAllByUserId(String userId);

    /**
     * 批量更新
     * @param photoId
     */
    void deletePhotoByBatch(Integer[] photoId);


}