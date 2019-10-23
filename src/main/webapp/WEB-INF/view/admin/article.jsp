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
		<div align="right">
			<button class="btn btn-secondary" onclick="check(1)">通过</button>
			<button class="btn btn-danger" onclick="check(-1)">驳回</button>
			<button class="btn btn-dark" onclick="back()">返回</button>
		</div>
		<div>
			<h3>${article.title }</h3>
			<br>
			<dl>
				<dd style="color: gray;">${article.user.username }   &nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${article.created }" pattern="yy-MM-dd HH:mm:ss"/> </dd>
			</dl>
			<hr>
			<hr>
				${article.content}
		</div>
	</div>
</body>
<script type="text/javascript">
	function back(){
		var page = '${page}';
		$("#content-wrapper").load("/admin/articles?page="+page);
	}
	function check(status){
		var id = '${article.id}';
		$.post("/admin/updateArticle",{status:status,id:id},function(flag){
			if(flag){
				alert("操作成功");
				$("#content-wrapper").load("/admin/articles");
			}else{
				alert("操作失败");
			}
			
		})
	}
</script>
</html>