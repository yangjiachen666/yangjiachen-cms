<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">专题编辑</h1>
	<div class="container">
	<form id="form1">
		<div class="form-group form-inline">
			<label for="title">专题标题:</label>
			<input type="text" class="form-control" name="title" id="title" value="${special.title }"/>
		</div>
		<div class="form-group form-inline">
			<label for="abstracts">专题摘要:</label>
			<textarea rows="10" cols="100" name="abstracts" id="abstracts">
				${special.abstracts }
			</textarea>
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-outline-dark" onclick="addspeciala()">修改专题</button>
		</div>
	</form>
	</div>
</body>
<script type="text/javascript">
	function addspeciala(){
		$.post("/admin/updatespeciala",$("#form1").serialize(),function(flag){
			if(flag){
				alert("修改专题成功");
				$("#content-wrapper").load("/admin/speciala");
			}else{
				alert("修改专题失败");
			}
		})
	}
</script>
</html>