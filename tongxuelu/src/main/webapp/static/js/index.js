var pn=0;
$(function(){
	var article1=$("#article1");
	article1.html("");
	initLeft();
	initRightArticle();
	initArticleCount();
	initUserCount();
	
})

function initLeft(){
	pn=pn+1;
	initLeftArticle(pn);
}
function initLeftArticle(pn){
	var article1=$("#article1");
	var msg="";
	$.post("/tongxuelu/UserBlogController/getAllUserBlog",{"pn":pn},function(data){
		var pageInfo=data.extend.list;
		var minicIndex=$("#minicIndex");
		minicIndex.html("");
		var thory="";
		thory+='<h2><span class="red">【推荐】</span><a target="_blank" href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+pageInfo[0].blogId+'" title="'+pageInfo[0].blogTitle+'" >'+pageInfo[0].blogTitle+'</a></h2>';
		thory+='<p class="note">'+pageInfo[0].blogContent.replace(/<.*?>/ig,'').substring(0,120)+'</p>';
		minicIndex.html(thory);
		for(var i=0;i<pageInfo.length;i++){
			var before=pageInfo[i].blogContent.indexOf("http");
			var end=pageInfo[i].blogContent.indexOf("style")-2;
			msg+='<article class="excerpt excerpt-2" style=""><a class="focus" href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+pageInfo[i].blogId+'" title='+pageInfo[i].blogTitle+' target="_blank" ><img class="thumb" data-original="'+pageInfo[i].blogContent.substring(before,end)+'" src="'+pageInfo[i].blogContent.substring(before,end)+'" alt='+pageInfo[i].blogTitle+'  style="display: inline;"></a>';
			msg+='<header><a class="cat" href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+pageInfo[i].blogId+'" title='+pageInfo[i].blogCategory.categoryName+' >'+pageInfo[i].blogCategory.categoryName+'<i></i></a><h2><a href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+pageInfo[i].blogId+'" title='+pageInfo[i].blogTitle+' target="_blank" >'+pageInfo[i].blogTitle+'</a></h2>';
			msg+='</header><p class="meta"><time class="time"><i class="glyphicon glyphicon-time"></i> '+pageInfo[i].releaseTime+'</time>';
			msg+='<span class="views"><i class="glyphicon glyphicon-eye-open"></i>216</span> <a class="comment" href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+pageInfo[i].blogId+'" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i>4</a></p>';
			msg+='<p class="note">'+pageInfo[i].blogContent.replace(/<.*?>/ig,'').substring(0,120)+'</p></article>';
		}
		article1.append(msg);
	})
}
function initRightArticle(){
	var ul1=$("#ul1");
	ul1.html("");
	var msg="";
	$.post("/tongxuelu/UserBlogController/getAllUserBlog",{"pn":pn},function(data){
		var pageInfo=data.extend.list;
		for(var i=0;i<pageInfo.length;i++){
			var before=pageInfo[i].blogContent.indexOf("http");
			var end=pageInfo[i].blogContent.indexOf("style")-2;
			msg+="<li><a title="+pageInfo[i].blogTitle+" href='/tongxuelu/UserBlogController/getBlogByBlogId?blogId="+pageInfo[i].blogId+"' ><span class='thumbnail'>";
			msg+="<img class='thumb' data-original='"+pageInfo[i].blogContent.substring(before,end)+"' src='"+pageInfo[i].blogContent.substring(before,end)+"' alt="+pageInfo[i].blogTitle+"  style='display: block;'>";
			msg+="</span><span class='text'>"+pageInfo[i].blogContent.replace(/<.*?>/ig,'').substring(0,50)+"</span><span class='muted'><i class='glyphicon glyphicon-time'></i>";
			msg+=pageInfo[i].releaseTime+"</span><span class='muted'><i class='glyphicon glyphicon-eye-open'></i>88</span></a></li>";
		}
		ul1.html(msg);
	})
}

function initArticleCount(){
	var articleH2=$("#articleH2");
	$.get("/tongxuelu/UserBlogController/getAllCount",{},function(data){
		articleH2.html("文章总数："+data);
	})
}

function initUserCount(){
	var sitetime=$("#sitetime");
	$.get("/tongxuelu/user/getAllUserCount",{},function(data){
		sitetime.html(data);
	})
}
function getBlogWithLike(){
	alert("a")
	var article1=$("#article1");
	article1.html("")
	var fn=0;
	var msg=$("#form-control").val();
	getMoreBlogWithLike(msg,fn);
	
}
function getMoreBlogWithLike(msg,fn){
	var content3=$("#content3");
	content3.html("");
	var mfg="";
	fn=fn+1;
	getAllBlogLike(msg,fn);
	mfg+='<div id="content3" style="cursor:pointer;width:820px;font-size:16px;margin-top:2px;padding-top:6px;height:40px;text-align:center;background-color:#ccccff;" onclick="getMoreBlogWithLike(&quot;'+msg+'&quot;)">加载更多</div>';
	content3.html(mfg);
}
function getAllBlogLike(msg,fn){
	var article1=$("#article1");
	var msg="";
	var size=10;
	$.post("/tongxuelu/UserBlogController/getAllUserBlogWithLike",{"msg":msg,"pn":fn,"size":size},function(data){
		var minicIndex=$("#minicIndex");
		minicIndex.html("");
		var thory="";
		thory+='<h2><span class="red">【推荐】</span><a target="_blank" href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+data[0].blogId+'" title="'+data[0].blogTitle+'" >'+data[0].blogTitle+'</a></h2>';
		thory+='<p class="note">'+data[0].blogContent.replace(/<.*?>/ig,'').substring(0,120)+'</p>';
		minicIndex.html(thory);
		for(var i=0;i<data.length;i++){
			var before=data[i].blogContent.indexOf("http");
			var end=data[i].blogContent.indexOf("style")-2;
			msg+='<article class="excerpt excerpt-2" style=""><a class="focus" href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+data[i].blogId+'" title='+data[i].blogTitle+' target="_blank" ><img class="thumb" data-original="'+data[i].blogContent.substring(before,end)+'" src="'+pageInfo[i].blogContent.substring(before,end)+'" alt='+data[i].blogTitle+'  style="display: inline;"></a>';
			msg+='<header><a class="cat" href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+data[i].blogId+'" title='+data[i].blogCategory.categoryName+' >'+data[i].blogCategory.categoryName+'<i></i></a><h2><a href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+data[i].blogId+'" title='+data[i].blogTitle+' target="_blank" >'+data[i].blogTitle+'</a></h2>';
			msg+='</header><p class="meta"><time class="time"><i class="glyphicon glyphicon-time"></i> '+data[i].releaseTime+'</time>';
			msg+='<span class="views"><i class="glyphicon glyphicon-eye-open"></i>216</span> <a class="comment" href="/tongxuelu/UserBlogController/getBlogByBlogId?blogId='+data[i].blogId+'" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i>4</a></p>';
			msg+='<p class="note">'+data[i].blogContent.replace(/<.*?>/ig,'').substring(0,120)+'</p></article>';
		}
		article1.append(msg);
	})
}