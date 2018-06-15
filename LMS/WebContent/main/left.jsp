<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/menu.js"></script>
<!-- bootstrap的核心css包 -->
<link
	href="${pageContext.request.contextPath }/static/css/bootstrap.min.css"
	rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="left_menu">
		<ul id="nav_dot">
			<li>
			<a style = "text-decoration : none" href = 'began.jsp' target = "mainAction" class = "M1">
				<h4 class="M1">
					<span></span>回到首页
				</h4>
				</a>
			</li>
			<li>
				<h4 class="M1">
					<span></span>读者信息管理
				</h4>
				<div class="list-item none">
					<a href='../reader/add.jsp' target="mainAction">添加读者</a> <a
						href='../reader/find.jsp' target="mainAction">查询读者信息</a>
				</div></li>
			<li>
				<h4 class="M2">
					<span></span>图书信息管理
				</h4>
				<div class="list-item none">
					<a href='../book/add.jsp' target="mainAction">图书入库</a> <a
						href='../book/find.jsp' target="mainAction">查询图书信息</a>
				</div></li>
			<li>
				<h4 class="M3">
					<span></span>借阅管理
				</h4>
				<div class="list-item none">
					<a href='../borrow/borrow.jsp' target="mainAction">借书</a> <a
						href='../borrow/return.jsp' target="mainAction">还书</a>
				</div></li>

		</ul>
	</div>

	<script>
		navList(12);
	</script>
</body>
</html>
