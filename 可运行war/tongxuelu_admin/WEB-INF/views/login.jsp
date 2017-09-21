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
				<a href="${pageContext.request.contextPath}/user/toLogin" class="active">登录</a>
				<a href="${pageContext.request.contextPath}/user/toRegister">注册</a>
				<div class="slide-bar"></div>				
			</div>
		</div>

		<div class="login form">
			<div class="group">
				<div class="group-ipt email">
					<input type="text" name="email" id="email" class="ipt" placeholder="请输入账号" required>
				</div>
				<div class="group-ipt password">
					<input type="password" name="password" id="password" class="ipt" placeholder="输入您的登录密码" required>
				</div>
				<div class="group-ipt verify">
					<input type="text" name="verify" id="verify" class="ipt" placeholder="输入验证码" required>
					<img src="${pageContext.request.contextPath}/codeController/code" class="imgcode" id="code" style="height:46.6px">
				</div>
			</div>
		</div>

		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">登录</button>
		</div>

		<div class="remember clearfix">
			<label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox"  name="remember-me"  id="remember-me" class="remember-mecheck">记住我</label>
			<label class="forgot-password">
				<a href="#">忘记密码？</a>
			</label>
		</div>
	</div>
</div>

<div class="footer">
	<p>晨博 - Thousands Find</p>
	<p>Designed By MYM & <a href="${pageContext.request.contextPath}/index.jsp">晨博Team</a> 2016</p>
</div>

<script src="${pageContext.request.contextPath}/static/js/particles.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/background.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/layer/layer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/index.js" type="text/javascript"></script>
<script>
	$(document).ready(function(){
		$(".zt").hide();			//先让显示选择记住我的蓝色点隐藏，也代表没有勾选记住我
	
		$('.imgcode').hover(function(){
			layer.tips("看不清？点击更换", '.verify', {
	        		time: 6000,
	        		tips: [2, "#3c3c3c"]
	    		})
		},function(){
			layer.closeAll('tips');
		}).click(function(){
			changeCode();
		});
		
			
			
			
			
		$("#remember-me").click(function(){
			var n = document.getElementById("remember-me").checked;
			if(n){
				$(".zt").show();
			}else{
				$(".zt").hide();
			}
		});
		
		
		//===========================提交按钮=====================================
		$("#button").click(function(){
			login();
			
		});
		
	
		
	});



	
	
	
	
	
	function login(){
	
		var verify=$("#verify").val();
		var	userId=$("#email").val();
		var password=$("#password").val();
		var isRemember = "no";				//默认没有选择记住我
		
		if(document.getElementById("remember-me").checked){
			isRemember = "yes";
		}
		
		/*
		 * 1.登陆成功
		 * 2.账号或验证码错误
		 * 3.验证码错误
		 * */
		$.post("${pageContext.request.contextPath}/user/login",{"verify":verify,"userId":userId,"password":password,"isRemember":isRemember},function(data){
			if(data.code==300){
				alert("验证码错误");
				$("#div2").html("验证码错误");			//div1 div2不存在
				$("#div2").css({color:"#ff0011"});
			}else if(data.code==100){
				window.location.href = "${pageContext.request.contextPath}/index.jsp";
			}else if(data.code==200){
				alert("账号或密码错误");
				$("#div1").html("账号或密码错误");
				$("#div1").css({color:"#ff0011"});
			}else if(data.code == 400){
				alert(data.message);
			}
			
			
			changeCode();		//更换验证码
		});
	
	}
	
	
	//================更换验证码======
	function changeCode(){
		$(".imgcode").attr('src','${pageContext.request.contextPath}/codeController/code?date='+new Date().getTime());
	}
</script>
</body>
</html>