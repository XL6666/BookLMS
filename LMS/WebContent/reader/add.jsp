<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div style= "height:100px"></div>
		<div class="col-xs-6 col-md-offset-3">
			<h3 class = "text-center">读者信息的录入</h3><br>
			<form class="form"
				action="${pageContext.request.contextPath }/servlet/readerServlet?method=add"
				role="form" method="post">
				<div class="form-group">
					<input type="text" class="form-control" name="rd_name"
						placeholder="读者的名字">
				</div>
				<div class="radio">
					<label> <input type="radio" name="rd_type" value="1"
						checked> 学生 </label> <label> <input type="radio"
						name="rd_type" value="2">教师</label>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="所属系部"
						name="system">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="班级"
						name="rclass">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="联系电话"
						name="phone">
				</div>

				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">确定添加</button>
				</div>
			</form>
		</div>
		<div class="col-md-12">
			<c:if test="${param.status.equals('1') }">
				<div class="alert alert-success" role="alert">
					<span style="margin-left: 75px;">添加成功</span>
				</div>
			</c:if>
			<c:if test="${param.status.equals('0') }">
				<div class="alert alert-danger" role="alert">添加失败</div>
			</c:if>
		</div>
	</div>

</body>
</html>