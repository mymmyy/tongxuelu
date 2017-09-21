package org.jxnd.tongxuelu.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *对密码使用MD5加密  32位
 */
public class MD5Utils {
    public static String md5(String plainText){
        //1.准备一个字符数组
        byte[] secretBytes = null;

        try {
            secretBytes = MessageDigest.getInstance("md5")
                    .digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法");
        }
        String md5code = new BigInteger(1,secretBytes).toString(16);
        //如果生成数字未满32位，需要前面补零
        for(int i = 0;i<32-md5code.length();i++){
            md5code = "0"+md5code;
        }
        return md5code;
    }
}
