<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的好友</title>
<script src="/tongxuelu/static/img/jquery.js" type="text/javascript"></script>
<script src="/tongxuelu/static/img/v2js.js" type="text/javascript"></script>
<link href="/tongxuelu/static/img/css.css" rel="stylesheet">
<script type="text/javascript" src="/tongxuelu/static/js/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="/tongxuelu/static/js/kkpager.min.js"></script>
<link rel="stylesheet" type="text/css" href="/tongxuelu/static/css/kkpager_orange.css" />
<script type="text/javascript" src="/tongxuelu/static/js/space.js"></script>
</head>
<script>
var totalPage = 0;//总页码
var totalRecords = 0;//总记录数
var pageNo = 1;//开始页码
var pageCount = 8;//每页条数
$(function(){
	showMyFriend();
	$.getJSON("/tongxuelu/friend/selectCount",function(result){//获取条数
		totalRecords = parseInt(result.extend.count);
		getFriend(((pageNo-1)*pageCount),pageCount);//获取第一页信息
	});
	$(".del").live("click",function(){
		var fId = $(this).next().val();
		$.post("/tongxuelu/friend/delete",{"fId":fId},function(data){
			if(data.code=="100"){
				totalRecords = totalRecords-1;
				getFriend(((pageNo-1)*pageCount),pageCount);
			}
		},"json");
	});
	//修改备注事件
	$(".reName").live("click",function(){
		var item = ($(this).parent().parent()).next();//获得父元素的父元素的第二个个元素
		var text = item.text();
		item.html("<input type='text' value='"+text+"' maxlength='10'><input onclick='updateName(this)' type='button' value='提交'>");
	});
});

function showMyFriend(){
	var myFriend=$("#myFriend");
	myFriend.html("");
	var start=0;
	var size=8;
	$.get("/tongxuelu/friend/selectFriendInfo",{"start":start,"end":size},function(data){
		var msg="";
		var list=data.extend.list;
		for(var i=0;i<list.length;i++){
			msg+='<ul class="avatar-list clf">';
			msg+='<li><a href="/tongxuelu/space/homepage/'+list[0].friendId+'" target="_blank"><img src="'+list[i].user.imgurl+'" alt="'+list[i].user.nickname+'">';
			msg+='<div class="a-name">'+list[i].user.nickname+'</div></a></li>';
		}
		myFriend.html(msg);
	})
}

//修改备注
function updateName(i){
	var e = $(i);
	var fId = ((e.parent()).next()).val();
	var text = e.siblings("input").val();
	$.ajax({
		type: "post",
		url: "/tongxuelu/friend/updateName",
		dataType: "json",
		data:{"comment":text,"fId":fId},
		async:true,
		success: function(data){
			if(data.code=="100"){
				getFriend(((pageNo-1)*pageCount),pageCount);
			}
		}
    });
	/*$.post("/tongxuelu/friend/upateName",{"comment":text,"fId":fId},function(data){
		if(data.code=="100"){
			getFriend(((pageNo-1)*pageCount),pageCount);
		}
	},"json");*/
}
function getFriend(start,end){
	if(totalRecords>0){//如果条数大于零
		$.ajax({
			type: "post",
			url: "/tongxuelu/friend/selectFriendInfo?start="+start+"&end="+end,
			dataType: 'json',
			async:false,
			success: function(data) {
				var msg = "";
				$.each(data.extend.list,function(i,item){
					msg += "<div class='c_list clf' >";
					msg += "<div class='c_hpic'><a href='/tongxuelu/space/homepage/"+item.friendId+"'><img src="+item.user.imgurl+" alt='头像' height='20' width='20'></a></div>";
				    msg += "<div class='c_fr'>";
				    msg += "<p class='c_meta'><a href='/tongxuelu/space/homepage/"+item.friendId+"' style='color:blue;'>"+item.user.nickname+"</a>";
				    msg +="<span class='c_time'><a class='del' href='javascript:void(0)'>删除</a><input class='fId' type='hidden' value='"+item.fId+"'>&nbsp;";
				    if(item.comment==null){
				    	 msg +="<a class='reName' href='javascript:void(0)'>添加备注</a></span></p>";
				    	 msg += " <div class='c_nr'></div><input  type='hidden' value='"+item.fId+"'>";
				    }else{
				    	 msg +="<a class='reName' href='javascript:void(0)'>修改备注</a></span></p>";
				    	 msg += " <div class='c_nr'>"+item.comment+"</div><input type='hidden' value='"+item.fId+"'>";
				    }
				    msg += "</div></div>";
				});
				 msg +="<div style='width:1000px;margin:10px auto;'>";
	             msg +="<div id='kkpager'></div></div>";
				 $(".comm_content").html(msg);
				 producePage();//生成分页导航
			}  
		});
	}
	else{
		var msg = "<div class='c_list clf'><font size='3'  color='#4B97D5'>暂时还没有好友,快去添加好友吧！</font></div>"
		$(".comm_content").html(msg);
	}
}
//生成分页导航
function producePage(){
	    totalPage = Math.ceil(totalRecords/pageCount);
		kkpager.generPageHtml({
			pno : pageNo,
			//总页码
			total : totalPage,
			//总数据条数
			totalRecords : totalRecords,
			mode : 'click',//默认值是link，可选link或者click
			click : function(n){
				// do something
				//手动选中按钮
				this.selectPage(n);
				pageNo = n;
				getLeaveWord(((pageNo-1)*pageCount),pageCount);
			}
		});
}
</script>
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
        <c:choose>
	    <c:when test="${sessionScope.existUser.userId != sessionScope.spaceUser.userId}"><!-- 如果加入自己的空间-->
             <div class="actions"><a href="javascript:void(0)" id="concern" class="a-gz" style="background-color:#84E18D;">+加为好友</a> </div>
        </c:when>
	  </c:choose>
      <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp ">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/homepage/${sessionScope.spaceUser.userId}">主页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/bookList/${sessionScope.spaceUser.userId}">全部文章</a></li>
        <li><a href="${pageContext.request.contextPath}/space/leaveWord/${sessionScope.spaceUser.userId}">留言板</a></li>
          <c:choose>
	     <c:when test="${sessionScope.existUser.userId == sessionScope.spaceUser.userId}"><!-- 如果加入自己的空间-->
              <li><a href="${pageContext.request.contextPath}/space/logwrite/${sessionScope.spaceUser.userId}">写文章</a></li>
             <li><a href="${pageContext.request.contextPath}/space/myFriend/${sessionScope.spaceUser.userId}">我的好友</a></li>
            <li><a href="${pageContext.request.contextPath}/space/garbage/${sessionScope.spaceUser.userId}">文章回收站</a></li>
         </c:when>
	    </c:choose>
      </ul>
      <a href="${pageContext.request.contextPath}/space/uploadhead/${sessionScope.spaceUser.userId}"><div class="head-avatar"><img src="${sessionScope.spaceUser.imgurl}" alt=""></div></a>
    </div>
  </div>
  <div class="layout-body">
    <div class="w960  clf">
      <div class="m_left">
        <div class="inner pd1">
           <ul class="stats-list clf">
            <li style="width:130px;"><strong id='friendCount'>16</strong><span>我的好友</span></li>
            <li ><strong id='articleCount' style="margin-left:30px;">174</strong><span style="margin-left:30px;">我的文章</span></li>
          </ul>
        </div>
        <div class="inner mt12 p0">
          <div class="hd">
            <h3>个人信息</h3>
          </div>
          <div class="bd">
            <ul class="detail-list">
              <li><i class="i-nc"></i>昵称：<span>${sessionScope.spaceUser.nickname}</span></li>
              <li><i class="i-dj"></i>职业：<span>${sessionScope.spaceUser.profession}</span></li>
              <li><i class="i-ip"></i>个性签名：<span>${sessionScope.spaceUser.signal}</span></li>
              <li class="born"><a href="/tongxuelu/space/info/${sessionScope.spaceUser.userId}">查看详细资料</a></li>
            </ul>
          </div>
        </div>
        <div class="inner mt12 p0">
          <div class="hd">
            <h3>最近添加好友</h3>
          </div>
          <div class="bd" id="myFriend">
            <ul class="avatar-list clf">
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="m_main">
        <div class="inner">
          <div class="hd" style='background-color:#ccccff'>
            <h3 >我的好友</h3>
          </div>
          <div class="comm_content" ><!-- 留言板 -->
            
          </div>
        </div>
      </div>
    </div>
    <div id="footer">Copyright &#169; 2014 www.5imb.com 版权所有</div>
  </div>
</div>
</body>
</html>