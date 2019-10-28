<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
</head>
<body>
	<div class="container">
	<form id="form1">
		<div class="form-group" align="right">
			<button class="btn btn-outline-dark" type="button" onclick="addPic()">add图片</button>
			<button class="btn btn-outline-info" type="button" onclick="publishpic()">发布</button>
		</div>
		<div class="form-group">
			<label for="title"><span style="font-size: 20px;">标题</span></label>
			<input type="text" name="title" id="title" class="form-control" style="width: 500px;"/>
		</div>
		<div class="form-group" id="div1">
			<div class="div2" style="float: left;">
				<div class="card" style="width: 18rem;">
					<div class="card-header">
						<label for="picture"><span style="font-size: 20px;">图片</span></label>
						<input type="file" name="files" id="picture" class="form-control"/>
					</div>
					<div class="card-body" style="background-color: #f8f9fa">
						<input type="text" name="descripts" style="width: 200px;height: 100px;" placeholder="图片描述"/>
					</div>
				</div>
			</div>
		</div>
	</form>
	</div>
</body>
<script type="text/javascript">
	function addPic(){
		$("#div1").append($(".div2").html());
	}
	function publishpic(){
		var formData=new FormData($("#form1")[0]);
		$.ajax({
			url:"/my/publishPic",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(flag){
				if(flag){
					alert("发布成功");
					location.href="/my";
				}else{
					alert("发布失败,请重新登录账号后在试");
				}
			}
			
		})
	}
</script>
</html>