<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript" src="/resource/js/cms.js"></script>
</head>
<body>
<div class="container">
	<div class="form-group form-inline">
		<label for="username"><span style="font-family: '楷体';font-size:20px;color: red;" class="font-weight-bolder">用户名:</span></label><input type="text" id="username" name="username" value="${username }" class="form-control">
		&nbsp;&nbsp;<button class="btn btn-outline-primary btn-sm" onclick="getUserByName()">查询</button>
	</div>

	<table class="table table-striped table-bordered">
		<tr align="center" valign="middle">
			<td>序号</td>
			<td>用户名</td>
			<td>昵称</td>
			<td>生日</td>
			<td>性别</td>
			<td>状态</td>
			<td>角色</td>
			<td>注册日期</td>
			<td>修改日期</td>
		</tr>
		<c:forEach items="${users }" var="u" varStatus="index">
			<tr align="center" valign="middle">
				<td>${index.index+1 }</td>
				<td>${u.username }</td>
				<td>${u.nickname }</td>
				<td><fmt:formatDate value="${u.birthday }" pattern="yyyy-MM-dd"/></td>
				<td>${u.gender==0?'男':'女' }</td>
				<td>
					<c:if test="${u.locked==0 }">
						<button class="btn btn-success btn-sm" onclick="updateLock(${u.id},this)">正常</button>					
					</c:if>
					<c:if test="${u.locked==1 }">
						<button class="btn btn-warning btn-sm" onclick="updateLock(${u.id},this)">禁用</button>					
					</c:if>
				</td>
				<td>${u.role==0?'普通用户':'管理员' }</td>
				<td><fmt:formatDate value="${u.created }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${u.updated }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		${pages }
	</div>
</div>
<script type="text/javascript">
	
	function updateLock(id,own){
		var locked = $(own).text();
		var newlocked = (locked=='正常'?1:0);
		$.post("/admin/updateLocked",{id:id,locked:newlocked},function(flag){
			if(flag){
				alert("修改状态成功");
				$(own).text(newlocked==1?'禁用':'正常');
				$(own).attr("class",newlocked==1?'btn btn-warning btn-sm':'btn btn-success btn-sm');
			}else{
				alert("修改状态失败");
			}
		})
	}
	function getUserByName(){
		var username = $("[name=username]").val();
		$("#content-wrapper").load("/admin/selects?username="+username);
	}
</script>
</body>
</html>