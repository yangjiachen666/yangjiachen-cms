<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>用户展示界面</title>
</head>
<body>
		<div>
			<jsp:include page="/WEB-INF/view/common/top.jsp"/>
		</div>
	<div class="container">
		<br>
		
		<!-- 左侧栏目栏 -->
		<div class="row">
			<div class="col-md-2" align="center">
					<ul class="list-group">
						  <li style="list-style: none">
						  	<span class="channel"style="color:red;font-size:35px;">CMS</span>
						  </li>
					 </ul>
					 <br>
					<ul class="list-group">
						  <li style="width:110px;height: 40px;list-style: none;padding-top: 5px;margin-top: 5px; " class="cms-list-group-item-action ${article.channelId==null?'cms-list-group-item-active':''}  ">
						    <a class="channel" style="color: black" href="?hot=1">热门</a>
						  </li>
					 </ul>
				<ul class="list-group">
					<c:forEach items="${channels }" var="c">
						  <li style="width:110px;height: 40px; list-style: none;padding-top:5px;margin-top: 5px" class="cms-list-group-item-action ${c.id==article.channelId?'cms-list-group-item-active':'' }">
						    <a class="channel" style="color: black" href="?channelId=${c.id }">${c.name }</a>
						  </li>
					</c:forEach>
				 </ul>
			</div>
			<div class="col-md-7 min_h_500">
			
			
			<!-- 展示分类文章 -->
		<c:if test="${article.channelId!=null }">
				<div class="nav nav-tabs">
					<ul class="nav">
						<li class="nav-item">
							<a class="nav-item nav-link ${article.categoryId==null?'active':'' }" href="?channelId=${article.channelId }">全部</a>
						</li>
						<c:forEach items="${categorys }" var="c">
								<li class="nav-item">
							   	 	<a class="nav-item nav-link ${c.id==article.categoryId?'active':'' }" href="?channelId=${article.channelId}&categoryId=${c.id}">${c.name }</a>
							 	</li>
						</c:forEach>
					</ul>
				</div>
				<br>
				<div>
					<!-- 发布文章 -->
					<c:forEach items="${articles}" var="a">
						<div class="media">
							<img alt="" src="/pic/${a.picture }" class="mr-3"  style="width:190px; height: 124px;">
							 <div class="media-body">
							 	  <h1 class="mt-0"><a style="color:black" href="select?id=${a.id }" target="blank">${a.title }</a></h1>&nbsp;&nbsp;&nbsp;&nbsp;
							 	  <span style="color:gray;font-size: 15px">作者:${a.user.username } &nbsp;&nbsp; ${a.hits }条评论  &nbsp;&nbsp;&nbsp; <fmt:formatDate value="${a.created }" pattern="yy-MM-dd HH:mm:ss"/> </span> 
							 </div>
						</div>
						 <hr>
					</c:forEach>
				</div>
					<div>
						${pages }
					</div>
				</c:if>
		
		
			<!-- 热门文章和轮播图 -->
		<c:if test="${article.channelId==null }">
		
		
		<!-- 轮播图 -->
			<div class="bd-example">
			  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
				      <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
				      <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
				      <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
				    </ol>
			    <div class="carousel-inner">
			      <div class="carousel-item active">
			        <img src="/pic/1.jpg" class="d-block w-100" alt="...">
			        <div class="carousel-caption d-none d-md-block">
			          <h5>图一</h5>
			        </div>
			      </div>
			      <div class="carousel-item">
			        <img src="/pic/2.jpg" class="d-block w-100" alt="...">
			        <div class="carousel-caption d-none d-md-block">
			          <h5>图二</h5>
			        </div>
			      </div>
			      <div class="carousel-item">
			        <img src="/pic/3.jpg" class="d-block w-100" alt="...">
			        <div class="carousel-caption d-none d-md-block">
			          <h5>图三</h5>
			        </div>
			      </div>
			    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
 		 </div>
	</div>
			<br>
			
			
			<!-- 文章展示 -->
				<div style="margin-left: 10px">
					<!-- 热门文章 -->
					 <c:forEach items="${hotarticles}" var="a">
						<div class="media">
							<img alt="" src="/pic/${a.picture }" class="mr-3"  style="width:190px; height: 124px;">
							 <div class="media-body">
							 	  <h1 class="mt-0"><a style="color:black" href="select?id=${a.id }" target="blank">${a.title }</a></h1>&nbsp;&nbsp;&nbsp;&nbsp;
							 	  <span style="color:gray;font-size: 15px">作者:${a.user.username } &nbsp;&nbsp; ${a.hits }条评论  &nbsp;&nbsp;&nbsp; <fmt:formatDate value="${a.created }" pattern="yy-MM-dd HH:mm:ss"/> </span> 
							 </div>
						</div>
						 <hr>
					</c:forEach> 
					
					<div>
						${pages }
					</div>
				</div>
			</c:if>
			</div>
			
			
			<!-- 24小时热门.最新文章 -->
			
			<div class="col-md-3 split min_h_500">
				<div class="card" style="width: 20rem;">
					<div class="card-header" style="background-color: light gray;"><b style="font-size: 15px;">24小时热门</b></div>
					<div class="card-body" style="background-color:#f8f9fa;">
					<c:forEach items="${article24 }" var="a" varStatus="count">
					    		<div class="media">
								    <img src="/pic/${a.picture }" class="mr-3" alt="..." style="width: 50px;height: 50px;">
								    <div class="media-body">
								    	<h5 class="mt-0" style="font-size: 12px;"><a style="color:black" href="select?id=${a.id }" target="blank">${a.title }</a></h5>
									</div>
								</div>
								<c:if test="${count.count<article24.size() }">
									<hr>
								</c:if>
					 </c:forEach>	
					 </div>
					</div>
					
					
					<!-- 最新文章 -->
					<br>
					<div class="card" style="width: 20rem;">
					<div class="card-header" style="background-color: light gray;"><b style="font-size: 15px;">最新文章</b></div>
					<div class="card-body" style="background-color:#f8f9fa;">
					<c:forEach items="${articleNew }" var="a" varStatus="count">
					    		<div class="media">
								    <img src="/pic/${a.picture }" class="mr-3" alt="..." style="width: 50px;height: 50px;">
								    <div class="media-body">
								    	<h5 class="mt-0" style="font-size: 12px;"><a style="color:black" href="select?id=${a.id }" target="blank">${a.title }</a></h5>
									</div>
								</div>
								<c:if test="${count.count<articleNew.size() }">
									<hr>
								</c:if>
					 </c:forEach>	
					 </div>
					</div>
					<br>
					
					
					<!-- 图片集 -->
					<div class="card" style="width: 20rem;">
					<div class="card-header" style="background-color: light gray;"><b style="font-size: 15px;">图片集</b></div>
					<div class="card-body" style="background-color:#f8f9fa;">
					<c:forEach items="${contentpics }" var="a" varStatus="count">
					    		<div class="media">
								    <img src="/pic/${a.picture }" class="mr-3" alt="..." style="width: 50px;height: 50px;">
								    <div class="media-body">
								    	<h5 class="mt-0" style="font-size: 12px;"><a style="color:black" href="selectpic?id=${a.id }" target="blank">${a.title }</a></h5>
									</div>
								</div>
								<c:if test="${count.count<contentpics.size() }">
									<hr>
								</c:if>
					 </c:forEach>	
					 </div>
					</div>
					
					<br>
					
					
					<!-- 文章专题 -->
					<div class="card" style="width: 20rem;">
					<div class="card-header" style="background-color: light gray;"><b style="font-size: 15px;">专题</b></div>
					<div class="card-body" style="background-color:#f8f9fa;">
					<c:forEach items="${specials }" var="s" varStatus="count">
						<span style="color:red;font-size: 18px;"><strong>${s.title }</strong></span>
						<br>
						<span style="font-size: 10px;color:gray;">${s.abstracts }</span>
						<c:forEach items="${s.articles }" var="a" varStatus="count">
							<h5 class="mt-0" style="font-size: 12px;"><a href="select?id=${a.id }" target="blank"><span style="color: black;">${count.count}.</span>${a.title }</a></h5>
						</c:forEach>
					 </c:forEach>
					 </div>
					</div>
					
					<br>
					
					<!-- 友情链接 -->
					<div class="card" style="width: 20rem;">
					<div class="card-header" style="background-color: light gray;"><b style="font-size: 15px;">友情链接</b></div>
					<div class="card-body" style="background-color:#f8f9fa;">
					<c:forEach items="${friendlys }" var="f" varStatus="count">
						<a href="${f.url }" target="blank">${f.text }</a> &nbsp;&nbsp;&nbsp;
						<c:if test="${count.count%4==0 }">
							<br><br>
						</c:if>
					 </c:forEach>
					 </div>
					</div>
					
			</div>
			
		</div>
		<div>
			<jsp:include page="/WEB-INF/view/common/footer.jsp"/>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$(".page-link").click(function(){
				var url = $(this).attr("data");
  				location.href=url;
			})
		})
	</script>
</body>

</html>