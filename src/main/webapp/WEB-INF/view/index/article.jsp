<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<div class="container" align="center">
		<h1>${article.title }</h1>
		<dl>
			<dd style="color: gray;">${article.user.username }   &nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${article.created }" pattern="yy-MM-dd HH:mm:ss"/> 
				标签:${article.terms }
			</dd>
			<dd style="width: 700px">${article.content }</dd>
		</dl>
			<div class="form-group">
				<label for="commons" style="font-size: 20px;">评论</label>				
				<textarea rows="2" cols="100" class="form-control" id="commons"></textarea>
				<input type="button" value="发表评论" class="btn btn-info"/>
			</div>
	</div>
</body>
</html>