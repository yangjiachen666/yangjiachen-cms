<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入  css -->
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<!-- 后台页面样式模板 -->
<link rel="stylesheet" href="/resource/css/sb-admin.css">
<link rel="stylesheet" href="/resource/css/all.min.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/cms.js"></script>
</head>
<body>
	
<div class="container">
	<h1 align="center">专题管理</h1>
	<button class="btn btn-outline-dark" onclick="addSpecial()">添加专题</button>
	<table class="table table-striped table-bordered">
		<tr align="center" valign="middle">
			<td>专题标题</td>
			<td>专题文章</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${speciala }" var="s" varStatus="index">
			<tr align="center" valign="middle">
				<td>${s.title }</td>
				<td>${s.count }篇</td>
				<td>
					<a href="/admin/addArticle?sid=${s.id }">追加文章</a>
					<a href="/admin/update?sid=${s.id }">修改专题</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
<script type="text/javascript">
	function addSpecial(){
		$("#content-wrapper").load("/admin/addSpeciala");
	}
</script>
</body>
</html>