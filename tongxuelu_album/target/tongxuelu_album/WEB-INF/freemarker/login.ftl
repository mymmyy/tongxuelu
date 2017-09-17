<#--<pre class="java" name="code">-->
<html>


    <head>


        <meta charset="utf-8">

        <title>Fullscreen Login</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <meta name="description" content="album">

        <meta name="author" content="mym">



        <!-- CSS -->

        <link rel="stylesheet" href="assets/css/reset.css">

        <link rel="stylesheet" href="assets/css/supersized.css">

        <link rel="stylesheet" href="assets/css/style.css">



        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->

        <!--[if lt IE 9]>

            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>

        <![endif]-->



    </head>



    <body>



        <div class="page-container">

            <h1>登陆</h1>

            <form action="" method="post">

                <input type="text" name="userId" class="username" placeholder="Username">

                <input type="password" name="password" class="password" placeholder="Password">

                <input type="text" name="verify" class="username" placeholder="请输入验证码" id="verify">

                <img src="${pageContext.request.contextPath}/codeController/code" class="imgcode" id="code" style="height:40px;padding: 10px";width:50px>

                <button type="submit">登陆</button>

                <div class="error"><span>+</span></div>

                <a href="/tongxuelu/user/toRegister" style="text-decoration:none;">没有账号？</a>

                <a href="/tongxuelu/user/toRegister" style="text-decoration:none;">忘记密码？</a>

            </form>


            <div class="connect">

                <#--<p>Or connect with:</p>-->

                <p>

                    <#--<a class="facebook" href=""></a>

                    <a class="twitter" href=""></a>-->
                        <#--<a class="" href="">忘记密码？</a>
                        <a class="" href="">没有账号？</a>-->


                </p>

            </div>

        </div>

      



        <!-- Javascript -->

        <script src="/assets/js/jquery-1.8.2.min.js"></script>

        <script src="/assets/js/supersized.3.2.7.min.js"></script>

        <script src="/assets/js/supersized-init.js"></script>

        <script src="/assets/js/scripts.js"></script>

        <script>
            $(document).ready(function () {

                $('.imgcode').click(function(){
                    changeCode();
                });


                //登陆按钮事件
                $("form>button").click(function () {

                    login();

                    return false;
                });


            })


            //登陆的方法===============================================
            function login(){

                var verify=$("#verify").val();
                var	userId=$(".username").eq(0).val();
                var password=$(".password").val();


                /*
                 * 1.登陆成功
                 * 2.账号或验证码错误
                 * 3.验证码错误
                 * */
                $.post(
                        "/UserController/login",
                        {"verify":verify,"userId":userId,"password":password},
                        function(data){
                    if(data.code==300){
                        alert("验证码错误");
                    }else if(data.code==100){
                        window.location.href = "/AlbumController/list/"+userId+"/1";
                    }else if(data.code==200){
                        alert("账号或密码错误");
                    }else if(data.code == 400){
                        alert(data.message);
                    }


                    changeCode();		//更换验证码
                });

            }



            //================更换验证码======
            function changeCode(){
                $(".imgcode").attr('src','${pageContext.request.contextPath}/codeController/code?date='+new Date().getTime());
            }

        </script>


    </body>



</html>





