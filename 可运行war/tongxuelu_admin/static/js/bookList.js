$(function(){
	initMyBlog(1)
	$.get("/tongxuelu/UserBlogController/getCountByUserId",{},function(data){
		var page=Math.ceil(data/6);
		$('.M-box3').pagination({
		    pageCount:page,
		    jump:true,
		    coping:true,
		    homePage:'首页',
		    endPage:'末页',
		    prevContent:'上页',
		    nextContent:'下页',
		    callback:function(api){
	    		 var pn=api.getCurrent();
	    		 initMyBlog(pn);
		    }
		});
	});
	
})
function initMyBlog(pn){
	var mb_list=$("#mb_list");
	mb_list.html("");
	var msg="";
	var size=6;
	$.post("/tongxuelu/UserBlogController/getUserBlogEmps",{"pn":pn,"size":size},function(data){
		var pageInfo=data.extend.list;
		msg+="<ul>";
		for(var i=0;i<pageInfo.length;i++){
			var before=pageInfo[i].blogContent.indexOf("http");
			var end=pageInfo[i].blogContent.indexOf("style")-2;
			msg+='<li><a class="ih3" href="#" target="_blank">'+pageInfo[i].blogTitle+'</a> <a href="/tongxuelu/UserBlogController/setUserBlog?blogId='+pageInfo[i].blogId+'" target="_blank" class="mba"><img src="'+pageInfo[i].blogContent.substring(before,end)+'" alt='+pageInfo[i].blogTitle+'><span></span></a>';
			msg+='<div style="display: none;" class="cover">';
			msg+='<div class="cov_pbg"></div>';
			msg+='<div class="cov_tbg"></div>';
			msg+='<div class="cov_p">模板简介:<br>';
			msg+=pageInfo[i].blogContent.replace(/<.*?>/ig,'').substring(0,60)+'</div>';
			msg+='<div class="cov_t">时间:2014-04-11&nbsp;&nbsp;点击:675<a href="#" target="_blank" class="fr">查看详细&gt;&gt;</a></div>';
			msg+='</div></li>';
		}
		msg+="</ul>";
		mb_list.html(msg);
	})
}

