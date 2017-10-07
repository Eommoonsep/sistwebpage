<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>






<ul class="nav" id="main-menu">

	<li><a href="${pageContext.request.contextPath}/teacher_teachercheck.it" ><i
			class="fa fa-table "></i>강사개인정보확인<span class="badge">Included</span></a>
			
	<li><a href="#demo136" data-toggle="collapse"><i
			class="fa fa-desktop "></i>강사스케줄조회 <span class="badge">Included</span></a>

		<ul id="demo136" class="collapse">
			<li><a href="${pageContext.request.contextPath}/teacher_teacher1.it"><span
					class="glyphicon glyphicon-pencil"></span>강의 예정</a></li>
			<li><a href="${pageContext.request.contextPath}/teacher_teacher2.it"><span
					class="glyphicon glyphicon-pencil"></span> 강의 중</a></li>
			<li><a href="${pageContext.request.contextPath}/teacher_teacher3.it"><span
					class="glyphicon glyphicon-pencil"></span> 강의 종료</a></li>
		
		</ul></li>



		
		
		
	<li><a href="${pageContext.request.contextPath}/teacher_bajam.it"><i class="fa fa-edit "></i>배점관리
			<span class="badge">Included</span></a>
	</li>
	<li><a href="${pageContext.request.contextPath}/teacher_grade.it"><i class="fa fa-edit "></i>성적 관리
			<span class="badge">Included</span></a>
	</li>	



</ul>