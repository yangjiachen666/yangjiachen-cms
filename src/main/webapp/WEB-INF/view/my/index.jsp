<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的个人空间</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/top.jsp"/>
	<div class="container">
		<!--横幅  -->
		<br>
		<div class="container">
			<div class="row">
				<div class="col-md-12 my_banner"></div>
			</div>
		</div>
		<!-- 左侧导航 -->
		<div>
			<div class="row">
				<div class="col-md-3">
					<!-- 导航条 -->
						<jsp:include page="/WEB-INF/view/my/left.jsp"></jsp:include>
					<br/>
				</div>
				<div class="col-md-9" id="center">
					<div style="display: none;">
						<jsp:include page="/resource/kindeditor/jsp/demo.jsp"/>
					</div>
				</div>
			</div>
		</div>
		<!-- 右侧内容 -->
		
	</div>
	<jsp:include page="/WEB-INF/view/common/footer.jsp"/>
</body>
<script type="text/javascript">
	$(function(){
		$("#center").load("/my/selectsByUser")
	})
	$(function(){
		$(".channel").click(function(){
			var li = $("ul li");
			$(li).removeClass("list-group-item-info");
			$(this).parent().addClass("list-group-item-info");
			var url = $(this).attr("data");
			$("#center").load(url);
		})
	})
</script>
</html>