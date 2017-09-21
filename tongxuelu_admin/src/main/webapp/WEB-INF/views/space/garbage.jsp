<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章回收站</title>
<script src="/tongxuelu/static/img/jquery.js" type="text/javascript"></script>
<script src="/tongxuelu/static/img/v2js.js" type="text/javascript"></script>
<link href="/tongxuelu/static/img/css.css" rel="stylesheet">
<script src="/tongxuelu/static/js/garbage.js" type="text/javascript"></script>

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
      <div class="actions"> <a href="#" class="a-gz">特别关注</a> </div>
      <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp ">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/homepage/${sessionScope.spaceUser.userId}">主页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/bookList/${sessionScope.spaceUser.userId}">我的文章</a></li>
        <li><a href="${pageContext.request.contextPath}/space/leaveWord/${sessionScope.spaceUser.userId}">留言板</a></li>
        <li><a href="${pageContext.request.contextPath}/space/logwrite/${sessionScope.spaceUser.userId}">写文章</a></li>
        <li><a href="${pageContext.request.contextPath}/space/myFriend/${sessionScope.spaceUser.userId}">我的好友</a></li>
        <li><a href="${pageContext.request.contextPath}/space/garbage/${sessionScope.spaceUser.userId}">文章回收站</a></li>
      </ul>
      <a href="${pageContext.request.contextPath}/space/uploadhead/${sessionScope.spaceUser.userId}"><div class="head-avatar"><img src="http://192.168.73.187/images${sessionScope.spaceUser.imgurl}" alt=""></div></a>
    </div>
  </div>
  <div class="layout-body">
    <div class="w960  clf">
      <div class="m_main" id="articleMain1" style="margin: auto;">
        
      </div>
      <div class="m_main" id="articleMain2">
      	<div class="inner more"><a href="javascript:initArticle()">更多内容&gt;&gt;</a></div>
      </div>
    </div>
  </div>
</div>
<a style="opacity: 0;" id="topcontrol" href="javascript:;" title="返回顶部"></a>
</body>
</html>
