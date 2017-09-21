$(function(){
	inittable();
})

function getAllAdmin(){
	$.post("administrator/getAllAdmin",{},function(data){
		alert(data);
	})
}

function inittable(){
	alert("a");
	$("#tb1").datagrid({
		
		url:"administrator/getAllAdmin.json",
		columns:[[    
			        {field:'id',title:'编号',width:100,sortable:true},    
			        {field:'name',title:'名称',width:100},    
			        {field:'tele',title:'联系电话',width:100},
			        {field:'email',title:'邮编',width:100}
			    ]],
	    fitColumns:true,
		pagination:true,
		rownumbers:true
	});
}