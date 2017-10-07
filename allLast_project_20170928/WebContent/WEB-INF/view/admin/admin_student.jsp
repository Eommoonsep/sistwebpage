<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Simple Responsive Admin</title>
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
	font-size: 16px;
}

ul li ul li {
	list-style-type: none;
}

ul li ul li:hover {
	background: #F3F3F3;
}
</style>
<script>
	$(document).ready(
			function() {

				//조회버튼
				$(".btninfo").on("click", function() {
					var student_id = $(this).val();
					$.get("admin_studentcourse.it", {
						student_id : student_id
					}, function(data) {
						$("div#demo").html(data);

					});
				});
				$(".btnStudent").on("click", function() {
					$("#studentModal").modal();
				});

				//과정추가 버튼
				$(document).on("click",".btnstudentcourse", function() {
					var student_id = $(this).val();
					console.log($(this).val());
					$("#studentcourseModal").modal();
					
					$.get("admin_studentcourseinsertform.it",{student_id:student_id}, function(data) {
						$("div#courseinsert").html(data);
					});
				});

				//탈락버튼
				$(document).on("click",".btndropout", function() {
					var student_id = $(this).val();
					console.log($(".btninfo").val());
					$("#dropoutModal").modal();
					$.get("admin_studentindropform.it",{student_id:student_id}, function(data) {
						$("div#drop").html(data);
					});
				});
				//과정취소버튼
				$(document).on("click",".btncoursecancel", function() {
					$("#coursecancelModal").modal();
					var student_id = $(this).val();
					$.get("admin_studentcoursedeleteform.it", {student_id : student_id}, function(data) {
						$("div#deleteform").html(data);

					});
				});

				//수정버튼
				$(".btnupdate").on("click", function() {
					$("#studentupdateModal").modal();
					var student_id = $(this).val();
					$.get("admin_studentupdateform.it", {student_id : student_id}, function(data) {
						$("div#update").html(data);

					});
				});
				//삭제버튼
				$(".btndelete").on("click", function() {
					$("#studentdeleteModal #student_id2").val($(this).val());
					$("#studentpdeleteModal").modal();

				});

				//검색 진행후 검색 key, value를 유지하는 과정 추가
				var key = "${key}";
				var value = "${value}";
				$("select#key > option[value='" + key + "']").attr("selected",
						"selected"); //selected="selected" 속성 추가
				$("input#value").val(value); //value="" 속성에 특정 값 지정
			})
</script>
</head>
<body>


  <c:import url="menuadmin.jsp" />
 
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<h2>수강생 관리</h2>
				<!-- /. ROW  -->
				<hr />
				<!--검색하기  -->
				<div class="form-group" style="text-align: center;">
					<form method="post" class="form-inline" method="post">
						<select class="form-control" id="key" name="key"
							style="display: inline; width: auto;">
							<option value="student_id">수강생ID</option>
							<option value="student_name">수강생명</option>
							<option value="student_phone">전화번호</option>
						</select> <input type="text" class="form-control" id="value" name="value"
							required="required" style="display: inline; width: auto;">

						<button type="submit" class="btn btn-default  studentInfo">조회</button>
					</form>
				</div>

				<div class="panel panel-default" style="overflow: auto; width:100%; height:500px;">


					<table class="table">
						<thead>
							<tr>
								<th>수강생ID</th>
								<th>수강생명</th>
								<th>전화번호</th>
								<th>수강횟수</th>
								<th>등록일</th>
								<th>조회</th>
								<th>수정</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<!-- <tr>
								<td>st_001</td>
								<td>최혜진</td>
								<td>010-5532-7535</td>
								<td>1</td>
								<td>2014-12-01</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btnupdate" data-toggle="modal"
										data-target="#studentupdateModal">수정</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btndelete" data-toggle="modal"
										data-target="#studentdeleteModal" disabled>삭제</button></td>
							</tr>
							<tr>
								<td>st_002</td>
								<td>최혜진</td>
								<td>010-5532-7535</td>
								<td>1</td>
								<td>2014-12-01</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btnupdate" data-toggle="modal"
										data-target="#studentupdateModal">수정</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btndelete" data-toggle="modal"
										data-target="#studentdeleteModal">삭제</button></td>
							</tr>
							<tr>
								<td>st_003</td>
								<td>최혜진</td>
								<td>010-5532-7535</td>
								<td>1</td>
								<td>2014-12-01</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btnupdate" data-toggle="modal"
										data-target="#studentupdateModal">수정</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btndelete" data-toggle="modal"
										data-target="#studentdeleteModal" disabled>삭제</button></td>
							</tr> -->
							<c:forEach var="s" items="${studentlist}">
								<tr>
									<td>${s.student_id}</td>
									<td>${s.student_name}</td>
									<td>${s.student_phone}</td>
									<td>${s.course_count}</td>
									<td>${s.student_hiredate}</td>
									<td><button type="button"
											class="btn btn-default btn-xs btninfo"
											value="${s.student_id}">조회</button></td>
									<td><button type="button" id="student_id"
											class="btn btn-default btn-xs btnupdate" data-toggle="modal"
											data-target="#studentupdateModal" value="${s.student_id}">수정</button></td>
									<c:if test="${s.course_count == 0}">
										<td><button type="button"
												class="btn btn-default btn-xs btndelete" data-toggle="modal"
												data-target="#studentdeleteModal" value="${s.student_id}">삭제</button></td>
									</c:if>
									<c:if test="${s.course_count != 0}">
										<td><button type="button"
												class="btn btn-default btn-xs btndelete" data-toggle="modal"
												data-target="#studentdeleteModal" value="${s.student_id}"
												disabled>삭제</button></td>
									</c:if>
								</tr>
							</c:forEach>

						</tbody>
					</table>
					<button type="button" class="btn btn-default  btnStudent"
						data-toggle="modal" data-target="#studentModal">수강생입력</button>

				</div>

				<div id="demo"></div>
			</div>

		</div>

		<!-- /. ROW  -->
 
	<!-- /. PAGE INNER  -->
	<div class="footer">


		<div class="row">
			<div class="col-lg-12">
				&copy; 2014 yourdomain.com | Design by: <a
					href="http://binarytheme.com" style="color: #fff;" target="_blank">www.binarytheme.com</a>
			</div>
		</div>
	</div>


	<!-- 수강생 과정 취소  Modal -->
	<div id="coursecancelModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>수강생 과정 취소</h1>
				</div>
				<div class="modal-body" id="deleteform">
					
				</div>

			</div>

		</div>

	</div>


	<!-- 탈락 Modal  -->
	<div id="dropoutModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>수강생 과정탈락</h1>
				</div>
				<div class="modal-body" id="drop">
					
				</div>

			</div>

		</div>

	</div>







	<!--수강생 입력 Modal -->
	<div id="studentModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>신규 수강생 추가</h1>
				</div>
				<div class="modal-body">
					<form role="form" method="post" action="admin_studentinsert.it">
						<div class="form-group">


							<label for="course_openday"> 수강생명 :</label> <input type="text"
								class="form-control" id="student_name" name="student_name"
								required="required"> <label for="course_closeday">주민번호뒷자리
								: :</label> <input type="text" class="form-control" id="student_ssn"
								name="student_ssn" required="required"> <label
								for="phone"> 전화번호 :</label> <input type="text"
								class="form-control" id="student_phone" name="student_phone"
								required="required">
						</div>

						<div class="modal-footer">
							<button type="submit" class="btn btn-default"
								id="memberInsertForm">등록</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">취소</button>
						</div>

					</form>

				</div>

			</div>

		</div>

	</div>




	<!--수강생과정추가  Modal -->
	<div id="studentcourseModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>수강생과정추가</h1>
				</div>
				<div class="modal-body" id="courseinsert">
					

				</div>

			</div>

		</div>

	</div>




	<!--수강생 정보 수정 Modal  -->
	<div id="studentupdateModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>수강생정보 수정</h1>
				</div>
				<div class="modal-body" id="update">
					

				</div>

			</div>

		</div>

	</div>




	<!--수강생 정보 삭제 Modal  -->
	<div id="studentdeleteModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-footer" style="text-align: center;">
					<h4>수강생 정보를 삭제 하시겠습니까?</h4>
					<form role="form" method="post" action="admin_studentdelete.it">
						<div class="modal-footer">
							<button type="submit" class="btn btn-default btn-sm" id="modal">확인</button>
							<button type="button" class="btn btn-default btn-sm"
								data-dismiss="modal">취소</button>
						</div>
						<input type="hidden" id="student_id2" name="student_id2" value="">
					</form>
				</div>
			</div>

		</div>

	</div>
</body>
</html>