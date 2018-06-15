<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改读者</title>
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
			<h3 class = "text-center">修改读者信息</h3><br>
			<form class="form"
				action="${pageContext.request.contextPath }/servlet/readerServlet?method=update&readerid=${readerBean.readerid}"
				role="form" method="post">
				<div class="form-group">
					<input type="text" class="form-control" name="rd_name"
						placeholder="读者的名字" value = "${readerBean.rd_name }">
				</div>
				<div class="radio">
				<c:if test="${readerBean.rd_type==1 }">
					<label> <input type="radio" name="rd_type" value="1"
						checked> 学生 </label> <label> <input type="radio"
						name="rd_type" value="2">教师</label>
				</c:if>
				<c:if test="${readerBean.rd_type==2 }">
					<label> <input type="radio" name="rd_type" value="1"
						> 学生 </label> <label> <input type="radio"
						name="rd_type" value="2" checked>教师</label>
				</c:if>	
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="所属系部"
						name="system" value = "${readerBean.system }">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="班级"
						name="rclass" value = "${readerBean.rclass }">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="联系电话"
						name="phone" value = "${readerBean.phone }">
				</div>

				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">修改</button>
				</div>
			</form>
		</div>
		<div class="col-md-12">
			<c:if test="${param.status.equals('1') }">
				<div class="alert alert-success" role="alert">
					<span style="margin-left: 75px;">修改成功</span>
				</div>
			</c:if>
			<c:if test="${param.status.equals('0') }">
				<div class="alert alert-danger" role="alert">修改失败</div>
			</c:if>
		</div>
	</div>

</body>
</html>