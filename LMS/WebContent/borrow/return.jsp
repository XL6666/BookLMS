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
	<div class = "col-md-12"><h3 class = "text-center">查询可否还书</h3><br></div>
	<form class="form"
		action="${pageContext.request.contextPath }/servlet/borrowServlet?method=returnfind"
		role="form" method="post">
		<div class = "col-md-2"></div>
		<div class = "col-md-3">
			<input type="text" class="form-control" placeholder="输入借书卡号"
				name="readerid">
		</div>
		<div class="form-group col-md-3">
			<input type="text" class="form-control" placeholder="输入图书编号"
				name="bk_code">
		</div>

		<button type="submit" class="btn btn-primary col-md-2">查询</button>
		
	</form>
	<div>
		<c:if test="${borrowBean!=null }">
				<div class="col-md-6 col-md-push-3">
					<table class="table table-striped">
						<tr>
							<td>读者姓名</td>
							<td>${borrowBean.readerBean.rd_name}</td>
						</tr>
						<tr>
							<td>图书名称</td>
							<td>${borrowBean.bookBean.bk_name}</td>
						</tr>
						<tr>
							<td>当前日期</td>
							<td>${param.date}</td>
						</tr>
						<tr>
							<td>应还日期</td>
							<td>${borrowBean.duedate}</td>
						</tr>
						<tr>
							<td>借书状态</td>
							<c:if test = "${borrowBean.borrowstate==1 }">
								<td>已经归还</td>
							</c:if>
							<c:if test = "${borrowBean.borrowstate==0 }">
								<td>尚未归还</td>
							</c:if>
						</tr>
						<tr>
						<td></td>
							<td><a class="btn btn-primary " href="${pageContext.request.contextPath }/servlet/borrowServlet?method=return&readerid=${borrowBean.readerBean.readerid}&bk_code=${borrowBean.bookBean.bk_code}">还书</a>
							</td>
							
						</tr>
					</table>
				</div>
			</c:if>
		</div>
		<div class = "col-md-12">
		<c:if test="${param.status.equals('1') }">
			<div class = "alert alert-success" role = "alert"><span style = "margin-left:75px;">还书成功</span></div>
		</c:if>
		<c:if test="${param.status.equals('0') }">
			<div class = "alert alert-danger" role = "alert">还书失败</div>
		</c:if>
		</div>
	</div>
</body>
</html>