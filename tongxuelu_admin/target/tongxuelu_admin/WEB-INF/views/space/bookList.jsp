<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章总数</title>
<script src="/tongxuelu/static/img/jquery.js" type="text/javascript"></script>
<script src="/tongxuelu/static/img/v2js.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="/tongxuelu/static/css/buttons.css" />
<script src="/tongxuelu/static/paging/script/jquery.pagination.js" type="text/javascript"></script>
<link href="/tongxuelu/static/img/css.css" rel="stylesheet">
<link href="/tongxuelu/static/paging/style/common.css" rel="stylesheet">
<link href="/tongxuelu/static/paging/style/pagination.css" rel="stylesheet">
<script src="/tongxuelu/static/js/bookList.js" type="text/javascript"></script>
<script src="/tongxuelu/static/js/space.js" type="text/javascript"></script>

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
     <div class="actions"><a href="javascript:void(0)" id="concern" class="a-gz" style="background-color:#84E18D;">+加为好友</a> </div>
      <ul>
      	<li><a href="${pageContext.request.contextPath}/index.jsp ">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/homepage/${sessionScope.spaceUser.userId}">主页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/bookList/${sessionScope.spaceUser.userId}">我的文章</a></li>
        <li><a href="${pageContext.request.contextPath}/space/leaveWord/${sessionScope.spaceUser.userId}">留言板</a></li>
        <li><a href="${pageContext.request.contextPath}/space/logwrite/${sessionScope.spaceUser.userId}">写文章</a></li>
        <li><a href="${pageContext.request.contextPath}/space/myFriend/${sessionScope.spaceUser.userId}">我的好友</a></li>
        <li><a href="${pageContext.request.contextPath}/space/garbage/${sessionScope.spaceUser.userId}">文章回收站</a></li>
      </ul>
      <!-- <div class="head-avatar"><img src="/tongxuelu/static/img/head_snew.jpg" alt=""></div> -->
      <a href="${pageContext.request.contextPath}/space/uploadhead/${sessionScope.spaceUser.userId}"><div class="head-avatar"><img src="http://192.168.73.187/images${sessionScope.spaceUser.imgurl}" alt=""></div></a>
    </div>
  </div>
  <div class="layout-body">
    <div class="w960  clf">
      <div class="mb_list" id="mb_list">
       
        <ul >
          <li><a class="ih3" href="#" target="_blank">这个是文章内容的标题啊标题标题</a> <a href="#" target="_blank" class="mba"><img src="img/ad.png" alt="这个是文章内容的标题啊标题标题"><span></span></a>	 
          </li>
         
          <li><a class="ih3" href="#" target="_blank">这个是文章内容的标题啊标题标题</a> <a href="#" target="_blank" class="mba"><img src="img/ad.png" alt="这个是文章内容的标题啊标题标题"><span></span></a>
            <div style="display: none;" class="cover">
              <div class="cov_pbg"></div>
              <div class="cov_tbg"></div>
              <div class="cov_p">模板简介:<br>
                这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题</div>
              <div class="cov_t">时间:2014-04-11&nbsp;&nbsp;点击:675<a href="#" target="_blank" class="fr">查看详细&gt;&gt;</a></div>
            </div>
          </li>
          <li><a class="ih3" href="#" target="_blank">这个是文章内容的标题啊标题标题</a> <a href="#" target="_blank" class="mba"><img src="img/ad.png" alt="这个是文章内容的标题啊标题标题"><span></span></a>
            <div style="display: none;" class="cover">
              <div class="cov_pbg"></div>
              <div class="cov_tbg"></div>
              <div class="cov_p">模板简介:<br>
                这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题</div>
              <div class="cov_t">时间:2014-04-11&nbsp;&nbsp;点击:675<a href="#" target="_blank" class="fr">查看详细&gt;&gt;</a></div>
            </div>
          </li>
          <li><a class="ih3" href="#" target="_blank">这个是文章内容的标题啊标题标题</a> <a href="#" target="_blank" class="mba"><img src="img/ad.png" alt="这个是文章内容的标题啊标题标题"><span></span></a>
            <div style="display: none;" class="cover">
              <div class="cov_pbg"></div>
              <div class="cov_tbg"></div>
              <div class="cov_p">模板简介:<br>
                这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题</div>
              <div class="cov_t">时间:2014-04-11&nbsp;&nbsp;点击:675<a href="#" target="_blank" class="fr">查看详细&gt;&gt;</a></div>
            </div>
          </li>
          <li><a class="ih3" href="#" target="_blank">这个是文章内容的标题啊标题标题</a> <a href="#" target="_blank" class="mba"><img src="img/ad.png" alt="这个是文章内容的标题啊标题标题"><span></span></a>
            <div style="display: none;" class="cover">
              <div class="cov_pbg"></div>
              <div class="cov_tbg"></div>
              <div class="cov_p">模板简介:<br>
                这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题</div>
              <div class="cov_t">时间:2014-04-11&nbsp;&nbsp;点击:675<a href="#" target="_blank" class="fr">查看详细&gt;&gt;</a></div>
            </div>
          </li>
          <li><a class="ih3" href="#" target="_blank">这个是文章内容的标题啊标题标题</a> <a href="#" target="_blank" class="mba"><img src="img/ad.png" alt="这个是文章内容的标题啊标题标题"><span></span></a>
            <div style="display: none;" class="cover">
              <div class="cov_pbg"></div>
              <div class="cov_tbg"></div>
              <div class="cov_p">模板简介:<br>
                这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题</div>
              <div class="cov_t">时间:2014-04-11&nbsp;&nbsp;点击:675<a href="#" target="_blank" class="fr">查看详细&gt;&gt;</a></div>
            </div>
          </li>
          <li><a class="ih3" href="#" target="_blank">这个是文章内容的标题啊标题标题</a> <a href="#" target="_blank" class="mba"><img src="img/ad.png" alt="这个是文章内容的标题啊标题标题"><span></span></a>
            <div style="display: none;" class="cover">
              <div class="cov_pbg"></div>
              <div class="cov_tbg"></div>
              <div class="cov_p">模板简介:<br>
                这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题</div>
              <div class="cov_t">时间:2014-04-11&nbsp;&nbsp;点击:675<a href="#" target="_blank" class="fr">查看详细&gt;&gt;</a></div>
            </div>
          </li>
          <li><a class="ih3" href="#" target="_blank">这个是文章内容的标题啊标题标题</a> <a href="#" target="_blank" class="mba"><img src="img/ad.png" alt="这个是文章内容的标题啊标题标题"><span></span></a>
            <div style="display: none;" class="cover">
              <div class="cov_pbg"></div>
              <div class="cov_tbg"></div>
              <div class="cov_p">模板简介:<br>
                这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题这个是文章内容的标题啊标题标题</div>
              <div class="cov_t">时间:2014-04-11&nbsp;&nbsp;点击:675<a href="#" target="_blank" class="fr">查看详细&gt;&gt;</a></div>
            </div>
          </li>
        </ul>
      </div> 
       <div class="M-box3"></div> 
    </div>
   
  </div>
</div>
<a id="topcontrol" href="javascript:;" title="返回顶部"></a>
</body>
</html>