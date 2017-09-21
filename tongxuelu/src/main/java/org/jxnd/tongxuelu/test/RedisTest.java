package org.jxnd.tongxuelu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jxnd.tongxuelu.service.IRedisCache;
import org.jxnd.tongxuelu.utils.MailUtils;
import org.jxnd.tongxuelu.utils.SSOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:spring-redis.xml"})
public class RedisTest {
	
	@Autowired
	private IRedisCache iRedisCache;
	
	
    @Test
    public void test7() throws Exception{
        List<String> list = new ArrayList<String>();
        list.add("测试list1243");
        list.add("测试list212432");
        
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("test*","测试数据");
        map.put("测试数据","啥的");
        map.put("listTest",list);
        iRedisCache.putCache("testMapmym",map);

        Map<String,Object> mapResult = iRedisCache.getCache("testMapmym");
        System.out.print(mapResult.toString());

    }
    
    
    @Test
    public void testStringSub(){
    	String thisStr = "/tongxuelu/space/homepage/maoyuanming";
    	if(thisStr.startsWith("/tongxuelu/space/homepage")){
    		System.out.println("true");
    	}else{
    		System.out.println("false");
    	}
    }
    
    
    /**
     * 测试邮件发送
     */
    @Test
    public void sendMail(){
    	try {
	        String emailMsg = "注册成功，请在12小时内<a href='http:///tongxuelu/user/activeUser?activeCode="
	                + "asgadsg"
	                + "'>点击激活</a>====激活码是："
	                + "123"+"<br/>如果连接不能跳转，请复制地址：http:///tongxuelu/user/activeUser?activeCode="
	                +"123"+"<br/>到浏览器地址栏运行即可进行激活！";
			MailUtils.sendMail("2739403728@qq.com", emailMsg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
      

}
