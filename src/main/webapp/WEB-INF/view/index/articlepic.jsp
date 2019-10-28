<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" align="center">
		<h1>${article.title }</h1>
		<dl>
			<dd style="color: gray;">${article.user.username }
				&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:formatDate value="${article.created }"
					pattern="yy-MM-dd HH:mm:ss" />
			</dd>
		</dl>


		<div class="bd-example">

			<div id="carouselExampleCaptions" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<c:forEach items="${articlepic }" var="a" varStatus="count">
						<li data-target="#carouselExampleCaptions"
							data-slide-to="${count.index }"
							class="${count.index==0?'active':'' }"></li>
					</c:forEach>
				</ol>

				<div class="carousel-inner">

					<c:forEach items="${articlepic }" var="a" varStatus="count">
						<div class="carousel-item ${count.index==0?'active':'' }">
							<img src="/pic/${a.url }" class="d-block w-100" alt="...">
							<div class="carousel-caption d-none d-md-block">
								<h5>${a.descipt }</h5>
							</div>
						</div>
					</c:forEach>
				</div>

				<a class="carousel-control-prev" href="#carouselExampleCaptions"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>


		<!-- 评论 -->
		<div class="form-group">
			<label for="commons" style="font-size: 20px;">评论</label>
			<textarea rows="2" cols="100" class="form-control" id="commons"></textarea>
			<input type="button" value="发表评论" class="btn btn-info" />
		</div>
	</div>
</body>
</html>