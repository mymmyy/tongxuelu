package org.jxnd.tongxuelu_album.service;

import org.jxnd.tongxuelu_album.entity.Album;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mym on 2017/9/12.
 * 相册service
 */

@Service
public interface IAlbumService {


    /**
     * 保存album
     * @param album
     */
    void saveAlbum(Album album);

    /**
     * 查询所有
     * @return
     */
    List<Album> selectAll();

    /**
     * 更新
     * @param album
     */
    void updateAlbum(Album album);


    /**
     * 级联删除
     * @param albumId
     */
    void deleteAlbum(Integer albumId);

    /**
     * 根据主键查询
     * @param albumId
     * @return
     */
    Album selectByPrimaryId(Integer albumId);

    /**
     * 不关联查询，查询所有
     * @return
     */
    List<Album> findAll();

    /**
     * 查询该用户的所有相册
     * @param userId
     * @return
     */
    List<Album> selectAllByUserIdWithPhotoOne(String userId);

    /**
     * 检查答案是否正确
     * @param album
     * @return
     */
    Album checkAnswer(Album album);
}
