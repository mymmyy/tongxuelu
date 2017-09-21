$(function(){
	
	/*$(".M-box3").click(function(){
		
	})*/
	
	
	getAllWord(1);
	$.post("authority/getCount",{},function(data){
		
		var page=Math.ceil(data/2);
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
			    getAllWord(pageIndex);
			 }	
		});
	})
})

function getAllWord(pageIndex){
	var size=2;
	$.get("authority/getWordByPage",{"pageIndex":pageIndex,"size":size},function(data){
		var items=data;
		var nav=$("#tbody");
		nav.html("");
		var msg="";
		if(items!=null){
		for(var i=0;i<items.length;i++){
			var thisTr = $("<tr></tr>");
			thisTr.append($("<td>"+items[i].leaveWordId+"</td>"));
			thisTr.append($("<td>"+items[i].leaveWordContent+"</td>"));
			thisTr.append($("<td>"+items[i].leaveWordTime+"</td>"));
			thisTr.append($("<td></td>").append($("<a href='javascript:deleteWord(&quot;"+items[i].leaveWordId+"&quot;,"+pageIndex+")' class='layui-btn layui-btn-mini'>删除</a>")));
			nav.append(thisTr);
			/*msg+='<tr>';
			msg+='<td>'+items[i].leaveWordId+'</td>';
			msg+='<td>'+items[i].leaveWordContent+'</td>';
			msg+='<td>'+items[i].leaveWordTime+'</td>'
			msg+='<td><a href="/manage/article_edit_1" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:deleteAdmin(&quot;'+items[i].leaveWordId+'&quot;)" data-id="1" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini" id="delete">删除</a></td>';*/
		}
		//nav.html(msg);
		}
	})
}

function deleteWord(leaveWordId,pageIndex){
	$.post("authority/deleteWord",{"leaveWordId":leaveWordId},function(data){
		if(data==1){
			getAllWord(pageIndex)
		}else{
			alert("删除失败，请联系管理员!")
		}
	})
}






