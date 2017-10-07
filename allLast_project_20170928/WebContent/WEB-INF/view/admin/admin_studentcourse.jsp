<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--수강생관리 조회  -->

<c:forEach var="st" items="${studentinfo}">

<div class="row">
	<div class="col-lg-12">
		
		<h2>수강생 ID: ${st.student_id}, 수강생명: ${st.student_name}</h2>
		
		<hr />
	</div>
</div>
	<div class="panel panel-default">

		<table class="table">
			<thead>
				<tr>
					<th>과정 ID</th>
					<th>과정시작</th>
					<th>과정종료</th>
					<th>강의실</th>
					<th>과정명</th>
					<th>수료일/과정탈락일</th>
					<th>수료여부</th>
					<th>취소/탈락</th>
				</tr>
			</thead>
			<tbody>
				<!-- <tr>
					<td>oc_019</td>
					<td>2016-07-05</td>
					<td>2016-09-05</td>
					<td>강의실1</td>
					<td>JAVA기반 응용SW엔지니어링 실무과정</td>
					<td>NULL</td>
					<td>수료예정</td>
					<td><button type="button" class="btn btn-default btndropout"
							data-toggle="modal" data-target="#dropoutModal">탈락</button></td>
				</tr>
			
				<tr>
					<td>oc_019</td>
					<td>2016-07-05</td>
					<td>2016-09-05</td>
					<td>강의실1</td>
					<td>JAVA기반 응용SW엔지니어링 실무과정</td>
					<td>NULL</td>
					<td>수료예정</td>
					<td><button type="button" class="btn btn-default btncoursecancel" data-toggle="modal" data-target="#coursecancelModal">취소</button>
					</td>
				</tr> -->
				<c:set var="nowDate" value="${nowDate}" />
				<c:forEach var="sl2" items="${studentlist2}">
				<c:set var="oc_begin" value="${sl2.oc_begin}" />
				<tr>
					<td>${sl2.oc_id}</td>
					<td>${sl2.oc_begin}</td>
					<td>${sl2.oc_end}</td>
					<td>${sl2.room_name}</td>
					<td>${sl2.course_name}</td>
					<c:if test="${sl2.date_ == '수료'}">
						<td>${sl2.oc_end}</td>
					</c:if>
					<c:if test="${sl2.date_ != '수료'}">
						<td>${sl2.drop_date}</td>
					</c:if>
					<td>${sl2.date_}</td>
					<td>
					<c:if test="${nowDate > oc_begin.substring(0,10).replace('-','')}">
						<button type="button" class="btn btn-default btndropout"
							data-toggle="modal" data-target="#dropoutModal" value="${st.student_id}">탈락</button>
					</c:if>
					<c:if test="${nowDate < oc_begin.substring(0,10).replace('-','')}">
						<button type="button" class="btn btn-default btncoursecancel" data-toggle="modal" data-target="#coursecancelModal" value="${student_id}">취소</button>
					</c:if>
					
					
					</td>
				</tr>
				</c:forEach>
		</table>
		<button type="button" class="btn btn-default btnstudentcourse"
							data-toggle="modal" data-target="#studentcourseModal" value="${student_id}">과정추가</button>
	</div>
</c:forEach>





