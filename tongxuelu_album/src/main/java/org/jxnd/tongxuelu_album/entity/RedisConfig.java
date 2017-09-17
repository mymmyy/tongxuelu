package org.jxnd.tongxuelu_album.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mym on 2017/9/15.
 */
@Component
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;       //主机ip--服务器地址

    @Value("${redis.port}")
    private String redisPort;       //服务端口

    @Value("${redis.password}")
    private String redisPassword;   //密码

    @Value("${redis.default.db}")
    private String redisDefaultDb;  //链接数据库

    @Value("${redis.timeout}")
    private Integer redisTimeout;    //客户端超时时间单位是毫秒

    @Value("${redis.maxActive}")
    private Integer redisMaxActive;  //最大连接数


    @Value("${redis.maxIdle}")
    private Integer redisMaxIdle;    //最大空闲数

    @Value("${redis.maxWaitMillis}")
    private Integer redisMaxWaitMillis;  //最大建立连接等待时间


    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public String getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(String redisPort) {
        this.redisPort = redisPort;
    }

    public String getRedisPassword() {
        return redisPassword;
    }

    public void setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
    }

    public String getRedisDefaultDb() {
        return redisDefaultDb;
    }

    public void setRedisDefaultDb(String redisDefaultDb) {
        this.redisDefaultDb = redisDefaultDb;
    }

    public Integer getRedisTimeout() {
        return redisTimeout;
    }

    public void setRedisTimeout(Integer redisTimeout) {
        this.redisTimeout = redisTimeout;
    }

    public Integer getRedisMaxActive() {
        return redisMaxActive;
    }

    public void setRedisMaxActive(Integer redisMaxActive) {
        this.redisMaxActive = redisMaxActive;
    }

    public Integer getRedisMaxIdle() {
        return redisMaxIdle;
    }

    public void setRedisMaxIdle(Integer redisMaxIdle) {
        this.redisMaxIdle = redisMaxIdle;
    }

    public Integer getRedisMaxWaitMillis() {
        return redisMaxWaitMillis;
    }

    public void setRedisMaxWaitMillis(Integer redisMaxWaitMillis) {
        this.redisMaxWaitMillis = redisMaxWaitMillis;
    }


    @Override
    public String toString() {
        return "RedisConfig{" +
                "redisHost='" + redisHost + '\'' +
                ", redisPort='" + redisPort + '\'' +
                ", redisPassword='" + redisPassword + '\'' +
                ", redisDefaultDb='" + redisDefaultDb + '\'' +
                ", redisTimeout=" + redisTimeout +
                ", redisMaxActive=" + redisMaxActive +
                ", redisMaxIdle=" + redisMaxIdle +
                ", redisMaxWaitMillis=" + redisMaxWaitMillis +
                '}';
    }
}
