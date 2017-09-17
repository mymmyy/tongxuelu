<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
    <link href="/fileupload/css/iconfont.css" rel="stylesheet" type="text/css"/>
    <link href="/fileupload/css/fileUpload.css" rel="stylesheet" type="text/css">
</head>
<body>
<#include "head.ftl" encoding="UTF-8" parse=true>
<div style="margin: 30px;">
    <h7 style="float: left">选择相册：</h7>
    <h3><select class="form-control" name="albumId" style="width: 30%" id="albumId">
    <#list albums as album>
        <option value="${album.albumId}">${album.albumName}</option>
    </#list>

    </select>
        </h3>
</div>

<div id="fileUploadContent" class="fileUploadContent" style="margin: 30px;">
    <!--<div class="uploadBts">
        <div>
            <div class="selectFileBt">选择文件</div>
        </div>
        <div>
        <i class="iconfont icon-shangchuan"></i>
        </div>
    </div>
    <div class="subberProgress">
        <div class="progress">
            <div>30%</div>
        </div>
    </div>
    <div class="box">
        <div class="fileItem">
            <div class="imgShow">
                <div class="fileType">txt</div>
                <i class="iconfont icon-wenjian"></i>
            </div>
            <div class="progress">
                <div class="progress_inner error"></div>
            </div>
            <div class="status">
                <i class="iconfont icon-shanchu"></i>
            </div>
            <div class="fileName">
               qwertyuiopasdfghjklzxcvbnm.jpg
            </div>
        </div>
        <div class="fileItem">
            <div class="imgShow">
                <div class="fileType">jpg</div>
                <i class="iconfont icon-wenjian"></i>
            </div>
            <div class="progress">
                <div class="progress_inner error"></div>
            </div>
            <div class="status">
                <i class="iconfont icon-shanchu"></i>
            </div>
            <div class="fileName">
                qwertyuiopasdfghjklzxcvbnm.jpg
            </div>
        </div>
        <div class="fileItem">
            <div class="imgShow">
                <img src="404bg.jpg"/>
            </div>
            <div class="progress">
                <div class="progress_inner error"></div>
            </div>
            <div class="status">
                <i class="iconfont icon-shanchu"></i>
            </div>
            <div class="fileName">
                qwertyuiopasdfghjklzxcvbnm.jpg
            </div>
        </div>

    </div>-->

</div>

</body>
</html>
<script src="/fileupload/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/fileupload/js/fileUpload.js"></script>
<script type="text/javascript">
    $("#fileUploadContent").initUpload({
        "uploadUrl":"/PhotoController/uploadFiles",//上传文件信息地址
        "progressUrl":"#",//获取进度信息地址，可选，注意需要返回的data格式如下（{bytesRead: 102516060, contentLength: 102516060, items: 1, percent: 100, startTime: 1489223136317, useTime: 2767}）
        //"showSummerProgress":true,//总进度条，默认限制
        //"scheduleStandard":true,//模拟进度的方式，设置为true是按总进度，用于控制上传时间，如果设置为false,按照文件数据的总量,默认为false
        //"size":350,//文件大小限制，单位kb,默认不限制
        "maxFileNumber":10,//文件个数限制，为整数
        //"filelSavePath":"",//文件上传地址，后台设置的根目录
        "beforeUpload":beforeUploadFun,//在上传前执行的函数
        //"onUpload":onUploadFun，//在上传后执行的函数
        // autoCommit:true,//文件是否自动上传
        //"fileType":['png','jpg','docx','doc']，//文件类型限制，默认不限制，注意写的是文件后缀

    });

    function beforeUploadFun(opt){

        opt.otherData =[{"name":"albumId","value":$("#albumId").val()}];
    }
    function onUploadFun(opt,data){
        alert(data);
        uploadTools.uploadError(opt);//显示上传错误
    }
</script>