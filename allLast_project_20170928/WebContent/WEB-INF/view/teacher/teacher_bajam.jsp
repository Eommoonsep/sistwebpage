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
		//배점 입력
		$(".btninfo").on("click", function() {
			$("#bajamModal #os_id").val($(this).val());
			$("#bajamModal").modal();
		});

		//배점 삭제
		$(".btndelete").on("click", function() {
			$("#btndeleteModal #os_id").val($(this).val());
			$("#btndeleteModal").modal();
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
	})
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
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<h2>배점 관리 > 과목 선택</h2>
			<!-- /. ROW  -->
			<hr />
			<div class="panel panel-default">
				<table class="table">
					<thead>
						<tr>
							<th>과목ID</th>
							<th style="width: 70px;">과목명</th>
							<th style="width: 80px;">과목시작</th>
							<th style="width: 80px;">과목종료</th>
							<th style="width: 100px;">과정명</th>
							<th style="width: 80px;">과정시작</th>
							<th style="width: 80px;">과정종료</th>
							<th style="width: 80px;">강의실명</th>
							<th>교재명</th>
							<th style="width: 80px;">수강인원</th>
							<th style="width: 80px;">출결배점</th>
							<th style="width: 80px;">필기배점</th>
							<th style="width: 80px;">실기배점</th>
							<th style="width: 80px;">시험날짜</th>
							<th style="width: 80px;">시험문제</th>
							<th>입력</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="t" items="${ScoreManagingList1}">
							<tr>
								<td>${t.os_id }</td>
								<td>${t.able_subject }</td>
								<td>${t.os_begin }</td>
								<td>${t.os_end }</td>
								<td>${t.course_name }</td>
								<td>${t.oc_begin }</td>
								<td>${t.oc_end }</td>
								<td>${t.room_name }</td>
								<td><button type="button" class="btn btn-default btn-xs btnimage" data-toggle="modal" data-target="#imageModal" value="${t.textbook_name}">${t.textbook_name}</button></td>
								<td>${t.st_count }</td>
								<td>${t.sc_attend }</td>
								<td>${t.sc_written }</td>
								<td>${t.sc_practice }</td>
								<td>${t.ex_date }</td>
								<td><a
									href="${pageContext.request.contextPath}/img/${t.ex_qs }">
										${t.ex_qs }</a></td>

								<td><button type="submit"
										class="btn btn-default btn-xs btninfo" data-toggle="modal"
										data-target="#bajamModal" value="${t.os_id}">입력</button></td>
								<td><button type="submit"
										class="btn btn-default btn-xs btndelete" data-toggle="modal"
										data-target="#btndeleteModal" value="${t.os_id}">삭제</button></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div id="demo"></div>
			</div>

		</div>

	</div>



	<!-- Modal -->
	<div id="bajamModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>배점 입력</h1>
					<br>
					<div>
						<h4>출결, 필기, 실기의 총 배점은 100점입니다.</h4>
					</div>
					<h4>100점보다 적거나 많을 수 없습니다.</h4>
				</div>
				<div class="modal-body">

					<form role="form"
						action="${pageContext.request.contextPath}/teacher_subjectbajam.it"
						method="post">
						<%-- <c:forEach var="os" items="${teacher_bajam}">  --%>

						<div class="form-group">
							<input type="hidden" class="form-control" id="os_id" name="os_id"
								placeholder="" required="required" value="${os_id}">
						</div>

						<div class="form-group">
							<label for="sc_attend"> 출결 :</label> <input type="text"
								class="form-control" id="sc_attend" name="sc_attend"
								placeholder="" required="required">
						</div>
						<div class="form-group">
							<label for="sc_written"> 필기 :</label> <input type="text"
								class="form-control" id="sc_written" name="sc_written"
								placeholder="" required="required">
						</div>
						<div class="form-group">
							<label for="sc_practice"> 실기 :</label> <input type="text"
								class="form-control" id="sc_practice" name="sc_practice"
								placeholder="" required="required">
						</div>
						<div class="form-group">
							<label for="ex_date"> 시험날짜 :</label> <input type="text"
								class="calender" id="ex_date" name="ex_date"
								placeholder="시험일(YYYY-MM-DD)" required="required">
						</div>
						<div class="form-group">
							<label for="ex_qs"> 시험문제 :</label> <input type="file"
								class="ex_qs" id="ex_qs" name="ex_qs" required="required">
						</div>
						<%-- </c:forEach>    --%>
						<div class="modal-footer">
							<button type="submit" class="btn btn-default btn-sm" id="">입력</button>
							<button type="button" class="btn btn-default btn-sm"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
	<!-- Modal -->
	<div id="btndeleteModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>배점 삭제</h1>
					<br>
					<div>
						<h4>배점을 삭제하시겠습니까?</h4>
					</div>
				</div>
				<div class="modal-body"></div>
				<form role="form"
					action="${pageContext.request.contextPath}/teachergradedelete.it"
					method="post">

					<div class="form-group">
						<input type="hidden" class="form-control" id="os_id" name="os_id"
							placeholder="" required="required" value="${os_id}">
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





	<!--이미지 Modal -->
	<div id="imageModal" class="modal fade" role="dialog"
		style="width: 100%;">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" id="image"></div>
		</div>
	</div>
	
	

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
