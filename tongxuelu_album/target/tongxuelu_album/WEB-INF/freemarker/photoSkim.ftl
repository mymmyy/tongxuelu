
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/index/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="/index/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/index/css/baguetteBox.min.css">
    <link rel="stylesheet" href="/index/css/gallery-grid.css">
    <style>
        .jq22-demo{ text-align: center; margin-top: 30px; }
        .jq22-demo a{ padding-left: 20px; padding-right: 20px; }
    </style>

    <style>
        .listImg{
            width: 200px;
            height: 200px;
        }

        .listLi{
            float: left;
            padding: 20px;
        }

        .listA{
            padding: 20px;
        }

    </style>

</head>
<body>

<#include "head.ftl" encoding="UTF-8" parse=true>
<div class="htmleaf-container">
    <div class="container gallery-container">

        <h1>Photo display</h1>
        <div class="jq22-demo">

            <a href="${pageContext.request.contextPath}/PhotoController/allPhoto/${pageInfo.list[0].albumId}/1">流式幻灯片</a>
            <a href="${pageContext.request.contextPath}/PhotoController/allPhoto_grid/${pageInfo.list[0].albumId}/1">Grid组合欣赏</a>
        </div>
        <p class="page-description text-center">see me life</p>

        <div class="tz-gallery">

        <#--<#list pageInfo.list as photo>
            <li class="listLi">
                <a href="#" class="listA">
                    <img class="listImg" src="${photo.photoUrl}" alt="图片加载失败">
                </a>

            </li>
        </#list>-->

            <div class="row">
            <#list pageInfo.list as photo>
                <div class="col-sm-6 col-md-4">
                    <a class="lightbox" href="${photo.photoUrl}">
                        <img src="${photo.photoUrl}" alt="图片加载失败">
                    </a>
                </div>
            </#list>

            </div>

        </div>

    </div>

</div>

<script type="text/javascript" src="/index/js/baguetteBox.min.js"></script>
<script type="text/javascript">
    baguetteBox.run('.tz-gallery');
</script>

<!--===========================================================================-->

<#--
<h2 style="padding: 50px">相册中的相片</h2>

<div style="margin: 0px;padding: 50px">

    <ul>
        <#list pageInfo.list as photo>
        <li class="listLi">
            <a href="#" class="listA">
                <img class="listImg" src="${photo.photoUrl}" alt="图片加载失败">
            </a>

        </li>
        </#list>
    </ul>

</div>
-->



<div style="width: 100%;text-align: center">

    <div>
        当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
    </div>

    <div>

        <nav aria-label="Page navigation">
            <ul class="pagination">

                <li><a href="${pageContext.request.contextPath}/PhotoController/allPhoto/${pageInfo.list[0].albumId}/1">首页</a></li>

                <!--上一页-->
                <#--<li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <a href="${pageContext.request.contextPath}/PhotoController/allPhoto/${pageInfo.list[0].albumId}/${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>-->

                <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
            <#list pageInfo.navigatepageNums as page_num>
              <#if (page_num == pageInfo.pageNum)>
                  <li class="active"><a href="#">${page_num}</a></li>
              <#else>
                  <li><a href="${pageContext.request.contextPath}/PhotoController/allPhoto/${pageInfo.list[0].albumId}/${page_num}">${page_num}</a></li>

              </#if>
            <#--<c:if test="${page_num != pageInfo.pageNum}">-->
            <#--</c:if>-->
            </#list>

                <!--下一页-->
               <#-- <li>
                <#if (pageInfo.hasNextPage)>
                    <a href="${pageContext.request.contextPath}/PhotoController/allPhoto/${pageInfo.list[0].albumId}/${pageInfo.pageNum+1}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </#if>
                </li>-->

                <li><a href="${pageContext.request.contextPath}/PhotoController/allPhoto/${pageInfo.list[0].albumId}/${pageInfo.pages}">尾页</a></li>
            </ul>
        </nav>

    </div>

</div>

</body>
</html>
