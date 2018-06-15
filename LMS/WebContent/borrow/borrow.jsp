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
	<div class = "col-md-12"><h3 class = "text-center">查询可否借书</h3><br></div>
	<form class="form"
		action="${pageContext.request.contextPath }/servlet/borrowServlet?method=borrowfind"
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
		<c:if test="${readerBean!=null }">
			<c:if test="${bookBean!=null }">

				<div class="col-md-6 col-md-push-3">
					<table class="table table-striped">
						<tr>
							<td>读者姓名</td>
							<td>${readerBean.rd_name}</td>
						</tr>
						<tr>
							<td>读者类别</td>
							<td>${readerBean.readertypeBean.rt_name}</td>
						</tr>
						<tr>
							<td>读者可借阅量</td>	
							<td>${readerBean.readertypeBean.rt_number}</td>
						</tr>
						<tr>
							<td>读者已借阅量</td>	
							<td>${readerBean.borrowed_num}</td>
						</tr>
						<tr>
							<td>图书名称</td>
							<td>${bookBean.bk_name}</td>
						</tr>
						
						<tr>
							<td>图书状态</td>
							<c:if test="${bookBean.bk_state==0 }">
								<td>未借出</td>
							</c:if>
							<c:if test="${bookBean.bk_state==1 }">
								<td>已借出</td>
							</c:if>
						</tr>
						<tr>
						<td></td>
							<td><a class="btn btn-primary " href="${pageContext.request.contextPath }/servlet/borrowServlet?method=borrow&readerid=${readerBean.readerid}&bk_code=${bookBean.bk_code}">借阅</a>
							</td>
							
						</tr>
					</table>
				</div>
			</c:if>
		</c:if>
		</div>
		<div class = "col-md-12">
		<c:if test="${param.status.equals('1') }">
			<div class = "alert alert-success" role = "alert"><span style = "margin-left:75px;">借阅成功</span></div>
		</c:if>
		<c:if test="${param.status.equals('0') }">
			<div class = "alert alert-danger" role = "alert">借阅失败</div>
		</c:if>
		</div>
	</div>
</body>
</html>