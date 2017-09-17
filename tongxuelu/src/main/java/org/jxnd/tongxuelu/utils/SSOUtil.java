package org.jxnd.tongxuelu.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mym on 2017/9/15.
 * 一些关于sso相关的方法
 */
public class SSOUtil {


    /**
     * 处理是否需要端口号，如果为localhost或者192开头或者127开头，就是：serverName:端口号  的形式
     * 否则直接返回serverName
     * @param request
     * @return
     */
    public static String getHostName(HttpServletRequest request){
        String oldHost = request.getServerName();
        //处理是否需要端口号，如果为localhost或者192开头或者127开头，就需要端口号，否则直接返回serverName
        if("localhost".equals(oldHost) || "127".equals(oldHost.substring(0,3))
                || "192".equals(oldHost.substring(0,3))){

            return oldHost+":"+request.getServerPort();
        }
        return oldHost;
    }
    
    
    /**
     * redis获取的user的实体类类型进转换，因为包不同名，为了不改以前的代码，就做一个封装转换
     * 本方法是把，tongxuelu_album.entity.User类型转换称tongxuelu.entity.User类型。其中有时间类型的转换
     *title:convertToTongxueluUser
     *@param albumUser 需要转换的对象，是从redis中获取的tongxuelu_album.entity.User对象
     *@return
     */
/*    public static org.jxnd.tongxuelu.entity.User convertToTongxueluUser(org.jxnd.tongxuelu_album.entity.User albumUser){
    	if(albumUser == null){
    		return null;
    	}
    	org.jxnd.tongxuelu.entity.User existUser = new org.jxnd.tongxuelu.entity.User();
		existUser.setActive(albumUser.getActive());
		existUser.setActiveCode(albumUser.getActiveCode());
		existUser.setAddress(albumUser.getAddress());
		existUser.setAge(albumUser.getAge());
		if(albumUser.getBirth() != null){
			existUser.setBirth(new java.sql.Date(albumUser.getBirth().getTime()));
		}
		existUser.setDescription(albumUser.getDescription());
		existUser.setEmail(albumUser.getEmail());
		existUser.setGender(albumUser.getGender());
		existUser.setImgurl(albumUser.getImgurl());
		existUser.setNickname(albumUser.getNickname());
		existUser.setPassword(albumUser.getPassword());
		existUser.setProfession(albumUser.getProfession());
		existUser.setQq(albumUser.getQq());
		if(albumUser.getRegisterTime() != null){
			existUser.setRegisterTime(new java.sql.Date(albumUser.getRegisterTime().getTime()));
		}
		existUser.setSchool(albumUser.getSchool());
		existUser.setSignal(albumUser.getSignal());
		existUser.setState(albumUser.getState());
		existUser.setUserId(albumUser.getUserId());
		
		return existUser;
    }*/
    
    
    
    /**
     * redis获取的user的实体类类型进转换，因为包不同名，为了不改以前的代码，就做一个封装转换
     * 本方法是把，tongxuelu.entity.User类型转换称tongxuelu_album.entity.User类型。其中有时间类型的转换
     * 注意两个实体类的时间类型也是不一样的
     *title:convertToTongxueluAlbumUser
     *@param user
     *@return
     */
/*    public static org.jxnd.tongxuelu_album.entity.User convertToTongxueluAlbumUser(org.jxnd.tongxuelu.entity.User user){
    	
    	if(user == null){
    		return null;
    	}
    	
    	org.jxnd.tongxuelu_album.entity.User albumUser = new org.jxnd.tongxuelu_album.entity.User();
    	albumUser.setActive(user.getActive());
    	albumUser.setActiveCode(user.getActiveCode());
    	albumUser.setAddress(user.getAddress());
    	albumUser.setAge(user.getAge());
		if(user.getBirth() != null){
			albumUser.setBirth(user.getBirth());
		}
		albumUser.setDescription(user.getDescription());
		albumUser.setEmail(user.getEmail());
		albumUser.setGender(user.getGender());
		albumUser.setImgurl(user.getImgurl());
		albumUser.setNickname(user.getNickname());
		albumUser.setPassword(user.getPassword());
		albumUser.setProfession(user.getProfession());
		albumUser.setQq(user.getQq());
		if(user.getRegisterTime() != null){
			albumUser.setRegisterTime(user.getRegisterTime());
		}
		albumUser.setSchool(user.getSchool());
		albumUser.setSignal(user.getSignal());
		albumUser.setState(user.getState());
		albumUser.setUserId(user.getUserId());
		
		return albumUser;
    }
     */
    
    
    

}
