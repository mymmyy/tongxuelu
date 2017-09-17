/**
 * Created by mym on 2017/9/12.
 */

$(document).ready(function () {



    //添加相册下拉选择框改变值触发事件，判断是否要显示设置问题和答案
    $(".urlField").find("select").change(function () {
        if($(this).val() == "1"){
            $("#viewIssue").parent().parent().fadeIn(100);
            $("#viewKey").parent().parent().fadeIn(100);
        }else {
            $("#viewIssue").parent().parent().fadeOut(100);
            $("#viewKey").parent().parent().fadeOut(100);
        }
    })


    $("#album_add_button").click(function () {
        if($("#albumName").val() == "" || $("#albumName").val() == null) {
            alert("请输入相册名称！");
            return false;
        }


        if($(".urlField").find("select").val() == "1"){
            if($("#viewIssue").val() == "" || $("#viewIssue").val() == null){
                alert("请输入访问问题！");
                return false;
            } 
            if($("#viewKey").val() == "" || $("#viewKey").val() == null){
                alert("请输入访问答案！");
                return false;
            } 
        }

        $("#addForm").submit();
    })


    //编辑按钮
    $(".edit_button").click(function () {
        var albumId = $(this).prev().val();

        var contentDiv = $(".md-effect-3-content");

        contentDiv.html("");//先清空

        
        $.ajax({ 
            url: "/AlbumController/album/"+albumId,
            type:"GET",
            success: function(data){

                if(data.code == 200){
                    contentDiv.html("获取相册信息失败！请稍后再试！")
                }else{
                    console.log(data.extend.album);
                    contentDiv.append(constructEditForm(data));
                    
                }
            }
        });
    });







    //确认编辑
    $(".confirm_the_change").click(function () {
        var editForm = $(".md-effect-3-content").find("form").eq(0);
        editForm.submit();
    })



    //下拉选择框事件
    $(".md-effect-3-content").find("select").eq(0).on('change',function (){
        alert("asgasd");
    });




    //==========================删除相册=================
    /*$(".confirm_the_edit").click(function () {
       $(".delete_form").submit();
    })*/
    $(".delete_button").click(function () {
        var flag = window.confirm("相册中的所有相片也会删除，确认要删除？");
        if(flag){
            return true;
        }
        return false;
    })


});




//构建表单
function constructEditForm(data) {
/*<form action="" class=".form-horizontal">
        <input type="text" name="albumName" class="form-control" placeholder="相册名称">
        <select class="form-control" name="viewLock">
        <option value="0">仅自己</option>
        <option value="1">回答问题</option>
        <option value="2">好友可见</option>
        <option value="3">所有人</option>
        </select>
        <input type="text" name="viewIssue" class="form-control" placeholder="访问问题">
        <input type="text" name="viewKey" class="form-control" placeholder="访问答案">
        </form>*/

    var form = $("<form action='/AlbumController/album' class='form-horizontal edit_form' method='post'></form>");
    var methodInput = $("<input type='hidden' name='_method' value='PUT'/>")
    var albumNameInput = $("<input type='text' name='albumName' value='"+data.extend.album.albumName+"' class='form-control' placeholder='相册名称'>");
    var albumIdInput = $("<input type='hidden' name='albumId' value='"+data.extend.album.albumId+"'>");

    var select = $("<select class='form-control' name='viewLock'></select>");


    var arr = new Array("仅自己","回答问题","好友可见","所有人");


    for(var i=0;i<4;i++){

        if(data.extend.album.viewLock == i){
            select.append($("<option value='"+i+"' selected></option>").append(arr[i]));
        }else{
            select.append($("<option value='"+i+"'></option>").append(arr[i]));
        }

    }

    var viewIssueInput = $("<input type='text' name='viewIssue' value='"+data.extend.album.viewIssue+"' class='form-control' placeholder='访问问题'>");
    var viewKeyInput = $("<input type='text' name='viewKey' value='"+data.extend.album.viewKey+"' class='form-control' placeholder='访问答案'>");


    form.append(methodInput);
    form.append(albumNameInput);
    form.append(albumIdInput);
    form.append(select);
    form.append(viewIssueInput);
    form.append(viewKeyInput);
    form.append($("<span style='color: #85878c'>提示：如果选择【回答问题】则请输入问题和答案</span>"))
    return form;
}