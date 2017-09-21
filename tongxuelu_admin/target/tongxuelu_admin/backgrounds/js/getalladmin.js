$(function(){
	getAllAdmin(1);
	$.post("administrator/getCount",{},function(data){
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
		    	getAllAdmin(pageIndex);
		     }	
		});
	})
})

function getAllAdmin(pageIndex){
	var size=5;
	$.post("administrator/getAdminByPage",{"pageIndex":pageIndex,"size":size},function(data){
		var items=data.extend.list;
		var nav=$("#alladmin");
		var msg="";
		for(var i=0;i<items.length;i++){
			msg+='<tr>';
			msg+='<td>'+items[i].id+'</td>';
			msg+='<td>'+items[i].name+'</td>';
			msg+='<td>'+items[i].tele+'</td>';
			msg+='<td>'+items[i].email+'</td>'
			msg+='<td>'+items[i].rinfo.name+'</td>';
			/*msg+='<td><a href="/detail-1" target="_blank" class="layui-btn layui-btn-normal layui-btn-mini">预览</a><a href="/manage/article_edit_1" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:;" data-id="1" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td></tr></td>';*/
			msg+='<td>'+'<a href="/manage/article_edit_1" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:deleteAdmin(&quot;'+items[i].name+'&quot;,'+pageIndex+')" data-id="1" data-opt="del" class="layui-btn layui-btn-danger layui-btn-mini" id="delete">删除</a></td>';
		}
		nav.html(msg);
	})
	
}

function deleteAdmin(name,pageIndex){
	$.post("administrator/deleteAdmin",{"name":name},function(data){
		if(data==1){
			getAllAdmin(pageIndex)
		}else{
			alert("删除失败，请联系管理员!")
		}
	})
}


