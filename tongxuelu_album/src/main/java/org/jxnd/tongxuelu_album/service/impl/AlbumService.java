package org.jxnd.tongxuelu_album.service.impl;

import org.jxnd.tongxuelu_album.dao.AlbumMapper;
import org.jxnd.tongxuelu_album.dao.PhotoMapper;
import org.jxnd.tongxuelu_album.entity.Album;
import org.jxnd.tongxuelu_album.entity.FtpConfig;
import org.jxnd.tongxuelu_album.entity.Photo;
import org.jxnd.tongxuelu_album.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mym on 2017/9/12.
 * 相册的一个实现类
 */
@Service
public class AlbumService implements IAlbumService{

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private FtpConfig ftpConfig;            //用来修改URL

    @Autowired
    private PhotoMapper photoMapper;


    /**
     * 保存album
     *
     * @param album
     */
    @Override
    public void saveAlbum(Album album) {
        int result = albumMapper.insert(album);
        System.out.println(result);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Album> selectAll() {
        List<Album> albumList = albumMapper.selectByExampleWithPhotoOne(null);
        for(Album album:albumList){
            for(Photo photo:album.getPhotoList()){
                photo.setPhotoUrl(ftpConfig.getIMAGE_BASE_URL()+photo.getPhotoUrl());
            }
        }
        return albumList;
    }

    /**
     * 更新
     *
     * @param album
     */
    @Override
    public void updateAlbum(Album album) {
        //albumMapper.updateByPrimaryKey(album);
        albumMapper.updateByPrimaryKeySelective(album);
    }

    /**
     * 级联删除
     *
     * @param albumId
     */
    @Override
    @Transactional
    public void deleteAlbum(Integer albumId) {
        photoMapper.deleteByForeignKey(albumId);
        albumMapper.deleteByPrimaryKey(albumId);
    }

    /**
     * 根据主键查询
     *
     * @param albumId
     * @return
     */
    @Override
    public Album selectByPrimaryId(Integer albumId) {
        return albumMapper.selectByPrimaryKey(albumId);
    }

    /**
     * 不关联查询，查询所有
     *
     * @return
     */
    @Override
    public List<Album> findAll() {
        return albumMapper.selectByExample(null);
    }

    /**
     * 查询该用户的所有相册
     *
     * @param userId
     * @return
     */
    @Override
    public List<Album> selectAllByUserIdWithPhotoOne(String userId) {
        List<Album> albumList = albumMapper.selectAllByUserIdWithPhotoOne(userId);
        for(Album album:albumList){
            for(Photo photo:album.getPhotoList()){
                photo.setPhotoUrl(ftpConfig.getIMAGE_BASE_URL()+photo.getPhotoUrl());
            }
        }
        return albumList;
    }


    /**
     * 检查答案是否正确
     *
     * @param album
     * @return
     */
    @Override
    public Album checkAnswer(Album album) {
        return albumMapper.checkAnswer(album);
    }



}
