
<html>
<head>
    <title>相片管理</title>
    <link rel="stylesheet" type="text/css" href="/index/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="/index/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="/myStatic/js/jquery.min.js"></script>

    <script>

        $(document).ready(function () {



            //删除按钮事件
            $(".delete_a").click(function () {


                var flag = window.confirm("确定要删除相片吗？");
                var thisLi = $(this).parent().parent();


                if(flag) {
                    $.ajax({
                        url: $(this).attr("href"),
                        type: "get",
                        success: function (data) {
                            if (data.code == 100) {

                                thisLi.remove();
                                //alert("删除成功！");

                            }else{
                                alert("服务器繁忙，请稍后再试");
                            }
                        }
                    });
                }

                return false;
            })



            //更换相册的下拉选择框事件
            $(".select_label").change(function () {

                var albumId = $(this).val();
                var photoId = $(this).attr("id");



                $.ajax({
                    url:"${pageContext.request.contextPath}/PhotoController/editBelongAlbum?albumId="+albumId+"&photoId="+photoId,
                    type:"get",
                    success:function (data) {
                        if(data.code == 100){
                            //修改成功
                        }else if(data.code == 200){
                            //修改失败
                        }
                    }
                })


            });





            //批量删除================================
            $(".batch_delete_button").click(function () {
                var photoId = new Array();

                var allChecked = $("input:checked").parent().parent();

                if(allChecked.length == 0){
                    alert("请选择！");
                    return false;
                }
                //alert(allChecked.length);

                $("input:checked").each(function(i){
                    photoId[i] = $(this).attr("name");
                });

                $.ajax({
                    url:"${pageContext.request.contextPath}/PhotoController/deletePhotoByBatch",
                    type:"POST",
                    data:{"photoId":photoId},
                    traditional: true,//这里设置为true
                    success:function (data) {
                        if(data.code == 100){
                            //删除成功
                            allChecked.remove();

                        }else if(data.code == 200){
                            alert("服务器繁忙，请稍后再试！");
                        }
                    }
                })

            })


        });


    </script>


</head>
<body>

<#include "head.ftl" encoding="UTF-8" parse=true>



<!--通过bootstrap的栅格系统布局-->
<div class="container">

    <!--标题-->
    <div class="row">
        <div class="col-md-12">
            <h1>相片管理</h1>
            <button class="btn btn-danger batch_delete_button" style="margin: 5px;">批量删除</button>
        </div>

    </div>

    <!--按钮-->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">

            <#--<button class="btn btn-primary">编辑</button>-->
        </div>
    </div>

    <!--显示表格数据-->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>选择</th>
                    <th>序号</th>
                    <th>图片缩略图</th>
                    <th>图片描述</th>
                    <th>上传时间</th>
                    <th>所属相册</th>
                    <th>操作</th>
                </tr>


            <#list pageInfo.list as photo>
                <tr>

                    <th><input type="checkbox" name="${photo.photoId}"></th>

                    <th>${photo.photoId}</th>

                    <th><img src="${photo.photoUrl}" alt="图片加载失败" style="width: 100px;height: 100px"></th>
                    <th>${photo.photoDesc}</th>
                    <th>${photo.updateTime?string('yyyy-MM-dd HH:mm:ss')}</th>
                    <th>
                        <select class="form-control select_label" name="albumId"  id="${photo.photoId}">
                          <#list albums as album>
                              <#if (photo.albumId == album.albumId)>
                              <option value="${album.albumId}" selected>${album.albumName}</option>
                              <#else>
                              <option value="${album.albumId}">${album.albumName}</option>
                              </#if>
                          </#list>

                        </select>


                    </th>

                    <th>
                        <#--<button class="btn btn-primary" >
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                            编辑
                        </button>-->

                        <a class="btn btn-danger delete_a" href="${pageContext.request.contextPath}/PhotoController/deletePhoto/${photo.photoId}">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            删除
                        </a>

                    </th>
                </tr>
            </#list>

            </table>
        </div>

    </div>

    <!--显示分页信息-->
    <div class="row">
        <!--文字信息-->
        <div class="col-md-6">
            当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 张相片
        </div>

        <!--点击分页-->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><a href="${pageContext.request.contextPath}/PhotoController/list/${existUser.userId}/1">首页</a></li>

                    <!--上一页-->
                    <#--<li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <a href="${pageContext.request.contextPath}/PhotoController/list/${existUser.userId}/${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </c:if>
                    </li>-->

                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                <#list pageInfo.navigatepageNums as page_num>
                  <#if (page_num == pageInfo.pageNum)>
                      <li class="active"><a href="#">${page_num}</a></li>
                  <#else>
                      <li><a href="${pageContext.request.contextPath}/PhotoController/list/${existUser.userId}/${page_num}">${page_num}</a></li>

                  </#if>
                <#--<c:if test="${page_num != pageInfo.pageNum}">-->
                <#--</c:if>-->
                </#list>

                    <!--下一页-->
                    <#--<li>
                    <#if (pageInfo.hasNextPage)>
                        <a href="${pageContext.request.contextPath}/PhotoController/list/${existUser.userId}/${pageInfo.pageNum+1}"
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </#if>
                    </li>-->

                    <li><a href="${pageContext.request.contextPath}/PhotoController/list/${existUser.userId}/${pageInfo.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>

    </div>


</div>

</body>
</html>
