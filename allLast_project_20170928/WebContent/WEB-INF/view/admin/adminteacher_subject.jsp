<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-lg-12">
		<h2>성적 조회 > 과목조회 </h2>
	</div>
</div>
<hr>
		<p>강사 ID: ${oneteacherInfo.teacher_id} 강사명 :${oneteacherInfo.teacher_name}</p>
<div class="panel panel-default">
	 
	<div class="panel-body">

		<table class="table">
			<thead>
				<tr>
					<th>배정과목명</th>
					<th>과목기간</th>
					<th>과정명</th>
					<th>과정기간</th>
					<th>교재명</th>
					<th>강의실명</th>
					<th>진행여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${oneteachercourse}">

					<tr>
						<td>${t.subject_name }</td>
						<td>${t.os_begin }~ ${t.os_end}</td>
						<td>${t.course_name }</td>
						<td>${t.oc_begin }~ ${t.oc_end}</td>
						<%-- <td><a href="${pageContext.request.contextPath}/img/${t.textbook_filename}" target="blank_"  >${t.textbook_name}</a></td> --%>
						<td><button type="button" class="btnimage" data-toggle="modal" data-target="#imageModal" value="${t.textbook_name}">${t.textbook_name}</button></td>
						
						
						
						<td>${t.room_name }</td>
						<td>${t.progress }</td>
					</tr>

				</c:forEach>


			</tbody>
		</table>

	</div>
</div>