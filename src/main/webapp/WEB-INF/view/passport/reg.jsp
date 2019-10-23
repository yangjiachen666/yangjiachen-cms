<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注册页面</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/top.jsp" />
	<div class="container">
		<div class="row passport_bg">
			<div class="col-md-5">
				<br>
				<div class="card">
					<div class="card-body">
						<form action="/passport/reg" method="post" id="form1">
							<h5 class="card-title" style="font-family: '楷体'; color: red; font-size: 30px;" align="center">欢迎注册</h5>
							<div class="form-group">
								<label for="username">用户名:</label> <input type="text"
									id="username" name="username" class="form-control">
							</div>
							<div class="form-group">
								<label for="password">密码:</label> <input type="password"
									id="password" name="password" class="form-control">
							</div>
							<div class="form-group">
								<label for="repassword">确认密码:</label> <input type="password"
									id="repassword" name="repassword" class="form-control">
							</div>
							<div class="form-group form-check form-check-inline">
								<input class="form-check-input" checked="checked" type="radio" name="gender" id="gender1" value="0"><label for="gender1" class="form-check-label">男</label>
								&nbsp;&nbsp;
								<input class="form-check-input" type="radio" name="gender" id="gender2" value="1"><label for="gender2" class="form-check-label">女</label>
							</div>
							<div class="form-group" align="center">
								<button class="btn btn-success">注册</button>
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
				rangelength:[2,5],
				remote:{
					type:"post",
					url:"/passport/onlyUsername",
					dataType:"json",
					data:{
						username:function(){
							return $("[name=username]").val();
						}
					}
				}
			},
			password:{
				required:true,
				rangelength:[8,15],
			},
			repassword:{
				equalTo:"#password",
			}
		},
		messages:{
			username:{
				required:"用户名不能为空",
				rangelength:"用户名的长度是2-5",
				remote:"该用户已经存在",
			},
			password:{
				required:"密码不能为空",
				rangelength:"密码的长度是8-15位",
			},
			repassword:{
				equalTo:"两次密码输入的不一致",
			},
		},
	})
})
</script>
</html>