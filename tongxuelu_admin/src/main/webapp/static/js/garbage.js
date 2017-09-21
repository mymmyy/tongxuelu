var pn=0;
$(function(){
	var main1=$("#articleMain1");
	main1.html("");
	initArticle();
})
function initArticle(){
	pn=pn+1;
	myArticle(pn);
}

function myArticle(pn){
	var deleteState=1;
	var size=8;
	$.post("/tongxuelu/UserBlogController/getUserBlogEmps",{"pn":pn,"deleteState":deleteState,"size":size},function(data){
		var main1=$("#articleMain1");
		var msg="";
		var pageInfo=data.extend.list;
		for(var i=0;i<pageInfo.length;i++){
			var before=pageInfo[i].blogContent.indexOf("http");
			var end=pageInfo[i].blogContent.indexOf("style")-2;
			msg+="<div class='inner'><a class='ckxx' href='/tongxuelu/UserBlogController/restoreArticle?blogId="+pageInfo[i].blogId+" target='_blank'>还原文章</a>";
			msg+="<div class='hd'>";
			msg+="<h3><a href='#' target='_blank'>"+pageInfo[i].blogTitle+"</a></h3></div>"
			msg+="<div class='i_info'>类型:<a href='#' class='lm' target='_blank'>"+pageInfo[i].blogCategory.categoryName
			+"</a><em></em>时间:"+pageInfo[i].releaseTime+"<em></em>浏览:675</div>";
			msg+="<div class='i_xx clf'> <a href='#' target='_blank'><img src='"+pageInfo[i].blogContent.substring(before,end)+"' class='litpic' alt='"+pageInfo[i].blogTitle+"'></a>"+
			pageInfo[i].blogContent.replace(/<.*?>/ig,'').substring(0,120)+"</div></div>";
			
		}
		main1.append(msg)
	})
}