<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入  css -->
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<!-- 后台页面样式模板 -->
<link rel="stylesheet" href="/resource/css/sb-admin.css">
<link rel="stylesheet" href="/resource/css/all.min.css">
</head>
<body>
	<div class="container">
	<h1 align="center">专题文章设置</h1>
	<br>
		<table style="border: none;">
			<tr>
			<tr><td><span style="color:red">专题名称:</span>${special.title }</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><span style="color:red">专题摘要:</span>${special.abstracts }</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><span style="color:red">专题文章:</span></td></tr>
			<tr><td>&nbsp;</td></tr>
		</table>
		
		<table class="table table-striped table-bordered">
			<tr>
				<td>文章ID</td>
				<td>文章标题</td>
				<td>文章发布时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${special.articles }" var="a">
				<tr>
					<td>${a.id }</td>
					<td>${a.title }</td>
					<td><fmt:formatDate value="${a.created }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td><a href="#">移除</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="form-group form-inline">
			<input type="text" placeholder="文章ID" name="aid" class="form-control"/>
			<button class="btn btn-outline-dark" onclick="addArticle(${special.id})">添加文章</button>
			${error }
		</div>
	</div>
</body>
<script type="text/javascript">
	function addArticle(sid){
		var aid = $("[name=aid]").val();
		if($.trim(aid).length<=0){
			alert("必须输入才能添加在此标题中添加文章");
		}
		$.post("admin/addArticle",{sid:sid,aid:aid},function(flag){
			if(flag){
				alert("操作成功");
				$("#content-wrapper").load("/admin/addArticle?sid="+sid);
			}else{
				alert("没有此文章,或添加失败了,请检查是否有此文章");
			}
		})
	}
</script>
</html>