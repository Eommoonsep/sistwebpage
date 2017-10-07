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
			$("#oc_id").val(oc_id);
			$.get("admin_opensubject_subject.it", {
				oc_id : oc_id
			}, function(data) {
				$("div#demo").html(data);
			});
		});

		//수정버튼에 대한 이벤트 등록
		//-> 정적 등록(이벤트 등록 코드가 실행되기 전에 객체가 이미 존재), 동적 등록(이벤트 등록 코드가 실행되기 전에 객체가 존재하지 않아도 등록)
		$(document).on("click", ".btnalter", function() {
			var os_id = $(this).val();
			$.get("admin_open_subjectupdateform.it", {os_id : os_id}, function(data) {
				$("div#update").html(data);
			});
		});

		//삭제 버튼
		$(document).on("click", ".btndelete", function() {
			$("#os_id2").val($(this).val());
		});
		
		//이미지버튼
		$(document).on("click",".btnimage", function() {
			var textbook_name = $(this).val();
			
			$.get("admin_opensubjectimageform.it", {textbook_name : textbook_name}, function(data) {
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
				<h2>개설과목 관리</h2>
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
								<th>수강 인원</th>
								<th>조회</th>
							</tr>
						</thead>
						<tbody>
							<!-- <tr>
								<td>oc_002</td>
								<td>프로그래밍 언어 마스터과정</td>
								<td>2016-05-05</td>
								<td>2016-11-01</td>
								<td>2</td>
								<td>강의실2</td>
								<td>5</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
							</tr>
							<tr>
								<td>oc_003</td>
								<td>IT정보보안 및 네트워크</td>
								<td>2017-07-04</td>
								<td>2017-12-01</td>
								<td>2</td>
								<td>강의실3</td>
								<td>3</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
							</tr>
							<tr>
								<td>oc_004</td>
								<td>JAVA Enterprise System 개발자 양성과정</td>
								<td>2016-07-04</td>
								<td>2016-12-31</td>
								<td>2</td>
								<td>강의실4</td>
								<td>2</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
							</tr>
							<tr>
								<td>oc_005</td>
								<td>C언어 자바 프로그래밍 개발자 과정</td>
								<td>2017-08-03</td>
								<td>2018-01-30</td>
								<td>2</td>
								<td>강의실5</td>
								<td>0</td>
								<td><button type="button"
										class="btn btn-default btn-xs btninfo">조회</button></td>
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
								</tr>
							</c:forEach>
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


	<!-- Modal -->
	<div id="gradeModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>개설 과목 등록</h1>
				</div>
				<div class="modal-body">
					<form role="form" method="post"
						action="admin_open_subjectinsert.it">
						<div class="panel panel-default">
							<label class="control-label col-sm-2" for="subject_id">과목
								추가:</label>

							<div class="scroll" style="overflow-y: auto">
								<c:forEach var="s" items="${subject_name}">
									<label class="radio-inline"> <input type="radio"
										name="subject_id" value="${s.subject_id}">${s.subject_name}</label>
								</c:forEach>
							</div>

						</div>


						<div class="form-group">
							<label for="os_begin"> 개강날짜 :</label> <input type="text"
								class="form-control" id="os_begin" name="os_begin"
								placeholder="개강날짜를 입력하세요" required="required">
						</div>
						<div class="form-group">
							<label for="os_end"> 종강날짜 :</label> <input type="text"
								class="form-control" id="os_end" name="os_end"
								placeholder="종갈날짜를 입력하세요" required="required">
						</div>


						<div class="panel panel-default">
							<label class="control-label col-sm-2" for="textbook_id">교재
								추가:</label>

							<div class="scroll" style="overflow-y: auto">
								<c:forEach var="t" items="${textbook}">
									<label class="radio-inline"> <input type="radio"
										name="textbook_id" value="${t.textbook_id}">${t.textbook_id}
										${t.textbook_name} ${t.textbook_publisher}
									</label>
								</c:forEach>
							</div>

						</div>
						<div class="panel panel-default">
							<label class="control-label col-sm-2" for="lunar">강사 추가:</label>

							<!-- 강사ID  강사명  주민번호 뒷자리 전화번호  강의가능과목 -->
							<div class="scroll" style="overflow-y: auto">
								<c:forEach var="te" items="${teacher}">
									<label class="radio-inline"> <input type="radio"
										name="teacher_id" value="${te.teacher_id }">${te.teacher_id }
										${te.teacher_name } ${te.ableSubject }
									</label>
								</c:forEach>
							</div>

						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-default btn-sm" id="modal">입력</button>
							<button type="button" class="btn btn-default btn-sm"
								data-dismiss="modal">취소</button>
						</div>
						<input type="hidden" id="oc_id" name="oc_id" value="">
					</form>
				</div>

			</div>

		</div>

	</div>

	<!-- 수정 Modal -->
	<!-- Modal -->
	<div id="alterModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>개설 과목 수정</h1>
				</div>
				<div class="modal-body" id="update">
					
				</div>
			</div>

		</div>

	</div>


	<!-- 삭제 Modal -->
	<!-- Modal -->
	<div id="deleteModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4>삭제 하시겠습니까?</h4>
					<form role="form" method="post"
						action="admin_open_subjectdelete.it">
						<input type="hidden" id="os_id2" name="os_id2" value="">
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

<!--이미지 Modal -->
	<div id="imageModal" class="modal fade" role="dialog"  style="width:100%;">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" id="image">
			</div>
		</div>
	</div>	
	
	
</body>
</html>