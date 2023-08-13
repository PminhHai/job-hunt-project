<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>profile</title>
	
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
	
	
	<style>
	.error {
		color: red
	}
	</style>
	</head>
	<body>
		<c:if test="${not empty message}" > <div class="alert alert-success">${message }</div></c:if>
		<c:if test="${not empty errorMessage}" > <div class="alert alert-danger">${errorMessage}</div></c:if>
		
			<h2>
				Xin chào người dùng:
				<security:authentication property="principal.username" />
			</h2>
			<a href="${pageContext.request.contextPath}/homepage">
				<button class="btn btn-primary">trở lại homepage</button>
			</a>
			<!-- update avatar form -->
			<form method="POST" action="${pageContext.request.contextPath}/uploadAvatar?${_csrf.parameterName}=${_csrf.token}"
				enctype="multipart/form-data" id="avatar-form">
		        
		         <label class="btn btn-primary">
		 		 <i class="fa fa-image"></i> Chọn ảnh<input type="file" style="display: none;"  name="file" accept="image/png, image/gif, image/jpeg" id="avatar-input">
			     </label>
			</form> 
			<!-- user avatar image -->
			<c:if test="${empty base64Encoded}">	
				<img
					src="${pageContext.request.contextPath}/avatar/defaultAvatar.jpg"
					class="avatar">
			</c:if>
			<c:if test="${not empty base64Encoded}">
				<img alt="img" class="avatar" src="data:image/jpeg;base64,${base64Encoded}"/>	
			</c:if>
			
			<security:authorize access="hasRole('EMPLOYEE')">
				<form method="POST" action="${pageContext.request.contextPath}/uploadCV?${_csrf.parameterName}=${_csrf.token}"
					enctype="multipart/form-data" id="cv-form">
			        
			         <label class="btn btn-primary">
			 		 <i class="fa fa-edit"></i> Chọn CV<input type="file" style="display: none;"  name="file" accept=".pdf" id="cv-input">
				     </label>
				</form> 
			</security:authorize>
		
			<div id="profileMain">
		
				<div id="loginbox" style="margin-top: 50px;"
					class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
		
					<div class="panel panel-primary">
		
						<div class="panel-heading">
							<div class="panel-title">Thông tin cá nhân</div>
						</div>
		
						<div style="padding-top: 30px" class="panel-body">
		
							<!-- Update User Form -->
							<form:form
								action="${pageContext.request.contextPath}/updateProfile"
								modelAttribute="user" class="form-horizontal">
								<form:hidden path="password" />
								<form:hidden path="id" />
								<form:hidden path="userName" />
								<!-- Full name -->
								<p>Full name</p>
								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span>
									<form:errors path="fullName" cssClass="error" />
									<form:input path="fullName" placeholder="full name"
										class="form-control profile-form" disabled="true" />
								</div>
		
								<!-- Email -->
								<p>Email:</p>
								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span>
									<form:errors path="email" cssClass="error" />
									<form:input path="email" placeholder="email"
										class="form-control profile-form" disabled="true" />
								</div>
		
								<!-- Phone number -->
								<p>Phone number:</p>
								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span>
									<form:errors path="phoneNumber" cssClass="error" />
									<form:input path="phoneNumber" placeholder="phone number"
										class="form-control profile-form" disabled="true" />
								</div>
		
								<!-- Description -->
								<p>Description:</p>
								<div style="margin-bottom: 25px" class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span>
									<form:errors path="description" cssClass="error" />
									<form:textarea path="description" placeholder="description"
										class="form-control profile-form" disabled="true" />
								</div>
		
								<!-- Edit Button -->
								<div style="margin-top: 10px" class="form-group">
									<div class="col-sm-6 controls">
										<button class="btn btn-primary" id="edit-input" type="button">Edit</button>
									</div>
								</div>
								<!-- Confirm Button -->
								<div style="margin-top: 10px" class="form-group">
									<div class="col-sm-6 controls">
										<button type="submit" class="btn btn-primary" id="confirm-btn"
											style="display: none">Confirm</button>
									</div>
								</div>
		
		
							</form:form>
		
						</div>
		
					</div>
				</div>
			</div>
			<div id="companyMain">
				<c:if test="${not empty user.company}">
					<div id="loginbox" style="margin-top: 50px;"
						class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
		
						<div class="panel panel-primary">
		
							<div class="panel-heading">
								<div class="panel-title">Thông tin công ty</div>
							</div>
		
							<div style="padding-top: 30px" class="panel-body">
		
								<!-- Update Company Form -->
								<form:form
									action="${pageContext.request.contextPath}/updateCompany"
									modelAttribute="company" class="form-horizontal">
									<form:hidden path="id" />
		
									<!-- Name -->
									<p>Name:</p>
									<div style="margin-bottom: 25px" class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span>
										<form:errors path="name" cssClass="error" />
										<form:input path="name" placeholder="Name (*)"
											class="form-control company-form" disabled="true" />
									</div>
		
									<!-- Address -->
									<p>Address:</p>
									<div style="margin-bottom: 25px" class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span>
										<form:errors path="address" cssClass="error" />
										<form:input path="address" placeholder="address"
											class="form-control company-form" disabled="true" />
									</div>
									<!-- Phone number -->
									<p>Phone number:</p>
									<div style="margin-bottom: 25px" class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span>
										<form:errors path="phoneNumber" cssClass="error" />
										<form:input path="phoneNumber" placeholder="phone number (*)"
											class="form-control company-form" disabled="true" />
									</div>
		
									<!-- Email -->
									<p>Email:</p>
									<div style="margin-bottom: 25px" class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span>
										<form:errors path="email" cssClass="error" />
										<form:input path="email" placeholder="email (*)"
											class="form-control company-form" disabled="true" />
									</div>
									<!-- Description -->
									<p>Description:</p>
									<div style="margin-bottom: 25px" class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span>
										<form:errors path="description" cssClass="error" />
										<form:textarea path="description" placeholder="description"
											class="form-control company-form" disabled="true" />
									</div>
		
									<!-- Edit Button -->
									<div style="margin-top: 10px" class="form-group">
										<div class="col-sm-6 controls">
											<button class="btn btn-primary" id="edit-company-input"
												type="button">Edit</button>
										</div>
									</div>
									<!-- Confirm Button -->
									<div style="margin-top: 10px" class="form-group">
										<div class="col-sm-6 controls">
											<button type="submit" class="btn btn-primary"
												id="confirm-company-btn" style="display: none">Confirm</button>
										</div>
									</div>
		
		
								</form:form>
		
							</div>
		
						</div>
					</div>
				</c:if>
			</div>
			<script
				src="${pageContext.request.contextPath}/assets/user/assets/js/JQuery3.3.1.js"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
				crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
				crossorigin="anonymous"></script>
		
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/assets/js/script.js"></script>
			<script>
				document.getElementById("avatar-input").onchange = function() {
				    document.getElementById("avatar-form").submit();
				};
				document.getElementById("cv-input").onchange = function() {
				    document.getElementById("cv-form").submit();
				};
			</script>
	</body>
</html>