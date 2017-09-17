package org.jxnd.tongxuelu_album.Interceptor;

import org.jxnd.tongxuelu.entity.User;
import org.jxnd.tongxuelu_album.entity.FtpConfig;
import org.jxnd.tongxuelu_album.utils.JedisPoolUtil;
import org.jxnd.tongxuelu_album.utils.JedisUtil;
import org.jxnd.tongxuelu_album.utils.SSOUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by mym on 2017/9/15.
 * 登陆拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * 日志记录
     */
   // private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    public static final String LAST_PAGE = "org.jxnd.tongxuelu_album.Interceptor";

    @Autowired
    private JedisPoolUtil jedisPoolUtil;

    @Autowired
    private FtpConfig ftpConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        User existUser = (User) request.getSession().getAttribute("existUser");
        if (existUser == null) {

            //再查询redis，如果用户存在，就设置session，让它登陆
            //sessionId在地址上
            String sessionID = request.getParameter("sessionId");
            if(sessionID != null){
                //查询redis中的内容
                existUser = (org.jxnd.tongxuelu.entity.User) JedisUtil.getObject(jedisPoolUtil,sessionID);
                System.out.println("查了redis");
            }

            if(existUser == null){
                //redis中也没有的话，就跳转到登陆页面
                //request.getSession().invalidate();      //清理一下
                System.out.println("尚未登录，调到登录页面");
                response.sendRedirect("/login.html");

                return false;
            }else{
                //如果redis中查询到了，就把该用户存到session中
                System.out.println("redis查询到了用户！");

                existUser.setImgurl(ftpConfig.getIMAGE_BASE_URL()+existUser.getImgurl());
                request.getSession().setAttribute("existUser",existUser);
                return true;
            }



        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }


}
