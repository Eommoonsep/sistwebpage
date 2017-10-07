<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-lg-12">
		<c:forEach var="cl" items="${courselist}">
			<h2>과정ID: ${cl.oc_id}, 과정명: ${cl.course_name}(${cl.oc_begin} ~
				${cl.oc_end})</h2>
		</c:forEach>
		<hr />
	</div>
</div>
<div class="panel panel-default">

	<table class="table" id="subjecttable">
		<thead>
			<tr>
				<th>과목ID</th>
				<th>과목명</th>
				<th>과목시작</th>
				<th>과목종료</th>
				<th>강의실</th>
				<th>과정명</th>
				<th>교재명</th>
				<th>강사명</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<!-- <tr>
				<td>os_095</td>
				<td>Oracle</td>
				<td>2017-08-03</td>
				<td>2017-09-10</td>
				<td>강의실6</td>
				<td>C언어 자바 프로그래밍 개발자 과정</td>
				<td><a href="#" data-toggle="modal" data-target="#imageModal">오라클
						SQL과 PL/SQL</td>
				<td>이영표</td>
				<td><button type="button"
						class="btn btn-default btn-xs btnalter" data-toggle="modal"
						data-target="#alterModal">수정</button></td>
				<td><button type="button"
						class="btn btn-default btn-xs btndelete" data-toggle="modal"
						data-target="#deleteModal">삭제</button></td>
			</tr>
			<tr>
				<td>os_087</td>
				<td>C언어</td>
				<td>2017-09-11</td>
				<td>2017-11-30</td>
				<td>강의실6</td>
				<td>C언어 자바 프로그래밍 개발자 과정</td>
				<td><a href="#" data-toggle="modal" data-target="#imageModal">예제로
						배우는 C언어 프로그래밍</td>
				<td>이민종</td>
				<td><button type="button"
						class="btn btn-default btn-xs btnalter" data-toggle="modal"
						data-target="#alterModal">수정</button></td>
				<td><button type="button"
						class="btn btn-default btn-xs btndelete" data-toggle="modal"
						data-target="#deleteModal">삭제</button></td>
			</tr> -->
			<c:forEach var="sl" items="${subjectlist}">
			<tr>
				<td>${sl.os_id }</td>
				<td>${sl.subject_name}</td>
				<td>${sl.os_begin }</td>
				<td>${sl.os_end}</td>
				<td>${sl.room_name}</td>
				<td>${sl.course_name}</td>
				<td><button type="button" class="btn btn-default btn-xs btnimage" data-toggle="modal" data-target="#imageModal" value="${sl.textbook_name}">${sl.textbook_name}</button></td>
				<td>${sl.teacher_name }</td>
				<td><button type="submit"
						class="btn btn-default btn-xs btnalter" data-toggle="modal"
						data-target="#alterModal" value="${sl.os_id }">수정</button></td>
				<td><button type="button"
						class="btn btn-default btn-xs btndelete" data-toggle="modal"
						data-target="#deleteModal" value="${sl.os_id }">삭제</button></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="button" class="btn btn-default btn-xs btnsubject"
		data-toggle="modal" data-target="#gradeModal">과목 추가</button>
</div>




