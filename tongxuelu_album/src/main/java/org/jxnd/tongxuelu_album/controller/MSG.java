package org.jxnd.tongxuelu_album.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * 专门返回json数据的包装类
 * Created by mym on 2017/8/30.
 */
public class MSG {

    //状态码，100成功，200有问题
    private int code;

    //返回信息
    private String message;


    //放置包装的数据对象(原要返回给浏览器的数据)
    private Map<String,Object> extend = new HashMap<String,Object>();


    /**
     * 请求失败的方法
     * @return MSG对象
     */
    public static MSG success(){
        MSG msg = new MSG();
        msg.setCode(100);
        msg.setMessage("请求成功");
        return msg;
    }


    /**
     * 请求失败的方法
     * @return MSG对象
     */
    public static MSG fail(){
        MSG msg = new MSG();
        msg.setCode(200);
        msg.setMessage("请求失败");
        return msg;
    }


    /**
     * 添加要给浏览器的数据
     * @param key
     * @param value
     * @return
     */
    public MSG add(String key,Object value){
        this.getExtend().put(key, value);
        return this;
    }








    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }




}
