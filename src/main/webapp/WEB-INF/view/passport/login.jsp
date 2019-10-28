<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录页面</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/top.jsp" />
	<div class="container">
		<div class="row passport_bg">
			<div class="col-md-5">
				<br><br>
				<div class="card">
					<div class="card-body">
							<span style="color: red">${error}</span>
					  		<span style="color: red">${error1}</span>
						<form action="/passport/login" method="post" id="form1">
							<h5 class="card-title" style="font-family: '楷体'; color: red; font-size: 30px;" align="center">欢迎登录</h5>
							<div class="form-group">
								<label for="username">用户名:</label> <input type="text"
								value="${user.username }" id="username" name="username" class="form-control">
							</div>
							<div class="form-group">
								<label for="password">密码:</label> <input type="password"
								 id="password" name="password" class="form-control" value="12345678">
								
							</div>
							<div class="form-group" align="center">
								<button class="btn btn-success">登录</button>
								<button class="btn btn-warning" type="reset">重置</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-7">
				<div class="passport_r">
					<h3>最新加入的用户：</h3>
					<p align="center">
						<img src="/resource/images/guest.jpg" alt="..."
							class="rounded-circle img-thumbnail" /> &nbsp;&nbsp;&nbsp;&nbsp;
						<img src="/resource/images/guest1.jpg" alt="..."
							class="rounded-circle img-thumbnail" />
					</p>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	$(function(){
		$("#form1").validate({
			rules:{
				username:{
					required:true,
				},
				password:{
					required:true,
				}
			},
			messages:{
				username:{
					required:"用户名不能为空",
				},
				password:{
					required:"密码不能为空",
				}
			}
		})
	})
</script>
</html>