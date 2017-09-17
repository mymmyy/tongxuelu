package org.jxnd.tongxuelu_album.utils;

import java.util.UUID;


/**
 * 生成随机字符串
 *<p>Title:UUIDUtil</p>
 *@author mym
 *@date 2017-9-6上午10:45:10
 *@version 1.0
 */
public class UUIDUtil {
	
	/**
	 * 根据UUID自生成两段字符串然后连接各自一部分得到不重复的随机字符串可以作为实体类ID
	 *title:getRandomStringAsId
	 *@return
	 */
	public static String getRandomStringAsId(){
		return UUID.randomUUID().toString().split("-")[0]+UUID.randomUUID().toString().split("-")[0];
	}
	
	/**
	 * 根据UUID生成随机的字符串
	 *title:getActiveCode
	 *@return
	 */
	public static String getRandomString(){
		return UUID.randomUUID().toString();
	}
	
	
	

}
