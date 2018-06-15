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
	<div class = "container">
	<div style= "height:80px"></div>
		<div class="col-xs-6 col-md-offset-3">
			<h3 class = "text-center">图书信息的录入</h3><br>
					<form class="form"
						action="${pageContext.request.contextPath }/servlet/bookServlet?method=add"
						role="form" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="bk_name"
								placeholder="书名">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="bk_number"
								placeholder="书号">
						</div>
						<div class="radio">
							<label> <input type="radio" name="bk_type" value="1"
								checked> 玄幻 </label> <label> <input type="radio"
								name="bk_type" value="2">修仙</label> <label> <input
								type="radio" name="bk_type" value="3">都市</label> <label>
								<input type="radio" name="bk_type" value="4">言情</label>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="作者"
								name="writer">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="单价"
								name="price">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="书架编号"
								name="bs_number">
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">确定添加</button>
						</div>
					</form>
				</div>
			</div>
		<div class = "col-md-12">
		<c:if test="${param.status.equals('1') }">
			<div class = "alert alert-success" role = "alert"><span style = "margin-left:75px;">添加成功</span></div>
		</c:if>
		<c:if test="${param.status.equals('0') }">
			<div class = "alert alert-danger" role = "alert">添加失败</div>
		</c:if>
		</div>
	</div>
</body>
</html>