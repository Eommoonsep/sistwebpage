<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-lg-12">
		<c:forEach var="t" items="${ScoreList2}">
			<h2>과목ID: ${t.os_id}, 과목명: ${t.able_subject}(${t.os_begin} ~ ${t.os_end})</h2>
		</c:forEach>
		<hr />
	</div>
</div>
	<div class="panel panel-default">
			<table class="table">
				<thead>
					<tr>
						<th>수강생ID</th>
						<th>수강생명</th>
						<th>전화번호</th>
						<th>등록일</th>
						<th>수료여부</th>
						<th>수료/중도탈락날짜</th>
						<th>출결성적</th>
						<th>필기성적</th>
						<th>실기성적</th>
						<th>총점</th>
						<th>성적입력</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach var="st" items="${ScoreManagingList3}">
							<tr>
								<td>${st.student_id}</td>
								<td>${st.student_name}</td>
								<td>${st.student_phone}</td>
								<td>${st.student_hiredate}</td>
								<td>${(st.complete_ck eq null)? "수료":"중도탈락"}</td>
								<td>${st.drop_date}</td>
								<td>${(st.grade_attend eq -1)? "-":st.grade_attend}</td>
								<td>${(st.grade_written eq -1)? "-":st.grade_written}</td>
								<td>${(st.grade_practice eq -1)? "-":st.grade_practice}</td>
								<td>${(st.grade_total eq -1)? "-":st.grade_total}</td>
								<td><button type="button"
										class="btn btn-default btn-xs btnInsert" data-toggle="modal"
										data-target="#teacherinfoModal" ${(st.grade_attend eq -1)? "":"disabled"}>성적 입력</button></td>
										<%-- 버튼 비활성화 --%>
								<td><button type="button"
										class="btn btn-default btn-xs btnInsert">삭제</button></td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
		</div>

