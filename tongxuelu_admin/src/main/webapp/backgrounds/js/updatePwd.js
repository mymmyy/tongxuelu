$(function(){
	$("#oldPwd").blur(function(){
		var oldPwd=$("#oldPwd").val();
		$.post("administrator/compareoldPwd",{"oldPwd":oldPwd},function(data){
			if(data==1){
				$("#span1").html("密码正确");
				$("#span1").css({color:"#ff0011"});
			}else{
				$("#span1").html("密码错误,请重新输入");
				$("#span1").css({color:"#ff0011"});
			}
		})
	})
	
	$("#newPwdConfirm").blur(function(){
		var newPwd=$("#newPwd").val();
		var newPwdConfirm=$("#newPwdConfirm").val();
		if(newPwd!=newPwdConfirm)
			$("#span2").html("两次输入的密码不一致");
			$("#span2").css({color:"#ff0011"});
	})

})

function updatePwd(){
	var newPwd=$("#newPwd").val();
	$.post("administrator/updatePwd",{"newPwd":newPwd},function(data){
		if(data==1){
			alert("修改成功!")
		}else{
			alert("修改失败!")
		}
	})
}
