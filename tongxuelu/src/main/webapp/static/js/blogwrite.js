$(function(){
	initSelect();
})
function initSelect(){
	$.get("/tongxuelu/BlogCategoryController/getAllBlogCategory",{},function(data){
		if(data.code!=200){
			var list=data.extend.list;
			var blogSelect=$("#blogSelect");
			var msg="";
			msg+="<option>选择文章类型</option>";
			for(var i=0;i<list.length;i++){
				msg+="<option value='"+list[i].categoryId+"'>"+list[i].categoryName+"</option>";
			}
			blogSelect.html(msg);
		}
	});
}
