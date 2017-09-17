<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- add styles -->
        <link href="/tongxuelu/static/userhead/css/main.css" rel="stylesheet" type="text/css" />
        <link href="/tongxuelu/static/userhead/css/jquery.Jcrop.min.css" rel="stylesheet" type="text/css" />

        <!-- add scripts -->
        <script src="/tongxuelu/static/userhead/js/jquery.min.js"></script>
        <script src="/tongxuelu/static/userhead/js/jquery.Jcrop.min.js"></script>
        <script src="/tongxuelu/static/userhead/js/script.js"></script>
</head>
<body>	
<div class="demo" style=" margin-top:60px;">
            <div class="bheader"><h2>——图像上传表单——</h2></div>
            <div class="bbody">

                <!-- upload form -->
                <form:form id="upload_form" enctype="multipart/form-data" method="post" action="/tongxuelu/user/uploadHead" onSubmit="return checkForm()" modelAttribute="user">
                    <!-- hidden crop params -->
                    <input type="hidden" id="x1" name="x1" />
                    <input type="hidden" id="y1" name="y1" />
                    <input type="hidden" id="x2" name="x2" />
                    <input type="hidden" id="y2" name="y2" />
                    <h2>第一步:请选择图像文件</h2>
                    <div><input type="file" name="fileName" id="image_file" onChange="fileSelectHandler()" /></div>

                    <div class="error"></div>

                    <div class="step2">
                        <h2>请选择需要截图的部位,然后按上传</h2>
                        <img id="preview" />

                        <div class="info">
                            <label>文件大小</label> <input type="text" id="filesize" name="filesize" />
                            <label>类型</label> <input type="text" id="filetype" name="filetype" />
                            <label>图像尺寸</label> <input type="text" id="filedim" name="filedim" />
                            <label>宽度</label> <input type="text" id="w" name="w" />
                            <label>高度</label> <input type="text" id="h" name="h" />
                        </div>

                        <input type="submit" value="上传" />
                    </div>
                </form:form>
            </div>
        </div>

</body>
</html>