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
			#title-modal {
			display: inline-block;
			margin:12px 0px;
			}
			#cv-type-dropdown {
			margin:12px 0px;
			}
			#apply-description-input {
			height:300px
			}
			#cv-file-input {
			margin:12px 0px;
			}
			.text-warning {
			float:right;
			color:#cfc75c!important;
			}
			.text-danger {
			float:right;
			}
			.text-success {
			float:right;
			}
			
		</style>
	</head>
	<body>
		<nav class="bg-light p-2">
			<a href="${pageContext.request.contextPath}/homepage" role="button"
				class="btn btn-primary">Về trang chủ</a>
			<h3 class="text-center">Danh sách các bài đăng đã ứng tuyển</h3>
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
				
				<c:if test="${empty posts}"><h4>Không có kết quả</h4> </c:if>
				<c:forEach items="${posts}" var="post">
					<div class="row p-2 align-items-center item-border"
						style="width: 900px">
	
						<div class="col-lg">
							<p>${post.jobType.name}</p>
							<h4 id="postName${post.id}">${post.title}</h4>
							<span class="fas fa-building"></span>
							<span> ${post.company.name} </span>
							<span
								class="fa fa-map-marker-alt"></span>
								
							<span> ${post.company.address} </span>
						</div>
						<div class="col-sm">
							<c:if test="${post.getStatus(username) == 4}">
								<button class="btn btn-primary float-right mx-2 apply-modal-btn"
									id="apply-modal-btn${post.id}">Apply Job</button>
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
					</div>
				</c:forEach>
				<ul class="pagination">
					<c:forEach var="j" begin="1" step="1" end="${maxPage}">
						<!-- contruct a pagin link -->
						<c:url var="pageLink" value="/postApplied">
							<c:param name="page" value="${j}"></c:param>
						</c:url>
						<!-- display page link -->
						<c:if test="${page == j}">
							<li><a href="${pageLink}" class="page-link disabled"
								style="background-color: beige">${j}</a></li>
						</c:if>
						<c:if test="${page != j}">
							<li><a href="${pageLink}" class="page-link">${j}</a></li>
						</c:if>
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