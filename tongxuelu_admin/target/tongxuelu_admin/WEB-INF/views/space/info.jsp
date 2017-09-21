<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人空间信息页</title>
<script src="/tongxuelu/static/img/jquery.js" type="text/javascript"></script>
<script src="/tongxuelu/static/img/v2js.js" type="text/javascript"></script>
<link href="/tongxuelu/static/img/css.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/tongxuelu/static/css/ui2.css?2013032917">
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
         <li><a href="${pageContext.request.contextPath}/space/homepage/${sessionScope.spaceUser.userId}">主页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/bookList/${sessionScope.spaceUser.userId}">我的文章</a></li>
        <li><a href="${pageContext.request.contextPath}/space/leaveWord/${sessionScope.spaceUser.userId}">留言板</a></li>
        <li><a href="${pageContext.request.contextPath}/space/logwrite/${sessionScope.spaceUser.userId}">写文章</a></li>
         <li><a href="${pageContext.request.contextPath}/space/myFriend/${sessionScope.spaceUser.userId}">我的好友</a></li>
      </ul>
      <div class="head-avatar"><img src="/tongxuelu/static/img/head_snew.jpg" alt=""></div>
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
              <li class="born"><a href="/tongxuelu/space/info/${sessionScope.existUser.userId}">查看详细资料</a></li>
            </ul>
          </div>
        </div>
        <div class="inner mt12 p0">
          <div class="hd">
            <h3>最近访客</h3>
          </div>
          <div class="bd">
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
          <div class="hd">
            <h3>基本资料
			<a style="float:right;text-align:center;width:100px;height:40px;background-color:#C1C1C1;" role="button" data-category="UserAccount" data-action="login" data-toggle="modal" href="#login-modal">完善资料</a></h3>
			
          </div>
          <div class="infos">
		    <ul>
			  <li>昵称:${sessionScope.spaceUser.nickname}</li>
              <li>性别:${sessionScope.spaceUser.gender}</li>
			  <li>出生日期:${sessionScope.spaceUser.birth}</li>
			  <li>邮件地址:${sessionScope.spaceUser.email}</li>
			  <li>居住地址:${sessionScope.spaceUser.address}</li>
			  <li>毕业院系:${sessionScope.spaceUser.school}</li>
			  <li>目前职业:${sessionScope.spaceUser.profession}</li>
			  <li>个性签名:${sessionScope.spaceUser.signal}</li>
			</ul>
          </div>
        </div>
        <div class="inner">
          <div class="hd">
            <h3>联系方式</h3>
          </div>
          <div class="infos"> 主人已经设置为保密所有联系信息! </div>
        </div>
      </div>
    </div>
    <div id="footer">Copyright &#169; 2014 www.5imb.com 版权所有</div>
  </div>
</div>
<a style="opacity: 0;" id="topcontrol" href="javascript:;" title="返回顶部"></a>
 <div class="modal in" id="login-modal"> <a class="close" data-dismiss="modal">×</a>
        <h1>完善信息</h1>
        <font style="width:300px;height:25px;margin-top:-20px;float:left;" size="4" color="red" id="errorMsg"></font>
        <form style="margin-top:55px;" class="login-form clearfix" method="post" action="#" onSubmit="return checkSubmit()">
		  <input name="nickname" class="nickname" value="${sessionScope.spaceUser.nickname}" type="text" maxlength="22" placeholder="昵称">
          <input name="gender" class="gender" value="${sessionScope.spaceUser.gender}" type="text" placeholder="性别">
		  <input name="birth" class="birth" value="${sessionScope.spaceUser.birth}" type="text" placeholder="出生日期(yyyy-mm-dd)">
		  <input name="email" class="email" value="${sessionScope.spaceUser.email}" type="text" placeholder="邮箱">
		  <input name="address" class="address" value="${sessionScope.spaceUser.address}" type="text" placeholder="目前职业">
		  <input name="school" class="school" value="${sessionScope.spaceUser.school}" type="text" placeholder="居住地址">
		   <input name="profession" class="profession" value="${sessionScope.spaceUser.profession}" type="text" placeholder="毕业院校">
		  <input name="signal" class="signal" value="${sessionScope.spaceUser.signal}" type="text" placeholder="个性签名">
		
          <input style="margin-top:-12px;height:40px;" id="submit" type="submit" name="type" class="button-blue login" value="提&nbsp;交">
        </form>
</div>
</body>
<script src="/tongxuelu/static/js/landing-min.js?2013032917"></script>
<script>
 function checkSubmit(){
	 var flag = false;
	 if($(".nickname").val()==""){
		 $("#errorMsg").text("提交失败!昵称不能为空");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false; 
	 }
	 if($(".nickname").val().length>20){
		 $("#errorMsg").text("提交失败!昵称过长");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false;
	 }
	 /*if($(".gender").val()==""){
		 $("#errorMsg").text("提交失败!性别不能为空");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false; 
	 }*/
	 var sex = $(".gender").val();
	 if(!(sex=="男"||sex=="女")){
		 $("#errorMsg").text("提交失败!性别只能为男或女");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false; 
	 }
	 if(!(/\d{4}-\d{2}-\d{2}/.test($(".birth").val()))){
		 //alert($(".birth").val());
		 $("#errorMsg").text("提交失败!生日格式不正确");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false;
	 }
	 if(!/^([a-z0-9_.-]+)@([\da-z.-]+).([a-z.]{2,6})$/.test($(".email").val())){
		 $("#errorMsg").text("提交失败!邮箱格式不正确");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false;
	 }
	 if($(".address").val().length>20){
		 $("#errorMsg").text("提交失败!地址过长");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false;
	 }
	 if($(".school").val().length>20){
		 $("#errorMsg").text("提交失败!学校名称过长");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false;
	 }
	 if($(".profession").val().length>20){
		 $("#errorMsg").text("提交失败!职位名称过长");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false;
	 }
	 if($(".signal").val().length>20){
		 $("#errorMsg").text("提交失败!个性签名名称过长");
		 setTimeout("$('#errorMsg').text('')","2000");
		 return false;
	 }
	 return true;
 }
</script>
</html>