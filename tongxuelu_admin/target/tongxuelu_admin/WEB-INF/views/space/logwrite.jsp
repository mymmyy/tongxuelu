<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/tongxuelu/static/logwrite/button/button.css" />
<script src="/tongxuelu/static/img/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="/tongxuelu/static/logwrite/wangEditor-3.0.4/release/wangEditor.min.js"></script>
<script type="text/javascript" src="/tongxuelu/static/js/blogwrite.js"></script>
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
		select{
			width: 300px;
			height: 30px;
			font-size: 15px;
			
		}
</style>
</head>
<body>
	<div id="firstDiv">
		<div>
		<select id="blogSelect">
			
		</select>	
		</div>
		<div>
		<input type="text" id="text1" value="无标题文章">
		</div>
		 <div id="div1" class="toolbar">
		</div>
	    <div style="padding: 5px 0; color: #ccc"></div>
	    <div id="div2" class="text" style="margin-left: 5px"> <!--可使用 min-height 实现编辑区域自动增加高度-->
	        
	    </div>
	    	
	    <div style="margin-left: 300px;margin-top: 8px">
		    	<ul class="bul">
		    		<li><button type="button" id="button1" class="button gray tags" style="cursor:pointer;">发布文章</button></li>
		    		<li><button type="button" id="button2" class="button gray tags" style="cursor:pointer;">重置文章</button></li>
		  		</ul>
		</div> 
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
        		var categoryId=$("#blogSelect").val();
	    	  var blog_title=text1.val();
	    	  var blog_content=editor.txt.html();
	    	  $.post("/tongxuelu/UserBlogController/iusserArticle",{"blogTitle":blog_title,"blogContent":blog_content,"categoryId":categoryId},function(data){
	    		  text1.val("无标题文章");
	    		  if(data==1)
	    			  location.href="/tongxuelu/logwrite/homepage";
	    		  else
	    			  alert("发布文章失败");
	    	  })
		        
		   })
		   
		    document.getElementById('button2').addEventListener('click', function () {
		        // 如果未配置 editor.customConfig.onchange，则 editor.change 为 undefined
		    	$("#text1").val("无标题文章");
		    	  editor.txt.clear();
		        
		   })
		  
         
		  
    </script>
     
</body>
</html>