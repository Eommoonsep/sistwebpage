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
					
					<div class="panel-heading">
						<h2>수강생ID: ${st_end_top.student_id}, 수강생명: ${st_end_top.student_name}, 과정ID: ${st_end_top.oc_id}, 과정명: ${st_end_top.course_name}(${st_end_top.oc_begin} ~ ${st_end_top.oc_end})의 성적</h2>
						
						<hr>
						</div>
						<div class="panel-body">

							<table class="table">
								<thead>
								
									<tr>
										<th>과목 ID</th>
										<th>과목명</th>
										<th>과목시작</th>
										<th>과목종료</th>
										<th>강사명</th>
										<th>출결배점</th>
										<th>필기배점</th>
										<th>실기배점</th>
										<th>출결</th>
										<th>필기</th>
										<th>실기</th>
										<th>총점</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="os" items="${st_total_gpa}">
									<tr>
										<td>${os.os_id}</td>
										<td>${os.subject_name}</td>
										<td>${os.os_begin}</td>
										<td>${os.os_end}</td>
										<td>${os.teacher_name}</td>
										<td>${os.sc_attend}</td>
										<td>${os.sc_written}</td>
										<td>${os.sc_practice}</td>
										<td>${os.grade_attend}</td>
										<td>${os.grade_written}</td>
										<td>${os.grade_practice}</td>
										<td>${os.grade_total}</td>
									</tr>
									
									<!--  
									<tr>
										<td>os_059</td>
										<td>C언어</td>
										<td>2016-03-03</td>
										<td>2016-05-28</td>
										<td>김사랑</td>
										<td>25</td>
										<td>35</td>
										<td>40</td>
										<td>24</td>
										<td>32</td>
										<td>34</td>
										<td>90</td>
									</tr>
									<tr>
										<td>os_081</td>
										<td>정보보안</td>
										<td>2016-05-28</td>
										<td>2016-08-11</td>
										<td>김사랑</td>
										<td>25</td>
										<td>35</td>
										<td>40</td>
										<td>20</td>
										<td>39</td>
										<td>35</td>
										<td>94</td>
									</tr>
									-->
									</c:forEach>
								</tbody>
							</table>
						</div>
					
			
</body>
</html>





