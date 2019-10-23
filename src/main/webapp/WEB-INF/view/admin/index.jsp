<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员后台</title>

<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入  css -->
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<!-- 后台页面样式模板 -->
<link rel="stylesheet" href="/resource/css/sb-admin.css">
<link rel="stylesheet" href="/resource/css/all.min.css">
<link rel="stylesheet" href="/resource/css/cms.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<style type="text/css">
	.div1_relative{
		position:absolute;
		left:0px;
		top:0px;
	}
</style>
</head>
<body>
	<!--top -->
	<div class="div1">
		<jsp:include page="top.jsp"></jsp:include>
	</div>

	<div id="wrapper">
		<!-- 后台管理系统左册菜单 -->
		<jsp:include page="left.jsp" />
		<!-- 中间内容显示区域 -->
		<div id="content-wrapper">
			<div align="center"  >
				<img alt="" src="/resource/images/bg_admin.jpg"
					class="rounded-circle">
			</div>
		</div>
	</div>
 <script type="text/javascript">
 $(function(){
	 $(".nav-link").click(function(){
		var lis = $("ul li a");
		$(lis).removeClass("list-group-item-danger");
		$(this).addClass("list-group-item-danger");
		var date = $(this).attr("data");
		$("#content-wrapper").load(date);
	 })
 })
</script>
</body>
</html>