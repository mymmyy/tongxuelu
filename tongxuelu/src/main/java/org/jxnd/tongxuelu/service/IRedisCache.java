package org.jxnd.tongxuelu.service;


import org.springframework.stereotype.Service;


/**
 * redis缓存操作的接口,需要进行缓存的内容必须实现序列化接口，否则报错
 * 注意：有异常一定要捕获，让程序继续运行
 *<p>Title:IRedisCache</p>
 *@author mym
 *@date 2017-9-16上午10:29:37
 *@version 1.0
 */
@Service
public interface IRedisCache{
	
	
	
    /**
     * 添加缓存数据
     * @param key
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
	public <T> boolean putCache(String key, T obj) throws Exception;
	
	
	
    /**
     * 添加缓存数据，设定缓存失效时间
     * @param key
     * @param obj
     * @param expireTime
     * @param <T>
     * @throws Exception
     */
	public <T> void putCacheWithExpireTime(String key, T obj, final long expireTime) throws Exception;
	
    /**
     * 根据key取缓存数据
     * @param key
     * @param <T>
     * @return
     * @throws Exception
     */
	public <T> T getCache(final String key) throws Exception;

}
