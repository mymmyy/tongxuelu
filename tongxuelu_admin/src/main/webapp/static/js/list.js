var pn=0;
$(function(){
	initLeft();
	initSentence();
	initRight();
	
})
function initLeft(){
	pn=pn+1;
	initLeftBlog(pn);
}
function initLeftBlog(pn){
	var content2=$("#content2");
	$.post("/tongxuelu/UserBlogController/getAllUserBlog",{"pn":pn},function(data){
		var pageInfo=data.extend.list;
		var msg="";
		for(var i=0;i<pageInfo.length;i++){
			var before=pageInfo[i].blogContent.indexOf("http");
			var end=pageInfo[i].blogContent.indexOf("style")-2;
			msg+="<article class='excerpt excerpt-1'><a class='focus' href='#' title="+pageInfo[i].blogTitle+" target='_blank' ><img class='thumb' data-original='"+pageInfo[i].blogContent.substring(before,end)+"' src='"+pageInfo[i].blogContent.substring(before,end)+"' alt="+pageInfo[i].blogTitle+"  style='display: inline;'></a>";
			msg+="<header><a class='cat' href='/tongxuelu/UserBlogController/getBlogByBlogId?blogId="+pageInfo[i].blogId+"' title="+pageInfo[i].blogCategory.categoryName+" >"+pageInfo[i].blogCategory.categoryName+"<i></i></a>";
			msg+="<h2><a href='/tongxuelu/UserBlogController/getBlogByBlogId?blogId="+pageInfo[i].blogId+"' title="+pageInfo[i].blogTitle+" target='_blank' >"+pageInfo[i].blogTitle+"</a></h2></header>";
			msg+="<p class='meta'><time class='time'><i class='glyphicon glyphicon-time'></i> "+pageInfo[i].releaseTime+"</time>";
			msg+="<span class='views'><i class='glyphicon glyphicon-eye-open'></i> 217</span> <a class='comment' href='##comment' title='评论' target='blank' ><i class='glyphicon glyphicon-comment'></i> 4</a></p>";
			msg+="<p class='note'>"+pageInfo[i].blogContent.replace(/<.*?>/ig,'').substring(0,120)+"</p></article>"
		}
		content2.append(msg);
	})
}
function initSentence(){
	var fn=0;
	var sentence=$("#widget-sentence-content");
	sentence.html("");
	var msg="";
	$.get("/tongxuelu/BlogCategoryController/getAllBlogCategory",{},function(data){
		msg+="<ul class='plinks ptags'> ";
		var list=data.extend.list;
		for(var i=0;i<list.length;i++){
			msg+="<li><a href='javascript:sentence("+list[i].categoryId+",&quot;"+list[i].categoryName+"&quot;,"+fn+")' title="+list[i].categoryName+" draggable='false'>"+list[i].categoryName+" </a></li>"
		}
		msg+="</ul>";
		sentence.html(msg);
	})
}

function initRight(){
	var rightUl=$("#rightUl");
	rightUl.html("");
	var msg="";
	$.post("/tongxuelu/UserBlogController/getAllUserBlog",{},function(data){
		var pageInfo=data.extend.list;
		for(var i=0;i<pageInfo.length;i++){
			var before=pageInfo[i].blogContent.indexOf("http");
			var end=pageInfo[i].blogContent.indexOf("style")-2;
			msg+="<li><a title="+pageInfo[i].blogTitle+" href='/tongxuelu/UserBlogController/getBlogByBlogId?blogId="+pageInfo[i].blogId+"' ><span class='thumbnail'>";
			msg+="<img class='thumb' data-original='"+pageInfo[i].blogContent.substring(before,end)+"' src='"+pageInfo[i].blogContent.substring(before,end)+"' alt="+pageInfo[i].blogTitle+"  style='display: block;'>";
			msg+="</span><span class='text'>"+pageInfo[i].blogContent.replace(/<.*?>/ig,'').substring(0,30)+"</span><span class='muted'><i class='glyphicon glyphicon-time'></i>";
			msg+=pageInfo[i].releaseTime+"</span><span class='muted'><i class='glyphicon glyphicon-eye-open'></i>88</span></a></li>";
		}
		rightUl.html(msg);
	})
}
function sentence(categoryId,categoryName,fn){
	var content2=$("#content2");
	content2.html("");
	var titleH3=$("#titleH3");
	titleH3.html(categoryName);
	initLeftBySentence(categoryId,fn);
}
function initLeftBySentence(categoryId,fn){
	var content3=$("#content3");
	content3.html("");
	var msg="";
	fn=fn+1;
	initLeftBlogBySentence(categoryId,fn);
	msg+='<div id="content3" style="cursor:pointer;width:820px;font-size:16px;margin-top:2px;padding-top:6px;height:40px;text-align:center;background-color:#ccccff;" onclick="initLeftBySentence('+categoryId+')">加载更多</div>';
	content3.html(msg);
}

function initLeftBlogBySentence(categoryId,fn){
	var content2=$("#content2");
	var msg="";
	$.post("/tongxuelu/UserBlogController/getAllUserBlogByCategoryId",{"pn":fn,"categoryId":categoryId},function(data){
		var pageInfo=data.extend.list;
		for(var i=0;i<pageInfo.length;i++){
			var before=pageInfo[i].blogContent.indexOf("http");
			var end=pageInfo[i].blogContent.indexOf("style")-2;
			msg+="<article class='excerpt excerpt-1'><a class='focus' href='#' title="+pageInfo[i].blogTitle+" target='_blank' ><img class='thumb' data-original='"+pageInfo[i].blogContent.substring(before,end)+"' src='"+pageInfo[i].blogContent.substring(before,end)+"' alt="+pageInfo[i].blogTitle+"  style='display: inline;'></a>";
			msg+="<header><a class='cat' href='/tongxuelu/UserBlogController/getBlogByBlogId?blogId="+pageInfo[i].blogId+"' title="+pageInfo[i].blogCategory.categoryName+" >"+pageInfo[i].blogCategory.categoryName+"<i></i></a>";
			msg+="<h2><a href='/tongxuelu/UserBlogController/getBlogByBlogId?blogId="+pageInfo[i].blogId+"' title="+pageInfo[i].blogTitle+" target='_blank' >"+pageInfo[i].blogTitle+"</a></h2></header>";
			msg+="<p class='meta'><time class='time'><i class='glyphicon glyphicon-time'></i> "+pageInfo[i].releaseTime+"</time>";
			msg+="<span class='views'><i class='glyphicon glyphicon-eye-open'></i> 217</span> <a class='comment' href='##comment' title='评论' target='blank' ><i class='glyphicon glyphicon-comment'></i> 4</a></p>";
			msg+="<p class='note'>"+pageInfo[i].blogContent.replace(/<.*?>/ig,'').substring(0,120)+"</p></article>"
		}
		content2.append(msg);
	})
}