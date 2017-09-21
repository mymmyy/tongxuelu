$(function(){
})
function login(){
	var name=$("#aname").val();
	var pwd=$("#apwd").val();
	$.post("administrator/adminLogin",{"name":name,"pwd":pwd},function(data){
		if(data.code==100){
			location.href="adminIndex.html";
		}else{
			alert("用户名或密码错误！");
		}
	})
}