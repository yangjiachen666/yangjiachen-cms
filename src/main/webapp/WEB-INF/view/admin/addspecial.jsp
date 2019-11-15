<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="/resource/css/jquery/screen.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/jquery.validate.js"></script>
</head>
<body>
	<div class="container">
	<form id="form1">
		<div class="form-group">
			<label for="title">专题标题</label>
			<input type="text" name="title" id="title" class="form-control"/>
		</div>
		<div class="form-group">
			<label for="abstracts">专题摘要</label>
			<input type="text" name="abstracts" id="abstracts" style="height: 200px;" class="form-control"/>
		</div>
		<div class="form-group">
		<input type="submit" class="btn btn-outline-dark" value="保存"/>
		</div>
	</form>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#form1").validate({
			rules:{
				title:{
					required:true,
				}
			},
			messages:{
				title:{
					required:"专题必须填才能够添加呦",
				}
			},
			submitHandler:function(){
				$.post("/admin/addspecial",$("#form1").serialize(),function(flag){
					if(flag){
						alert("添加专题成功");
						$("#content-wrapper").load("/admin/specials");
					}else{
						alert("添加专题失败");
					}
				})
			}
		})
	})

</script>
</html>