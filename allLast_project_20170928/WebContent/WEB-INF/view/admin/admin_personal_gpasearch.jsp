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
	//조회2버튼
	$(document).ready(function() {

		$(".stuinfo").on("click", function() {
			var key = $("#key").val();
			var value = $("#value").val();
			$.get("admin_personal_search.it", {
				key : key,
				value : value
			}, function(data) {
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
			<h2>수강생 관리</h2>
			<!-- /. ROW  -->
			<hr />
			<!--검색하기  -->
			<div class="form-group" style="text-align: center;">
				<form method="post" class="form-inline" method="post">
					<select class="form-control" id="key" name="key"
						style="display: inline; width: auto;">
						<option value="student_id">수강생ID</option>
						<!-- option의 value는 검색의 key 값 -->
						<option value="student_name">수강생명</option>
						<option value="student_phone">전화번호</option>
					</select> <input type="text" class="form-control" id="value" name="value"
						required="required" style="display: inline; width: auto;">
					<!-- value가 된다. -->


					<button type="button" class="btn btn-default btn-xs stuinfo"
						value="">조회</button>



				</form>
			</div>
			<div id="demo"></div>
			<!--
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
								<tr>
									<td>st_013</td>
									<td>최혜진</td>
									<td>010-3518-8447</td>
									<td>1</td>
									<td>2016-06-09</td>
									<td><button type="button"
											class="btn btn-default btn-xs btnocinfo">과정조회</button></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div id="demo1"></div>
						
					  
					<div class="panel-heading" id="demo2">
						<h2>수강생ID: st_013, 수강생명: 최혜진 의 과정 정보</h2>
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
									<tr>
										<td>oc_003</td>
										<td>IT정보보안 및 네트워크</td>
										<td>2016-06-04</td>
										<td>2016-12-01</td>
										<td>강의실3</td>
										<td><button type="button"
												class="btn btn-default btn-xs btngpainfo">성적조회</button></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div> 
				</div>-->

			<!-- /. ROW  -->

		</div>
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





