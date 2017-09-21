package org.jxnd.tongxuelu.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jxnd.tongxuelu.entity.FtpConfig;
import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu.service.IRedisCache;
import org.jxnd.tongxuelu.service.IUserService;
import org.jxnd.tongxuelu.utils.FtpUtil;
import org.jxnd.tongxuelu.utils.MD5Utils;
import org.jxnd.tongxuelu.utils.MailUtils;
import org.jxnd.tongxuelu.utils.SSOUtil;
import org.jxnd.tongxuelu.utils.UUIDUtil;
import org.jxnd.tongxuelu.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



/**
 * 用户的Controller
 *<p>Title:UserController</p>
 *@author mym
 *@date 2017-9-4下午7:53:53
 *@version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	
	@Autowired
	private FtpConfig ftpConfig;
	
	
	@Autowired
	private IRedisCache iRedisCache;		//redis操作的接口
	
    @RequestMapping("/list1")
    public String list(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                       Map<String,Object> map){

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,5);
        //startPage后紧跟的这个查询就是分页查询
        List<User> users = iUserService.findAll();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo(users,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数

        map.put("pageInfo",pageInfo);
        return "list";
    }
    
    
    
    
    @ResponseBody
    @RequestMapping("/list")
    public MSG getEmps(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn){

        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,5);
        //startPage后紧跟的这个查询就是分页查询
        List<User> emps = iUserService.findAll();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo(emps,5);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数


        return MSG.success().add("pageInfo",pageInfo);
    }
    
    
    
    /**
     * 去往注册页面
     *title:toRegister
     *@return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
    	return "register";
    }
    
    /**
     * 去往登陆页面
     *title:toRegister
     *@return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
    	return "login";
    }
    
    
    
    /**
     * 校验用户账号是否重复
     */
    @ResponseBody
    @RequestMapping("/checkUserId")
    public MSG checkUserId(@RequestParam("userId")String userId){
    	User existUser = iUserService.selectUserByUserId(userId);
    	if(existUser != null){
    		return MSG.success();
    	}else{
    		return MSG.fail();
    	}
    }
    
    /**
     * 注册的方法
     * @throws MessagingException 
     */
    @ResponseBody
    @RequestMapping("/userRegister")
    public MSG userRegister(@Valid User user,@RequestParam("verify")String verify,HttpSession session,Errors result,HttpServletRequest req){
    	System.out.println(user.getEmail());
    	if(user!=null){
    		if(verify != null){
    			

    			//验证验证码
    			if(verify.equalsIgnoreCase(session.getAttribute("code").toString())){
    				System.out.println(verify);
    				
        			//JSR303数据校验是否成功
        			if(result.getErrorCount() > 0){
        				System.out.println("出错了!");
        				/*for(FieldError error:result.getFieldErrors()){
        					System.out.println(error.getField() + ":" + error.getDefaultMessage());
        				}*/
        				
        				//若验证出错, 则转向定制的页面
        				return MSG.fail();
        			}
        			
    				//开始User对象封装：加一些属性
    				user.setActiveCode(UUIDUtil.getRandomString());
    				user.setPassword(MD5Utils.md5(user.getPassword()));
    				user.setRegisterTime(new java.sql.Date(new Date().getTime()));
    				user.setImgurl("/upload/default.gif");
    				
    				//调用方法注册用户
    				int registerResult = iUserService.register(user);
    				
    				
    				if(registerResult > 0){
    					//说明插入数据成功，进行发送邮件
    			        String emailMsg = "注册成功，请在12小时内<a href='http://"+SSOUtil.getHostName(req)+"/tongxuelu/user/activeUser?activeCode="
    			                + user.getActiveCode()
    			                + "'>点击激活</a>====激活码是："
    			                + user.getActiveCode()+"<br/>如果连接不能跳转，请复制地址：http://"+SSOUtil.getHostName(req)+"/tongxuelu/user/activeUser?activeCode="
    			                +user.getActiveCode()+"<br/>到浏览器地址栏运行即可进行激活！";
    			        try {
							MailUtils.sendMail(user.getEmail(),emailMsg);
							return MSG.success();
						} catch (MessagingException e) {
							System.out.println("邮件发送失败！"+e.getMessage());
						}
    					
    				}
    				
    				
    			}
    		}
    		
    	}
    	return MSG.fail();
    }
    
    
    
    /**
     * 激活用户
     * @throws IOException 
     */
    @RequestMapping("/activeUser")
    public void activeUser(@RequestParam("activeCode")String activeCode,HttpServletRequest req,HttpServletResponse resp) throws IOException{
    	resp.setContentType("text/html; charset=utf-8");
    	User existUser = null;
    	if(activeCode != null){
    		existUser = iUserService.selectUserByActiveCode(activeCode);
    		if(existUser != null){
    			//说明用户存在，那么进行修改激活状态
    			//判断激活状态，若是已经激活，就返回不能重复激活
    			if("1".equals(existUser.getActive())){
    				resp.getWriter().write(
    		                "用户已经激活成功,请<a href='" + req.getContextPath()
    		                        + "/user/toLogin'>登陆</a>");
    			}
    			
    			//修改激活状态
    			existUser.setActive("1");
    			int result = iUserService.activeUser(existUser);
    			
    			if(result > 0){
    				resp.getWriter().write(
    		                "用户已经激活成功,请<a href='" + req.getContextPath()
    		                        + "/user/toLogin'>登陆</a>");
    			}else{
    				resp.getWriter().write(
    		                "激活码过期或无效激活码，用户激活失败！,请<a href='" + req.getContextPath()
    		                        + "/user/toRegister'>重新注册</a>");
    			}
    			
    		}
    	}
    	
    }
    /**
     * 取得所有用户总数
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllUserCount")
    public int getAllUserCount(){
    	return iUserService.getAllUserCount();
    }
    
    
    /**
     * 登陆等方法
     * @throws UnsupportedEncodingException 
     */
    @ResponseBody
    @RequestMapping("/login")
     public MSG getUserIdAndPwd(User user,@RequestParam("verify")String verify,HttpSession session,@RequestParam("isRemember")String isRemember,
    		 HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException{
    		User existUser=null;
        	//判断验证码
        	if(verify.equalsIgnoreCase(session.getAttribute("code").toString())){
        		
        		user.setPassword(MD5Utils.md5(user.getPassword()));
        		existUser=iUserService.getUserIdAndPwd(user.getUserId(), user.getPassword());
        		
        		
        		
        		if(existUser!=null){
        			
        			//先判断是否激活
        			if(!"1".equals(existUser.getActive())){
        				MSG msg = new MSG();
                		msg.setMessage("用户没有激活，请至[邮箱收件箱或垃圾箱]查看邮件进行激活，若10分钟后仍未收到邮件，请重新注册！");
                		msg.setCode(400);
                		return msg;
        			}
        			
        			//是否勾选了自动登录
                    if("yes".equals(isRemember)){
                        //勾选了，就保存用户名和密码到cookis中,把用户名然后编码和密码组合放在一个cookie对象中
                        Cookie cookie = new Cookie("autoLogin",
                                URLEncoder.encode(user.getUserId(),"utf-8")+"%chengboTeam%"+user.getPassword());
                        //中间放置标志位隔开
                        //设置最大时间
                        cookie.setMaxAge(7*24*60*60);
                        cookie.setPath("/");//作用地址范围
                        resp.addCookie(cookie);
                    }else {
                        //没有勾选，就不保存
                        Cookie cookie = new Cookie("autoLogin",
                                URLEncoder.encode(user.getUserId(),"utf-8")+"%chengboTeam%"+user.getPassword());
                        //中间放置标志位隔开
                        //设置最大时间
                        cookie.setMaxAge(0);
                        cookie.setPath("/");//作用地址范围
                        resp.addCookie(cookie);
                    }
                    

        			
        			existUser.setImgurl(ftpConfig.getIMAGE_BASE_URL()+existUser.getImgurl());
        			session.setAttribute("existUser", existUser);
        			
        			//登陆成功的同时，把用户信息设置到redis中,有异常一定要捕获，让程序继续运行
        			try {
						iRedisCache.putCacheWithExpireTime(req.getRequestedSessionId(), existUser, 10*60);
					} catch (Exception e) {
						e.printStackTrace();
					}
        			
        			return MSG.success();
        		}else{
        			return MSG.fail();
        		}
        	}else{
        		MSG msg = new MSG();
        		msg.setMessage("验证码错误");
        		msg.setCode(300);
        		return msg;
        	}
        }
    
    
   
	@RequestMapping("/uploadHead")
	public String uploadHead(@ModelAttribute("user")User user,@RequestParam("fileName")MultipartFile file,HttpServletRequest request,
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
		User info=(User) request.getSession().getAttribute("spaceUser");
		info.setImgurl(savePath);
		iUserService.updateHead(info);
		
		//iPictureService.addPicture(0, savePath);
		info.setImgurl(ftpConfig.getIMAGE_BASE_URL()+info.getImgurl());
		return "space/homepage";
	}
	
	 /**
	    * 判断是否是本人空间
	    * @param session
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/judgeIsSpaceUser")
	   public String judgeIsSpaceUser(HttpSession session){
		   User spaceUser = (User)session.getAttribute("spaceUser");
		   User existUser = (User)session.getAttribute("existUser");
		   if(existUser.getUserId().equals(spaceUser.getUserId()))
			   return "1";
		   else
			   return "0";
		 
	   }
	   
	   @ResponseBody
	   @RequestMapping("/updateUserInfo")
	   public int  updateUserInfo(String nickname,String gender,String birthday,String email,String address,String school,String profession
			   ,String signal,HttpSession session) throws ParseException{
		 User user = (User)session.getAttribute("spaceUser");
		 user.setNickname(nickname);
		 user.setGender(gender);
		 SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		 Date birth=sim.parse(birthday);
		 user.setBirth(new java.sql.Date(birth.getTime()));
		 user.setEmail(email);
		 user.setAddress(address);
		 user.setSchool(school);
		 user.setProfession(profession);
		 user.setSignal(signal);
		 int i=iUserService.updateUserInfo(user);
		 return i;
	   }
}
