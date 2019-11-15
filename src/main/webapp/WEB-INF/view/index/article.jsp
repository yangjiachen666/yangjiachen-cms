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
<meta name="keywords" content="${article.keywords}" />
<meta name="description" content="${article.summary}" />
<!-- 引入  css -->
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<!-- 后台页面样式模板 -->
<link rel="stylesheet" href="/resource/css/sb-admin.css">
<link rel="stylesheet" href="/resource/css/all.min.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" align="center">
		<h1>${article.title }</h1>
		<dl>
			<dd style="color: gray;">${article.user.username }   &nbsp;&nbsp;&nbsp;<fmt:formatDate value="${article.created }" pattern="yy-MM-dd HH:mm:ss"/> 
				&nbsp;&nbsp;&nbsp;标签:&nbsp;${article.terms } &nbsp;&nbsp;&nbsp;来源:&nbsp;${article.keywords }
			</dd>
			<dd style="width: 700px">${article.content }</dd>
		</dl>
		<c:if test="${sessionScope.user!=null }">
			<div class="form-group">
				<label for="commons" style="font-size: 20px;">评论</label>				
				<textarea rows="2" cols="100" class="form-control" name="content" id="commons"></textarea>
				<input type="button" value="发表评论" class="btn btn-info" onclick="comment()"/>
			</div>
		</c:if>
		<c:if test="${sessionScope.user==null }">
			<span style="color:red">请先登录在来评论</span>	
		</c:if>
			<h1 align="center">评论</h1>
			<dl>
				<c:forEach items="${comments }" var="c">
					<dt style="text-align: left">${c.user.username } <fmt:formatDate value="${c.created }" pattern="yyyy-MM-dd HH:mm:ss"/> </dt>
					<dd style="text-align: left">${c.content }</dd>
					<hr>
				</c:forEach>
				<dd>${pages }</dd>
			</dl>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$(".page-link").click(function(){
			var url = $(this).attr("data");
			location.href=url;
		})
	})

	function comment(){
		var id = '${article.id}';
		var content = $("[name=content]").val();
		$.post("addComment",{articleId:id,content:content},function(flag){
			if(flag){
				alert("评论成功");
				location.href="/select?id="+id;
			}else{
				alert("评论失败");
			}
		})
	}
</script>
</html>