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
				<a class="navbar-brand" href="admin.it"> 					
					 <img src="img/sist_white.png"  style="width: 200px; margin-top: 8px;" />

				</a>
			</div>

			<span class="logout-spn">
			 관리자(${sessionScope.logininfo.id_})
			 <a href="logout.it" style="color: #fff;">LOGOUT</a>
			</span>
		</div>
	</div>


	<!-- /. NAV TOP  -->
	<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li><a href="#demo136" data-toggle="collapse"> 
				<i class="fa fa-desktop "></i>기초 정보 관리 <span class="badge">Included</span></a>
			 
					<ul id="demo136" class="collapse">
						<li><a href=" "> 과정 정보</a></li>
						<li><a href=" "> 과목 정보</a></li>
						<li><a href=""> 강의실 정보</a></li>
						<li><a href=" "> 교재 정보</a></li>
					</ul>
				</li>
				<li><a href="adminteacher.it"> <i class="fa fa-table "></i>강사	계정 관리 </a></li>
				<li><a href="admin_opencourse.it"><i class="fa fa-edit "></i>개설 과정 관리</a></li>
				<li><a href="admin_open_subject.it"><i class="fa fa-qrcode "></i>개설 과목 관리</a></li>
				<li><a href="admin_student.it"><i class="fa fa-bar-chart-o"></i>수강생 관리</a></li>
				<li><a href="#demo137" data-toggle="collapse"><i class="fa fa-edit "></i>성적 조회 </a>
					<ul id="demo137" class="collapse">
							<li><a href="${pageContext.request.contextPath}/admin_gpasearch_info.it"><span
									class="glyphicon glyphicon-scissors"></span> 과정& 과목별 성적 조회</a></li>
							<li><a href="${pageContext.request.contextPath}/admin_personal_gpasearch.it"><span
									class="glyphicon glyphicon-erase"></span> 개인 성적 조회</a></li>
						</ul>
					</li>

			</ul>
		</div>
	</nav>

</div>

