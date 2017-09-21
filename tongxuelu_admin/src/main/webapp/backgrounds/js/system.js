$(function(){
	initRole();
	initSystem();
})

/*角色*/
function initRole(){
	$.post("authority/selectRolesAll",{},function(data){
		var msg="";
		msg+='<select id="rid" onchange="bindSystem()">'
		for(var i=0;i<data.length;i++){
			msg+='<option value="'+data[i].id+'">'+data[i].name+"</option>";
		}
		msg+="</select>";
		$("#div1").html(msg);
	})
}

/*给角色绑定权限*/

function bindSystem(){
	var rid=$("#rid").val();
	$.post("authority/getAuthorityByRid",{"rid":rid},function(data){
		$(":checkbox").removeProp("checked")
		for(var i=0;i<data.length;i++){
			$("#"+data[i].id).prop("checked","true")
		}
	})
}

/*所有权限*/
function initSystem(){
	$.post("authority/selectAuthorityAll",{},function(data){
		var msg="";
		for(var i=0;i<data.length;i++){
			if(data[i].pid==0){
				msg+='<dl><dt><input type="checkbox" id="'+data[i].id+'" value="'+data[i].id+'"/>'+data[i].name+"</dt><dd>";
				for(var j=0;j<data.length;j++){
					if(data[i].id==data[j].pid){
						msg+='<input type="checkbox" id="'+data[j].id+'" value="'+data[j].id+'"/>'+data[j].name;
					}
					
				}
				msg+='</dd></dl>';
			}
		}
		msg+='<input type="button" value="添加权限" onclick="setRoleSystem()">';
		$("#div2").html(msg);
	})
}


function setRoleSystem(){
	var rid=$("#rid").val()
	var items="";
	$("input:checked").each(function(){
		items+=this.value+",";
	})
	$.get("authority/updateRoleSystem",{"rid":rid,"items":items},function(data){
		if(data==1){
			initRole();
		}else{
			alert("添加失败")
		}
	})
}