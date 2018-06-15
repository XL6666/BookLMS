<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>find</title>
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
</head>
<body>
	
	
	<div class = "container">
	<form class="form"
		action="${pageContext.request.contextPath }/servlet/readerServlet?method=find"
		role="form" method="post">
		<div class = "col-md-12"><h3 class = "text-center">查询读者信息</h3><br></div>
		
		<div class="form-group col-md-9 col-md-offset-3">
			<input type="text" class="form-control" placeholder="输入借书卡号"
				name="readerid" style = "width:400px;height:40px ;float:left">
				<button type="submit" class="btn btn-primary col-md-1" style = "height:40px;width:100px">查询</button>
		</div>
	</form>
		<c:if test="${readerBean!=null }">
		<div class = "col-md-6 col-md-push-3">
			<table class="table table-striped">
				<caption>读者信息概览</caption>
				<tr>
					<td>借书卡号</td>
					<td>${readerBean.readerid}</td>
				</tr>
				<tr>
					<td>读者姓名</td>
					<td>${readerBean.rd_name}</td>
				</tr>
				<tr>
					<td>读者类别</td>
					<td>${readerBean.readertypeBean.rt_name}</td>
				</tr>
				<tr>
					<td>所属系部</td>
					<td>${readerBean.system}</td>
				</tr>
				<tr>
					<td>班级</td>
					<td>${readerBean.rclass}</td>
				</tr>
				<tr>
					<td>联系电话</td>
					<td>${readerBean.phone}</td>
				</tr>
				<tr>
					<td>登记日期</td>
					<td>${readerBean.reg_time}</td>
				</tr>
				<tr>
					<td>已借阅数量</td>
					<td>${readerBean.borrowed_num}</td>
				</tr>
				<tr>
					<td ><a class="btn btn-primary "  href = '${pageContext.request.contextPath }/servlet/readerServlet?method=delete&readerid=${readerBean.readerid}'>删除</a></td>
					<td ><a class="btn btn-primary"  href = '${pageContext.request.contextPath }/servlet/readerServlet?method=correct&readerid=${readerBean.readerid} '>修改</a></td>
				</tr>
			</table>
			</div>
		</c:if>
		<div class="col-md-12">
			<c:if test="${param.status.equals('1') }">
				<div class="alert alert-success" role="alert">
					<span style="margin-left: 75px;">删除成功</span>
				</div>
			</c:if>
			<c:if test="${param.status.equals('0') }">
				<div class="alert alert-danger" role="alert">删除失败</div>
			</c:if>
		</div>
	</div>
</body>
</html>