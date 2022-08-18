<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<input type="button" value="버튼" onclick="submit()">
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"  ></script>
<script id="entry-template" type="text/x-handlebars-template">


       <h1>{{num}}</h1>
       <h1>{{num2}}</h1>
       <h1>{{num3}}</h1>
 

</script>
<script>

var data={
		"num":"1",
		"num2" : "2",
		"num3" : "3"
}
function submit(){
	$.ajax({
		url:"<%=request.getContextPath()%>/handlebars/print",
		type:"post",
		data:JSON.stringify(data),	
		contentType:'application/json',
		success:function(data){
			alert(data.num);
			var source = $("#entry-template").html();
			var template = Handlebars.compile(source);
			var html = template(data);
			$('body').append(html);
			
		},
		error:function(error){
			AjaxErrorSecurityRedirectHandler(error.status);	
		}
	});
	
	
}

</script>
</html>
