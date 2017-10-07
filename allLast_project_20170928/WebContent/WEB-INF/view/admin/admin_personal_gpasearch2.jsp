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

		$(".btnocinfo").on("click", function() {
			student_id = $(this).val();
			$.get("admin_studentbasicInfo.it", {
				student_id : student_id
			}, function(data) {
				$("div#demo2").html(data);
			});
		});

	})
</script>
</head>
<body>

	<div class="panel-heading">
		<div class="panel-body">

			<table class="table">
				<thead>
					<tr>
						<th>수강생ID</th>
						<th>수강생명</th>
						<th>전화번호</th>
						<th>수강횟수</th>
						<th>등록일</th>
						<th>과정조회</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${admin_personal_gpa}">
						<tr>
							<td>${a.student_id }</td>
							<td>${a.student_name }</td>
							<td>${a.student_phone }</td>
							<c:forEach var="st" items="${st_count}">
								<td>${st.st_count}</td>
							</c:forEach>
							<td>${a.student_hiredate}</td>
							<td><button type="button"
									class="btn btn-default btn-xs btnocinfo" value="${a.student_id}">과정조회</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<div id="demo2"></div>

	</div>


</body>
</html>





