<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form role="form" method="post" action="admin_studentcourseinsert.it">
	<c:forEach var="s" items="${studentlist}">
		<div class="form-group">
			<label for="student_id"> 수강생ID :</label> <input type="text"
				class="form-control" id="st_id" name="st_id" required="required"
				value="${s.student_id}"> <label for="student_name">
				수강생명 :</label> <input type="text" class="form-control" id="student_name"
				name="student_name" required="required" value="${s.student_name}">
			<label for="student_ssn">주민번호뒷자리 :</label> <input type="text"
				class="form-control" id="student_ssn" name="student_ssn"
				value="${s.student_ssn}" required="required"> <label
				for="student_phone"> 전화번호 :</label> <input type="text"
				class="form-control" id="student_phone" name="student_phone"
				value="${s.student_phone}" required="required">
		</div>

		<div class="panel panel-default">
			<label>과정추가 :</label><br>
			<div class="radio">
				<c:forEach var="c" items="${courselist}">
					<label class="radio-inline"> <input type="radio"
						name="oc_id" value="${c.oc_id}"> ${c.oc_id} &nbsp;
						${c.course_name}(${c.oc_begin} ~ ${c.oc_end})
					</label>
				</c:forEach>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-default" id="memberInsertForm">등록</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		</div>
		<input type="hidden" id="student_id" name="student_id"
			value="${student_id}">
	</c:forEach>
</form>