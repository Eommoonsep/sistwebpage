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


		<!--성적 조회 > 과목별 개인 성적 조회  -->
		<!-- 여기서 os_id2이름의 임시변수 호출 -->
		<c:forEach var="os" items="${os_id2}">
			<h2>과목ID: ${os.os_id}, 과목명: ${os.subject_name} (${os.os_begin} ~
				${os.os_end})의 성적정보, 출결배점: ${os.sc_attend}, 필기배점: ${os.sc_written},
				실기배점: ${os.sc_practice}</h2>
		</c:forEach>
		<hr />
		<div class="panel panel-default">
			<table class="table">
				<thead>
					<tr>
						<th>수강생 ID</th>
						<th>수강생명</th>
						<th>전화번호</th>
						<th>출결</th>
						<th>필기</th>
						<th>실기</th>
						<th>총점</th>
					</tr>
				</thead>
				<tbody>
					<!-- 
				<tr>
					<td>st_027</td>
					<td>고미진</td>
					<td>010-1585-2651</td>
					<td>30</td>
					<td>35</td>
					<td>30</td>
					<td>95</td>
				</tr>
				<tr>
					<td>st_054</td>
					<td>신정선</td>
					<td>010-5855-0581</td>
					<td>30</td>
					<td>35</td>
					<td>30</td>
					<td>95</td>
				</tr>
				<tr>
					<td>st_061</td>
					<td>안지혜</td>
					<td>010-8545-2588</td>
					<td>25</td>
					<td>32</td>
					<td>29</td>
					<td>86</td>
				</tr>
				 -->
					<c:forEach var="stu" items="${osstudent}">
						<tr>
							<td>${stu.student_id}</td>
							<td>${stu.student_name}</td>
							<td>${stu.student_phone}</td>
							<td>${stu.grade_attend}</td>
							<td>${stu.grade_written}</td>
							<td>${stu.grade_practice}</td>
							<td>${stu.grade_total}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<div id="demo3"></div>



</body>
</html>