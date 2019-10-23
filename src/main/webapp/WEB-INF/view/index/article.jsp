<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h1>${article.title }</h1>
		<dl>
			<dd style="color: gray;">${article.user.username }   &nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${article.created }" pattern="yy-MM-dd HH:mm:ss"/> </dd>
			<dd style="width: 700px">${article.content }</dd>
		</dl>
	
	</div>
</body>
</html>