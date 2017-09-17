package org.jxnd.tongxuelu_album.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by 明柯 on 2017/4/12.
 * 邮件发送工具类
 */
public class MailUtils {
    public static void sendMail(String email,String emailMsg) throws MessagingException {
        //1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();

        // 使用smtp：简单邮件传输协议
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.host", "localhost");//存储发送邮件服务器的信息
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true

        // 创建验证器
        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("chengboTeam_mym", "123123");
            }
        };

        Session session = Session.getInstance(props,auth);//根据属性新建一个邮件会话

        //2. 创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        // 设置发送者
        message.setFrom(new InternetAddress("chengboTeam_mym@localhost"));
        //设置发送方式与接收者
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
        message.setSubject("用户激活");//设置标题
        message.setContent(emailMsg,"text/html;charset=utf-8");
        //3.创建Transport用于将邮件发送
        Transport.send(message);

    }

    //测试
    /*public static void main(String[] args) throws Exception {
    	String emailMsg = "注册成功，请在12小时内<a href='http://localhost:8080/tongxuelu/user/activeUser?activeCode=367d09b8-d8d2-4de7-baeb-c4d96008d879'>点击激活</a>====激活码是：367d09b8-d8d2-4de7-baeb-c4d96008d879";
        String email = "2739403728@qq.com";
        sendMail(email,emailMsg);
    }*/
}
