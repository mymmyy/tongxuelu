package org.jxnd.tongxuelu_album.entity;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private Integer albumId;

    @NotEmpty
    private String albumName;

    private Integer viewLock;

    private String viewIssue;

    private String viewKey;

    private String userId;




    //增加相片属性
    private List<Photo> photoList = new ArrayList<Photo>();


    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public Integer getViewLock() {
        return viewLock;
    }

    public void setViewLock(Integer viewLock) {
        this.viewLock = viewLock;
    }

    public String getViewIssue() {
        return viewIssue;
    }

    public void setViewIssue(String viewIssue) {
        this.viewIssue = viewIssue == null ? null : viewIssue.trim();
    }

    public String getViewKey() {
        return viewKey;
    }

    public void setViewKey(String viewKey) {
        this.viewKey = viewKey == null ? null : viewKey.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}