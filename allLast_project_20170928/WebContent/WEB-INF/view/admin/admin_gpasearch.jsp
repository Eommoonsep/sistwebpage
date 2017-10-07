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
	$(document).ready(function() {

		//성적조회>과정&과목별 성적 조회 클릭시 나오는 과정정보 
		$(".btninfo2").on("click", function() {
			os_id = $(this).val();
			$("#oc_id").val(oc_id);
			$.get("admin_os_studentInfo.it", {
				os_id : os_id
			}, function(data) {
				console.log(data);
				$("div#demo2").html(data);
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
					<a class="navbar-brand" href="#"> <img src="img/sist_white.png"
						style="width: 250px; margin-top: 8px;" />


					</a>

				</div>

				<span class="logout-spn"> <a href="#" style="color: #fff;"><i
						class="fa fa-sign-out" aria-hidden="true"> LOGOUT</i></a>

				</span>
			</div>
		</div>




		<c:forEach var="bt" items="${basictoplist}">
			<h2>과정 ID: ${bt.oc_id}, 과정명: ${bt.course_name} (${bt.oc_begin} ~
				${bt.oc_end}) 과목정보</h2>
		</c:forEach>
		<hr />
		<div class="panel panel-default">
			<table class="table">
				<thead>
					<tr>
						<th>과목 ID</th>
						<th>과목명</th>
						<th>과목시작</th>
						<th>과목종료</th>
						<th>교재명</th>
						<th>강의실</th>
						<th>강사명</th>
						<th>성적등록여부</th>
						<th>시험문제파일등록여부</th>
						<th>조회</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" items="${subject}">

						<tr>
							<td>${s.os_id}</td>
							<td>${s.subject_name}</td>
							<td>${s.os_begin}</td>
							<td>${s.os_end}</td>
							<td>${s.textbook_name}</td>
							<td>${s.room_name}</td>
							<td>${s.teacher_name}</td>
							<td>${(s.score_regi_ck=="0")?"X":"O"}</td><!-- String 자료형이니까-> 0이면 x출력 아니면 o출력 -->
							<td>${(s.ex_qs_ck=="0")?"X":"O"}</td>
							<td><button type="button"
									class="btn btn-default btn-xs btninfo2" value="${s.os_id}">조회</button></td>
						</tr>
					</c:forEach>


					<!-- 
				<tr>
					<td>os_001</td>
					<td>Linux</td>
					<td>2016-07-04</td>
					<td>2016-09-02</td>
					<td>이것이 리눅스다</td>
					<td>강의실3</td>
					<td>하정우</td>
					<td>O</td>
					<td>O</td>
					<td><button type="button" class="btn btn-default btn-xs btninfo2">조회</button></td>
				</tr>
			 
				<tr>
					<td>os_005</td>
					<td>정보보안</td>
					<td>2016-09-03</td>
					<td>2016-11-02</td>
					<td>정보보안개론</td>
					<td>강의실3</td>
					<td>하정우</td>
					<td>O</td>
					<td>O</td>
					<td><button type="button" class="btn btn-default btn-xs btninfo2">조회</button></td>
				</tr>
					<tr>
					<td>os_008</td>
					<td>JAVA</td>
					<td>2016-11-03</td>
					<td>2016-12-30</td>
					<td>이것이 자바다</td>
					<td>강의실3</td>
					<td>하정우</td>
					<td>X</td>
					<td>X</td>
					<td><button type="button" class="btn btn-default btn-xs btninfo2">조회</button></td>
				</tr>
				
				-->
				</tbody>
			</table>
		</div>
	</div>
	<div id="demo2"></div>


</body>
</html>