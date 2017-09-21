$(function(){
	getAllPic(1);
	$.post("PhotoController/getCount",{},function(data){
		var page=Math.ceil(data/6);
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
			    getAllPic(pageIndex);
			 }	
	})
	})
})

function getAllPic(pageIndex){
	var size=6;
	$.post("PhotoController/getAllPhoto",{"pageIndex":pageIndex,"size":size},function(data){
		var items=data.extend.list;
		var nav=$("#allpic");
		var msg='';
		for(var i=0;i<items.length;i++){
			msg+='<div class="col-md-4"><img alt="无法显示" src="'+items[i].photoUrl+'"  style="width:380px;height:220px;margin-top: 30px;">';
			msg+='<a href="javascript:deletePhoto('+items[i].photoId+','+pageIndex+')" class="layui-btn layui-btn-warm">删除</a>';
			msg+='</div>';
		}
		nav.html(msg);
	})
}

function deletePhoto(photoId,pageIndex){
	$.post("PhotoController/deletePhoto",{"photoId":photoId},function(data){
		if(data==1){
			getAllPic(pageIndex);
		}else{
			alert("删除失败，请联系管理员!")
		}
	})
}
