<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人空间首页</title>
<script src="/tongxuelu/static/img/jquery.js" type="text/javascript"></script>
<script src="/tongxuelu/static/img/v2js.js" type="text/javascript"></script>
<link href="/tongxuelu/static/img/css.css" rel="stylesheet">
<script src="/tongxuelu/static/js/homepage.js" type="text/javascript"></script>
<script src="/tongxuelu/static/js/space.js" type="text/javascript"></script>
<style type="text/css">
	#articleMain1 img{
		width: 275px;
		height: 175px;
	}
</style>

</head>
<body>
<div id="main">
  <div class="layout-head w960">
    <div class="head-info">
     <h1>${sessionScope.spaceUser.nickname}的空间</h1>
      <div class="head-description">${sessionScope.spaceUser.signal}</div>
    </div>
  </div>
  <div class="head_nav">
    <div class="nav_bg"></div>
    <div class="w960">
      <div class="head-name"><span class="user-name textoverflow">${sessionScope.spaceUser.nickname}</span>
        <div class="head-description">http://www.chenbo.com/</div>
      </div>
       <c:choose>
	    <c:when test="${sessionScope.existUser.userId != sessionScope.spaceUser.userId}"><!-- 如果加入自己的空间-->
             <div class="actions"><a href="javascript:void(0)" id="concern" class="a-gz" style="background-color:#84E18D;">+加为好友</a> </div>
        </c:when>
	  </c:choose>
   
      <ul>
      	<li><a href="${pageContext.request.contextPath}/index.jsp ">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/homepage/${sessionScope.spaceUser.userId}">主页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/bookList/${sessionScope.spaceUser.userId}">全部文章</a></li>
        <li><a href="${pageContext.request.contextPath}/space/leaveWord/${sessionScope.spaceUser.userId}">留言板</a></li>
         <c:choose>
	     <c:when test="${sessionScope.existUser.userId == sessionScope.spaceUser.userId}"><!-- 如果加入自己的空间-->
              <li><a href="${pageContext.request.contextPath}/space/logwrite/${sessionScope.spaceUser.userId}">写文章</a></li>
             <li><a href="${pageContext.request.contextPath}/space/myFriend/${sessionScope.spaceUser.userId}">我的好友</a></li>
            <li><a href="${pageContext.request.contextPath}/space/garbage/${sessionScope.spaceUser.userId}">文章回收站</a></li>
            <li><a href="${pageContext.request.contextPath}/SsoForwardController/toAlbumSpace">相册系统</a></li>
         </c:when>
	    </c:choose>
       
      </ul>
      <a href="${pageContext.request.contextPath}/space/uploadhead/${sessionScope.spaceUser.userId}" class="uploadhead"><div class="head-avatar"><img src="${spaceUser.imgurl}" alt=""></div></a>
    </div>
  </div>
  <div class="layout-body">
    <div class="w960  clf">
      <div class="m_left">
        <div class="inner pd1">
          <ul class="stats-list clf">
            <li style="width:130px;"><strong id='friendCount'>16</strong><span>我的好友</span></li>
            <li ><strong id='articleCount' style="margin-left:30px;">174</strong><span style="margin-left:30px;">我的文章</span></li>
          </ul>
        </div>
        <div class="inner mt12 p0">
          <div class="hd">
            <h3>个人信息</h3>
          </div>
          <div class="bd">
            <ul class="detail-list">
              <li><i class="i-nc"></i>昵称：<span>${sessionScope.spaceUser.nickname}</span></li>
              <li><i class="i-dj"></i>职业：<span>${sessionScope.spaceUser.profession}</span></li>
              <li><i class="i-ip"></i>个性签名：<span>${sessionScope.spaceUser.signal}</span></li>
               <li class="born"><a href="/tongxuelu/space/info/${sessionScope.spaceUser.userId}">查看详细资料</a></li>
            </ul>
          </div>
        </div>
        <div class="inner mt12 p0">
          <div class="hd">
            <h3>最近添加好友</h3>
          </div>
          <div class="bd" id="myFriend">
            <ul class="avatar-list clf">
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="m_main" id="articleMain1">
        
      </div>
      <div class="m_main" id="articleMain2">
      	<div class="inner more"><a href="javascript:initArticle()">更多内容&gt;&gt;</a></div>
      </div>
    </div>
    <div id="footer">Copyright &#169; 2014 www.5imb.com 版权所有</div>
  </div>
</div>
<a style="opacity: 0;" id="topcontrol" href="javascript:;" title="返回顶部"></a>
</body>
</html>
