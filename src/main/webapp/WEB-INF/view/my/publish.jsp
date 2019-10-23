 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="/resource/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/resource/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="/resource/kindeditor/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="/resource/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="/resource/kindeditor/lang/zh-CN.js"></script>
	<script
		src="/resource/js/jquery-3.2.1.js"></script>

	<script>
		KindEditor.ready(function(K) {
			window.editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/resource/kindeditor/plugins/code/prettify.css',
				uploadJson : '/resource/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		function query(){
			alert(editor1.html())
			//alert( $("[name='content1']").attr("src"))
		} 
	</script>
</head>
<body>
	<form id="form1">
		<div class="form-group">
			<label for="title"><span style="color:blue;font-size: 15px;font-weight: bold">标题</span></label>
			<input type="text" name="title" id="title" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="centent"><span style="color:blue;font-size: 15px;font-weight: bold">文章内容</span></label>
			<textarea rows="10" id="centent" cols="30" name="content1" style="width: 825px;"></textarea>
		</div>
		
		<!--导航栏  -->
		<div class="form-group form-inline">
		<label for="channelId">所属栏目<span style="font-weight: bold;font-size: 20px">:</span></label>
			<select class="form-control form-control-sm" name="channelId" id="channelId">
			  <option>请选择</option>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;
		<label for="categoryId">所属类型<span style="font-weight: bold;font-size: 20px">:</span></label>
			<select class="form-control form-control-sm" name="categoryId" id="categoryId">
			  <option>请选择</option>
			</select>
		</div>
		<div class="form-group form-inline">
			<label for="picture"><span style="color:blue;font-size: 15px;font-weight: bold">文章头像:</span></label>
			<input type="file" name="file" class="form-control" style="width: 400px"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="btn btn-outline-success" value="发布" onclick="publish()"/>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(function(){
		$.post("/my/selectsChannel",function(channels){
			for (var i = 0; i < channels.length; i++) {
				$("#channelId").append("<option value='"+channels[i].id+"'>"+channels[i].name+"</option>")
			}
			$("#channelId").change(function(){
				var channelId = $(this).val();
				$("#categoryId option:gt(0)").remove();
				$.post("/my/selectscategory",{channelId:channelId},function(categorys){
					for (var i = 0; i < categorys.length; i++) {
						$("#categoryId").append("<option value='"+categorys[i].id+"'>"+categorys[i].name+"</option>")
					}
				})
			})
		})
	})
	function publish(){
		var formData = new FormData($("#form1")[0]);
		formData.set("content",editor1.html());
		$.ajax({
			url:"/my/publish",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(flag){
				if(flag){
					alert("发布成功");
					location.href="/my"
				}else{
					alert("发布失败,请重新登录账号后再试试");
				}
			}
		})
	}
</script>
</html>

<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>