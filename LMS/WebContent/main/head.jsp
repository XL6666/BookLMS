<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>head</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/menu.js"></script>
</head>
<body>
<div class="top"></div>
<div id="header">
	<div class="logo">图书借阅管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href="#">${sessionScope.adminBean.user_name}</a></li>
			<!--  <li><a href="${pageContext.request.contextPath }/servlet/adminServlet?method=loginout">退出</a></li> -->
		</ul>
	</div>
</div>
</body>
</html>