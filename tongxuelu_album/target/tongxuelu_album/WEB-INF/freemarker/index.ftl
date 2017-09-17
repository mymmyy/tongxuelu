<html>
<head>
    <title>主页</title>

    <link rel="stylesheet" type="text/css" href="/index/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="/index/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="/myStatic/js/jquery.min.js"></script>
    <link rel="stylesheet" href="/index/css/baguetteBox.min.css">
    <link rel="stylesheet" href="/index/css/thumbnail-gallery.css">

    <link rel="stylesheet" href="/index/addalbum/css/Quttons.css">
    <link rel="stylesheet" href="/index/addalbum/css/main.css">

    <link href="/index/tip/css/component.css" rel="stylesheet">
    <style>
        .jq22-demo {
            text-align: center;
            margin-top: 30px;
        }

        .jq22-demo a {
            padding-left: 20px;
            padding-right: 20px;
        }
    </style>


</head>
<body>

<#include "head.ftl" encoding="UTF-8" parse=true>



<!--相册编辑信息-->
<div class="md-modal md-effect-3" id="modal-3">
    <div class="md-content">
        <div>
            <div class="md-effect-3-content">


            </div>
            <button class="md-close btn-sm btn-primary">取消</button>
            <button class="md-close btn-sm btn-primary confirm_the_change">确认修改</button>
        </div>
    </div>
</div>

<#--<div class="md-modal md-effect-10" id="modal-10">
    <div class="md-content">

        <h3>相册中的所有相片也会删除，确认要删除？</h3>


        <button class="md-close btn-sm btn-success">取消</button>
        <button class="md-close btn-sm btn-info confirm_the_edit">确认删除</button>

    </div>
</div>-->






<div class="htmleaf-container">
    <div class="container gallery-container">
        <h2>我的相册</h2>
       <#-- <div class="jq22-demo">
            <a href="index.html" class="current">Clean Layout</a>
            <a href="index2.html">Fluid Layout</a>
            <a href="index3.html">Grid Layout</a>
            <a href="index4.html">Thumbnails</a>
        </div>-->







        <!--相册正式信息-->
        <#--<p class="page-description text-center">我的相册</p>-->

        <div class="tz-gallery">

            <div class="row">


            <#list pageInfo.list as album>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail" style="width: 320px;">
                        <a class="lightbox" href="${pageContext.request.contextPath}/PhotoController/allPhoto/${album.albumId}/1">
                            <#if (album.photoList[0].photoId == null)>
                                <img src="/myStatic/img/nopic.png" alt="Park" style="width: 300px;height: 300px;">
                            <#else>
                                <img src="${album.photoList[0].photoUrl}" alt="Park"
                                     style="width: 300px;height: 300px;">
                            </#if>
                        </a>

                        <div class="caption">
                            <p style="font-size: 20px;">${album.albumName}</p>
                            <input type="hidden" name="albumId" value="${album.albumId}">
                            <a style="float: left;margin-left: 200px;" href="javascript:;" class="md-trigger btn btn-primary btn-sm edit_button" data-modal="modal-3">编辑</a>
                            <form action="/AlbumController/album/${album.albumId}" method="post" class="delete_form">
                                <input type="hidden" name="_method" value="DELETE">
                                <input type="submit" class="btn btn-danger btn-sm delete_button" value="删除">
                            </form>

                        </div>
                    </div>
                </div>
            </#list>


            <#--增加相册-->
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">

                        <div class="buttonCollection">
                            <div class="qutton" id="qutton_upload"
                                 style="background-color:#b9def0;width: 150px;height: 150px">
                                <div class="qutton_dialog" id="uploadDialog">
                                    <h2>添加相册</h2>
                                    <div class="urlField">
                                        <form action="${pageContext.request.contextPath}/AlbumController/album.html"
                                              method="post" id="addForm">
                                            <table class="table" border="1 solid gray">
                                                <tr>
                                                    <td>
                                                        <input type="text" id="albumName" name="albumName"
                                                               placeholder="相册名称" style="height: 30px;width: 200px">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <select name="viewLock" style="padding: 5px">
                                                            <option value="0">仅自己查看</option>
                                                            <option value="1">回答问题</option>
                                                            <option value="2">仅好友</option>
                                                            <option value="3" selected="selected">所有人</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr style="display: none">
                                                    <td>
                                                        <input type="text" id="viewIssue" name="viewIssue"
                                                               placeholder="访问问题" style="height: 30px;width: 200px">
                                                    </td>
                                                </tr>
                                                <tr style="display: none">
                                                    <td>
                                                        <input type="text" id="viewKey" name="viewKey"
                                                               placeholder="访问答案" style="height: 30px;width: 200px">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <button type="button" class="btn btn-primary btn-lg btn-block" id="album_add_button">添加
                                                        </button>
                                                    </td>
                                                </tr>
                                            </table>
                                            <input type="hidden" name="userId" value="${existUser.userId}">

                                        </form>
                                    </div>

                                <#--<div id="button_basic_upload">添加</div>-->
                                </div>
                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>



        <!--显示分页信息-->
        <div class="row">
            <!--文字信息-->
            <div class="col-md-6">
                当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 个相册
            </div>

            <!--点击分页-->
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">

                        <li><a href="${pageContext.request.contextPath}/AlbumController/list/${existUser.userId}/1">首页</a></li>

                        <!--上一页-->
                    <#--<li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <a href="${pageContext.request.contextPath}/AlbumController/list/${existUser.userId}/${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </c:if>
                    </li>-->

                        <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                    <#list pageInfo.navigatepageNums as page_num>
                        <#if (page_num == pageInfo.pageNum)>
                            <li class="active"><a href="#">${page_num}</a></li>
                        <#else>
                            <li><a href="${pageContext.request.contextPath}/AlbumController/list/${existUser.userId}/${page_num}">${page_num}</a></li>

                        </#if>
                    <#--<c:if test="${page_num != pageInfo.pageNum}">-->
                    <#--</c:if>-->
                    </#list>

                        <!--下一页-->
                    <#--<li>
                    <#if (pageInfo.hasNextPage)>
                        <a href="${pageContext.request.contextPath}/AlbumController/list/${existUser.userId}/${pageInfo.pageNum+1}"
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </#if>
                    </li>-->

                        <li><a href="${pageContext.request.contextPath}/AlbumController/list/${existUser.userId}/${pageInfo.pages}">尾页</a></li>
                    </ul>
                </nav>
            </div>

        </div>


    </div>

</div>

<script src="/index/tip/js/classie.js"></script>
<script src="/index/tip/js/modalEffects.js"></script>

<script type="text/javascript" src="/index/js/baguetteBox.min.js"></script>
<script type="text/javascript" src="/myStatic/js/index.js"></script>
<script type="text/javascript">
    baguetteBox.run('.tz-gallery');
</script>


<script type="text/javascript" src="/index/addalbum/js/velocity.js"></script>
<script type="text/javascript" src="/index/addalbum/js/velocity.ui.js"></script>
<script type="text/javascript" src="/index/addalbum/js/Quttons.js"></script>
<script type="text/javascript">
    $(function () {

        var quttonUpload = Qutton.getInstance($('#qutton_upload'));
        quttonUpload.init({
            icon: '/myStatic/img/add.png',
            backgroundColor: '#917466'
        });


        var quttonDelete = Qutton.getInstance($('#qutton_delete'));
        quttonDelete.init({
            icon: '/index/addalbum/images/icon_delete.png',
            backgroundColor: "#eb1220"
        });


        var quttonComment = Qutton.getInstance($('#qutton_comment'));
        quttonComment.init({
            icon: 'images/icon_comment.png',
            backgroundColor: "#41aaf1"
        });
    });
</script>


</body>
</html>
