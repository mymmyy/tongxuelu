$(function(){
	selectUserAll(1);
	$.post("user/getUserCount",{},function(data){
		var page=Math.ceil(data/5);
		$('.M-box3').pagination({
		    pageCount:page,
		    jump:true,
		    coping:true,
		    homePage:'首页',
		    endPage:'末页',
		    prevContent:'上页',
		    nextContent:'下页',
		    callback:function(api){
		    	var pageIndex=api.getCurrent()
		    	selectUserAll(pageIndex);
		     }	
		});
	})
})
function selectUserAll(pageIndex){
	var size=5
	$.post("user/getUserByPage",{"pageIndex":pageIndex,"size":size},function(data){
		var tbody=$("#tbody");
		tbody.html("");
		for (var i = 0; i < data.length; i++) {
			tbody.append("<tr>");
			tbody.append("<td>"+data[i].userId+"</td>");
			tbody.append("<td>"+data[i].nickname+"</td>");
			tbody.append("<td>"+data[i].gender+"</td>");
			tbody.append("<td>"+data[i].qq+"</td>");
			tbody.append("<td>"+data[i].registerTime+"</td>");
			tbody.append("<td>"+data[i].school+"</td>");
			tbody.append("<td>"+data[i].state+"</td>");
			tbody.append('<td>'+'<a href="/manage/article_edit_1" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:deleteUser(&quot;'+data[i].userId+'&quot;,'+pageIndex+')" data-id="1" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini" id="delete">删除</a>'+'</td>');
			tbody.append("</tr>");
		}
	})
}

function deleteUser(userId,pageIndex){
	$.post("user/deleteUser",{"userId":userId},function(data){
		if(data==1){
			selectUserAll(pageIndex);
		}else{
			alert("删除失败，请联系管理员!")
		}
	})
}


