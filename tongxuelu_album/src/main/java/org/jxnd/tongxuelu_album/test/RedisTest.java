package org.jxnd.tongxuelu_album.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jxnd.tongxuelu_album.entity.RedisConfig;
import org.jxnd.tongxuelu_album.utils.JedisPoolUtil;
import org.jxnd.tongxuelu_album.utils.JedisUtil;
import org.jxnd.tongxuelu_album.utils.SSOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;

/**
 * Created by mym on 2017/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RedisTest {

   /* @Autowired
    private IRedisCache iRedisCache;

    @Test
    public void test1() throws Exception{
        List<String> list = new ArrayList<String>();
        list.add("测试list");
        list.add("测试list2");

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("test*","测试数据");
        map.put("测试数据","啥的");
        map.put("listTest",list);
        iRedisCache.putCache("testMap",map);

        Map<String,Object> mapResult = iRedisCache.getCache("testMap");
        System.out.print(mapResult.toString());

    }


    @Test
    public void testSessionIDPut() throws Exception {
       *//* String sessionId = "qwertyuiop";
        User user = new User();

        user.setUserId("maoyuanming");
        user.setPassword("e10adc3949ba59abbe56e057f20f883e");
        user.setEmail("1021011249");

        Map<String,Object> map = new HashMap<String, Object>();
        map.put(sessionId,user);*//*

        //iRedisCache.putCache("sessionMap",map);

        Map<String,Object> mapResult = iRedisCache.getCache("sessionMap");
        System.out.print(mapResult.get("qwertyuiop"));

    }*/

    @Autowired
    private JedisPoolUtil jedisPoolUtil;

    @Test
    public void testRedis(){

        JedisPool jedisPool = jedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.set("pool", "poolvalue");

            System.out.println(jedis.get("pool"));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jedisPoolUtil.release(jedisPool, jedis);  //release resource from jedisPool
        }


    }


    @Autowired
    private RedisConfig redisConfig;




}
