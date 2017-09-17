<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<meta charset="utf-8">
	<title>注册 - 同学录 - Thousands Find</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/register-login.css">
</head>
<body>
<div id="box"></div>
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">晨博</h1>
		<h2 class="sub-title">晨博-同学录</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="${pageContext.request.contextPath}/user/toLogin">登录</a>
				<a href="${pageContext.request.contextPath}/user/toRegister" class="active">注册</a>
				<div class="slide-bar slide-bar1"></div>				
			</div>
		</div>

		<div class="login form">
			<div class="group">
				<div class="group-ipt email">
					<input type="email" name="email" id="email" class="ipt" placeholder="邮箱地址，尽量使用qq邮箱" required><span  id="emailMsg"><span>
				</div>
				<div class="group-ipt user">
					<input type="text" name="user" id="user" class="ipt" placeholder="用户账号" required><span  id="userMsg"><span>
				</div>
				<div class="group-ipt nickName">
					<input type="text" name="nickname" id="nickname" class="ipt" placeholder="用户昵称" required><span  id="nameMsg"><span>
				</div>
				<div class="group-ipt password">
					<input type="password" name="password" id="password" class="ipt" placeholder="登录密码" required><span id="pwdMsg"><span>
				</div>
				<div class="group-ipt password1">
					<input type="password" name="password1" id="password1" class="ipt" placeholder="重复密码" required><span id="twoPwdMsg"><span>
				</div>
				<div class="group-ipt verify">
					<input type="text" name="verify" id="verify" class="ipt" placeholder="输入验证码" required><span color="red"><span>
					<img src="${pageContext.request.contextPath}/codeController/code" class="imgcode" style="height:46.6px">
				</div>
			</div>
		</div>

		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">注册</button>
		</div>
	</div>
</div>



<script src="${pageContext.request.contextPath}/static/js/particles.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/background.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/layer/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/index.js" type="text/javascript"></script>
<script>
var userIdCheck = /^[A-Za-z0-9_-]{6,16}$/;//6至16位
var passwordCheck = /^[A-Za-z0-9_-]{6,18}$/;//区分大小写、数字、下划线，^表示以[]中的开始，6至18位
var emailCheck = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
//邮箱验证：以小写字母，数字，下划线，点，中杠，不限字符数 +@+ 点 + 2至6位小写字母组成
$(document).ready(function(){
	$('.imgcode').hover(function(){
		layer.tips("看不清？点击更换", '.verify', {
        		time: 6000,
        		tips: [2, "#3c3c3c"]
    		})
	},function(){
		layer.closeAll('tips');
	}).click(function(){
		//$(this).attr('src','${pageContext.request.contextPath}/codeController/code?date='+new Date().getTime());
		changeCode();
	});
		//===========================提交按钮=====================================
	$(".login-btn").click(function(){
			var email = $("#email").val();
			var userId = $("#user").val();
			var password = $("#password").val();
			var nickname = $("#nickname").val();
			var verify = $("#verify").val();
			if(checkInput()){
				$.ajax({
					url:"${pageContext.request.contextPath}/user/userRegister",
					type:"post",
					data:{"email":email,"userId":userId,"nickname":nickname,"password":password,"verify":verify},
					success:function(data){
						if(data.code == 100){
							alert("注册成功,请前往 注册邮箱 进行 激活 后进行登陆！");
							window.location.href = "${pageContext.request.contextPath}/user/toLogin";
						}else if(data.code == 200){
							alert("注册失败");
						}
						//一但提交就需要重新请求二维码
						changeCode();
					}
		        });
			}
	});
    
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	});
});

//================更换验证码======
function changeCode(){
	$(".imgcode").attr('src','${pageContext.request.contextPath}/codeController/code?date='+new Date().getTime());
}

function checkInput(){
	//===================================input值校验===================================
	var email = $("#email").val();
	var userId = $("#user").val();
	var nickname = $("#nickname").val();
	var password = $("#password").val();
	var password1 = $("#password1").val();
	var verify = $("#verify").val();
	if(!email.match(emailCheck)){
		$("#emailMsg").html("<font color='red'>邮箱格式不正确</font>");
		return false;
	}else{
		$("#emailMsg").html("");
	}
	if(!userId.match(userIdCheck)){
		$("#userMsg").html("<font color='red'>账号请输入6~16位</font>");
		return false;
	}else{
		$("#userMsg").html("");
	}
	//Id重复验证
	var f = false;
	$.ajax({
		type:"get",
		url:"/tongxuelu/user/checkUserId",
		data:{"userId":userId,"date":new Date().getTime()},
		async:false,
		dataType:"json",
		success:function(data){
			if(data.code == "100"){
				$("#userMsg").html("<font color='red'>账号已存在</font>");	
				f = true;
			}else{
				$("#userMsg").html("");	
			}
		}
	});
	if(f){
		return false;
	}
	if(!(nickname.length<10 && nickname.length>2)){
		$("#nameMsg").html("<font color='red'>昵称请输入2~10位！</font>");
		return false;
	}else{
		$("#nameMsg").html("");
	}
	if(!password.match(passwordCheck)){
		$("#pwdMsg").html("<font color='red'>密码请输入6~18位！</font>");
		return false;
	}else{
		$("#pwdMsg").html("");
	}
	if(password1 != password){
		$("#twoPwdMsg").html("<font color='red'>密码不一致</font>");
		return false;
	}else{
		$("#twoPwdMsg").html("");
	}
	return true;
	
}
</script>
</html>