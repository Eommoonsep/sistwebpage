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
	
 
 
<script>
	$(document).ready(function() {

		$("button.btninfo").on("click", function() {

			var oc_id = $(this).val();
			 
			$.get("student_subject.it", {
				oc_id : oc_id,
				 
			}, function(data) {

				$("div#demo").html(data);
			});
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
					<h2>성적 조회</h2>
				</div>
			</div>

			<hr />


			<div class="container-fluid">
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>과정ID</th>
									<th style="width: 30%;">과정명</th>
									<th>과정시작</th>
									<th>과정종료</th>
									<th>과목수</th>
									<th>강의실</th>
									<th>과목조회</th>
								</tr>
							</thead>
							<tbody>

								<!-- 
								<tr>
									<td>os_001</td>
									<td>JAVA기반 응용SW엔지니어 실무과정</td>
									<td>2017-04-01</td>
									<td>2017-04-30</td>
									<td>2</td>
									<td>강의실2</td>
									<td><button type="button" class="btn btn-default btninfo">과목조회</button></td>
								</tr>
							 -->
								<c:forEach var="s" items="${studentcourselist}">
									<tr>
										<td>${s.oc_id}</td>
										<td>${s.course_name }</td>
										<td>${s.oc_begin }</td>
										<td>${s.oc_end }</td>
										<td>${s.os_count }</td>
										<td>${s.room_name }</td>
										<td><button type="button" class="btn btn-default btninfo"
												value="${s.oc_id }">과목조회</button></td>

									</tr>

								</c:forEach>

							</tbody>
						</table>
					</div>

				</div>
					<div id="demo"></div>

			</div>


		</div>
		<!-- /. PAGE INNER  -->
	</div>
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