<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html lang="en">
<head">
    <title>Work CV</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700&display=swap" rel="stylesheet">

  <!-- CSS -->
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

  <!-- JS -->
  <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/jquery.easing.1.3.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/jquery.waypoints.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/jquery.stellar.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/jquery.magnific-popup.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/aos.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/jquery.animateNumber.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="${pageContext.request.contextPath}/assets/js/google-map.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
  <script src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid px-md-4	">
          <a class="navbar-brand" href="/">Work CV</a>
      
          <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item active"><a href="${pageContext.request.contextPath}/homepage" class="nav-link">Trang chủ</a></li>
                
                <c:if test="${empty user}">
                	<li class="nav-item cta cta-colored"><a href="${pageContext.request.contextPath}/login" class="nav-link">Đăng nhập</a></li>
                </c:if>
                <c:if test="${not empty user}">
                	<security:authorize access="hasRole('RECRUITER')">
                		<li class="nav-item cta mr-md-1"><a href="${pageContext.request.contextPath}/recruiter/postList" class="nav-link">Đăng tuyển</a></li>
                	</security:authorize>
                	<security:authorize access="hasRole('EMPLOYEE')">
                		<li class="nav-item cta mr-md-1"><a href="${pageContext.request.contextPath}/postApplied" class="nav-link">Danh sách ứng tuyển</a></li>
                	</security:authorize>
	              	<li class="nav-item"><a href="${pageContext.request.contextPath}/profile" class="nav-link">Hồ Sơ</a></li>
	              	<li class="nav-item"><a href="<c:url value="/logout" />" class="nav-link">Đăng xuất</a></li>             
                </c:if>
            </ul>
          </div>
        </div>
      </nav>
<!-- END nav -->
<div class="hero-wrap img" style="background-image: url(user/assets/images/bg_1.jpg);">
    <div class="overlay"></div>
    <div class="container">
        <div class="row d-md-flex no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-10 d-flex align-items-center ">
                <div class="text text-center pt-5 mt-md-5">
                    <p class="mb-4">Tìm việc làm, Cơ hội việc làm và Nghề nghiệp</p>
                    <h1 class="mb-5">Cách dễ dàng nhất để có được công việc mới của bạn</h1>
                    <div class="ftco-counter ftco-no-pt ftco-no-pb">
                        <div class="row">
                            <div class="col-md-4 d-flex justify-content-center counter-wrap ">
                                <div class="block-18">
                                    <div class="text d-flex">
                                        <div class="icon mr-2">
                                            <span class="flaticon-visitor"></span>
                                        </div>
                                        <div class="desc text-left">
                                            <strong class="number" data-number="46" th:text="${numberCandidate}"></strong>
                                            <span>Ứng cử viên</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 d-flex justify-content-center counter-wrap ">
                                <div class="block-18 text-center">
                                    <div class="text d-flex">
                                        <div class="icon mr-2">
                                            <span class="flaticon-visitor"></span>
                                        </div>
                                        <div class="desc text-left">
                                            <strong class="number" data-number="450" th:text="${numberCompany}"></strong>
                                            <span>Công ty</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 d-flex justify-content-center counter-wrap">
                                <div class="block-18 text-center">
                                    <div class="text d-flex">
                                        <div class="icon mr-2">
                                            <span class="flaticon-resume"></span>
                                        </div>
                                        <div class="desc text-left">
                                            <strong class="number" data-number="80000" th:text="${numberRecruitment}"></strong>
                                            <span>Tuyển dụng</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <security:authorize access="hasRole('EMPLOYEE')">
	                    <div class="ftco-search my-md-5">
	                        <div class="row">
	                            <div class="col-md-12 nav-link-wrap">
	                                <div class="nav nav-pills text-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
	                                    <a class="nav-link active mr-md-1" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true">Tìm công việc</a>
	
	                                    <a class="nav-link" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2" aria-selected="false">Tìm theo công ty</a>
	                                    <a class="nav-link" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3" aria-selected="false">Tìm theo địa điểm</a>
	
	                                </div>
	                            </div>
	                            <div class="col-md-12 tab-wrap">
	
	                                <div class="tab-content p-4" id="v-pills-tabContent">
	
	                                    <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="v-pills-nextgen-tab">
	                                        <form action="${pageContext.request.contextPath}/search" class="search-job">
	                                            <div class="row no-gutters">
	
	                                                <div class="col-md-10 mr-md-2">
	                                                    <div class="form-group">
	                                                        <div class="form-field">
	                                                            <div class="icon"><span class="icon-map-marker"></span></div>
	                                                            <input type="hidden" name="type" value="0">
	                                                            <input type="text" name="searchQuery" class="form-control" placeholder="Tìm theo công việc">
	                                                        </div>
	                                                    </div>
	                                                </div>
	                                                <div class="col-md">
	                                                    <div class="form-group">
	                                                        <div class="form-field">
	                                                            <button type="submit" class="form-control btn btn-primary">Tìm kiếm</button>
	                                                        </div>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </form>
	                                    </div>
	
	                                    <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-performance-tab">
	                                        <form action="${pageContext.request.contextPath}/search" class="search-job">
	                                            <div class="row no-gutters">
	
	                                                <div class="col-md-10 mr-md-2">
	                                                    <div class="form-group">
	                                                        <div class="form-field">
	                                                            <div class="icon"><span class="icon-map-marker"></span></div>
	                                                            <input type="hidden" name="type" value="1">
	                                                            <input type="text" name="searchQuery" class="form-control" placeholder="Tìm theo công ty">
	                                                        </div>
	                                                    </div>
	                                                </div>
	                                                <div class="col-md">
	                                                    <div class="form-group">
	                                                        <div class="form-field">
	                                                            <button type="submit" class="form-control btn btn-primary">Tìm kiếm</button>
	                                                        </div>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </form>
	                                    </div>
	                                    <div class="tab-pane fade" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-performance-tab">
	                                        <form action="${pageContext.request.contextPath}/search" class="search-job">
	                                            <div class="row no-gutters">
	
	                                                <div class="col-md-10 mr-md-2">
	                                                    <div class="form-group">
	                                                        <div class="form-field">
	                                                            <div class="icon"><span class="icon-map-marker"></span></div>
	                                                            <input type="hidden" name="type" value="2">
	                                                            <input type="text" name="searchQuery" class="form-control" placeholder="Tìm kiếm theo địa điểm">
	                                                        </div>
	                                                    </div>
	                                                </div>
	                                                <div class="col-md">
	                                                    <div class="form-group">
	                                                        <div class="form-field">
	                                                            <button type="submit" class="form-control btn btn-primary">Tìm kiếm</button>
	                                                        </div>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </form>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                    </security:authorize>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center mb-5">

            <div style="display: block" class="col-md-7 heading-section text-center">
                <span class="subheading">Danh mục công việc</span>
                <h2 class="mb-0">Top Danh Mục</h2>
            </div>
        </div>
        <div class="row">
        	<c:forEach var="category" items="${categories}">
	            <th>
		            <div class="col-md-3 ">
		                <ul class="category text-center">
		
		                    <li><a style="text-decoration: none !important;" href="${'/recruitment/category/'}+${categorie.id}"> <p>${category.categoryName}</p><span class="number">${category.countPost}</span> <span>Công việc</span><i class="ion-ios-arrow-forward"></i></a></li>
		                </ul>
		            </div>
	            </th>
            </c:forEach>
        </div>
    </div>
</section>

<section class="ftco-section services-section">
    <div class="container">
        <div class="row d-flex">
            <div class="col-md-3 d-flex align-self-stretch ">
                <div class="media block-6 services d-block">
                    <div class="icon"><span class="flaticon-resume"></span></div>
                    <div class="media-body">
                        <h3 class="heading mb-3">Tìm kiếm hàng triệu việc làm</h3>
                        <p>Một con sông nhỏ tên là Duden chảy qua nơi ở và nguồn cung cấp của họ.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 d-flex align-self-stretch ">
                <div class="media block-6 services d-block">
                    <div class="icon"><span class="flaticon-team"></span></div>
                    <div class="media-body">
                        <h3 class="heading mb-3">Dễ dàng quản lý công việc</h3>
                        <p>Một con sông nhỏ tên là Duden chảy qua nơi ở và nguồn cung cấp của họ.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 d-flex align-self-stretch ">
                <div class="media block-6 services d-block">
                    <div class="icon"><span class="flaticon-career"></span></div>
                    <div class="media-body">
                        <h3 class="heading mb-3">Top Nghề nghiệp</h3>
                        <p>Một con sông nhỏ tên là Duden chảy qua nơi ở và nguồn cung cấp của họ.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 d-flex align-self-stretch ">
                <div class="media block-6 services d-block">
                    <div class="icon"><span class="flaticon-employees"></span></div>
                    <div class="media-body">
                        <h3 class="heading mb-3">Ứng viên Chuyên gia Tìm kiếm</h3>
                        <p>Một con sông nhỏ tên là Duden chảy qua nơi ở và nguồn cung cấp của họ.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 pr-lg-5">
                <div class="row justify-content-center pb-3">
                    <div class="col-md-12 heading-section ">
                        <span class="subheading">CÔNG VIỆC ĐƯỢC NHIỀU NGƯỜI ỨNG TUYỂN</span>
                        <h2 class="mb-4">Các bài đăng về việc làm nổi bật</h2>

                    </div>
                </div>
                <div class="row">
                <c:if test="${not empty message}">
					<div class="alert alert-primary" role="alert">${message}</div>
				</c:if>
				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger" role="alert">${errorMessage}</div>
				</c:if>
                	<c:forEach var="post" items="${posts}">
	                		<th>
	                        <div class="col-md-12 ">
	                            <div class="job-post-item p-4 d-block d-lg-flex align-items-center">
	                                <div class="one-third mb-4 mb-md-0">
	                                    <div class="job-post-item-header align-items-center">
	                                        <span class="subadge">${post.category.name}</span>
	                                        <h2 class="mr-3 text-black" ><a href="${pageContext.request.contextPath}/viewPost?id=${post.id}">${post.title}</a></h2>
	                                    </div>
	                                    <div class="job-post-item-body d-block d-md-flex">
	                                        <div class="mr-3"><span class="icon-layers"></span> <a href="#">${post.company.name}</a></div>
	                                        <div><span class="icon-my_location"></span> <span>${post.company.address}</span></div>
	                                    </div>
	                                </div>
	                                <security:authorize access="hasRole('EMPLOYEE')">
		                                <input type="hidden" id="${post.id}" value="${post.id}">
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
	                        </div>
	                        <!-- end -->
	                        <!-- The Modal -->
							<div id="myModal" class="modal">
						
								<!-- Modal content -->
								<div class="modal-content">
								<div>
								<h4 id="title-modal">Ứng tuyển</h4>
										<div class="close-btn">&times;</div>
								</div>
									
							 	<form method="POST" action="${pageContext.request.contextPath}/applyPostHome?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" >
												<input type="hidden" name="page" value="${j}">
												
										<input type="hidden" name="postId" id="post-id-input"> 
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
                </div>
            </div>
            <div class="col-lg-3 sidebar">
                <div class="row justify-content-center pb-3">
                    <div class="col-md-12 heading-section ">
                        <h2 class="mb-4">Công ty nổi bật</h2>
                    </div>
                </div>
                <c:forEach var="company" items="${companies}">
	                <th>
		                <div class="sidebar-box">
		                    <div class="">
		                        <div class="text p-3">
		                            <h3><a href="${pageContext.request.contextPath}/listPostCompany/${company.id}">${company.name}</a></h3>
		                            <p><span class="number" style="color: black">${company.address}</span></p>
		                            <p><span class="number" style="color: black">${company.phoneNumber}</span></p>
		                            <p><span class="number" style="color: black">${company.email}</span></p>
		                        </div>
		                    </div>
		                </div>
	                </th>	
                </c:forEach>
                
            </div>
        </div>
    </div>
</section>
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


<footer th:replace="public/fragments :: footer" class="ftco-footer ftco-bg-dark ftco-section">

</footer>


<!-- loader -->
<!--<div th:replace="public/fragments :: loading" id="ftco-loader" class="show fullscreen"></div>-->

</body>
</html>