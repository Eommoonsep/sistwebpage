<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 

<div id="wrapper">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="adjust-nav">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="studentmain.it"> 					
				   <img src="img/sist_white.png"  style="width: 200px; margin-top: 8px;" />

				</a>
			</div>

			<span class="logout-spn">학생(${sessionScope.logininfo.id_})
			 <a href="${pageContext.request.contextPath}/logout.it" style="color: #fff;">LOGOUT</a>
			</span>
		</div>
	</div>


	<!-- /. NAV TOP  -->
	<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
			<li><a href="student_info.it" > <i class="fa fa-desktop"></i>
				개인 정보 확인
				</a></li>
			<li><a href="student_score.it"> <i class="fa fa-table"></i>성적
						조회
				</a></li>
				<%--  <c:set var="en" value="${endecode.encode(sessionScope.logininfo.id_)}"/> 
			 
			 <c:set var="en" value="${sessionScope.logininfo.id_}"/>  
				<li><a href="student_info.it?student_id=${en}"> <i class="fa fa-desktop"></i>
				개인 정보 확인
				</a></li>
				<li><a href="student_score.it?student_id=${en}"> <i class="fa fa-table"></i>성적
						조회
				</a></li>
 --%>
			</ul>
		</div>

	</nav>

</div>





