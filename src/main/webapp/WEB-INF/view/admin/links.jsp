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
	<input type="button" class="btn btn-outline-success" value="点击添加友情连接" onclick="addlink()"/>
	<table class="table table-striped table-bordered">
		<tr align="center" valign="middle">
			<td>序号</td>
			<td>友情连接文本</td>
			<td>友情连接地址</td>
			<td>添加日期</td>
		</tr>
		<c:forEach items="${friendlys }" var="f" varStatus="index">
			<tr align="center" valign="middle">
				<td>${index.index+1 }</td>
				<td>${f.text }</td>
				<td>${f.url }</td>
				<td><fmt:formatDate value="${f.created }" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		${pages }
	</div>
</div>
<script type="text/javascript">
	function addlink(){
		$("#content-wrapper").load("/admin/addlinks");		
	}
</script>
</body>
</html>