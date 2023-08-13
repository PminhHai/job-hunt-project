<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
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
	href="${pageContext.request.contextPath}/assets/css/owl.carousel.min.css">
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
		<a href="${pageContext.request.contextPath}/homepage" role="button"
			class="btn btn-primary">Về trang chủ</a> 
	<security:authorize access="hasRole('RECRUITER')">
		<a
			href="${pageContext.request.contextPath}/recruiter/postList" role="button"
			class="btn btn-primary">Về danh sách bài viết</a>
	</security:authorize>
		
		<h3 class="text-center">Chi tiết bài viết</h3>
	</nav>
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>
	<c:if test="${not empty message}">
		<div class="alert alert-success">${message}</div>
	</c:if>
	<div class="d-flex m-5 justify-content-center">
		<aside class="item-border mx-4 p-5"  style="width: 40%">
			<h4 style="width: 300px; display: inline-block">Tóm tắt công
				việc</h4>
			<p style="margin: 10px 0px 0px 0px">Tiêu đề: ${post.title}</p>
			<p style="margin: 10px 0px 0px 0px">Mô tả công việc:</p>
			<p style="margin: 10px 0px 0px 0px">${post.description }
			<p style="margin: 10px 0px 0px 0px">Kinh nghiệm:
				${post.experience}</p>
			<p style="margin: 10px 0px 0px 0px">Số người cần tuyển:
				${post.numberOfRecruit}</p>
			<p style="margin: 10px 0px 0px 0px">Địa chỉ công ty:
				${post.company.address}</p>
			<p style="margin: 10px 0px 0px 0px">Nơi tuyển dụng:
				${post.location}</p>	
			<p style="margin: 10px 0px 0px 0px">Hạn ứng tuyển:
				${post.expireDate}</p>
				<p style="margin: 10px 0px 0px 0px">Ngày tạo:
				${post.createdDate}</p>
			<p style="margin: 10px 0px 0px 0px">Lương: ${post.salary}</p>
			<p style="margin: 10px 0px 0px 0px">Loại công việc:
				${post.jobType.name}</p>
			<p style="margin: 10px 0px 0px 0px">Danh mục công việc:
				${post.category.name}</p>
		</aside>
		<security:authorize access="hasRole('RECRUITER')">
			<main class="container item-border p-5 d-flex flex-column" style="width:60%">
		
			<h4 style="width: 300px; display: inline-block">Danh sách người ứng tuyển</h4>
				<c:if test="${empty applyPosts}">
				<p>không có ứng cử viên nào</p>
				</c:if>
				<c:forEach items="${applyPosts}" var="applyPost">
					<div class="row p-2 align-items-center item-border">
						<div class="col-lg">
							<h4>${applyPost.user.fullName}</h4>
							<p>Mô tả: ${applyPost.text}</p>
							<span class="fas fa-building"></span><span> Ngày ứng tuyển: ${applyPost.createDate}</span>
							<br>
						</div>
						
							<c:if test="${user.id == post.user.id }">
								<div class="col-sm">
								<!-- incase applypost is waiting for input -->
									<c:if test="${applyPost.status==0}">
										<a href="${pageContext.request.contextPath}/approveApply?id=${applyPost.id}">
											<button class="btn btn-primary float-right mx-2">Chấp nhận</button>
										</a> <a
											href="${pageContext.request.contextPath}/refuseApply?id=${applyPost.id}">
											<button class="btn btn-danger float-right mx-2">Từ chối</button>
										</a> 
									</c:if>
								
									<!-- incase applypost is approved -->
									<c:if test="${applyPost.status==1}">
										<h3 class="text-success float-right">Đã được chấp nhận </h3>
									</c:if>
									<c:if test="${applyPost.status==2}">
										<h3 class="text-danger float-right">Đã bị từ chối </h3>
									</c:if>
								</div>
						   </c:if>
						<c:if test="${user.id != post.user.id }">
							<div class="col-sm"></div>
						</c:if>
									
					</div>
				</c:forEach>
			</main>
		</security:authorize>
		
	</div>
</body>
</html>