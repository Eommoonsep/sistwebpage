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
	 
 
		$("button.pwChange").on("click", function() {

			var name = $(this).val();
			$(this).css("background-color", "#F5F5F5");
			$("div#pwFormModal input[type=text]").attr("value", name);
			$("div#pwFormModal").modal();

		});

		// 개인정보수정 버튼 클릭시
		$("button.infoChange").on("click", function() {
			var name = $(this).val();

			//	var id = $(this).parents().find("td:eq(0)").text();
			//	var name_ = $(this).parents().find("td:eq(1)").text();
			var ssn = $(this).parents().find("td:eq(2)").text();
			var phone = $(this).parents().find("td:eq(3)").text();

			$(this).css("background-color", "#F5F5F5");

			$("div#infoFormModal input[id=name_]").attr("value", name);
			$("div#infoFormModal input[id=ssn]").attr("value", ssn);
			$("div#infoFormModal input[id=phone]").attr("value", phone);
			$("div#infoFormModal").modal();
		});

	});
</script>
</head>
<body>

	<c:import url="menustudent.jsp" />

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-lg-12">
					<h2>개인 정보 확인</h2>
					
				</div>
			</div>
			<hr />
			<div class="container-fluid">
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>아이디</th>
									<th>이름</th>
									<th style="width: 30%;">주민번호(뒷자리)</th>
									<th>전화번호</th>
									<th>과정수강횟수</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${student_info.student_id}</td>
									<td>${student_info.student_name }</td>
									<td>${student_info.student_ssn }</td>
									<td>${student_info.student_phone }</td>
									<td>${student_info.course_count }</td>
								</tr>
							</tbody>
						</table>
						<ul class="pager">
							<li><button type="button"
									class="btn btn-default btn-sm pwChange" data-toggle="modal"
									data-target="#pwFormModal" value="${student_info.student_name}">비밀번호변경</button></li>
							<li><button type="button"
									class="btn btn-default btn-sm infoChange" data-toggle="modal"
									data-target="#infoFormModal"
									value="${student_info.student_name}">개인정보수정</button></li>
						</ul>

					</div>

				</div>

			</div>


		</div>
		<!-- /. PAGE INNER  -->
	</div>
	<div class="footer">
		<div class="row">
			<div class="col-lg-12">
				&copy; 2014 yourdomain.com | Design by: <a
					href="http://binarytheme.com" style="color: #fff;" target="_blank">www.binarytheme.com</a>
			</div>
		</div>
	</div>



	<!-- 비밀번호 변경 Modal -->
	<div id="pwFormModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">비밀번호 변경</h4>
				</div>
				<div class="modal-body">

					<!-- 사진 삭제를 위한 hidden 폼 추가, submit버튼이 없다. -->
					<form action="studentpasswordupdate.it" method="POST" id="blindform">
						<div class="form-group">
							이름 :<input type="text" placeholder="" value="" class="form-control" id="name_" name="name_" readonly maxlength="20"> 
							기존 비밀번호 :<input type="password" placeholder="PASSWORD(max:20)" class="form-control" id="pw" name="pw" required maxlength="20">
							새 비밀번호 :<input type="password" placeholder="PASSWORD(max:20)" class="form-control" id="newpw" name="newpw" required maxlength="20">
						</div>

						<div class="form-group" style="text-align: center;">변경하시겠습니까?</div>
						<div class="form-group" style="text-align: center;">
							<button type="submit" class="btn btn-default">확인</button>
							<button type="reset" class="btn btn-default" data-dismiss="modal">취소</button>
						</div>
					</form>

				</div>
				 
			</div>
		</div>
	</div>




	<!-- 개인정보수정 Modal  -->

	<div id="infoFormModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">개인정보 수정</h4>
				</div>
				<div class="modal-body">

					<!-- 사진 삭제를 위한 hidden 폼 추가, submit버튼이 없다. -->
					<form action="studentinfoupdate.it" method="post" id="blindform">
						<div class="form-group">
							<input type="hidden" id="student_id" name="student_id" value="${sessionScope.logininfo.id_}"/> 
							이름 :<input type="text" placeholder="" class="form-control" id="name_" name="name_" required maxlength="20" value=""
								readonly> 
								
							주민번호 뒷자리 :<input type="password" placeholder="주민번호 뒷자리" class="form-control" id="ssn" name="ssn"
								required maxlength="20" readonly>
								
								 전화번호 :<input
								type="text" placeholder="PHONE" value="" class="form-control"
								id="phone" name="phone" required maxlength="20">
						</div>

						<div class="form-group" style="text-align: center;">변경하시겠습니까?</div>
						<div class="form-group" style="text-align: center;">
							<button type="submit" class="btn btn-default">확인</button>
							<button type="reset" class="btn btn-default" data-dismiss="modal">취소</button>
						</div>
					</form>

				</div>
				 
			</div>
		</div>
	</div>



</body>
</html>