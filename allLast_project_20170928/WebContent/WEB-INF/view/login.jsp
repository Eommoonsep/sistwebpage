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
					 <img src="img/sist_white.png"  style="width: 200px; margin-top: 8px;" />
					</a>
				</div>
			<!-- 	<span class="logout-spn"> <a href="#" style="color: #fff;">LOGOUT</a>

				</span> -->
			</div>
		</div>
	 
	  
	</div>
	  
	  
	  	<div class="form">
	 
		<div class="form-panel one">
			<div class="form-header">
			
		 
				
				<div style="text-align:-webkit-center;"> 
					<img alt="img/login.png" src="img/login.png" style="width:100px;height:100px;margin-top: 35px;">
				</div>

				<!-- <div style="display:block;"><h1>Account Login</h1></div> -->
			</div>
			<div class="form-content">
				<form action="loginsubmit.it" method="POST">

					<div class="form-group">
						<label for="password">Account</label>
						 <select id="loginselect" name="loginselect">
						 	<option value="select">======================선택하시오========================</option>
							<option value="0">관리자</option>
							<option value="1">강사</option>
							<option value="2">학생</option>
						</select>
					</div>
					<div class="form-group">
						<label for="username">ID</label> 
						<input type="text" id="id_" name="id_" required="required" />
					</div>
					<div class="form-group">
						<label for="password">Password</label> 
						<input type="password" id="pw" name="pw" required="required" />
					</div>


					<div class="form-group">
						<button type="submit">Log In</button>
					</div>
				</form>
			</div>
		</div>

	</div>
	
	 


 
   
   
   
   
 
</body>
</html>