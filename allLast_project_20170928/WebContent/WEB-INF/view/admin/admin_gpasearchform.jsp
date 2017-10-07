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
		$(".btninfo1").on("click", function() {
			oc_id = $(this).val();
			$("#oc_id").val(oc_id);
			$.get("admin_ocbasicInfo.it", {
				oc_id : oc_id
			}, function(data) {
				console.log(data);
				$("div#demo").html(data);
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
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<c:import url="menuadmin.jsp" />
			</div>

		</nav>



	
						
						<!-- /. NAV SIDE  -->
						<div id="page-wrapper">
						<div id="page-inner">
						<!--성적 조회 > 과정 출력  -->
						<h2>성적 조회 > 과정/과목/과목별 학생 성적</h2>
							<!-- /. ROW  -->
							<hr />
					<div class="panel panel-default">
					<table class="table">
							<thead>
								<tr>
									<th>과정 ID</th>
									<th>과정명</th>
									<th>과정시작</th>
									<th>과정종료</th>
									<th>과목수</th>
									<th>강의실</th>
									<th>수강인원</th>
									<th>조회</th>
								</tr>
							</thead>
							<tbody>
							<!-- 
								<tr>
									<td>oc_001</td>
									<td>JAVA Enterprise System 개발자 양성과정</td>
									<td>2016-04-05</td>
									<td>2016-10-02</td>
									<td>3</td>
									<td>강의실1</td>
									<td>3</td>
									
									<td>oc_001</td>
									<td>JAVA Enterprise System 개발자 양성과정</td>
									<td>2016-04-05</td>
									<td>2016-10-02</td>
									<td>3</td>
									<td>강의실1</td>
									<td>3</td>
									 -->
									 <c:forEach var="g" items="${admin_gpasearch_info}">
									 <tr>
									 <td>${g.oc_id}</td>
									 <td>${g.course_name}</td>
									 <td>${g.oc_begin}</td>
									 <td>${g.oc_end}</td>
									 <td>${g.os_count}</td>
									 <td>${g.room_name}</td>
									 <td>${g.st_count}</td>
									 <td><button type="button"
											class="btn btn-default btn-xs btninfo1" value="${g.oc_id}" >조회</button></td>
									 
									 </tr>
									 </c:forEach>
								<!-- 	 
								<tr>
									<td>oc_002</td>
									<td>JAVA Enterprise System 개발자 양성과정</td>
									<td>2016-05-05</td>
									<td>2016-11-01</td>
									<td>2</td>
									<td>강의실2</td>
									<td>5</td>
									<td><button type="button"
											class="btn btn-default btn-xs btninfo1">조회</button></td>

								</tr>
								<tr>
									<td>oc_003</td>
									<td>JAVA Enterprise System 개발자 양성과정</td>
									<td>2016-07-04</td>
									<td>2016-12-31</td>
									<td>2</td>
									<td>강의실3</td>
									<td>3</td>
									<td><button type="button"
											class="btn btn-default btn-xs btninfo1">조회</button></td>

								</tr>
								 -->
								 
							</tbody>
						</table>

					
				</div>
				<div id="demo"></div>
			</div>
		</div>
		<!-- /. ROW  -->
		
	</div>
	<!-- /. PAGE INNER  -->
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