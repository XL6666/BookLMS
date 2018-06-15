<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>	
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Login" />
<link href="css/style.css" rel='stylesheet' type='text/css' />


<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
</head>
<body>
<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>
<h2 class = "text-center">Welcome Login！</h2>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="images/avtar.png" />
	</div>
	
			<form action="${pageContext.request.contextPath }/servlet/adminServlet?method=login" method="post">
					<input name = "user" type="text" class="text" " >
						<div class="key">
					<input name = "password" type="password" ">
						</div>
				<div class="signin">
					<input type="submit" value="Login" >
				</div>
				<c:if test="${param.status.equals('1')}">
					<div class="alert alert-danger" role="alert">用户名或密码错误</div>
				</c:if>
				<c:if test="${param.status.equals('2')}">
					<div class="alert alert-danger" role="alert">注册成功</div>
				</c:if>
			</form>
	
</div>

</body>
</html>