<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<!-- BOOTSTRAP STYLES-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />


<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="assets/js/bootstrap.min.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="assets/js/custom.js"></script>




<style>
a, a:hover, a:active, a:link {
	color: #214761;
	font-weight: 900;
	font-size: 16px;
	text-decoration: none;
}

ul li ul li {
	list-style-type: none;
}

ul li ul li:hover {
	background: #F3F3F3;
}
</style>


<script>
	$(document).ready(function() {
		$("#accordian h3").click(function() {
			$("#accordian ul ul").slideUp();
			if (!$(this).next().is(":visible")) {
				$(this).next().slideDown();
			}
		});
		$(".btnpassword").on("click", function() {
			$("#passwordModal").modal();
		});
		$(".btninfo").on("click", function() {
			$("#infoModal").modal();
		});
		//수정버튼
		$(".btnupdate").on("click", function() {
			$("#teaupdateModal").modal();

		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="teacher.it"> <img
						src="img/sist_white.png" style="width: 200px; margin-top: 8px;" />

					</a>
				</div>
				<span class="logout-spn"> 강사 (${sessionScope.logininfo.id_}) 님
					<a href="logout.it" style="color: #fff;">LOGOUT</a>
				</span>
			</div>
		</div>

	</div>


	<!-- /. NAV TOP  -->
	<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<c:import url="menuteacher.jsp" />
		</div>

	</nav>
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<h2>강사 개인정보 확인</h2>
			<!-- /. ROW  -->
			<hr />
			<div class="panel panel-default">

				<table class="table teacherinfo">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>주민번호 뒷자리</th>
							<th>전화번호</th>
							<th style="width: 200px;">강의 가능 과목</th>
							<th>등록일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="teacher" items="${teacher_teachercheck}">
							<tr>
								<td>${teacher.teacher_id}</td>
								<td>${teacher.teacher_name}</td>
								<td>${teacher.teacher_ssn}</td>
								<td>${teacher.teacher_phone}</td>
								<td>${teacher.ableSubject}</td>
								<td>${teacher.teacher_hiredate}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pager">
					<li><button type="button"
							class="btn btn-default btn-xs btnPassword" data-toggle="modal"
							data-target="#passwordModal" value="${teacher.teacher_id}">비밀번호
							변경</button></li>
					<li><button type="button" id="teacher_id"
							class="btn btn-default btn-xs btnupdate" data-toggle="modal"
							data-target="#teaupdateModal" value="${teacher.teacher_id}">개인정보
							수정</button></li>
				</ul>

			</div>

		</div>
	</div>





	<!-- Modal -->
	<div id="passwordModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4>비밀번호 변경</h4>
				</div>
				<div class="modal-body">

					<form role="form" method="post" action="teacherpwmodify.it">
						<c:forEach var="teacher" items="${teacher_teachercheck}">
							<div class="form-group">
								<input type="hidden" class="form-control" id="teacher_id"
									name="teacher_id" placeholder="" required="required"
									value="${teacher.teacher_id}">
							</div>
							<div class="form-group">
							<!-- readonly maxlength="20" 입력을 막기위한 설정  -->
								<label for="teacher_name"> 이름 : </label> <input type="text"
									class="form-control" id="teacher_name" name="teacher_name"
									placeholder="" readonly maxlength="20"
									value="${teacher.teacher_name}">
							</div>
						</c:forEach>
						<div class="form-group">
							<label for="teacher_ssn"> 새 비밀번호</label> <input type="text"
								class="form-control" id="teacher_ssn" name="teacher_ssn"
								placeholder="새로운 비밀번호를 입력하세요" required="required">
						</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default btn-sm" id="">확인</button>
					<button type="button" class="btn btn-default btn-sm"
						data-dismiss="modal">취소</button>
				</div>
				</form>
			</div>


		</div>

	</div>




	<!-- Modal -->
	<div id="teaupdateModal" class="modal fade" role="dialog">
		<div>
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4>개인정보 수정</h4>
					</div>
					<div class="modal-body">
						<form role="form"
							action="${pageContext.request.contextPath}/teachermodify.it"
							method="post">
							<c:forEach var="teacher" items="${teacher_teachercheck}">
								<div class="form-group">
									<input type="hidden" class="form-control" id="teacher_id"
										name="teacher_id" placeholder="" required="required"
										value="${teacher.teacher_id}">
								</div>
								<div class="form-group">
									<label for="teacher_name"> 이름 : </label> <input type="text"
										class="form-control" id="teacher_name" name="teacher_name"
										placeholder="" required="required"
										value="${teacher.teacher_name}">
								</div>
								<div class="form-group">
									<label for="teacher_ssn"> 주민번호 뒷자리</label> <input type="text"
										class="form-control" id="teacher_ssn" name="teacher_ssn"
										placeholder="수정할 주민번호 7자리를 입력하세요" required="required">
								</div>
								<div class="form-group">
									<label for="teacher_phone"> 전화번호</label> <input type="text"
										class="form-control" id="teacher_phone" name="teacher_phone"
										placeholder="수정할 전화번호를 입력하세요" required="required">
								</div>


								<div class="form-group" style="border: px solid gray;">
									<%-- 	<h5>
										<b>강의 가능 과목</b>
									</h5>
									<select class="form-control" id="subject_id" name="subject_id">
										<c:forEach var="s" items="${teacherUpdate}">
											<option value="${s.subject_id}"
												${(s.subject_name==s.subject_name)?'selected':''}>${s.subject_id} ${s.subject_name}</option>
										</c:forEach>
									</select> --%>
									<!-- 	<input type="checkbox" name="sub" value="java">sub_001
									java <input type="checkbox" name="sub" value="Oracle">sub_002
									Oracle <input type="checkbox" name="sub" value="C">sub_003
									C언어<br> <input type="checkbox" name="sub"
										value="infomation">sub_004 정보보안 <input type="checkbox"
										name="sub" value="HTML">sub_005 HTML/CSS/Javascript -->
								</div>

							</c:forEach>

							<div class="modal-footer">
								<button type="submit" class="btn btn-default btn-sm" id="">확인</button>
								<button type="button" class="btn btn-default btn-sm"
									data-dismiss="modal">취소</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>




	<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->
	</div>
	<div class="footer">
		<div class="row">
			<div class="col-lg-12">
				&copy; 2014 yourdomain.com | Design by: <a
					href="http://binarytheme.com" style="color: #fff;" target="_blank">www.binarytheme.com</a>
			</div>
		</div>
	</div>
</body>
</html>
