$(function(){
	getAllHistory();
})

function getAllHistory(){
	$.post("HistoryController/getAllHistory",{},function(data){
		var items=data.extend.list;
		var nav=$("#allhistory");
		var msg="";
		for(var i=0;i<items.length;i++){
			msg+='<tr>';
			msg+='<td>'+items[i].id+'</td>';
			msg+='<td>'+items[i].aid+'</td>';
			msg+='<td>'+items[i].aname+'</td>';
			msg+='<td>'+items[i].operation+'</td>'
			msg+='<td>'+items[i].date+'</td>';
		}
		nav.html(msg);
	})
}