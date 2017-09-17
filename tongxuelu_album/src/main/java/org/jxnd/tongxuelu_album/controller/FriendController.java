package org.jxnd.tongxuelu_album.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.entity.Album;
import org.jxnd.tongxuelu_album.entity.Friend;
import org.jxnd.tongxuelu_album.entity.Photo;
import org.jxnd.tongxuelu_album.service.IAlbumService;
import org.jxnd.tongxuelu_album.service.IFriendService;
import org.jxnd.tongxuelu_album.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by mym on 2017/9/14.
 * 好友的controller
 */
@Controller
@RequestMapping("/FriendController")
public class FriendController {

    @Autowired
    private IFriendService iFriendService;

    @Autowired
    private IAlbumService iAlbumService;

    @Autowired
    private IPhotoService iPhotoService;

    /**
     * 根据用户id查询用户，注：为了信息安全只查询部分信息
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectUserByUserId")
    public MSG selectUserByUserId(@RequestParam("userId")String userId){

        User findUser = iFriendService.selectUserByUserId(userId);
        if(findUser != null){
            return MSG.success().add("findUser",findUser);

        }else{
            return MSG.fail();
        }

    }





    /**
     * 得到对应用户的所有相册
     */
    @RequestMapping("/list/{userId}/{pn}")
    public String list(@PathVariable("pn") Integer pn,
                       Map<String,Object> map, @PathVariable("userId") String userId, HttpSession session){

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,6);
        List<Album> albums = iAlbumService.selectAllByUserIdWithPhotoOne(userId);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo(albums,3);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

        Friend friend = null;
        Friend findFriend = new Friend();

        //获得当前用户
        User existUser = (User) session.getAttribute("existUser");
        if(existUser != null){
            //根据当前登陆用户和查询用户查好友信息
            findFriend.setMyId(existUser.getUserId());
            findFriend.setFriendId(userId);
            friend = iFriendService.selectFriendByMyIdAndFriendId(findFriend);
        }

        if(friend == null){
            friend = new Friend();
            friend.setFriendId(userId);
        }

        map.put("friend",friend);
        map.put("pageInfo",pageInfo);

        return "/friend/friendIndex.ftl";
    }


    /**
     *
     */
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


        return "/friend/friendPhotoSkim.ftl";
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


        return "/friend/friendPhotoSkim_grid.ftl";
    }


    /**
     * 查询用户的所有好友
     */
    @ResponseBody
    @RequestMapping("getAllByMyId")
    public MSG getAllByMyId(String userId,Integer pn){

        PageHelper.startPage(pn,6);
        List<Friend> friendList = iFriendService.getAllByMyId(userId);
        PageInfo pageInfo = new PageInfo(friendList,3);

        if(friendList == null){
            return MSG.fail();
        }
        return MSG.success().add("pageInfo",pageInfo);
    }


    /**
     * 检查问题是否正确
     */
    @ResponseBody
    @RequestMapping("checkAnswer")
    public MSG checkAnswer(Album album){

        Album existAlbum = iAlbumService.checkAnswer(album);

        if(existAlbum != null){
            return MSG.success();
        }

        return MSG.fail();
    }




}
