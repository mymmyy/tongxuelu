<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css" href="/tongxuelu/static/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/tongxuelu/static/css/nprogress.css">
<link rel="stylesheet" type="text/css" href="/tongxuelu/static/css/style.css">
<link rel="stylesheet" type="text/css" href="/tongxuelu/static/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="/tongxuelu/static/images/icon.png">
<link rel="shortcut icon" href="/tongxuelu/static/img/favicon.ico">
<script src="/tongxuelu/static/js/jquery.min.js"></script>
<script src="/tongxuelu/static/js/nprogress.js"></script>
<script src="/tongxuelu/static/js/jquery.lazyload.min.js"></script>
<script src="/tongxuelu/static/js/show.js"></script>
<!--[if gte IE 9]>
  <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="js/html5shiv.min.js" type="text/javascript"></script>
  <script src="js/respond.min.js" type="text/javascript"></script>
  <script src="js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->
<style type="text/css">
	#showArticle{
		width: 700px;red;
		text-align: center;
		background-color: white;
		font-family: "楷体";
		font-size: 17px;
	}
	#showArticle img{
		width: 500px;
		height: 300px;
	}
</style>
</head>
<body class="user-select" style="background-color: white;">
<header class="header">
<nav class="navbar navbar-default" id="navbar">
<div class="container">
  <div class="header-topbar hidden-xs link-border">
	<ul class="site-nav topmenu">
	<c:choose>
	    <c:when test="${sessionScope.existUser!=null}"><!-- 如果存在已经登录的用户 -->
        <li><a href="${pageContext.request.contextPath}/space/homepage/${sessionScope.existUser.userId}" rel="nofollow" >${sessionScope.existUser.nickname}</a></li>
        <li><a href="javascript:void(0)" >退出</a></li>
        </c:when>
        <c:otherwise>
        <li><a href="${pageContext.request.contextPath}/user/toLogin" rel="nofollow" >登录</a></li>
        <li><a href="${pageContext.request.contextPath}/user/toRegister" >注册</a></li>
        </c:otherwise>
	  </c:choose>
		<li><a href="#" title="RSS订阅" >
			<i class="fa fa-rss">
			</i> 联系我们
		</a></li>
	</ul>
			 勤记录 懂分享</div>
  <div class="navbar-header">
	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
	<h1 class="logo hvr-bounce-in"><a href="#" title="木庄网络博客"><img src="/tongxuelu/static/img/logo.jpg" alt="木庄网络博客"></a></h1>
  </div>
  <div class="collapse navbar-collapse" id="header-navbar">
	<form class="navbar-form visible-xs" action="/Search" method="post">
	  <div class="input-group">
		<input type="text" name="keyword" class="form-control" placeholder="请输入关键字" maxlength="20" autocomplete="off">
		<span class="input-group-btn">
		<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
		</span> </div>
	</form>
	<ul class="nav navbar-nav navbar-right">
	  <li><a data-cont="博客首页" title="博客首页" href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
	  <li><a data-cont="列表页" title="列表页" href="${pageContext.request.contextPath}/chenbo/list">文章列表</a></li>
	  <li><a data-cont="个人空间" title="个人空间" href="${pageContext.request.contextPath}/space/homepage/${sessionScope.existUser.userId}">个人空间</a></li>
	</ul>
  </div>
</div>
</nav>
</header>
<section class="container">
<div class="content-wrap">
<div class="content">
   <header class="article-header" id="blog_title">
	<h1 class="article-title"><a href="#" title=${requestScope.userBlog.blogTitle } >${requestScope.userBlog.blogTitle }</a></h1>
	<div class="article-meta"> <span class="item article-meta-time">
	  <time class="time" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="发表时间：${requestScope.userBlog.releaseTime}"><i class="glyphicon glyphicon-time"></i> ${requestScope.userBlog.releaseTime}</time>
	  </span> <span class="item article-meta-source" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="来源：${requestScope.userBlog.user.nickname }"><i class="glyphicon glyphicon-globe"></i> <a href='/tongxuelu/space/homepage/${requestScope.userBlog.user.userId}'>${requestScope.userBlog.user.nickname }</a></span> <span class="item article-meta-category" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="${requestScope.userBlog.blogCategory.categoryName}"><i class="glyphicon glyphicon-list"></i> <a href="#" title="${requestScope.userBlog.blogCategory.categoryName}" >${requestScope.userBlog.blogCategory.categoryName}</a></span> <span class="item article-meta-views" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="浏览量：219"><i class="glyphicon glyphicon-eye-open"></i> 219</span> <span class="item article-meta-comment" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="评论量"><i class="glyphicon glyphicon-comment"></i> 4</span> </div>
  </header>
  <article class="article-content">
	<!-- <p><img data-original="/tongxuelu/static/img/201610181557196870.jpg" src="/tongxuelu/static/img/201610181557196870.jpg" alt="" /></p> -->
	
	<article  id="showArticle" style="margin: auto;">
		${requestScope.userBlog.blogContent }
	</article >
	<br>
	<br>
	<div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_tieba" data-cmd="tieba" title="分享到百度贴吧"></a><a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a></div>

		  <script>                  window._bd_share_config = { "common": { "bdSnsKey": {}, "bdText": "", "bdMini": "2", "bdMiniList": false, "bdPic": "", "bdStyle": "1", "bdSize": "32" }, "share": {} }; with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=0.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
  </article>
  <div class="article-tags"><!-- 标签：<a href="#list/2/" rel="tag" >DTcms博客</a><a href="#list/3/" rel="tag" >木庄网络博客</a><a href="#list/4/" rel="tag" >独立博客</a><a href="#list/5/" rel="tag" >修复优化</a>-->
	</div>

  <div class="title" id="comment">
	<h3>评论</h3>
  </div>
  <div id="respond">
		<form id="comment-form" name="comment-form" action="javascript:void(0)" method="POST">
			<div class="comment">
				<div class="comment-box">
				    <input id="blogId" type="hidden" value="${requestScope.userBlog.blogId}">
				    <input id="userId" type="hidden" value="${requestScope.userBlog.userId}">
					<textarea placeholder="您的评论或留言（最多100字）" name="comment-textarea" id="comment-textarea" cols="100%" rows="3" tabindex="3"></textarea>
					<div class="comment-ctrl">
						<div class="comment-prompt" style="display: none;"> <i class="fa fa-spin fa-circle-o-notch"></i> <span class="comment-prompt-text">评论正在提交中...请稍后</span> </div>
						<div class="comment-success" style="display: none;"> <i class="fa fa-check"></i> <span class="comment-prompt-text">评论提交成功...</span> </div>
						<div class="comment-fail" style="display: none;text-align:center;"> <i class="fa fa-check"></i> <span class="comment-prompt-text">评论提交失败...</span> </div>
						<button type="submit" name="comment-submit" id="comment-submit" tabindex="4">评论</button>
					</div>
				</div>
			</div>
		</form>
		
	</div>
  <div id="postcomments">
	<ol id="comment_list" class="commentlist">        
		<!--<li class="comment-content"><span class="comment-f">#1</span>
		<div class="comment-main"><p><a class="address" href="#" rel="nofollow" target="_blank">木庄网络博客</a><span class="time">(2016/10/28 11:41:03)</span><a href="javascript:void(0)"><img src="/tongxuelu/static/img/reply.jpg"></a><br>不错的网站主题，看着相当舒服</p></div>
		<div class="comment-main"><p><a class="address" href="#" rel="nofollow" target="_blank">无敌<font color="black"> 回复  </font>20170904</a><span class="time">(2016/10/28 11:41:03)</span><a href="javascript:void(0)"><img src="/tongxuelu/static/img/reply.jpg"></a><br>不错的网站主题，看着相当舒服</p> </div>
		</li>
		<li class="comment-content"><span class="comment-f">#2</span><div class="comment-main"><p><a class="address" href="#" rel="nofollow" target="_blank">木庄网络博客</a><span class="time">(2016/10/14 21:02:39)</span><br>博客做得好漂亮哦！</p></div></li>-->
	</ol>
  </div>
</div>
</div>
<aside class="sidebar">
<div class="fixed">
  <div class="widget widget-tabs">
	<ul class="nav nav-tabs" role="tablist">
	  <li role="presentation" class="active"><a href="#notice" aria-controls="notice" role="tab" data-toggle="tab" draggable="false">统计信息</a></li>
	  <li role="presentation"><a href="#contact" aria-controls="contact" role="tab" data-toggle="tab" draggable="false">联系站长</a></li>
	</ul>
	<div class="tab-content">
	  <div role="tabpanel" class="tab-pane contact active" id="notice">
		<h2 id="articleH2">博客总数:
			  888篇
		  </h2>
		  <h2>网站用户:
		  <span id="sitetime">88天 </span></h2>
	  </div>
		<div role="tabpanel" class="tab-pane contact" id="contact">
		  <h2>博主QQ:
			  <a href="" target="_blank" rel="nofollow" data-toggle="tooltip" data-placement="bottom" title="" draggable="false" data-original-title="QQ:577211782">577211782</a>
		  </h2>
		  <h2>博主Email:
		  <a href="mailto:577211782@qq.com" target="_blank" data-toggle="tooltip" rel="nofollow" data-placement="bottom" title="" draggable="false" data-original-title="Email:577211782@qq.com">577211782@qq.com</a></h2>
	  </div>
	</div>
  </div>
  <div class="widget widget_search">
	<form class="navbar-form" action="/Search" method="post">
	  <div class="input-group">
		<input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" autocomplete="off">
		<span class="input-group-btn">
		<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
		</span> </div>
	</form>
  </div>
</div>
<div class="widget widget_hot">
	  <h3>博主的其他文章</h3>
	 <ul id="ul1">
	 	
	 </ul>
  </div>
  <div class="widget widget_sentence">

<a href="#" target="_blank" rel="nofollow" title="MZ-NetBlog主题" >
	<img style="width: 100%" src="/tongxuelu/static/img/ad.jpg" alt="MZ-NetBlog主题" ></a>

</div>
  <div class="widget widget_sentence">

<a href="#" target="_blank" rel="nofollow" title="专业网站建设" >
	<img style="width: 100%" src="/tongxuelu/static/img/201610241224221511.jpg" alt="专业网站建设" ></a>

</div>
</aside>
</section>
<footer class="footer">
<div class="container">
 <p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://chenbo.com"></a> </p>
</div>
<div id="gotop"><a class="gotop"></a></div>
</footer>
<script src="/tongxuelu/static/js/bootstrap.min.js"></script>
<script src="/tongxuelu/static/js/jquery.ias.js"></script>
<script src="/tongxuelu/static/js/scripts.js"></script>
</body>
</html>