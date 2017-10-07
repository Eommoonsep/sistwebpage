<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row">
	<div class="col-lg-12">
		<h2>성적 조회 > 과목조회 </h2>
	</div>
</div>
<hr>
	<div class="panel panel-default">
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>과목ID</th>
						<th >과목명</th>
						<th>과목시작</th>
						<th>과목종료</th>
						<th>교재명</th>
						<th>강사명</th>
						<th>수료여부(수료날짜</th>
						<th>출결배점</th>
						<th>필기배점</th>
						<th>실기배점</th>
						<th>출결점수</th>
						<th>필기점수</th>
						<th>실기점수</th>
						<th>시험날짜</th>
						<th>시험문제</th>

					</tr>
				</thead>
				<tbody>

					<c:forEach var="st" items="${studentScoreList}">
						<tr>
							<td>${st.os_id}</td>
							<td>${st.subject_name}</td>
							<td>${st.os_begin }</td>
							<td>${st.os_end}</td>
							<td><a href="${pageContext.request.contextPath}/img/${st.textbook_filename}" target="blank_"  >${st.textbook_name}</a></td>
							<td>${st.teacher_name}</td>
							<td>${st.date_}</td>
							<td>${st.sc_attend}</td>
							<td>${st.sc_written}</td>
							<td>${st.sc_practice}</td>
							<td>${st.grade_attend}</td>
							<td>${st.grade_written}</td>
							<td>${st.grade_practice}</td>
							<td>${st.ex_date}</td>
							<td>${st.ex_qs}</td>
						</tr>

					</c:forEach>

				</tbody>
			</table>



	</div>
</div>
