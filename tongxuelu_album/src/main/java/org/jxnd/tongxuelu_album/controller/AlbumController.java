package org.jxnd.tongxuelu_album.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.entity.Album;
import org.jxnd.tongxuelu_album.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by mym on 2017/9/12.
 * 相册的controller
 */

@Controller
@RequestMapping("/AlbumController")
public class AlbumController {

    @Autowired
    private IAlbumService iAlbumService;


    /**
     * 当前用户得到所有相册
     */
    @RequestMapping("/list/{userId}/{pn}")
    public String list(@PathVariable("pn") Integer pn,
                       Map<String,Object> map, @PathVariable("userId") String userId){

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,6);
        List<Album> albums = iAlbumService.selectAllByUserIdWithPhotoOne(userId);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo(albums,3);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        map.put("pageInfo",pageInfo);

        return "/index.ftl";
    }


    /**
     * 增加相册的方法
     */
    @RequestMapping(value = "/album",method = RequestMethod.POST)
    public String addAlbum(@Valid Album album, HttpServletRequest request){
        User existUser = (User) request.getSession().getAttribute("existUser");
        iAlbumService.saveAlbum(album);
        System.out.println("add success!");
        return "redirect:/AlbumController/list/"+existUser.getUserId()+"/1";
    }

    /**
     * 修改相册的方法
     */
    @RequestMapping(value = "/album",method = RequestMethod.PUT)
    public String editAlbum(@Valid Album album, HttpServletRequest request){
        User existUser = (User) request.getSession().getAttribute("existUser");
        iAlbumService.updateAlbum(album);
        System.out.println("edit success!");
        return "redirect:/AlbumController/list/"+existUser.getUserId()+"/1";
    }



    /**
     * 删除相册的方法
     */
    @RequestMapping(value = "/album/{albumId}",method = RequestMethod.DELETE)
    public String deleteAlbum(@PathVariable("albumId") Integer albumId, HttpServletRequest request){
        User existUser = (User) request.getSession().getAttribute("existUser");
        iAlbumService.deleteAlbum(albumId);
        System.out.println("delete success!");
        return "redirect:/AlbumController/list/"+existUser.getUserId()+"/1";
    }



    /**
     * 根据id取值
     */
    @ResponseBody
    @RequestMapping(value = "/album/{albumId}",method = RequestMethod.GET)
    public MSG getAlbum(@PathVariable("albumId") Integer albumId){
       Album album = iAlbumService.selectByPrimaryId(albumId);

        if(album != null){
            return MSG.success().add("album",album);
        }else{
            return MSG.fail();
        }
    }






}
