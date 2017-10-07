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




<style>
a, a:hover, a:active, a:link {
	color: #214761;
	font-weight: 900;
	font-size: 16px;
	text-decoration: none;
}

ul li ul li {
	list-style-type: none;
}

ul li ul li:hover {
	background: #F3F3F3;
}

.btnimage {
   border:0;
   color:blue;
   text-decoration:underline;
   background-color:white;
   outline:0;
}
.btnimage:hover{
   background-color:white;
}



</style>


<script>
	$(document).ready(function() {

						//글쓰기 성공(100), 실패 메시지(101) 반환
						if ("${code}" == "100") {
							$(".insert-success").css("display", "inline");
						} else if ("${code}" == "101") {
							$(".insert-fail").css("display", "inline");
						}

						$("#accordian h3").click(function() {
							$("#accordian ul ul").slideUp();
							if (!$(this).next().is(":visible")) {
								$(this).next().slideDown();
							}
						})

						// 강사 조회버튼 클릭시
						$(".btninfo").on("click", function() {
							var tea_id = $(this).val();
							$.get("adminteacher_subject.it", {
								tea_id : tea_id
							}, function(data) {
								$("div#demo").html(data);
							});
						});

						// 강사 수정버튼 클릭시 모달창
						$(".btnteaUpdate").on("click",function() {
											var txt = "";
											var tea_id = $(this).parent().parent().children().eq(0).text();
											console.log(tea_id);
											var tea_name = $(this).parent().parent().children().eq(1).text();
											var tea_ssn = $(this).parent().parent().children().eq(2).text();
											var tea_phone = $(this).parent().parent().children().eq(3).text();
											var ableSubject = $(this).parent().parent().children().eq(4).text();
					  
											$("div#teaUpdateModal input#name_").val(tea_name);
											$("div#teaUpdateModal input#ssn")
													.val(tea_ssn);
											$("div#teaUpdateModal input#phone")
													.val(tea_phone);
							   
											
											var txt = "";
											$.ajax({
														url : "adminteachesubject.it",
												 		data:{tea_id:tea_id, tea_name:tea_name, tea_phone:tea_phone, tea_ssn:tea_ssn, ableSubject:ableSubject},
														success : function(data) {
														/* 	var myObj = JSON.parse(data);
															console.log(myObj); */
															
													/* 		 $.each(myObj,function(idx,item) {
																 
																				txt += "<label><input type='checkbox' name='ablesubject' checked value='"+item.subject_id+"'>"
																						+ item.subject_name
																						+ "</label><br>";
																			})  */
																			
															$("div#teaUpdateModal .modal-body").html(data);
															$("div#teaUpdateModal").modal("show");

														}

													});					

					 					 
					 				
					 				/* 		 
					 						var myObj = $("div#teaUpdateModal input.subjects");
					 						
					 						$.each(myObj,function(idx,item) {
					 							if (ableSubject.includes($(item).parent().text())) {
					 								$(this).prop("checked", true);	
					 							} else {
					 								$(this).prop("checked", false);
					 							}
					 						});
					 				
						 					 */
									 
						});

						//강사 삭제버튼 클릭시 모달창
						$(".btnteaDelete").on( "click", function() {
									var tea_id = $(this).parent().parent().children().eq(0).text();
									var tea_name = $(this).parent().parent().children().eq(1).text();
									
 									$("div#teaDeleteModal input#teacher_id").val(tea_id);
									$("div#teaDeleteModal p#name_").text(tea_name);
									
									$("div#teaDeleteModal").modal();
									
									
								});

						
						
						
						
						//강사 등록 버튼
						$(document).on("click",".btnteacherAdd",function() {
											var txt = "";

											$.ajax({
														url : "adminteachesubject2.it",
														success : function(data) {
															var myObj = JSON.parse(data);
															console.log(myObj);

															$.each(myObj,function(idx,item) {
																				txt += "<label><input type='checkbox' name='ablesubject' value='"+item.subject_id+"'>"
																						+ item.subject_name
																						+ "</label><br>";
																			})
															$(".subcheckbox")
																	.html(txt);
															$("div#subjectModal")
																	.modal(
																			"show");

														}

													});
										});
						
						//이미지버튼
						$(document).on("click",".btnimage", function() {
							var textbook_name = $(this).val();
							
							$.get("admin_teachersubject_imageform.it", {textbook_name : textbook_name}, function(data) {
								$("div#image").html(data);
							});
						});
						

 });
			 
</script>
</head>
<body>
 <c:import url="menuadmin.jsp" />


 
	
	
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-lg-12">
						<h2>강사 계정 관리</h2>
					</div>
				</div>
				<hr />
				<div class="container-fluid">
					<div class="panel panel-default">
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>강사 ID</th>
										<th>강사명</th>
										<th>주민번호 뒷자리</th>
										<th>전화번호</th>
										<th>강의가능과목</th>
										<th>조회</th>
										<th>수정</th>
										<th>삭제</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="tea" items="${teacher}">
										<tr>
											<td>${tea.teacher_id}</td>
											<td>${tea.teacher_name }</td>
											<td>${tea.teacher_ssn }</td>
											<td>${tea.teacher_phone }</td>
											<td>${tea.ableSubject }</td>
											<td><button type="button"
													class="btn btn-default btn-xs btninfo"
													value="${tea.teacher_id }">조회</button></td>
											<td><button type="button"
													class="btn btn-default btn-xs btnteaUpdate"
													data-toggle="modal" data-target="#teaUpdateModal" value="${tea.teacher_id}">수정</button></td>
											 
										
											<td>
											<button type="button" class="btn btn-default btn-xs btnteaDelete"data-toggle="modal" data-target="#teaDeleteModal" value="${tea.teacher_id}"  ${(tea.noremovebutton==1 )? "disabled=\"disabled\"":""} >
													삭제</button></td>
														 
										</tr>

									</c:forEach>


								</tbody>
							</table>
							<button type="button"
								class="btn btn-default btn-xs btnteacherAdd" data-toggle="modal"
								data-target="#subjectModal">강사 등록</button>

						</div>

					</div>
					<div id="demo"></div>
				</div>


			</div>
			<!-- /. PAGE INNER  -->
		</div>
		
		
		
	<div class="footer">
		<div class="row">
			<div class="col-lg-12">
				&copy; 2014 yourdomain.com | Design by: <a
					href="http://binarytheme.com" style="color: #fff;" target="_blank">www.binarytheme.com</a>
			</div>
		</div>
	</div>






	<!-- 강사등록 Modal -->
	<div id="subjectModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4>강사 등록</h4>
				</div>
				<div class="modal-body">
					<form role="form" method="post" action="adminteacheradd.it">
						<div class="form-group">
							<label for="teacher_name"> 강사명 :</label> <input type="text"
								class="form-control" id="teacher_name" name="teacher_name"
								placeholder="40자 내로 입력" required="required">
						</div>
						<div class="form-group">
							<label for="teacher_ssn"> 주민번호 :</label> <input type="text"
								class="form-control" id="teacher_ssn" name="teacher_ssn"
								placeholder="40자 내로 입력" required="required">
						</div>
						<div class="form-group">
							<label for="teacher_phone"> 전화번호 :</label> <input type="text"
								class="form-control" id="teacher_phone" name="teacher_phone"
								placeholder="40자 내로 입력" required="required">
						</div>

						<div class="form-group">

							<div class="subcheckbox" style="border: 1px solid gray;">

								<!-- <input type="checkbox" name="sub_001" value=" JAVA">sub_001 java 
							 <input type="checkbox" name="sub_002" value="ORACLE">sub_002 Oracle 
						    <input type="checkbox" name="sub_003" value="C언어">sub_003 c언어<br>
							<input type="checkbox" name="sub_004" value="정보보안">sub_004 정보보안 
							<input type="checkbox" name="sub_005" value="HTML">sub_005 HTML/CSS/Javascript
							
							 -->


							</div>
						</div>
						<button type="submit" class="btn btn-default btn-sm"
							id="memberInsertForm">등록</button>
						<button type="reset" class="btn btn-default btn-sm"
							data-dismiss="modal">취소</button>
					</form>
				</div>

			</div>

		</div>

	</div>


	<!-- 강사 수정 Modal  -->

	<div id="teaUpdateModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">개인정보 수정</h4>
				</div>
				<div class="modal-body">

					<!-- 사진 삭제를 위한 hidden 폼 추가, submit버튼이 없다. -->
					<form action="adminteacherupdate.it" method="get" id="blindform">
						<div class="form-group">
							이름 :<input type="text" placeholder="" class="form-control"
								id="name_" name="name_" value="" required maxlength="20">

							주민번호 뒷자리 :<input type="text" placeholder="주민번호 뒷자리"
								class="form-control" id="ssn" name="ssn" value="" required
								maxlength="20"> 전화번호 :<input type="text"
								placeholder="PHONE" class="form-control" id="phone" name="phone"
								value="" required maxlength="20">
						</div>
						<div class="form-group">

							<div class="subcheckbox2" style="border: 1px solid gray;">

								<!-- <input type="checkbox" name="sub_001" value=" JAVA">sub_001 java 
							 <input type="checkbox" name="sub_002" value="ORACLE">sub_002 Oracle 
						    <input type="checkbox" name="sub_003" value="C언어">sub_003 c언어<br>
							<input type="checkbox" name="sub_004" value="정보보안">sub_004 정보보안 
							<input type="checkbox" name="sub_005" value="HTML">sub_005 HTML/CSS/Javascript
							
							 -->

 <%-- 
							 <c:forEach var="s" items="${subjectlist}">
							 <label><input type="checkbox" class="subjects" name="subjects" value="${s.subject_id}"   >${s.subject_name}</label><br>
							 </c:forEach> --%>

							</div>
						</div>

						<div class="form-group" style="text-align: center;">변경하시겠습니까?</div>
						<div class="form-group" style="text-align: center;">
							<button type="submit" class="btn btn-default">확인</button>
							<button type="reset" class="btn btn-default">취소</button>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default btn-sm"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>




	<!-- 강사 삭제 Modal  -->

	<div id="teaDeleteModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">개인정보 삭제</h4>
				</div>
				<div class="modal-body">

					<!-- 사진 삭제를 위한 hidden 폼 추가, submit버튼이 없다. -->
					<form action="adminteacherDelete.it" method="get" id="blindform">


						<div class="form-group" style="text-align: center;">
							<input type="hidden" id="teacher_id" name="teacher_id" value=""/>
							강사: <p id="name_"></p>님을 삭제하시겠습니까?
						</div>
						<div class="form-group" style="text-align: center;">
							<button type="submit" class="btn btn-default btndelete">확인</button>
							<button type="reset" class="btn btn-default">취소</button>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default btn-sm"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>


 
<!-- 교재명 클릭시 이미지 모달 -->
	<div id="imageModal" class="modal fade" role="dialog"  style="width:100%;">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" id="image">
			</div>
		</div>
	</div>
	
</body>
</html>