<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form role="form" method="post" action="admin_studentupdate.it">
	<c:forEach var="s" items="${studentlist}">
	<div class="form-group">

		<label for="student_name"> 수강생명 :</label> <input type="text"
			class="form-control" id="student_name" name="student_name"
			required="required" value="${s.student_name}"> <label for="student_phone">
			전화번호 :</label> <input type="text" class="form-control" id="student_phone"
			name="student_phone" required="required" value="${s.student_phone}"> <label
			for="student_hiredate">등록일 :</label> <input type="text"
			class="form-control" id="student_hiredate" name="student_hiredate"
			required="required" value="${s.student_hiredate}">
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-default" id="memberInsertForm">수정</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	</div>
	<input type="hidden" id="student_id" name="student_id" value="${student_id}">
	</c:forEach>
</form>