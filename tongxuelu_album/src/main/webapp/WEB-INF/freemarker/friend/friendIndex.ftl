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

    <!--自己的js-->
    <script>
        $(document).ready(function () {

            //回答问题按钮
            $(".answer").click(function () {
                var nextDiv = $(this).next();
                nextDiv.html("");
                var problem = $(this).attr("name");
                nextDiv.append($("<p>问题："+problem+"</p>"));
                nextDiv.append($("<input placeholder='答案' style='padding: 1px;margin: 5px;'>"));
                nextDiv.append($("<button class='btn bg-info btn-sm answer_submit_button'>确认</button>"))

            })

            //确认按钮事件
            $(".answer_div").on("click",".answer_submit_button",function () {
                var albumId = $(".answer_div").prev().prev().val();
                var viewKey = $(this).prev().val();

                $.ajax({
                    url:"/FriendController/checkAnswer?albumId="+albumId+"&viewKey="+viewKey,
                    type:"get",
                    success:function (data) {
                        if(data.code == 200){
                            alert("答案错误!");
                        }else if(data.code ==  100){
                            window.location.href = "/FriendController/allPhoto/"+albumId+"/1";
                        }
                    }
                })


            });




            //去往photo列表页面
            $(".to_photo_list_a").click(function () {
                var albumId = $(this).attr("name");
                //0:albumId  1:viewLock（（0，仅所有者、1.回答问题、2.好友、3.公开）  2:是否是好友
                var info = albumId.split(":");
                if(info[1] > 2){
                    window.location.href="/FriendController/allPhoto/"+info[0]+"/1";
                }else if(info[1] == 2 && info[2]){
                    window.location.href="/FriendController/allPhoto/"+info[0]+"/1";
                }

                return false;
            })


        })
    </script>


</head>
<body>

<#include "head.ftl" encoding="UTF-8" parse=true>



<#--相册编辑信息-->
<#--<div class="md-modal md-effect-3" id="modal-3">
    <div class="md-content">
        <div>
            <div class="md-effect-3-content">


            </div>
            <button class="md-close btn-sm btn-primary">取消</button>
            <button class="md-close btn-sm btn-primary confirm_the_change">确认修改</button>
        </div>
    </div>
</div>-->

<#--<div class="md-modal md-effect-10" id="modal-10">
    <div class="md-content">

        <h3>相册中的所有相片也会删除，确认要删除？</h3>


        <button class="md-close btn-sm btn-success">取消</button>
        <button class="md-close btn-sm btn-info confirm_the_edit">确认删除</button>

    </div>
</div>-->






<div class="htmleaf-container">
    <div class="container gallery-container">
        <h1>所有相册都在这里哦</h1>
        <div class="jq22-demo">

        </div>







        <#--相册正式信息-->
        <p class="page-description text-center">用户 ${friend.friendId} 的相册</p>

        <div class="tz-gallery">

            <div class="row">
            <#--判断是否是好友,声明变量：isFriend-->



            <#list pageInfo.list as album>
                <#if (friend.myId == null)>
                    <#assign isFriend=false>
                <#else>
                    <#assign isFriend=true>
                </#if>

                <#--设置 是否 要设置回答问题的按钮的变量-->
                <#if (album.viewLock == 1)>
                    <#assign isSetButton=true>
                <#else>
                    <#assign isSetButton=false>
                </#if>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail" style="width: 320px;">

                        <a class="lightbox to_photo_list_a" name="${album.albumId}:${album.viewLock}:${isFriend}" href="#">
                            <#if (album.viewLock == 0)>
                            <#--说明是仅自己查看：图片是上锁图片-->
                                <img src="/myStatic/img/only_user.png" alt="私有" style="width: 300px;height: 300px;">
                            <#elseif (album.viewLock == 1)>
                            <#--回答问题可见-->
                                <img src="/myStatic/img/answer.png" alt="回答问题可见" style="width: 300px;height: 300px;">

                            <#elseif (album.viewLock == 2)>
                            <#--好友可见-->
                                <#if (isFriend)>
                                    <#--是好友就相当于公开-->
                                    <#if (album.photoList[0].photoId == null)>
                                        <img src="/myStatic/img/nopic.png" alt="图片加载失败" style="width: 300px;height: 300px;">

                                    <#else>
                                        <img src="${album.photoList[0].photoUrl}" alt="图片加载失败"
                                             style="width: 300px;height: 300px;">
                                    </#if>

                                <#else>
                                    <img src="/myStatic/img/friend_see.png" alt="好友可见" style="width: 300px;height: 300px;">

                                </#if>

                            <#elseif (album.viewLock == 3)>
                            <#--公开-->
                                <#if (album.photoList[0].photoId == null)>
                                    <img src="/myStatic/img/nopic.png" alt="图片加载失败" style="width: 300px;height: 300px;">

                                <#else>
                                    <img src="${album.photoList[0].photoUrl}" alt="图片加载失败"
                                         style="width: 300px;height: 300px;">
                                </#if>
                            </#if>

                        </a>

                        <div class="caption" >
                            <p style="font-size: 20px;">${album.albumName}</p>
                            <input type="hidden" name="albumId" value="${album.albumId}">

                            <#if (isSetButton)>
                                <button class="answer btn bg-info" name="${album.viewIssue}">回答问题</button>
                                <div style="text-align: center;margin: 5px;" class="answer_div"></div>
                            </#if>
                            <#--<a style="float: left;margin-left: 50px;" href="javascript:;" class="md-trigger btn btn-primary btn-sm edit_button" data-modal="modal-3">编辑</a>
                            <form action="/AlbumController/album/${album.albumId}" method="post" class="delete_form">
                                <input type="hidden" name="_method" value="DELETE">
                                <input type="submit" class="btn btn-danger btn-sm delete_button" value="删除">
                            </form>-->

                        </div>
                    </div>
                </div>
            </#list>



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

                        <li><a href="${pageContext.request.contextPath}/FriendController/list/${friend.friendId}/1">首页</a></li>

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
                            <li><a href="${pageContext.request.contextPath}/FriendController/list/${friend.friendId}/${page_num}">${page_num}</a></li>

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

                        <li><a href="${pageContext.request.contextPath}/FriendController/list/${friend.friendId}/${pageInfo.pages}">尾页</a></li>
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
