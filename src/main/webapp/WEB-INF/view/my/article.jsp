<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入  css -->
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<!-- 后台页面样式模板 -->
<link rel="stylesheet" href="/resource/css/sb-admin.css">
<link rel="stylesheet" href="/resource/css/all.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<br>
		<div align="right">
			<button class="btn btn-outline-dark" onclick="back()">返回</button>
		</div>
		<h3>${article.title }</h3>
		<br>
		<dl>
			<dd style="color: gray;">${article.user.username }   &nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${article.created }" pattern="yy-MM-dd HH:mm:ss"/> 
				标签:${article.terms }
			</dd>
		</dl>
		<hr>
		<hr>
			${article.content}
	</div>
</body>
<script type="text/javascript">
	function back(){
		var page='${page}';
		$("#center").load("/my/selectsByUser?page="+page);
	}
</script>
</html>