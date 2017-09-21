

$(function(){
	
	getAuthority();		//显示右侧功能表
	
	getNowFormatDate();	//显示登录时间
	
	adminName();		//显示上方管理员姓名
	
	
	
});

//显示上方管理员姓名
function adminName(){
	$.post("authority/adminName",{},function(data){
		
		var name2="";
		var name1=$("#name1");
		var items=data.extend.admin;
		if(data.code==100){
			name2=items.name;
			name1.html(name2);
		}else{
			aler("登录信息有误！");
		}
	})
}


//显示登录时间
function getNowFormatDate() {
	var data1=$("#data1");
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = "本次登录时间："+date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    
    data1.html(currentdate);
    
}

function openPage(url){
	$.get(url+".html",{},function(data){
		$("#openpage").html(data);
	});
}

//显示右侧功能表
function getAuthority(){
	$.post("authority/getAuthorityByRolesid",{},function(data){
		
		if(data.code==200){
			location.href="adminLogin.html";
		}else{
			var items=data.extend.author;
			var msg="";
			var nav=$("#nav_dot");
			for(var i=0;i<items.length;i++){
				if(items[i].pid==0){
					var l=i+1;
					msg+='<li><h4 class="M'+l+'"><span></span>'+items[i].name+'</h4><div class="list-item none">';
					for(var j=0;j<items.length;j++){
						if(items[i].id==items[j].pid){
							msg+='<a href="javascript:openPage(&quot;'+items[j].url+'&quot;)">'+items[j].name+'</a>';
						}
					}
					msg+="</div></li>";
				}
			}
			nav.html(msg);
		}
		});	
}


