<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <div class="row">
	<div class="col-lg-12">
		<c:forEach var="cl" items="${courselist}">
			<h2>과목 ID: ${cl.student_id}, 과정명: ${cl.stud_name}(${cl.oc_begin} ~
				${cl.oc_end})</h2>
		</c:forEach>
		<hr />
	</div>
</div> --%>
	<div class="panel panel-default">
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>수강생ID</th>
						<th>수강생명</th>
						<th>전화번호</th>
						<th>등록일</th>
						<th>수료여부</th>
						<th>수료/중도탈락날짜</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach var="st" items="${ScoreManagingList4}">
							<tr>
								<td>${st.student_id}</td>
								<td>${st.student_name}</td>
								<td>${st.student_phone}</td>
								<td>${st.student_hiredate}</td>
								<td>${(st.complete_ck eq null)? "수료":"중도탈락"}</td>
								<td>${st.drop_date}</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

