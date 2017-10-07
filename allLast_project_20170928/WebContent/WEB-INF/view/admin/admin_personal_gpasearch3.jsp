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
		//조회3버튼
		$(".btngpainfo").on("click", function() {
			student_id = $(this).val();
			var oc_id = $(this).parents("tr").find("td:eq(0)").text();
			console.log(oc_id);
			$.get("admin_studentTotalgpa.it", {
				student_id : student_id,
				oc_id : oc_id
			}, function(data) {
				$("div#demo3").html(data);
			});
		});

	})
</script>
</head>
<body>
					<c:forEach var="s" items="${studentlist}">
					<div class="panel-heading">
						<h2>수강생ID: ${s.student_id}, 수강생명: ${s.student_name} 의 과정 정보</h2></div>
						<c:set var="student_id" value="${s.student_id}" />
						</c:forEach>
						<hr>
						<div class="panel-body">

							<table class="table">
								<thead>
								
									<tr>
										<th>과정 ID</th>
										<th>과정명</th>
										<th>과정시작</th>
										<th>과정종료</th>
										<th>강의실</th>
										<th>성적조회</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="oc" items="${st_oclist}">
									<tr>
										<td>${oc.oc_id}</td>
										<td>${oc.course_name}</td>
										<td>${oc.oc_begin}</td>
										<td>${oc.oc_end}</td>
										<td>${oc.room_name}</td>
										<td><button type="button"
												class="btn btn-default btn-xs btngpainfo" value="${student_id}">성적조회</button></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div id="demo3"></div>
				
					
</body>
</html>





