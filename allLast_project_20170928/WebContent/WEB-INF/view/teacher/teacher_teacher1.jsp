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
		})
		$(".btnRoom").on("click", function() {
			$("#roomModal").modal();
		});

		$(".btninfo").on("click", function() {
			var os_id = $(this).val();
			var teacher_id = "tea_001";
			$.get("teacher_schedulesubject.it", {
				teacher_id : teacher_id,
				os_id : os_id
			}, function(data) {
				$("div#demo").html(data);
			});
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
				<h2>강의 스케줄 조회 > 강의 예정</h2>
				<!-- /. ROW  -->
				<hr />
				<div class="panel panel-default">
					<div class="panel-body">

						<table class="table">
							<thead>
								<tr>
									<th>과목ID</th>
									<th>과목명</th>
									<th>과목시작</th>
									<th>과목종료</th>
									<th>과정명</th>
									<th>과정시작</th>
									<th>과정종료</th>
									<th>강의실명</th>
									<th>교재명</th>
									<th>수강인원</th>
									<th>조회</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach var="t" items="${ScheduleList}">
									<tr>
										<td>${t.os_id}</td>
										<td>${t.able_subject}</td>
										<td>${t.os_begin }</td>
										<td>${t.os_end }</td>
										<td>${t.course_name }</td>
										<td>${t.oc_begin }</td>
										<td>${t.oc_end }</td>
										<td>${t.room_name }</td>
										<td><button type="button" class="btn btn-default btn-xs btnimage" data-toggle="modal" data-target="#imageModal" value="${t.textbook_name}">${t.textbook_name}</button></td>
										<td>${t.st_count }</td>
										<td><button type="button"
												class="btn btn-default btn-xs btninfo" value="${t.os_id }">조회</button></td>

									</tr>
								</c:forEach>

								<tr>
									<!-- 
									<td>os_003</td>
									<td>C언어</td>
									<td>2017-07-27</td>
									<td>2017-11-27</td>
									<td>C언어/자바프로그래밍 개발자</td>
									<td>2017-07-27</td>
									<td>2018-02-27</td>
									<td>강의실5</td>
									<td><a href="#" data-toggle="modal" data-target="#imageModal">예제로 배우는 C언어 프로그래밍</a></td>
									<td>3</td>
									<td><button type="button" class="btn btn-default btn-xs btninfo">조회</button></td>
								</tr>
								
								<tr>
									<td>room_002</td>
									<td>강의실2</td>
									<td>30</td>
									<td><button type="button" class="btn btn-default btn-xs">수정</button></td>
									<td><button type="button" class="btn btn-default btn-xs">삭제</button></td>
								</tr>
								<tr>
									<td>room_003</td>
									<td>강의실3</td>
									<td>35</td>
									<td><button type="button" class="btn btn-default btn-xs">수정</button></td>
									<td><button type="button" class="btn btn-default btn-xs">삭제</button></td>
								</tr>
								<tr>
									<td>room_004</td>
									<td>강의실4</td>
									<td>22</td>
									<td><button type="button" class="btn btn-default btn-xs">수정</button></td>
									<td><button type="button" class="btn btn-default btn-xs">삭제</button></td>
								</tr>
								<tr>
									<td>room_005</td>
									<td>강의실5</td>
									<td>25</td>
									<td><button type="button" class="btn btn-default btn-xs">수정</button></td>
									<td><button type="button" class="btn btn-default btn-xs">삭제</button></td>
								</tr> -->
							</tbody>
						</table>
					</div>
					<div id="demo"></div>
				</div>

			</div>
		</div>

	<!-- Modal -->
	<div id="roomModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4>과목 추가</h4>
				</div>
				<div class="modal-body">
					<form role="form" method="post" action="">
						<div class="form-group">
							<label for="ROOM_NAME"> 강의실명 :</label> <input type="text"
								class="form-control" id="ROOM_NAME" name="ROOM_NAME"
								placeholder="40자 내로 입력" required="required">
						</div>
						<div class="form-group">
							<label for="ROOM_COUNT"> 강의실 정원 :</label> <input type="text"
								class="form-control" id="ROOM_COUNT" name="ROOM_COUNT"
								placeholder="" required="required">
						</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default btn-sm" id="">등록</button>
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
	
	

</body>
</html>
