/**
 * space空间共有的js
 */
$(function(){
	//获取你的好友数量
   $.getJSON("/tongxuelu/friend/selectCount",function(data){
	   $('#friendCount').text(data.extend.count);
   });
   //获取你的文章条数
   $.getJSON("/tongxuelu/UserBlogController/getCountByUserId",function(data){
	   $('#articleCount').text(data);
   });
   //判断是否为你的好友
   $.getJSON("/tongxuelu/friend/selctIsFriend",function(data){
	   if(data.code=="100"){
		  $("#concern").text("已是好友") ;
	   }else{
		   $("#concern").text("+加为好友") ;
	   }
   });
   $(".head-description").mouseover(function(){
	   $(this).css("color","#F2D120");
   });
   $(".head-description").mouseout(function(){
	   $(this).css("color","white");
   });
   //加好友
   $("#concern").click(function(){
	    if($(this).text()=="+加为好友"){
	    	$.ajax({
	    		type:"post",
	    		url:"/tongxuelu/friend/add",
	    		dataType:"json",
	    		async:true,
	    		success:function(data){
	    			if(data.code=="100"){
	    				$("#concern").text("已是好友");
	    				$("#concern").css("background-color","#EBBBEA");
	    			}
	    		}
	    	});	    	
	    }
   });
   
});