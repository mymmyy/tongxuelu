package org.jxnd.tongxuelu_album.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.entity.Album;
import org.jxnd.tongxuelu_album.entity.FtpConfig;
import org.jxnd.tongxuelu_album.entity.Photo;
import org.jxnd.tongxuelu_album.service.IAlbumService;
import org.jxnd.tongxuelu_album.service.IPhotoService;
import org.jxnd.tongxuelu_album.utils.FtpUtil;
import org.jxnd.tongxuelu_album.utils.UploadUtils;
import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.InsertElementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mym on 2017/9/13.
 */
@Controller
@RequestMapping("/PhotoController")
public class PhotoController {

    @Autowired
    private IPhotoService iPhotoService;

    @Autowired
    private IAlbumService iAlbumService;

    @Autowired
    private FtpConfig ftpConfig;

    /**
     * 去往上传图片页面
     */
    @RequestMapping("/toUploadPic")
    public String toUploadPic(Map<String,Object> map, HttpServletRequest request){

        User existUser = (User) request.getSession().getAttribute("existUser");
        if(existUser == null){
            return "/index.ftl";
        }
        List<Album> albums = iAlbumService.findAllByUserId(existUser.getUserId());
        map.put("albums",albums);
        return "/upload.ftl";
    }



    @RequestMapping("/uploadFiles")
    public MSG uploadFiles(@RequestParam("albumId")Integer albumId,@RequestParam("file")MultipartFile[] files) throws IOException {

        List<Photo> photoList = new ArrayList<Photo>();

        for(MultipartFile file:files){
            Photo photo = new Photo();

            String oldName = file.getOriginalFilename();
            String picNewName = UploadUtils.generateRandonFileName(oldName);

            String picSavePath = UploadUtils.generateRandomDir(picNewName);

            photo.setPhotoUrl(picSavePath+"/"+picNewName);
            photo.setAlbumId(albumId);
            photo.setPhotoDesc(oldName);

            photoList.add(photo);

            FtpUtil.pictureUploadByConfig(ftpConfig,picNewName,picSavePath,file.getInputStream());
        }

        //添加到数据库
        iPhotoService.savePhotoList(photoList);

        return MSG.success();
    }


    /**
     * 查询相册中所有的照片
     * @return
     */
    @RequestMapping(value = "/allPhoto/{albumId}/{pn}")
    public String allPhoto(@PathVariable("albumId")Integer albumId,
                           @PathVariable("pn")Integer pn,Map<String,Object> map){

        PageHelper.startPage(pn,6);
        List<Photo> photos = iPhotoService.findAllByAlbumId(albumId);
        PageInfo pageInfo = new PageInfo(photos,3);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        map.put("pageInfo",pageInfo);


        return "/photoSkim.ftl";
    }



    /**
     * 查询相册中所有的照片,第二种展示方式
     * @return
     */
    @RequestMapping(value = "/allPhoto_grid/{albumId}/{pn}")
    public String allPhoto_grid(@PathVariable("albumId")Integer albumId,
                                @PathVariable("pn")Integer pn,Map<String,Object> map){

        PageHelper.startPage(pn,6);
        List<Photo> photos = iPhotoService.findAllByAlbumId(albumId);
        PageInfo pageInfo = new PageInfo(photos,3);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        map.put("pageInfo",pageInfo);


        return "/photoSkim_grid.ftl";
    }



    /**
     * 根据用户查询他的所有相片
     */
    @RequestMapping("/list/{userId}/{pn}")
    public String list(@PathVariable("userId")String userId,
                       @PathVariable("pn")Integer pn,Map<String,Object> map){
        System.out.println(userId+":"+pn);

        //根据userId查询所有的相片
        PageHelper.startPage(pn,6);
        List<Photo> photos = iPhotoService.findAllByUserId(userId);
        PageInfo pageInfo = new PageInfo(photos,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        map.put("pageInfo",pageInfo);


        //查询所有的album
        List<Album> albums = iAlbumService.findAllByUserId(userId);
        map.put("albums",albums);


        return "/photoList.ftl";
    }


    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/deletePhoto/{photoId}")
    public MSG deletePhoto(@PathVariable("photoId") Integer photoId){
        try {
            iPhotoService.deleteByPhotoId(photoId);
        }catch (Exception e){
            return MSG.fail();
        }

        return MSG.success();
    }


    /**
     * 修改所属相册
     */
    @ResponseBody
    @RequestMapping("/editBelongAlbum")
    public MSG editBelongAlbum(@RequestParam("albumId") Integer albumId,@RequestParam("photoId")Integer photoId){
        try {
            iPhotoService.updateBelongAlbum(albumId,photoId);
        }catch (Exception e){
            return MSG.fail();
        }

        return MSG.success();
    }


    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("/deletePhotoByBatch")
    public MSG deletePhotoByBatch(@RequestParam("photoId") Integer[] photoId){
        try {
            iPhotoService.deletePhotoByBatch(photoId);
        }catch (Exception e){
            return MSG.fail();
        }

        return MSG.success();

    }



}
