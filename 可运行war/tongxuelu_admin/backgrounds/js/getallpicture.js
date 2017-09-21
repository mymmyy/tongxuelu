$(function(){
	getAllPicture(1);
	$.post("PictureController/getCount",{},function(data){
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
			    getAllPicture(pageIndex);
			 }	
		})
	
	});
})

function getAllPicture(pageIndex){
	var size=6;
	$.post("PictureController/getPictureByPage",{"pageIndex":pageIndex,"size":size},function(data){
		var items=data.extend.list;
		var nav=$("#allpicture");
		var msg='';
		for(var i=0;i<items.length;i++){
			msg+='<div class="col-md-4"><img alt="无法显示" src="'+items[i].imgurl+'"  style="width:300px;height:150px;margin-top: 30px;">';
			msg+='<a href="javascript:deletePicture('+items[i].id+','+pageIndex+')" class="layui-btn layui-btn-warm">删除</a>';
			msg+='</div>';
		}
		nav.html(msg);
	})
}

function deletePicture(id,pageIndex){
	$.post("PictureController/deletePicture",{"id":id},function(data){
		if(data==1){
			getAllPicture(pageIndex);
		}else{
			alert("删除失败，请联系管理员!")
		}
	})
}
