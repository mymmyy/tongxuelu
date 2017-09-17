package org.jxnd.tongxuelu_album.controller;

import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.entity.FtpConfig;
import org.jxnd.tongxuelu_album.service.IUserService;
import org.jxnd.tongxuelu_album.utils.JedisPoolUtil;
import org.jxnd.tongxuelu_album.utils.JedisUtil;
import org.jxnd.tongxuelu_album.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by mym on 2017/9/12.
 * album system的user controller
 */
@Controller
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private FtpConfig ftpConfig;

    @Autowired
    private JedisPoolUtil jedisPoolUtil;            //用于redis操作


    @ResponseBody
    @RequestMapping("/login")
    public MSG login(User user, @RequestParam(name = "verify",required = false) String verify, HttpSession session){
        System.out.println("得到的验证码是："+verify+"正确的验证码是："+session.getAttribute("code").toString());

        User existUser=null;
        //判断验证码
        if(verify.equalsIgnoreCase(session.getAttribute("code").toString())){

            user.setPassword(MD5Utils.md5(user.getPassword()));
            existUser=iUserService.getUserIdAndPwd(user.getUserId(), user.getPassword());

            if(existUser!=null){

                //先判断是否激活
                if(!"1".equals(existUser.getActive())){
                    MSG msg = new MSG();
                    msg.setMessage("用户没有激活，请至邮箱收件箱或垃圾箱查看邮件进行激活，若10分钟后仍未收到邮件，请重新注册！");
                    msg.setCode(400);
                    return msg;
                }


                existUser.setImgurl(ftpConfig.getIMAGE_BASE_URL()+existUser.getImgurl());


                session.setAttribute("existUser", existUser);

                //登陆成功，把信息存放到redis中
                JedisUtil.setObject(jedisPoolUtil,session.getId(),existUser);

                return MSG.success();
            }else{
                return MSG.fail();
            }
        }else{
            MSG msg = new MSG();
            msg.setMessage("验证码错误");
            msg.setCode(300);
            System.out.println(msg);
            return msg;
        }

    }




}
