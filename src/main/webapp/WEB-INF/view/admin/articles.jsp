<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	  body{
		background: url("/resource/images/aaa.jpg");
		width: 100%;
		height:100%;
		overflow:hidden;
		background-size: cover;
	}  
</style>
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
	<div class="form-group form-inline">
		<label for="title"><span style="font-family: '楷体';font-size:20px;color: black;" class="font-weight-bolder">标题:</span></label><input type="text" id="title" name="title" value="${article.title }" class="form-control">
		&nbsp;&nbsp;
		<select name="status" class="form-control">
			<option value="0">未审核</option>
			<option value="1">已审核</option>
			<option value="-1">驳回</option>
		</select>
		&nbsp;<button class="btn btn-outline-dark btn-sm" onclick="getArticleByTitle()">查询</button>
	</div>
	<table class="table table-striped">
		<tr align="center" valign="middle">
			<td>序号</td>
			<td>文章标题</td>
			<td>文章作者</td>
			<td>文章发布日期</td>
			<td>文章修改日期</td>
			<td>是否热门</td>
			<td>文章点击量</td>
			<td>文章状态</td>
		</tr>
		<c:forEach items="${articles }" var="a" varStatus="index">
			<tr align="center" valign="middle">
				<td>${index.index+1 }</td>
				<td><a href="javascript:editor(${a.id })" style="color:brown">${a.title }</a></td>
				<td>${a.user.username }</td>
				<td><fmt:formatDate value="${a.created }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${a.updated }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<c:if test="${a.hot==0 }">
						<button class="btn btn-outline-warning" onclick="hot(${a.id},this)">否</button>
					</c:if>
					<c:if test="${a.hot==1 }">
						<button class="btn btn-danger" onclick="hot(${a.id},this)">是</button>
					</c:if>
				</td>
				<td>${a.hits }条点击</td>
				<td>${a.status==0?'未审核':a.status==1?'已审核':'驳回' }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		${pages }
	</div>
</div>
<script type="text/javascript">
$(function(){
	$("[name=status]").val('${article.status}')
})
function getArticleByTitle(){
	var title = $("[name=title]").val();
	var status = $("[name=status]").val();
	$("#content-wrapper").load("/admin/articles?title="+title+"&status="+status);
}
function hot(id,own){
	var hot = $(own).text()=="是"?"0":"1";
	$.post("/admin/updateHot",{id:id,hot:hot},function(flag){
		if(flag){
			$(own).text(hot==0?"否":"是");
			$(own).attr("class",hot==0?"btn btn-outline-warning":"btn btn-danger")
			alert("操作成功");
		}else{
			alert("操作失败");
		}
	})
}
function editor(id){
	var page = '${page}';
	$("#content-wrapper").load("/admin/articleDetail?id="+id+"&page="+page);
}
</script>
</body>
</html>