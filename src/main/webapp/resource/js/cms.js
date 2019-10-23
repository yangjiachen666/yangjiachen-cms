//分页
$(".page-link").click(function(){
	var url = $(this).attr("data");
	$("#content-wrapper").load(url);
})