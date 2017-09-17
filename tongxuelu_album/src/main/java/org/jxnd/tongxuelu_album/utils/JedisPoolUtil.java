package org.jxnd.tongxuelu_album.utils;

import org.jxnd.tongxuelu_album.entity.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * jedis connection pool util
*  @author root
 */
@Component
public class JedisPoolUtil {

	//JedisPoolUtil(){}		//first to lock the default constructor

	@Autowired
	private RedisConfig redisConfig;
	
	//
	private volatile JedisPool jedisPools = null;
	
	/**
	 * get jedis connection through single model
	 */
	public JedisPool getJedisPoolInstance(){
		if(jedisPools == null){
			synchronized(this){//JedisPoolUtil.class是锁类
				if(jedisPools == null){
					//now should to create jedisPool
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					
					poolConfig.setMaxActive(redisConfig.getRedisMaxActive());
					poolConfig.setMaxIdle(redisConfig.getRedisMaxIdle());			//if up to this idle config,this pool will occur problem
					poolConfig.setMaxWait(redisConfig.getRedisMaxWaitMillis());
					poolConfig.setTestOnBorrow(true);
					
					jedisPools = new JedisPool(poolConfig, redisConfig.getRedisHost());
					
				}
			}
		}
		
		return jedisPools;
	}
	
	
	/**
	 * release the jedis connection
	 */
	public void release(JedisPool jedisPool,Jedis jedis){
		if(null != jedis){
			jedisPool.returnResourceObject(jedis);
		}
		
	}
	
	
}
