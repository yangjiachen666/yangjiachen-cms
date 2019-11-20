<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript">
	$(function(){
		$(".page-link").click(function(){
			var url = $(this).attr("data");
			$("#center").load(url);
		})
	})
</script>
</head>
<body>
<br>
<div class="container">
	<div class="form-group form-inline">
		<label for="title"><span style="font-family: '楷体';font-size:20px;color: red;" class="font-weight-bolder">标题:</span></label>
		<input type="text" id="title" name="title" value="${article.title }" class="form-control">
		&nbsp;&nbsp;
		<select name="status" class="form-control">
			<option value="0">未审核</option>
			<option value="1">已审核</option>
			<option value="-1">驳回</option>
		</select>&nbsp;
		<label for="terms"><span style="font-family: '楷体';font-size:20px;color: red;" class="font-weight-bolder">文章标签:</span></label>
		<input type="text" id="terms" name="terms" class="form-control" value="${article.terms }"/>
		&nbsp;<button class="btn btn-outline-primary btn-sm" onclick="getArticleByTitle()">查询</button>
	</div>
	<table class="table table-striped table-bordered" style="font-size: 12px;">
		<tr align="center" valign="middle">
			<td>序号</td>
			<td>文章标题</td>
			<td>文章作者</td>
			<td>是否热门</td>
			<td>标签</td>
			<td>文章状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${articles }" var="a" varStatus="index">
			<tr align="center" valign="middle">
				<td>${index.index+1 }</td>
				<td><a href="javascript:detail(${a.id })">${a.title }</a></td>
				<td>${a.user.username }</td>
				<td>
					<c:if test="${a.hot==0 }">
						否
					</c:if>
					<c:if test="${a.hot==1 }">
						是
					</c:if>
				</td>
				<td>${a.terms }</td>
				<td>${a.status==0?'未审核':a.status==1?'已审核':'驳回' }</td>
				<td>
					<button onclick="updateArticle(${a.id})" class="btn-light">修改</button>
					<button onclick="delArticle(${a.id})" class="btn-info">撤销</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		${pages }
	</div>
</div>
</body>
<script type="text/javascript">
	function getArticleByTitle(){
		var title = $("[name=title]").val();
		var status = $("[name=status]").val();
		var terms = $("[name=terms]").val();
		$("#center").load("/my/selectsByUser?title="+title+"&status="+status+"&terms="+terms);
	}
	$(function(){
		$("[name=status]").val('${article.status}')
	})
	function detail(id){
		var page = '${page}';
		$("#center").load("/my/articleDetail?id="+id+"&page="+page);
	}
	function updateArticle(id){
		var url = "/my/publish?id="+id;
		$("#center").load(url);
	}
	function delArticle(id){
		var page = '${page}';
		$.get("/my/delArticle",{id:id},function(flag){
			if(flag){
				alert("撤销成功");
				$("#center").load("/my/selectsByUser?page="+page);
			}else{
				alert("撤销失败");
			}
		})
	}
</script>
</html>