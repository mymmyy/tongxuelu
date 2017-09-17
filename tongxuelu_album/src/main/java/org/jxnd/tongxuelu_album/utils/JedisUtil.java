package org.jxnd.tongxuelu_album.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by mym on 2017/9/15.
 * redis用户设置用户信息和得到用户信息的专用封装方法，过期时间是10分钟
 */
public class JedisUtil {

    /**
     * 通过序列化存放对象信息，key可以是sessionID，value可以是用户对象
     * @param jedisPoolUtil 自定义的连接池工具类，需要从里面获取连接，最后释放连接
     * @param key 若是存放登陆的user可以使用当前登陆的sessionID，作为key
     * @param object 需要存放对象，可以是用户对象
     */
    public static void setObject(JedisPoolUtil jedisPoolUtil,String key,Object object){

        JedisPool jedisPool = jedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();

            jedis.set(key.getBytes(), SerializerUtil.serializeObj(object));
            jedis.expire(key.getBytes(),(60*10));//60秒*10 --》10分钟

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jedisPoolUtil.release(jedisPool, jedis);  //release resource from jedisPool
        }

    }


    /**
     * 从redis获取对象
     * @param jedisPoolUtil
     * @param key
     * @return
     */
    public static Object getObject(JedisPoolUtil jedisPoolUtil,String key){
        Object object = null;
        JedisPool jedisPool = jedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            if(key!=null){
                object = SerializerUtil.deserializeObj(jedis.get(key.getBytes()));

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jedisPoolUtil.release(jedisPool, jedis);  //release resource from jedisPool
        }

        return object;

    }




}
