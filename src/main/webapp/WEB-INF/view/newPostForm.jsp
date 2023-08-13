<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Bài viết</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/custom-bs.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jquery.fancybox.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap-select.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/fonts/icomoon/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/fonts/line-icons/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}assets/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/animate.min.css">

<!-- MAIN CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/isotope.pkgd.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/stickyfill.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.fancybox.min.js"></script>


<script
	src="${pageContext.request.contextPath}/assets/js/jquery.waypoints.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.animateNumber.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/bootstrap-select.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/custom.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="bg-light p-2">
			<a href="${pageContext.request.contextPath}/homepage" role="button" class="btn btn-primary">Về trang chủ</a>		
			<a href="#" role="button" class="btn btn-primary" onclick="goBack()">Về danh sách bài viết</a>
			<h3 class="text-center">Đăng bài</h3>
	</nav>
	<c:if test="${not empty errorMessage}">
	<div class="alert alert-danger">${errorMessage}</div>
	</c:if>
	<c:if test="${not empty message}">
	<div class="alert alert-success">${message}</div>
	</c:if>
	<main class="container item-border p-5">
				<form:form modelAttribute="post" action="${pageContext.request.contextPath}/newPost">
				<h3 style="width:300px;display:inline-block">Chi tiết bài tuyển dụng</h3>
				<button type="submit" class="float-right btn btn-primary mt-5">Tạo bài đăng</button>
				
				<p style="margin:10px 0px 0px 0px">Tiêu đề</p>
				<form:input path="title" cssClass="form-control"/>
				 <form:errors path="title" cssClass="error" />
				 			
				<p style="margin:10px 0px 0px 0px">Mô tả công việc</p>
				<form:textarea path="description" cssClass="form-control"/>
				<form:errors path="description" cssClass="error" />
							
				<p style="margin:10px 0px 0px 0px">Kinh nghiệm</p>
				<form:input path="experience" cssClass="form-control"/>
				<form:errors path="experience" cssClass="error" />
							
				<p style="margin:10px 0px 0px 0px">Số người cần tuyển</p>
				<form:input path="numberOfRecruit" cssClass="form-control"/>
				<form:errors path="numberOfRecruit" cssClass="error" />
				
				<p style="margin:10px 0px 0px 0px">Địa chỉ công ty</p>
				<input type="text" class="form-control" name="address" value="${companyAddress}" readonly>
				
				<p style="margin:10px 0px 0px 0px">Nơi tuyển dụng</p>
				<form:input path="location" cssClass="form-control"/>
				<form:errors path="location" cssClass="error" />
						
				<p style="margin:10px 0px 0px 0px">Hạn ứng tuyển</p>
				<form:input type="date" class="form-control" path="expireDate"/> 
				<form:errors path="expireDate" cssClass="error" />			
				
				<p style="margin:10px 0px 0px 0px">Lương</p>
				<form:input path="salary" cssClass="form-control"/>
				<form:errors path="salary" cssClass="error" />
							
				<p style="margin:10px 0px 0px 0px">Loại công việc</p>
				<form:select path="jobTypeId" cssClass="form-control">
				<c:forEach items="${jobTypes}" var="jobType">
				<form:option value="${jobType.id}" label="${jobType.name}"/>
				</c:forEach>
				</form:select>
				<form:errors path="jobTypeId" cssClass="error" />
							
				<p style="margin:10px 0px 0px 0px">Danh mục công việc</p>
				<form:select path="categoryId" cssClass="form-control">
				<c:forEach items="${categories}" var="category">
				<form:option value="${category.id}" label="${category.name}"/>
				</c:forEach>
				</form:select>
				<form:errors path="categoryId" cssClass="error" />
				</form:form>
	</main>
	
	<script>
	    function goBack() {
	        window.history.back();
	    }
	</script>
</body>
</html>