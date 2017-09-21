<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/tongxuelu/static/img/jquery.js" type="text/javascript"></script>
<script src="/tongxuelu/static/img/v2js.js" type="text/javascript"></script>
<link href="/tongxuelu/static/img/css.css" rel="stylesheet">
<script type="text/javascript" src="/tongxuelu/static/js/jquery-2.0.2.min.js"></script>
<script type="text/javascript" src="/tongxuelu/static/js/kkpager.min.js"></script>
<link rel="stylesheet" type="text/css" href="/tongxuelu/static/css/kkpager_orange.css" />
<script type="text/javascript" src="/tongxuelu/static/js/space.js"></script>
</head>
<script>
var totalPage = 0;//总页码
var totalRecords = 0;//总记录数
var pageNo = 1;//开始页码
var pageCount = 5;//每页条数
$(function(){
	$.getJSON("/tongxuelu/space/leaveWord/selectCount",function(result){//获取条数
		totalRecords = parseInt(result.extend.count);
		getLeaveWord(((pageNo-1)*pageCount),pageCount);//获取第一页信息
	});
	$("#submit").click(function(){
		var msg = $("#msg").val().trim();
		var nameHidden = "1";
		if(msg!=""||msg.length>250){
			if($("#niming:checked").length>0){//判断匿名是否选中
				nameHidden = "0";//"0"表示匿名
			}
			$.post("/tongxuelu/space/leaveWord/addLeaveWord",{
				leaveWordContent:$("#msg").val(),
				isNameHidden:nameHidden
			},function(data){
				if(data.code=="100"){
					alert("留言成功");
					$("#msg").val("");
					totalRecords=totalRecords+1;//条数加一,防止js中条数还是为零无法更新
					getLeaveWord(((pageNo-1)*pageCount),pageCount);//更新第一页信息
				}else{
					alert("留言失败");
				}
			},"json");
		}
		else if(msg==""){
			alert("留言内容不能为空");
		}else{
			alert("留言字数太多");
		}
	});
});
function getLeaveWord(start,end){
	if(totalRecords>0){//如果条数大于零
		$.ajax({
			type: "post",
			url: "/tongxuelu/space/leaveWord/selectLeaveWord?start="+start+"&end="+end,
			dataType: 'json',
			async:true,
			success: function(data) {
				var msg = "";
				$.each(data.extend.list,function(i,item){
					msg += "<div class='c_list clf'>";
					if(item.isNameHidden=="1"){//判断是否匿名,1表示不匿名
						msg += "<div class='c_hpic'><a href='/tongxuelu/space/homepage/"+item.leaveUserId+"'><img src='/tongxuelu/static/img/head_snew.jpg' alt='头像' height='50' width='50'></a></div>";
					    msg += "<div class='c_fr'>";
					    msg += "<p class='c_meta'><a href='/tongxuelu/space/homepage/"+item.leaveUserId+"' style='color:blue;'>"+item.leaveUserId+"</a>";
					}
					else{
						msg += "<div class='c_hpic'><img src='/tongxuelu/static/img/head_snew.jpg' alt='头像' height='50' width='50'></div>";
					    msg += "<div class='c_fr'>";
					    msg += "<p class='c_meta' style='color:blue;'>匿名网友";
					}
				    msg +="<span class='c_time'>"+item.leaveWordTime+"</span> </p>";
				    msg += " <div class='c_nr'>"+item.leaveWordContent+"</div>";
				    msg += "</div></div>";
				});
				 msg +="<div style='width:1000px;margin:10px auto;'>";
	             msg +="<div id='kkpager'></div></div>";
				 $(".comm_content").html(msg);
				 producePage();//生成分页导航
			}  
		});
	}
	else{
		var msg = "<div class='c_list clf'><font size='3'  color='#4B97D5'>该用户还没有留言,快去下方给他留言吧</font></div>"
		$(".comm_content").html(msg);
	}
}
//生成分页导航
function producePage(){
	    totalPage = Math.ceil(totalRecords/pageCount);
		kkpager.generPageHtml({
			pno : pageNo,
			//总页码
			total : totalPage,
			//总数据条数
			totalRecords : totalRecords,
			mode : 'click',//默认值是link，可选link或者click
			click : function(n){
				// do something
				//手动选中按钮
				this.selectPage(n);
				pageNo = n;
				getLeaveWord(((pageNo-1)*pageCount),pageCount);
			}
		});
}
</script>
<body>
<div id="main">
  <div class="layout-head w960">
    <div class="head-info">
      <h1>${sessionScope.spaceUser.nickname}的空间</h1>
      <div class="head-description">${sessionScope.spaceUser.signal}</div>
    </div>
  </div>
  <div class="head_nav">
    <div class="nav_bg"></div>
    <div class="w960">
      <div class="head-name"><span class="user-name textoverflow">${sessionScope.spaceUser.nickname}</span>
        <div class="head-description">http://www.chenbo.com/</div>
      </div>
     <div class="actions"><a href="javascript:void(0)" id="concern" class="a-gz" style="background-color:#84E18D;">+加为好友</a> </div>
      <ul>
         <li><a href="${pageContext.request.contextPath}/space/homepage/${sessionScope.spaceUser.userId}">主页</a></li>
        <li><a href="${pageContext.request.contextPath}/space/bookList/${sessionScope.spaceUser.userId}">我的文章</a></li>
        <li><a href="${pageContext.request.contextPath}/space/leaveWord/${sessionScope.spaceUser.userId}">留言板</a></li>
        <li><a href="${pageContext.request.contextPath}/space/logwrite/${sessionScope.spaceUser.userId}">写文章</a></li>
          <li><a href="${pageContext.request.contextPath}/space/myFriend/${sessionScope.spaceUser.userId}">我的好友</a></li>
      </ul>
      <div class="head-avatar"><img src="/tongxuelu/static/img/head_snew.jpg" alt=""></div>
    </div>
  </div>
  <div class="layout-body">
    <div class="w960  clf">
      <div class="m_left">
        <div class="inner pd1">
           <ul class="stats-list clf">
            <li style="width:130px;"><strong id='friendCount'>16</strong><span>我的好友</span></li>
            <li ><strong id='articleCount' style="margin-left:30px;">174</strong><span style="margin-left:30px;">我的文章</span></li>
          </ul>
        </div>
        <div class="inner mt12 p0">
          <div class="hd">
            <h3>个人信息</h3>
          </div>
          <div class="bd">
            <ul class="detail-list">
              <li><i class="i-nc"></i>昵称：<span>${sessionScope.spaceUser.nickname}</span></li>
              <li><i class="i-dj"></i>职业：<span>${sessionScope.spaceUser.profession}</span></li>
              <li><i class="i-ip"></i>个性签名：<span>${sessionScope.spaceUser.signal}</span></li>
              <li class="born"><a href="/tongxuelu/space/info/${sessionScope.existUser.userId}">查看详细资料</a></li>
            </ul>
          </div>
        </div>
        <div class="inner mt12 p0">
          <div class="hd">
            <h3>最近访客</h3>
          </div>
          <div class="bd">
            <ul class="avatar-list clf">
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
              <li><a href="#" target="_blank"><img src="/tongxuelu/static/img/head_snew.jpg" alt="十二的头像">
                <div class="a-name">十二</div>
                </a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="m_main">
        <div class="inner">
          <div class="hd">
            <h3>会员的留言本</h3>
          </div>
          <div class="comm_content"><!-- 留言板 -->
            
          </div>
        </div>
        <div class="inner">
          <div class="hd">
            <h3>给我留言(最多250字)</h3>
          </div>
          <div class="quote_f">
            <form action="#" name="form1" method="post">
              <input name="action" value="guestbooksave" type="hidden">
              <textarea style="color: rgb(0, 0, 0);" cols="60" name="msg" rows="5" id="msg" onfocus="iCc(this)"></textarea>
              <br>
			  <input  value="1" style="zoom:130%;" id="niming"  type="checkbox"><font size="4px">是否匿名</font>&nbsp;
              <input id="submit" value="提&nbsp;交" class="anbu" type="button">&nbsp;
			  <input id="reset" value="重&nbsp;置" class="anbu" type="reset">
            </form> 
          </div>
        </div>
      </div>
    </div>
    <div id="footer">Copyright &#169; 2014 www.5imb.com 版权所有</div>
  </div>
</div>
</body>
</html>