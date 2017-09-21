<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/tongxuelu/static/logwrite/button/button.css" />
<script type="text/javascript" src="/tongxuelu/static/logwrite/wangEditor-3.0.4/release/wangEditor.min.js"></script>
<script type="text/javascript" src="/tongxuelu/static/logwrite/bround1/js/jquery-1.8.3.min.js"></script>
<style type="text/css">
		body{
			background-color: white;
		}
        .toolbar {
            border: 1px solid #ccc;
        }
        .text {
            border: 1px solid #ccc;
            height: 530px;
        }
        .bul li{
			float:left;
			margin-left: 200px;
			list-style: none;
		}
		#text1,#text2{
			height:30px;
			width:500px;
			background:transparent;
			border:1px solid #ffffff;
			font-size: 15pt;
		}
</style>
</head>
<body>
	<div>
		<input type="text" id="text2" disabled="disabled" value="${requestScope.userBlog.blogCategory.categoryName}">	
	</div>
	<div>
		<input type="text" id="text1" value="${requestScope.userBlog.blogTitle}">
	</div>
	 <div id="div1" class="toolbar">
	</div>
    <div style="padding: 5px 0; color: #ccc"></div>
    <div id="div2" class="text" style="margin-left: 5px"> <!--可使用 min-height 实现编辑区域自动增加高度-->
        ${requestScope.userBlog.blogContent}
    </div>
    	
    <div style="margin-left: 300px;margin-top: 8px">
	    	<ul class="bul">
	    		<li><button type="button" id="button1" class="button gray tags" style="cursor:pointer;">确认修改</button></li>
	    		<li><button type="button" id="button2" class="button gray tags" style="cursor:pointer;">删除文章</button></li>
	  		</ul>
	</div> 
    <script >
        var E = window.wangEditor
        var editor = new E('#div1', '#div2')  // 两个参数也可以传入 elem 对象，class 选择器
        editor.customConfig.zIndex = 20000
		// 将图片大小限制为 3M
		  editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
			// 限制一次最多上传 1 张图片
		  editor.customConfig.uploadImgMaxLength = 1
		  editor.customConfig.uploadFileName = 'fileName';
	      // 或者 var editor = new E( document.getElementById('#editor') )
		  editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/UserBlogController/upImg';
		  editor.create();
        
		  document.getElementById('button1').addEventListener('click', function () {
		        // 如果未配置 editor.customConfig.onchange，则 editor.change 为 undefined
			 var text1=$("#text1");
		   	 var blog_title=text1.val();
		   	 var blog_content=editor.txt.html();
	    	$.post("/tongxuelu/UserBlogController/updateUserBlogByBlogId",{"blogTitle":blog_title,"blogContent":blog_content},function(data){
	    		if(data>0)
	    			location.href="/tongxuelu/logwrite/homepage";
	    		else
	    			alert("服务器发生故障！");
	    	}) 
		        
		   })
		   
		   
		   document.getElementById('button2').addEventListener('click', function (){
			   	var text1=$("#text1");
			   	var blog_title=text1.val();
			    var blog_content=editor.txt.html();
				var deleteState=1;
			  $.post("/tongxuelu/UserBlogController/updateUserBlogByBlogId",{"blogTitle":blog_title,"blogContent":blog_content,"deleteState":deleteState},function(data){
		    		if(data>0)
		    			location.href="/tongxuelu/logwrite/homepage";
		    		else
		    			alert("服务器发生故障！");
		    	})  
		   })
         
		  
    </script>
     
</body>
</html>