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

		//조회버튼
		$(".btninfo").on("click", function() {
			oc_id = $(this).val();
			$.get("admin_opencourseopensubject.it", {
				oc_id : oc_id
			}, function(data) {
				$("div#demo").html(data);
			});
		});

		//수정버튼
		$(document).on("click",".btnupdate", function() {
			var oc_id = $(this).val();
			
			$.get("admin_open_courseupdateform.it", {oc_id : oc_id}, function(data) {
				$("div#update").html(data);
			});
		});

		//삭제버튼
		$(".btndelete").on("click", function() {
			var oc_id = $(this).val();
			$("#ocDeleteModal #oc_id2").val(oc_id);
		});
		
		//이미지버튼
		$(document).on("click",".btnimage", function() {
			var textbook_name = $(this).val();
			
			$.get("admin_opencourseimageform.it", {textbook_name : textbook_name}, function(data) {
				$("div#image").html(data);
			});
		});
	})
</script>
</head>
<body>



<c:import url="menuadmin.jsp" />

		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<h2>개설 과정 관리</h2>
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
								<th>수정</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<!-- <tr>
								<td>oc_001</td>
								<td>JAVA기반 응용 SW엔지니어링 실무과정</td>
								<td>2017-01-01</td>
								<td>2018-03-02</td>
								<td>3</td>
								<td>강의실</td>
								<td>3명</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btnupdate" data-toggle="modal"
										data-target="#ocUpdateModal">수정</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btndelete" data-toggle="modal"
										data-target="#ocDeleteModal">삭제</button></td>
							</tr>
							<tr>
								<td>oc_002</td>
								<td>JAVA기반 응용 SW엔지니어링 실무과정</td>
								<td>2017-01-01</td>
								<td>2018-03-02</td>
								<td>3</td>
								<td>강의실</td>
								<td>3명</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btnupdate">수정</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btndelete">삭제</button></td>
							</tr>
							<tr>
								<td>oc_003</td>
								<td>JAVA기반 응용 SW엔지니어링 실무과정</td>
								<td>2017-01-01</td>
								<td>2018-03-02</td>
								<td>3</td>
								<td>강의실</td>
								<td>4명</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btnupdate" data-toggle="modal"
										data-target="#ocUpdateModal">수정</button></td>
								<td><button type="button"
										class="btn btn-default btn-xs btndelete" data-toggle="modal"
										data-target="#ocDeleteModal">삭제</button></td>
							</tr> -->
							<c:forEach var="cl" items="${courselist}">
								<tr>
									<td>${cl.oc_id}</td>
									<td>${cl.course_name}</td>
									<td>${cl.oc_begin}</td>
									<td>${cl.oc_end}</td>
									<td>${cl.os_count}</td>
									<td>${cl.room_name}</td>
									<td>${cl.st_count}</td>
									<td><button type="button"
											class="btn btn-default btn-xs btninfo" value="${cl.oc_id}">조회</button></td>
									<td><button type="button"
											class="btn btn-default btn-xs btnupdate" data-toggle="modal"
											data-target="#ocUpdateModal" value="${cl.oc_id}">수정</button></td>
									<c:if test="${cl.os_count == 0}">
									<td><button type="button"
											class="btn btn-default btn-xs btndelete" data-toggle="modal"
											data-target="#ocDeleteModal" value="${cl.oc_id}">삭제</button></td>
									</c:if>
									<c:if test="${cl.os_count != 0}">
									<td><button type="button"
											class="btn btn-default btn-xs btndelete" data-toggle="modal"
											data-target="#ocDeleteModal" value="${cl.oc_id}" disabled>삭제</button></td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<button type="button" class="btn btn-default btn-xs btnCurriculum"
						data-toggle="modal" data-target="#opencourseModal">개설과정등록</button>
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


	<!--개설과정등록 Modal -->
	<div id="opencourseModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>개설 과정 등록</h1>
				</div>
				<div class="modal-body">
					<form role="form" method="post" action="admin_opencourseinsert.it">
						<div class="form-group">
							<label for="course_id"> 과정 :</label>
							<div class="form-group">

								<select class="form-control" id="course_id" name="course_id">
									<c:forEach var="c" items="${course}">
										<option value="${c.course_id}">${c.course_id} ${c.course_name}</option>
									</c:forEach>
								</select>

							</div>

							<label for="oc_begin"> 과정개설날짜 :</label> <input type="text"
								class="form-control" id="oc_begin" name="oc_begin"
								required="required"> <label for="oc_end">과정종강날짜
								:</label> <input type="text" class="form-control" id="oc_end"
								name="oc_end" required="required"> <label for="room_id">
								사용 강의실 :</label>
							<div class="form-group">

								<select class="form-control" id="room_id" name="room_id">
									<c:forEach var="r" items="${room}">
										<option value="${r.room_id}">${r.room_name}</option>
									</c:forEach>
								</select>

							</div>

							<div class="modal-footer" style="text-align: center;">
								<button type="submit" class="btn btn-default btn-sm">등록</button>
								<button type="button" class="btn btn-default btn-sm"
									data-dismiss="modal">취소</button>
							</div>
						</div>
					</form>
				</div>

			</div>

		</div>

	</div>
	<!-- 수정버튼 Modal  -->
	<div id="ocUpdateModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>개설 과정 수정</h1>
				</div>
				<div class="modal-body" id="update">
					
				</div>
			</div>

		</div>

	</div>


	<!-- 삭제버튼 Modal  -->
	<div id="ocDeleteModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-footer" style="text-align: center;">
					<h4>삭제 하시겠습니까?</h4>
					<form role="form" method="post" action="admin_opencoursedelete.it">
						<input type="hidden" id="oc_id2" name="oc_id2" value="">
						<div class="modal-footer">
							<button type="submit" class="btn btn-default btn-sm" id="modal">확인</button>
							<button type="button" class="btn btn-default btn-sm"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>

		</div>

	</div>
	
	
	<!-- Modal -->
	<div id="imageModal" class="modal fade" role="dialog"  style="width:100%;">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content" id="image">
				
			</div>

		</div>

	</div>
</body>
</html>