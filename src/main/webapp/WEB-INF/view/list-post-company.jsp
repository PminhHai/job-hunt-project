<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Danh sách bài viết</title>

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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/open-iconic-bootstrap.min.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/animate.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.carousel.min.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.theme.default.min.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/magnific-popup.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.carousel.min.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.theme.default.min.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/aos.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ionicons.min.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datepicker.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery.timepicker.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/css/bootstrap-reboot.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/css/mixins/_text-hide.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/flaticon.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/icomoon.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap/bootstrap-grid.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap/bootstrap-reboot.css">

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
		<security:authorize access="hasRole('RECRUITER')">
			<a href="${pageContext.request.contextPath}/recruiter/newPostForm" role="button" class="btn btn-primary">Tạo bài đăng</a>
		</security:authorize>		
		<h3 class="text-center">Danh sách bài đăng công ty : ${company.name}</h3>
	</nav>
	 <c:if test="${not empty message}">
					<div class="alert alert-primary" role="alert">${message}</div>
	</c:if>
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger" role="alert">${errorMessage}</div>
	</c:if>
	<main>
		
		<div
			class="container d-flex align-items-center justify-content-center flex-column">
			<c:if test="${empty posts}"><h4>Không có bài đăng</h4> </c:if>
			<security:authorize access="hasRole('RECRUITER')">
				<c:forEach items="${posts}" var="post">
					<div class="row p-2 align-items-center item-border"
						style="width: 900px">
	
						<div class="col-lg">
							<p>${post.jobType.name}</p>
							<h4>${post.title}</h4>
							<span class="fas fa-building"></span><span> ${post.company.name} </span><span
								class="icon-room"></span><span> ${post.company.address}</span>
						</div>
						<c:if test="${user.id == post.user.id }">
							<div class="col-sm">
								<a href="${pageContext.request.contextPath}/viewPost?id=${post.id}">
									<button class="btn btn-primary float-right mx-2">Xem chi
										tiết</button>
								</a> <a
									href="${pageContext.request.contextPath}/recruiter/editPostForm?id=${post.id}">
									<button class="btn btn-warning float-right mx-2">Cập
										nhập</button>
								</a> <a
									href="${pageContext.request.contextPath}/recruiter/deletePost?id=${post.id}">
									<button class="btn btn-danger float-right mx-2" onclick="return confirm('bạn muốn xóa bài viết ${post.title}?');">Xóa</button>
								</a>
							</div>
						</c:if>
						<c:if test="${user.id != post.user.id}">
							<div class="col-sm"></div>	
						</c:if>
					</div>
				</c:forEach>
			</security:authorize>
			
			<security:authorize access="hasRole('EMPLOYEE')">
				<c:forEach var="post" items="${posts}">
	                		<th>
	                        <div class="col-md-12 ">
	                            <div class="job-post-item p-4 d-block d-lg-flex align-items-center">
	                                <div class="one-third mb-4 mb-md-0">
	                                    <div class="job-post-item-header align-items-center">
	                                        <span class="subadge">${post.category.name}</span>
	                                        <h2 class="mr-3 text-black" ><a href="">${post.title}</a></h2>
	                                    </div>
	                                    <div class="job-post-item-body d-block d-md-flex">
	                                        <div class="mr-3"><span class="icon-layers"></span> <a href="#">${post.company.name}</a></div>
	                                        <div><span class="icon-my_location"></span> <span>${post.company.address}</span></div>
	                                    </div>
	                                </div>
	                                <security:authorize access="hasRole('EMPLOYEE')">
		                                <input type="hidden" id="${post.id}" value="${post.id}">
		                     			 <input type="hidden" id="${company.id}" value="${company.id}">
		                                <div class="one-forth ml-auto d-flex align-items-center mt-4 md-md-0">
		                                	<c:if test="${post.getStatus(username) == 4}">
		                                    	<a id="apply-modal-btn${post.id}" data-target="${post.id}" class="btn btn-primary py-2 apply-modal-btn">Apply Job</a>
		                                    </c:if>	
		                                    <c:if test="${post.getStatus(username) == 0}">
												<h4 class="text-warning">Applied(Pending)</h4>
											</c:if>
											<c:if test="${post.getStatus(username) == 1}">
												<h4 class="text-success">Accepted</h4>
											</c:if>
											<c:if test="${post.getStatus(username) == 2}">
												<h4 class="text-danger">Denied</h4>
											</c:if>
		                                </div>
	               					</security:authorize>
	                            </div>
	                        </div><!-- end -->
	                        <!-- Modal -->
	                        <div id="myModal" class="modal">
						
								<!-- Modal content -->
								<div class="modal-content">
								<div>
								<h4 id="title-modal">Ứng tuyển</h4>
										<div class="close-btn">&times;</div>
								</div>
									
							 	<form method="POST" action="${pageContext.request.contextPath}/applyPostCompany?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" >
												<input type="hidden" name="page" value="${j}">
												
										<input type="hidden" name="postId" id="post-id-input"> 
										<input type="hidden" name="companyId" value="${company.id}">
										<select
											class="form-control" id="cv-type-dropdown" name="cvSubmitType">
											<option value="1" selected="selected" label="Dùng CV đã cập nhập" />
											<option value="2" label="Tải CV mới" />
										</select>
										<input type="file" name="file" id="cv-file-input" class="form-control" style="display:none;"> 
										<label>Giới thiệu:</label>
										<textarea cols="20" name="description" id="apply-description-input" class="form-control"></textarea>
										<input type="submit" value="Ứng tuyển" class="form-control btn btn-primary">
									</form> 
							
								</div>
						
							</div>
	                    </th>
                	</c:forEach>
			</security:authorize>
			<ul class="pagination">
			<c:forEach var="j" begin="1" step="1" end="${maxPage}">
				<!-- contruct a pagin link -->
				<c:url var="pageLink" value="${company.id}">
					<c:param name="page" value="${j}"></c:param>
				</c:url>
			    <!-- display page link -->	
			    <c:if test="${page == j}"><li><a href="${pageLink}" class="page-link disabled"  style="background-color:beige">${j}</a></li> </c:if>
				<c:if test="${page != j}"><li><a href="${pageLink}" class="page-link">${j}</a></li> </c:if>
			</c:forEach>
		</ul>
		</div>
		
	</main>
	
	<script>
		// Get the modal
		var modal = document.getElementById("myModal");
		var title = document.getElementById("title-modal");
		// Get the button that opens the modal
		var btn = document.getElementsByClassName("apply-modal-btn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close-btn")[0];

		// When the user clicks on the button, open the modal
		for (var i = 0; i < btn.length; i++) {
			btn[i].onclick = function() {
				modal.style.display = "block";
				var id = this.id.substring(15); //get post id
				var postInput = document.getElementById("post-id-input"); 
				postInput.value = id; // set hidden post id to apply job form modal
				var titlePostEl = document.getElementById("postName" + id); //get element of post title
				title.innerHTML = "Ứng tuyển cho bài : "
						+ titlePostEl.textContent; // set title for apply job form modal
			}
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
		
		var fileInputEl = document.getElementById("cv-file-input");
		$('#cv-type-dropdown').change(function() {
			fileInputEl.classList.toggle("d-block")
		})
		
	</script>
</body>
</html>