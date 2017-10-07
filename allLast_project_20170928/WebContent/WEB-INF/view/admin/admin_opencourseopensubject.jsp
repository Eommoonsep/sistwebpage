<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--개설과목  -->
<div class="row">
	<div class="col-lg-12">
		<c:forEach var="cl" items="${courselist}">
			<h2>과정ID: ${cl.oc_id}, 과정명: ${cl.course_name}(${cl.oc_begin} ~
				${cl.oc_end})</h2>
		</c:forEach>
		<hr>

	</div>
</div>

<div class="panel panel-default">

	<table class="table">
		<thead>
			<tr>
				<th>과목 ID</th>
				<th>과목명</th>
				<th>과목시작</th>
				<th>과목종료</th>
				<th>교재명</th>
				<th>강사명</th>
			</tr>
		</thead>
		<tbody>
			<!-- <tr>
				<td>os_020</td>
				<td>JAVA</td>
				<td>2016-07-05</td>
				<td>2016-09-05</td>
				<td><a href="#" data-toggle="modal" data-target="#imageModal">이것이
						자바다</a></td>
				<td>이민종</td>
			</tr>

			<tr>
				<td>os_020</td>
				<td>JAVA</td>
				<td>2016-07-05</td>
				<td>2016-09-05</td>
				<td><a href="#" data-toggle="modal" data-target="#imageModal">이것이
						자바다</a></td>
				<td>이민종</td>
			</tr>
			<tr>
				<td>os_020</td>
				<td>JAVA</td>
				<td>2016-07-05</td>
				<td>2016-09-05</td>
				<td><a href="#" data-toggle="modal" data-target="#imageModal">이것이
						자바다</a></td>
				<td>이민종</td>
			</tr> -->
			<c:forEach var="sl" items="${subjectlist}">
				<tr>
					<td>${sl.os_id }</td>
					<td>${sl.subject_name}</td>
					<td>${sl.os_begin }</td>
					<td>${sl.os_end}</td>
					<td><button type="button" class="btn btn-default btn-xs btnimage" data-toggle="modal" data-target="#imageModal" value="${sl.textbook_name}">${sl.textbook_name}</button></td>
					<td>${sl.teacher_name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

<!--수강생 출력  -->




<div class="panel panel-default">

	<table class="table">
		<thead>
			<tr>
				<th>수강생 ID</th>
				<th>수강생명</th>
				<th>전화번호</th>
				<th>등록일</th>
				<th>수료 및 중도탈락 날짜</th>
				<th>수료여부</th>
			</tr>
		</thead>
		<tbody>
			<!-- <tr>
				<td>st_004</td>
				<td>최혜진</td>
				<td>010-5532-7535</td>
				<td>2016-06-05</td>
				<td>2016-12-03</td>
				<td>w중도탈락</td>
			</tr>
			<tr>
				<td>st_0035</td>
				<td>최혜진</td>
				<td>010-5532-7535</td>
				<td>2016-06-05</td>
				<td>2016-12-03</td>
				<td>w중도탈락</td>
			</tr>
			<tr>
				<td>st_036</td>
				<td>최혜진</td>
				<td>010-5532-7535</td>
				<td>2016-06-05</td>
				<td>2016-12-03</td>
				<td>w중도탈락</td>
			</tr> -->
			
			<c:forEach var="stl" items="${studentlist}">
			<tr>
				<td>${stl.student_id}</td>
				<td>${stl.student_name}</td>
				<td>${stl.student_phone}</td>
				<td>${stl.student_hiredate}</td>
				<td>${stl.date_}</td>
				<td>${stl.pass_or_drop}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
