<link rel="stylesheet" href="/head/css/style.css">
<link rel="stylesheet" type="text/css" href="/index/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="/index/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<input type="hidden" name="userId" value="${existUser.userId}" id="userId">
<div id="header" class="construct clear-float">
    <div class="logo fl">
        <img src="/myStatic/img/logo.png" style="height: 70px;width: 70px;margin: 5px;float: left">
        <span style="font-size: 25px;color: bisque;">${existUser.nickname}</span>
        <span style="font-size: 15px;color: #eaeded">的私密空间</span>
    </div>
    <div class="navs">
        <ul>
            <li class="hasmenu active"><a href="${pageContext.request.contextPath}/AlbumController/list/${existUser.userId}/1">我的相册</a></li>
            <li class="hasmenu"><a href="${pageContext.request.contextPath}/tongxuelu_album/SsoForward/toPersonalSpace">个人空间</a></li>
            <li><a href="${pageContext.request.contextPath}/tongxuelu_album/SsoForward/toPersonalArticle">我的文章</a></li>
            <li class="hasmenu"><a href="${pageContext.request.contextPath}/tongxuelu_album/SsoForward/toPersonalLeaveWord">留言板</a></li>
            <li><a href="${pageContext.request.contextPath}/tongxuelu_album/SsoForward/toPersonalFriend">我的好友</a></li>
            <li><a href="#" id="about_li">关于</a></li>

        </ul>

        <a href="${pageContext.request.contextPath}/PhotoController/toUploadPic.html" class="btn btn-info" style="float: right;margin-top: 10px;">上传相片</a>
        <a href="${pageContext.request.contextPath}/PhotoController/list/${existUser.userId}/1" class="btn btn-info" style="float: right;margin-top: 10px;margin-right: 10px">相片管理</a>
        <button class="btn btn-info check_friend_button" style="float: right;margin-top: 10px;margin-right: 10px">好友相册</button>
        <div style="opacity: 0.7;width: 200px;position: relative;float: right;margin-top: 10px;margin-right: 5px;background-color: ghostwhite;text-align: center;"></div>
        <div class="menu-container">
            <#--<div class="menu-bg">
                <div class="menu">
                    <div class="scroll clear-float">
                        <div class="plate fl">
                            <div class="linker">
                                <img src="/head/image/nav_yang.jpg" alt="">
                                <p>示例文字1</p>
                            </div>
                            <div class="linker">
                                <img src="/head/image/nav_yang.jpg" alt="">
                                <p>示例文字2</p>
                            </div>
                        </div>
                        <div class="plate fl">
                            <div class="linker">
                                <img src="/head/image/nav_yang.jpg" alt="">
                                <p>示例文字3</p>
                            </div>
                            <div class="linker">
                                <img src="/head/image/nav_yang.jpg" alt="">
                                <p>示例文字4</p>
                            </div>
                            <div class="linker">
                                <img src="/head/image/nav_yang.jpg" alt="">
                                <p>示例文字5</p>
                            </div>
                        </div>
                        <div class="plate fl">
                            <div class="linker">
                                <img src="/head/image/nav_yang.jpg" alt="">
                                <p>示例文字6</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>-->
        </div>
    </div>
    <div class="search fr clear-float">
        <a href="/logout.html" style="font-size: 18px;float: right;color: wheat;">注销</a>
        <form action="#">
            <input type="text" class="fl" placeholder="输入用户账号搜索相册">
            <button type="submit" class="fl search_album_button"></button>
        </form>

    </div>
</div>
<#--<div id="body">
    <div class="banner">
        <div class="image imageload" origin-data="/head/image/02.jpg"></div>
        <div class="image imageload" origin-data="/head/image/03.jpg"></div>
        <div class="image imageload" origin-data="/head/image/06.jpg"></div>
    </div>
</div>-->

<script src="/head/script/jquery-1.9.1.min.js"></script>
<script src="/head/script/jquery.easing.min.js"></script>
<script src="/head/script/EasyBanner.js"></script>
<script src="/head/script/common.js"></script>
<script>

    var banner = new EasyBanner({
        wrap : '#body .banner',
        img : '.image',
        speed : 6000,
        interval : 10000
    });
</script>


<!--自js-->
<script>
    var userId;
    var isShowMyFriend;
    $(document).ready(function () {
        userId = $("#userId").val();
        $(".search_album_button").click(function () {
            var searchValue = $(this).prev().val();
            var existUserId = $("#userId").val();

            //如果查询的是当前用户，就刷新页面
            if(searchValue == existUserId){
                window.location.reload();//刷新当前页面
            }

            //查询用户存不存在
            $.ajax({
                url:"/FriendController/selectUserByUserId?userId="+searchValue,
                type:"get",
                success:function (data) {

                    if(data.code == 100){
                        //alert("用户存在");
                        //console.log(data.extend.findUser);
                        //可以跳转
                        window.location.href="/FriendController/list/"+data.extend.findUser.userId+"/1";
                    }else{
                        alert("用户不存在！");
                    }
                },
                error:function () {
                    alert("网络欠佳，请稍后再试");
                }

            })





            return false;
        })


        //关于连接事件
        $("#about_li").click(function () {
            alert("晨博潇洒小组具有最终解释权！");
            return false;
        });


        isShowMyFriend = true;                     //初始化不显示好友
        //查询所有好友=============================
        $(".check_friend_button").click(function () {

            //获取到放置数据的div
            var listDiv = $(this).next();
            if(!isShowMyFriend){
                listDiv.html("");
                isShowMyFriend = true;              //下次点击就需要显示
                return false;
            }


            $.ajax({
                url:"/FriendController/getAllByMyId?userId="+userId+"&pn=1",
                type:"get",
                success:function (data) {
                    if(data.code == 200){
                        alert("服务器繁忙，请稍后再试！");
                    }else if(data.code == 100){

                        createFriendList(data.extend.pageInfo,listDiv);
                        isShowMyFriend = false;             //下次点击就不用显示

                    }
                }
            })


        })



    });

    //friend是数组
    function createFriendList(pageInfo,listDiv) {
        listDiv.html("");
        var friend = pageInfo.list;
        var dataList = $("<div></div>");
        while(friend.length > 0){
            var thisFriend = friend.shift();
            dataList.append($("<a href='/FriendController/list/"+thisFriend.friendId+"/1'>"+thisFriend.comment+"</a>"));
        }
        listDiv.append(dataList);


        var prePageA = $("<a href='/FriendController/getAllByMyId?userId="+userId+"&pn="+pageInfo.prePage+"'>上一页</a>");
        var currentPage = $("<span>第"+pageInfo.pageNum+"页</span>");
        var nextPageA = $("<a href='/FriendController/getAllByMyId?userId="+userId+"&pn="+pageInfo.nextPage+"'>下一页</a>");
        if(pageInfo.hasPreviousPage){
            listDiv.append(prePageA);
        }
        listDiv.append(currentPage);
        if(pageInfo.hasNextPage){
            listDiv.append(nextPageA);
        }

    }


</script>
