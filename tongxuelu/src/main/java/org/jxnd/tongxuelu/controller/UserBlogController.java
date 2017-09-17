package org.jxnd.tongxuelu.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jxnd.tongxuelu.entity.FtpConfig;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu.entity.UserBlog;
import org.jxnd.tongxuelu.service.IPictureService;
import org.jxnd.tongxuelu.service.IUserBlogService;
import org.jxnd.tongxuelu.service.IUserService;
import org.jxnd.tongxuelu.utils.FtpUtil;
import org.jxnd.tongxuelu.utils.UUIDUtil;
import org.jxnd.tongxuelu.utils.UploadUtils;
import org.jxnd.tongxuelu.utils.WangEditUploadMSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 用户博客的controller层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/UserBlogController")
public class UserBlogController {
	@Autowired
	private IUserBlogService iUserBlogService;
	
	@Autowired
	private IPictureService iPictureService;
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private FtpConfig ftpConfig;
	/**
	 * 文章的发布
	 * @param blogTitle:博客标题
	 * @param blogContent:博客内容
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/iusserArticle")
	public String iusserArticle(String blogTitle,String blogContent,int categoryId,HttpSession session) throws ParseException{
		Date releaseTime=new java.sql.Date(new Date().getTime());
		String blogId=UUIDUtil.getRandomStringAsId();
		User user=(User) session.getAttribute("existUser");
		UserBlog userBlog=new UserBlog(blogId, categoryId, blogTitle,(java.sql.Date) releaseTime, 0, user.getUserId(), blogContent);
		int i=iUserBlogService.addArticle(userBlog);
		System.out.println(i);
		session.removeAttribute("categoryId");
		if(i>0)
			return "1";
		else
			return "2";
	}
	/**
	 * 查询一个用户的所有文章数
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/getCountByUserId")
	public int getCountByUserId(HttpSession session) throws ParseException{
		User user=(User) session.getAttribute("spaceUser");
		 int i=iUserBlogService.getAllUserBlogCount(user.getUserId(), 0);
		 return i;
	}
	
	/**
	 * 所有文章总数
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/getAllCount")
	public int getAllCount() throws ParseException{
		 int i=iUserBlogService.getAllUserBlogCount(null, 0);
		 return i;
	}
	
	/**
	 * 每个文章分类的文章数
	 * @param categoryId
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/getCountByCategoryId")
	public int getCountByCategoryId(int categoryId) throws ParseException{
		 int i=iUserBlogService.getAllUserBlogCount(null, categoryId);
		 return i;
	}
	
	/**
	 * 取得当前用户的文章
	 * @param pn
	 * @param session
	 * @param size
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getUserBlogEmps")
    public MSG getUserBlogEmps(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,HttpSession session,@RequestParam(required = false,defaultValue = "4",value = "size")Integer size,
    		@RequestParam(required = false,defaultValue = "0",value = "deleteState")Integer deleteState){
		
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        //PageHelper.startPage(pn,size);
        //startPage后紧跟的这个查询就是分页查询
		pn=(pn-1)*size;
        User user=(User) session.getAttribute("spaceUser");
        List<UserBlog> list = iUserBlogService.getAllUserBlogByUserId(user.getUserId(),pn,size,deleteState);
    	 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        //PageInfo<UserBlog> pageInfo = new PageInfo<UserBlog>(list,size);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
       if(list!=null)
    	   return MSG.success().add("list",list);
       else 
    	   return null;
    }
	
	@ResponseBody
    @RequestMapping("/getAllUserBlogWithLike")
    public List<UserBlog> getAllUserBlogWithLike(String msg,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,HttpSession session,@RequestParam(required = false,defaultValue = "4",value = "size")Integer size){
		pn=(pn-1)*size;
		List<UserBlog> list=iUserBlogService.getAllUserBlogWithLike(msg, pn, size);
		return list;
    }
	
	/**
	 * 
	 * @param blogId
	 * @param me
	 * @param session
	 * @return
	 */
	@RequestMapping("/getBlogByBlogId")
	public String getBlogByBlogId(String blogId,Model me,HttpSession session) {
		UserBlog userBlog=iUserBlogService.getUserBlogByBlogId(blogId);
		session.setAttribute("blogger", userBlog.getUserId());
		me.addAttribute("userBlog", userBlog);
		return "space/show";
	}
	
	@RequestMapping("/setUserBlog")
	public String setUserBlog(String blogId,Model me,HttpSession session) {
		UserBlog userBlog=iUserBlogService.getUserBlogByBlogId(blogId);
		session.setAttribute("writeBlog", userBlog);
		me.addAttribute("userBlog", userBlog);
		return "space/alterblog";
	}
	/**
	 * 还原被删除文章
	 * @param blogId
	 * @return
	 */
	@RequestMapping("/restoreArticle")
	public String restoreArticle(String blogId){
		UserBlog userBlog=iUserBlogService.getUserBlogByBlogId(blogId);
		userBlog.setDeleteState(0);
		iUserBlogService.updateUserBlogByBlogId(userBlog);
		return "space/homepage";
	}
	
	/**
	 * 修改文章
	 * @param session
	 * @param blogTitle
	 * @param blogContent
	 * @param deleteState
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/updateUserBlogByBlogId")
    public int updateUserBlogByBlogId(HttpSession session,String blogTitle,String blogContent,@RequestParam(required = false,defaultValue = "0",value = "deleteState")Integer deleteState){
		UserBlog userBlog=(UserBlog) session.getAttribute("writeBlog");
		userBlog.setBlogTitle(blogTitle);
		userBlog.setBlogContent(blogContent);
		Date releaseTime=new java.sql.Date(new Date().getTime());
		userBlog.setReleaseTime((java.sql.Date)releaseTime);
		userBlog.setDeleteState(deleteState);
		int i=iUserBlogService.updateUserBlogByBlogId(userBlog);
		return i;
		
    }
	
	/**
	 * 通过用户id取得文章
	 * @param pn
	 * @param session
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getUserBlog")
    public MSG getUserBlog(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,HttpSession session,
    		@RequestParam(required = false,defaultValue = "0",value = "deleteState")Integer deleteState){
		
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        //PageHelper.startPage(pn,8);
        //startPage后紧跟的这个查询就是分页查询
		pn=(pn-1)*8;
        String userId=(String) session.getAttribute("blogger");
        List<UserBlog> list = iUserBlogService.getAllUserBlogByUserId(userId,pn,8,deleteState);
        
       	 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        //PageInfo<UserBlog> pageInfo = new PageInfo<UserBlog>(list,8);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        if(list!=null)
     	   return MSG.success().add("list",list);
        else 
     	   return null;
    }
	/**
	 * 取得所有的文章
	 * @param pn:页码
	 * @param session
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getAllUserBlog")
    public MSG getAllUserBlog(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,HttpSession session){
		
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        //PageHelper.startPage(pn,10);
        //startPage后紧跟的这个查询就是分页查询
		pn=(pn-1)*10;
        List<UserBlog> list = iUserBlogService.getAllUserBlog(pn,10);
   	 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
       //PageInfo<UserBlog> pageInfo = new PageInfo<UserBlog>(list,10);
       //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        if(list!=null)
     	   return MSG.success().add("list",list);
        else 
     	   return null;
    }
	/**
	 * 通过文章分类取得文章
	 * @param pn:当前页码
	 * @param categoryId:类别id
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getAllUserBlogByCategoryId")
    public MSG getAllUserBlogByCategoryId(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,int categoryId){
		
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        //PageHelper.startPage(pn,10);
        //startPage后紧跟的这个查询就是分页查询
		pn=(pn-1)*10;
        List<UserBlog> list = iUserBlogService.getAllUserBlogByCategoryId(categoryId,pn,10);
        
   	 //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
       //PageInfo<UserBlog> pageInfo = new PageInfo<UserBlog>(list,10);
       //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        if(list!=null)
     	   return MSG.success().add("list",list);
        else 
     	   return null;

    }
	
	/**
	 * 图片上传
	 * @param file
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/upImg")
	public WangEditUploadMSG index(@RequestParam("fileName")MultipartFile file,HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException, IOException{
		String fileName = file.getOriginalFilename();//得到上传文件名称，包含了路径的名称
		String picNewName = UploadUtils.generateRandonFileName(fileName);
		//3.4 得到随机目录
        String randomDir = UploadUtils.generateRandomDir(picNewName);
		
		//存放到linux中的路径目录，不包括/1.jpg,只是例如：/upload/1/2
		String picSavePath = "/upload"+randomDir;
		
		
		String imgurl=FtpUtil.pictureUpload(ftpConfig,picNewName, picSavePath, file.getInputStream());
		
		
		/**
		 * 数据库存放的地址
		 */
		String savePath = picSavePath+"/"+picNewName;
		
		iPictureService.addPicture(0, savePath);
		
		return WangEditUploadMSG.getWangEditUploadMSGJson(0, new String[]{imgurl});
	}
	
}
