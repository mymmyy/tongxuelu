$(function(){
	getOtherBlog();
	getAllComment();//查询所有评论
	//评论提交事件
	$("#comment-submit").click(function(){
		var content = $("#comment-textarea").val().trim();
		if(content == ""){
			alert("评论为空!");
		}
		else if(content.length>100){
			alert("评论过长!");
		}else{
			$(".comment-prompt").css("display","block");
			setTimeout("addComment()",1000);
		}
	});
	/*//加载回复按钮事件
	$(".reply").on("click",function(){
		if($(this).next().val()=='0'){//使用隐藏表单来判断是否重复按回复按钮
			reply($(this));
		}
	});*/
	Replyclick();//给回复链接绑定一个点击事件
	initArticleCount();
	initUserCount();
});
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
function getOtherBlog(){
	var ul1=$("#ul1");
	var msg="";
	$.post("/tongxuelu/UserBlogController/getUserBlog",{},function(data){
		var pageInfo=data.extend.list;
		for(var i=0;i<pageInfo.length;i++){
			var before=pageInfo[i].blogContent.indexOf("http");
			var end=pageInfo[i].blogContent.indexOf("style")-2;
			msg+="<li><a title="+pageInfo[i].blogTitle+" href='/tongxuelu/UserBlogController/getBlogByBlogId?blogId="+pageInfo[i].blogId+"' ><span class='thumbnail'>";
			msg+="<img class='thumb' data-original='/tongxuelu/static/img/201610181739277776.jpg' src='"+pageInfo[i].blogContent.substring(before,end)+"' alt="+pageInfo[i].blogTitle+"  style='display: block;'>";
			msg+="</span><span class='text'>"+pageInfo[i].blogContent.replace(/<.*?>/ig,'').substring(0,40)+"</span><span class='muted'><i class='glyphicon glyphicon-time'></i>";
			msg+=pageInfo[i].releaseTime+"</span><span class='muted'><i class='glyphicon glyphicon-eye-open'></i>88</span></a></li>";
		}
		ul1.html(msg);
	});
}
//发表评论
function addComment(){
	var content = $("#comment-textarea").val().trim();
	var blogId = $("#blogId").val();
	var userId = $("#userId").val();
	$.ajax({
		type:"post",
	    url:"/tongxuelu/addComment",
	    dataType:"json",
	    async:true,
	    data:{"commentContent":content,"blogId":blogId,"userId":userId},
	    success:function(data,status){
	    	$(".comment-prompt").css("display","none");
	    	if(data.code==100){//成功
	    		if(data.extend.isLogin=="1"){
	    			$(".comment-success").css("display","block");
		    		setTimeout("$('.comment-success').css('display','none');$('#comment-textarea').val('');getAllComment();Replyclick();",1000);	
	    		}else{
	    			window.location.href='/tongxuelu/user/toLogin';
	    		}
	    	}else{//失败
	    		$(".comment-fail").css("display","block");
	    		setTimeout("$('.comment-fail').css('display','none');",1000);	
	    	}
	    }
	});
	
}

function getAllComment(){
	var blogId = $("#blogId").val();
	var msg = "";
	$.ajax({
		type:"get",
	    url:"/tongxuelu/selectAllComment",
	    dataType:"json",
	    async:false,//设置为同步，才能使得回复链接事件生效
	    data:{"blogId":blogId},
	    success:function(data){
	        $.each(data.extend.list,function(i,item){
	        	//alert(item.commentContent);
	        	msg += "<li class='comment-content'><input type='hidden' class='commentId' value='"+item.id+"'><span class='comment-f'>#"+(parseInt(i)+1)+"</span>";
	        	msg += "<div class='comment-main'><p><a class='replyUser' href='#' rel='nofollow'>"+item.commentUserId+"</a>";
	        	msg += "<span class='time'>("+item.commentTime+")</span>"
	        	msg +="<a class='reply' href='javascript:void(0)'><img  src='/tongxuelu/static/img/reply.jpg'></a><input type='hidden' class='hidden' value='0'><br>"+item.commentContent+"</p></div>";
	        	if(item.replyList.length>0){
	        		$.each(item.replyList,function(i,item){
	        			msg += "<div class='comment-main'><p><a class='replyUser' href='#' rel='nofollow'>"+item.replyUserId+"</a>";
		        		msg += "<font color='black'> 回复  </font>"
		        	    msg += "<a class='commentUser' href='#' rel='nofollow'>"+item.commentUserId+"</a>";
			        	msg += "<span class='time'>("+item.replyTime+")</span>"
			        	msg +="<a class='reply' href='javascript:void(0)'><img  src='/tongxuelu/static/img/reply.jpg'></a><input class='hidden' type='hidden' value='0'><br>"+item.replyContent+"</p></div>";
	        		});
	        	}
	        	msg +="</li>";
	        });
	        $("#comment_list").html(msg);
	    	/*<li class="comment-content"><span class="comment-f">#1</span>
	    	<div class="comment-main"><p><a class="address" href="#" rel="nofollow" target="_blank">木庄网络博客</a><span class="time">(2016/10/28 11:41:03)</span><a href="javascript:void(0)"><img src="/tongxuelu/static/img/reply.jpg"></a><br>不错的网站主题，看着相当舒服</p></div>
	    	<div class="comment-main"><p><a class="address" href="#" rel="nofollow" target="_blank">无敌<font color="black"> 回复  </font>20170904</a><span class="time">(2016/10/28 11:41:03)</span><a href="javascript:void(0)"><img src="/tongxuelu/static/img/reply.jpg"></a><br>不错的网站主题，看着相当舒服</p> </div>
	    	</li>*/
	    }
	});
}
function reply(item){
	var parentItem =item.parent().parent();
	parentItem.append("<input class='message' size='40' type='text' ><input type='button' onclick='send(this)' value='发送'>");//this代表当前对象
	item.next().val("1");
}
function send(v){
	//$(v)表示将普通的DOM对象转换成jquery对象
	var replyContent = $(v).siblings(".message").val();
	if(replyContent==""){
		return false;
	}
	var commentUserId = ($(v).siblings('p')).children('.replyUser').text();
	var commentId = ($(v).parent()).siblings('.commentId').val();
	$.ajax({
		type:"post",
		url:"/tongxuelu/addReply",
		data:{'replyContent':replyContent,'commentId':commentId,'commentUserId':commentUserId},
		dataType:"json",
		success:function(data){
			if(data.code==100){
				if(data.extend.isLogin=='1'){
					($(v).siblings('.message')).remove();//移除文本框
					(($(v).siblings('p')).children('.hidden')).val('0');//让回复事件生效
					$(v).remove();//移除按钮
					getAllComment();//重新加载评论
					Replyclick();
				}else{
					window.location.href='/tongxuelu/user/toLogin';
				}
				
			}
		}
	});
	
	
	
}
function Replyclick(){//绑定回复事件函数(用于再次评论刷新之后再次绑定事件)
	//加载回复按钮事件
	$(".reply").on("click",function(){
		if($(this).next().val()=='0'){//使用隐藏表单来判断是否重复按回复按钮
			reply($(this));
		}
	});
}






