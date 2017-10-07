<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form role="form" method="post" action="admin_studentcoursedelete.it">
	<c:forEach var="s" items="${studentlist}">
		<c:set var="s.course_name" value="${s.course_name}" />
		<div class="form-group">
			<label for="student_id"> 수강생ID :</label> <input type="text"
				class="form-control" id="student_id" name="student_id"
				required="required" value="${s.student_id}"> <label for="student_name">
				수강생명 :</label> <input type="text" class="form-control" id="student_name"
				name="student_name" required="required" value="${s.student_name}"> <label
				for="oc_id"> 과정명 :</label> <select class="form-control" id="oc_id"
				name="oc_id">
				<c:forEach var="c" items="${courselist}">
					<option value="${c.oc_id}" ${(c.course_name==s.course_name)?'selected':''}>${c.oc_id} &nbsp; ${c.course_name}(${c.oc_begin} ~ ${c.oc_end})</option>
				</c:forEach>
			</select>
		</div>
		<div class="modal-footer" style="text-align: center;">
			<h4>정말로 과정취소을 진행하시겠습니까??</h4>
			<button type="submit" class="btn btn-default btn-sm"
				id="memberInsertForm">과정취소</button>
			<button type="button" class="btn btn-default btn-sm"
				data-dismiss="modal">취소</button>
		</div>
	</c:forEach>
</form>