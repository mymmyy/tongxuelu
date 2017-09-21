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
	$.get("/tongxuelu/authority/getWordByPage",{"pageIndex":pageIndex,"size":size},function(data){
		var items=data;
		var nav=$("#tbody")
		var msg="";
		if(items!=null){
		for(var i=0;i<items.length;i++){
			msg+='<tr>';
			msg+='<td>'+items[i].leaveWordId+'</td>';
			msg+='<td>'+items[i].leaveWordContent+'</td>';
			msg+='<td>'+items[i].leaveWordTime+'</td>'
			msg+='<td><a href="/manage/article_edit_1" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:deleteAdmin(&quot;'+items[i].leaveWordId+'&quot;)" data-id="1" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini" id="delete">删除</a></td>';
		}
		nav.html(msg);
		}
	})
}





