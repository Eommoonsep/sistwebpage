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
		/* 
		///hide() 메소드 특정 영역이 화면에 보이지 않도록 설정
		$("#myQABoardInsertForm").find("#pwForm")
				.hide();
		$("#myQABoardInsertForm").find("#pwForm").find(
				"#pw").attr("disabled", "disabled");
		}
		 */

		$("button.btninfo").on("click", function() {
			var os_id = $(this).val();
			var teacher_id = "tea_001";
			$.get("teacher_subject.it", {
				teacher_id : teacher_id,
				os_id : os_id
			}, function(data) {
				//최종적으로 뿌린다
				$("div#demo").html(data);
			});
			var os_id = $(this).parents("tr").find("td:eq(0)").text();
			var os_begin = $(this).parents("tr").find("td:eq(1)").text();
			var os_end = $(this).parents("tr").find("td:eq(2)").text();
			var subject_name = $(this).parents("tr").find("td:eq(3)").text();
			$("#teacherinfoModal #subject_id").val(os_id);
			$("#teacherinfoModal #os_begin").val(os_begin);
			$("#teacherinfoModal #os_end").val(os_end);
			$("#teacherinfoModal #subject_name").val(subject_name);
		});
		$(document).on("click", ".btnInsert", function() {
			var st_id = $(this).parents("tr").find("td:eq(0)").text();
			var student_name = $(this).parents("tr").find("td:eq(1)").text();
			$("#teacherinfoModal #student_id").val(st_id);
			$("#teacherinfoModal #student_name").val(student_name);

		});

		//이미지버튼
		$(document).on("click", ".btnimage", function() {
			var textbook_name = $(this).val();

			$.get("teacher_opensubjectimageform.it", {
				textbook_name : textbook_name
			}, function(data) {
				$("div#image").html(data);
			});
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
				<span class="logout-spn"> 강사 (${sessionScope.logininfo.id_})
					님 <a href="logout.it" style="color: #fff;">LOGOUT</a>
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
			<h2>성적 관리 > 과목 선택</h2>
			<!-- /. ROW  -->
			<hr />
			<div class="panel panel-default">

				<table class="table">
					<thead>
						<tr>
							<th>과목ID</th>
							<th>과목명</th>
							<th>과목시작</th>
							<th>과목종료</th>
							<th style="width: 130px;">과정명</th>
							<th>과정시작</th>
							<th>과정종료</th>
							<th style="width: 80px;">강의실명</th>
							<th style="width: 80px;">교재명</th>
							<th style="width: 80px;">출결배점</th>
							<th style="width: 80px;">필기배점</th>
							<th style="width: 80px;">실기배점</th>
							<th style="width: 100px;">전체학생수</th>
							<th style="width: 100px;">성적입력수</th>

							<th>조회</th>
						</tr>
					</thead>
					<tbody>


						<c:forEach var="t" items="${ScoreList2}">
							<tr>
								<td>${t.os_id }</td>
								<td>${t.able_subject }</td>
								<td>${t.os_begin }</td>
								<td>${t.os_end }</td>
								<td>${t.course_name }</td>
								<td>${t.oc_begin }</td>
								<td>${t.oc_end }</td>
								<td>${t.room_name }</td>
								<td><button type="button"
										class="btn btn-default btn-xs btnimage" data-toggle="modal"
										data-target="#imageModal" value="${t.textbook_name}">${t.textbook_name}</button></td>
								<td>${t.sc_attend }</td>
								<td>${t.sc_written }</td>
								<td>${t.sc_practice }</td>
								<td>${t.st_count }</td>
								<td>${t.g_count }</td>
								<td><button type="button" class="btn btn-default btninfo"
										value="${t.os_id}">조회</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="demo"></div>
		</div>

	</div>

	<!--이미지 Modal -->
	<div id="imageModal" class="modal fade" role="dialog"
		style="width: 100%;">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" id="image"></div>
		</div>
	</div>



	<!-- teacherinfoModal -->

	<div id="teacherinfoModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">성적 입력</h4>
				</div>
				<div class="modal-body">

					<form class="form-horizontal"
						action="${pageContext.request.contextPath}/teacher_subjectInsert.it"
						method="post">

						<div class="form-group">
							<label class="control-label col-sm-3" for="subject_id">과목명ID:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control " id="subject_id"
									name="subject_id" value="" readonly>
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-sm-3" for="subject_name">과목명:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="subject_name"
									name="subject_name" value="" min="7" max="7" readonly>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="os_begin">과목시작:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="os_begin"
									name="os_begin" value="" readonly>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="os_end">과목종료:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="os_end"
									name="os_end" value="" readonly>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="student_id">아이디:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="student_id"
									name="student_id" value="" readonly>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="student_name">수강생:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="student_name"
									name="student_name" value="" readonly>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-3" for="grade_attend">출결:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="grade_attend"
									name="grade_attend" value="" placeholder="MAX(20)">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="grade_written">필기:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="grade_written"
									name="grade_written" value="" placeholder="MAX(40)">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="grade_practice">실기:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="grade_practice"
									name="grade_practice" value="" placeholder="MAX(40)">
							</div>
						</div>


						<hr>
						<div style="text-align: center">
							<button type="submit" class="btn btn-default btn-sm ">입력</button>
							<button type="button" class="btn btn-default btn-sm"
								data-dismiss="modal">취소</button>
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- 아래에 배너 넣기 위한 기능 -->
	<!-- /. PAGE INNER  -->
	<!-- /. PAGE WRAPPER  -->
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

