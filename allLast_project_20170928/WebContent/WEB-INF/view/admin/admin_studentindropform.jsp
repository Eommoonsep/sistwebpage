<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form role="form" method="post" action="admin_studentindrop.it">
	<c:forEach var="s" items="${studentlist}">
		<c:set var="s.course_name" value="${s.course_name}" />

		<div class="form-group">


			<label for="student_id"> 수강생ID :</label> <input type="text"
				class="form-control" id="student_id" name="student_id"
				required="required" value="${s.student_id}"> <label
				for="course_openday"> 수강생명 :</label> <input type="text"
				class="form-control" id="COURSE_NAME" name="COURSE_NAME"
				required="required" value="${s.student_name}"> <label
				for="oc_id"> 과정명 :</label> <select class="form-control" id="oc_id"
				name="oc_id">
				<c:forEach var="c" items="${courselist}">
					<option value="${c.oc_id}" ${(c.course_name==s.course_name)?'selected':''}>${c.oc_id} &nbsp; ${c.course_name}(${c.oc_begin} ~ ${c.oc_end})</option>
				</c:forEach>
			</select> <label for="drop_date">과정 탈락일 :</label> <input type="text"
				class="form-control" id="drop_date" name="drop_date"
				required="required" value="${nowDate}">

		</div>

		<div class="modal-footer" style="text-align: center;">
			<h4>정말로 과정탈락을 진행하시겠습니까??</h4>
			<button type="submit" class="btn btn-default btn-sm"
				id="memberInsertForm">탈락</button>
			<button type="button" class="btn btn-default btn-sm"
				data-dismiss="modal">취소</button>
		</div>
		<input type="hidden" id="student_id" name="student_id"
			value="${student_id}">
	</c:forEach>
</form>