<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-CN">
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
<link rel="apple-touch-icon-precomposed" href="/tongxuelu/static/img/icon.png">
<link rel="shortcut icon" href="/tongxuelu/static/img/favicon.ico">
<script src="/tongxuelu/static/js/jquery.min.js"></script>
<script src="/tongxuelu/static/js/nprogress.js"></script>
<script src="/tongxuelu/static/js/jquery.lazyload.min.js"></script>
<script src="/tongxuelu/static/js/list.js"></script>
<!--[if gte IE 9]>
  <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="js/html5shiv.min.js" type="text/javascript"></script>
  <script src="js/respond.min.js" type="text/javascript"></script>
  <script src="js/selectivizr-min.js" type="text/javascript"></script>
<![endif]-->
<!--[if lt IE 9]>
  <script>window.location.href='upgrade-browser.html';</script>
<![endif]-->

</head>
<body class="user-select">
<header class="header">
<nav class="navbar navbar-default" id="navbar">
<div class="container">
  <div class="header-topbar hidden-xs link-border">
	<ul class="site-nav topmenu">
	  <li><a href="#" >注册</a></li>
		<li><a href="#" rel="nofollow" >登录</a></li>
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
	<ul class="nav navbar-nav navbar-right" style="padding-left: -30px">
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
	<div class="title">
		<h3 style="line-height: 1.3" id="titleH3">最新文章</h3>
	 </div>
	<div class="content" id="content2">

  </div>
  <div class="content" id="content3">
	<div  style="cursor:pointer;width:820px;font-size:16px;margin-top:2px;padding-top:6px;height:40px;text-align:center;background-color:#ccccff;" onclick="initLeft()">
		加载更多
	</div>
	</div>
	
</div>
<aside class="sidebar">
<div class="fixed">
  <div class="widget widget_search">
	<form class="navbar-form" action="/Search" method="post">
	  <div class="input-group">
		<input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" autocomplete="off">
		<span class="input-group-btn">
		<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
		</span> </div>
	</form>
  </div>
  <div class="widget widget_sentence">
	<h3>标签云</h3>
	<div class="widget-sentence-content" id="widget-sentence-content">
		<ul class="plinks ptags">                
			<li><a href="#list/67/" title="移动统计" draggable="false">移动统计 <span class="badge">1</span></a></li>                
			<li><a href="#list/256/" title="404" draggable="false">404 <span class="badge">1</span></a></li>      
			<li><a href="#list/252/" title="VS2010" draggable="false">VS2010 <span class="badge">1</span></a></li>                
			<li><a href="#list/162/" title="杀毒软件" draggable="false">杀毒软件 <span class="badge">1</span></a></li>                
			<li><a href="#list/133/" title="html标签" draggable="false">html标签 <span class="badge">1</span></a></li>                
			<li><a href="#list/49/" title="循环" draggable="false">循环 <span class="badge">2</span></a></li>                
			<li><a href="#list/22/" title="百度统计" draggable="false">百度统计 <span class="badge">2</span></a></li>                
			<li><a href="#list/132/" title="sql" draggable="false">sql <span class="badge">6</span></a></li>                
		</ul>
	</div>
  </div>
</div>
<div class="widget widget_hot">
	  <h3>最新评论文章</h3>
	  <ul id="rightUl">
		
<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
<img class="thumb" data-original="/tongxuelu/static/img/201610181739277776.jpg" src="/tongxuelu/static/img/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
<img class="thumb" data-original="/tongxuelu/static/img/201610181739277776.jpg" src="/tongxuelu/static/img/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
<img class="thumb" data-original="/tongxuelu/static/img/201610181739277776.jpg" src="/tongxuelu/static/img/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
<img class="thumb" data-original="/tongxuelu/static/img/201610181739277776.jpg" src="/tongxuelu/static/img/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
<img class="thumb" data-original="/tongxuelu/static/img/201610181739277776.jpg" src="/tongxuelu/static/img/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
<img class="thumb" data-original="/tongxuelu/static/img/201610181739277776.jpg" src="/tongxuelu/static/img/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
<img class="thumb" data-original="/tongxuelu/static/img/201610181739277776.jpg" src="/tongxuelu/static/img/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>
<li><a title="用DTcms做一个独立博客网站（响应式模板）" href="#" ><span class="thumbnail">
<img class="thumb" data-original="/tongxuelu/static/img/201610181739277776.jpg" src="/tongxuelu/static/img/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: block;">
</span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
2016-11-01
</span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>

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
<p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a> </p>
</div>
<div id="gotop"><a class="gotop"></a></div>
</footer>
<script src="/tongxuelu/static/js/bootstrap.min.js"></script>
<script src="/tongxuelu/static/js/jquery.ias.js"></script>
<script src="/tongxuelu/static/js/scripts.js"></script>
</body>
</html>
