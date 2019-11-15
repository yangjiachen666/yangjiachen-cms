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
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入  css -->
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<!-- 后台页面样式模板 -->
<link rel="stylesheet" href="/resource/css/sb-admin.css">
<link rel="stylesheet" href="/resource/css/all.min.css">
<link rel="stylesheet" type="text/css" href="/resource/css/jquery/screen.css" />
	
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/cms.js"></script>
</head>
<body>
	<form id="form1">
		<div class="form-group">
			<label for="text"><span style="color:blue;font-size: 15px;font-weight: bold">友情链接文本</span></label>
			<input type="text" name="text" id="text" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="url"><span style="color:blue;font-size: 15px;font-weight: bold">友情链接地址</span></label>
			<input type="text" name="url1" id="url" class="form-control"/>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-outline-success" value="添加友情链接"/>
		</div>
	</form>
	<div>
		<jsp:include page="/WEB-INF/view/common/footer.jsp"/>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#form1").validate({
			rules:{
				url1:{
					required:true,
					url:true,
				},
				text:{
					required:true,
				}
			},
			messages:{
				url1:{
					required:"必须输入友情连接地址",
					url:"请输入正确的地址信息",
				},
				text:{
					required:"友情连接文本必须输入",
				}
			},
			submitHandler:function(){
				$.post("/admin/addlink",$("#form1").serialize(),function(flag){
					if(flag){
						alert("添加友情链接成功");
						$("#content-wrapper").load("/admin/links/selects");
					}else{
						alert("添加友情链接失败");	
					}
				})
			}
		})
	})
</script>
</html>