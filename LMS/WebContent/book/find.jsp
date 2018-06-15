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
		action="${pageContext.request.contextPath }/servlet/bookServlet?method=find"
		role="form" method="post">
		<div class = "col-md-12"><h3 class = "text-center">查询图书信息</h3><br></div>
		
		<div class="form-group col-md-9 col-md-offset-3">
			<input type="text" class="form-control" placeholder="输入图书编号"
				name="bk_code" style = "width:400px;height:40px ;float:left">
				<button type="submit" class="btn btn-primary col-md-1" style = "height:40px;width:100px">查询</button>
		</div>
	</form>
		<c:if test="${bookBean!=null }">
		<div class = "col-md-6 col-md-push-3">
			<table class="table table-striped">
				<caption>图书信息概览</caption>
				<tr>
					<td>图书编号</td>
					<td>${bookBean.bk_code}</td>
				</tr>
				<tr>
					<td>书名</td>
					<td>${bookBean.bk_name}</td>
				</tr>
				<tr>
					<td>书号</td>
					<td>${bookBean.bk_number}</td>
				</tr>
				<tr>
					<td>图书类型</td>
					<td>${bookBean.booktypeBean.bt_name}</td>
				</tr>
				<tr>
					<td>作者</td>
					<td>${bookBean.writer}</td>
				</tr>
				<tr>
					<td>单价</td>
					<td>${bookBean.price}</td>
				</tr>
				<tr>
					<td>入库时间</td>
					<td>${bookBean.addtime}</td>
				</tr>
				<tr>
					<td>操作员姓名</td>
					<td>${bookBean.op_name}</td>
				</tr>
				<tr>
					<td>书架编号</td>
					<td>${bookBean.bs_number}</td>
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
					<td ><a class="btn btn-primary "  href = '${pageContext.request.contextPath }/servlet/bookServlet?method=delete&bk_code=${bookBean.bk_code}'>删除</a></td>
					<td ><a class="btn btn-primary"  href = '${pageContext.request.contextPath }/servlet/bookServlet?method=correct&bk_code=${bookBean.bk_code} '>修改</a></td>
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