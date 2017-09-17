package org.jxnd.tongxuelu_album.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jxnd.tongxuelu_album.entity.Album;
import org.jxnd.tongxuelu_album.entity.AlbumExample;

public interface AlbumMapper {
    long countByExample(AlbumExample example);

    int deleteByExample(AlbumExample example);

    int deleteByPrimaryKey(Integer albumId);

    int insert(Album record);

    int insertSelective(Album record);

    List<Album> selectByExample(AlbumExample example);

    Album selectByPrimaryKey(Integer albumId);

    int updateByExampleSelective(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExample(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);


    /**
     * 查出所有的相册，每个相册跟一个图片
     * @param example
     * @return
     */
    List<Album> selectByExampleWithPhotoOne(AlbumExample example);

    /**
     * 查询该用户的所有
     * @param userId
     * @return
     */
    List<Album> selectAllByUserIdWithPhotoOne(String userId);

    /**
     * 级联删除
     * @param albumId
     */
    //void deleteByPrimaryKeyWithPhoto(Integer albumId);


    /**
     * 检查答案是否正确
     * @param album
     * @return
     */
    Album checkAnswer(Album album);
}