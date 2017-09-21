$(function(){
	getadmin();
})

function getadmin(){
	$.post("authority/adminName",{},function(data){
		var items=data.extend.admin;
		var nav=$("#tbody");
		var navTr = $("<tr></tr>").appendTo(nav);
		/*var msg="";
		msg+='<tr><td>'+items.id+'</td>';
		msg+='<td>'+items.name+'</td>';
		msg+='<td>'+items.tele+'</td>';
		msg+='<td>'+items.email+'</td>'
		msg+='<td>'+items.rinfo.name+'</td>';
		msg+='</tr>';
		alert(msg);
		navTr.html(msg);*/
		
		navTr.append($("<td>"+items.id+"</td>"));
		navTr.append($("<td>"+items.name+"</td>"));
		navTr.append($("<td>"+items.tele+"</td>"));
		navTr.append($("<td>"+items.email+"</td>"));
		navTr.append($("<td>"+items.rinfo.name+"</td>"));
	})
}