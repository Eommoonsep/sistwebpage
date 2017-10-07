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
	
  <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900|Material+Icons'>

<link rel="stylesheet" href="css/style.css">
 
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
    background:#F3F3F3;
}
</style>

 <script>
$(document).ready(function() {
	
 
	});
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
					<a class="navbar-brand" href="#">
					 <img src="img/sist_white.png"  style="width: 250px; margin-top: 8px;" />
					</a>
				</div>
			</div>
		</div>
	</div>
	  
	  
	  	<div class="form">
	 		<!-- Modal content-->
			<div class="modal-content">
				<div style="text-align:-webkit-center;"> 
					<img alt="img/gpa.png" src="img/login.png" style="width:100px;heigth:100px;margin-top:37px;">
				</div>
				<div class="modal-header" style="padding: 35px 50px;">
					<h4>
						<span class="glyphicon glyphicon-lock"></span> 로그인
					</h4>
					<label>로그인에 실패했습니다.</label>
					<label>다시 입력해주세요.</label>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<div class="form-group"></div>
					<a href="${pageContext.request.contextPath}/login.it" class="btn btn-default btn-block">Main</a>
				</div>
				<div class="modal-footer"></div>
			</div>
	 
	 

		</div>
 
</body>
</html>