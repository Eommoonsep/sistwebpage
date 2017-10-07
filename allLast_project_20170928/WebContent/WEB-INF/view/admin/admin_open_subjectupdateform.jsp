<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form role="form" method="post" action="admin_open_subjectupdate.it">
	<c:forEach var="u" items="${updatelist}">
		<c:set var="u.subject_name" value="${u.subject_name}" />
		<c:set var="u.textbook_name" value="${u.textbook_name}" />
		<c:set var="u.teacher_name" value="${u.teacher_name}" />
		<div class="panel panel-default">
			<label class="control-label col-sm-2" for="subject_id">과목 추가:</label>

			<div class="scroll" style="overflow-y: auto">
				<c:forEach var="s" items="${subject_name}">
					<label class="radio-inline"> <input type="radio"
						id="subject_id" name="subject_id" value="${s.subject_id}" ${(s.subject_name==u.subject_name)?'checked':''}>${s.subject_name}</label>
				</c:forEach>
			</div>

		</div>


		<div class="form-group">
			<label for="os_begin"> 개강날짜 :</label> <input type="text"
				class="form-control" id="os_begin" name="os_begin"
				placeholder="개강날짜를 입력하세요" value="${u.os_begin}" required="required">
		</div>
		<div class="form-group">
			<label for="os_end"> 종강날짜 :</label> <input type="text"
				class="form-control" id="os_end" name="os_end"
				placeholder="종갈날짜를 입력하세요" value="${u.os_end}" required="required">
		</div>


		<div class="panel panel-default">
			<label class="control-label col-sm-2" for="textbook_id">교재
				추가:</label>

			<div class="scroll" style="overflow-y: auto">
				<c:forEach var="t" items="${textbook}">
					<label class="radio-inline"> <input type="radio"
						id="textbook_id" name="textbook_id" value="${t.textbook_id}" ${(t.textbook_name==u.textbook_name)?'checked':''}>${t.textbook_id}
						${t.textbook_name} ${t.textbook_publisher}
					</label>
				</c:forEach>
			</div>

		</div>
		<div class="panel panel-default">
			<label class="control-label col-sm-2" for="lunar">강사 추가:</label>

			<!-- 강사ID  강사명  주민번호 뒷자리 전화번호  강의가능과목 -->
			<div class="scroll" style="overflow-y: auto">
				<c:forEach var="te" items="${teacher}">
					<label class="radio-inline"> <input type="radio"
						id="teacher_id" name="teacher_id" value="${te.teacher_id }" ${(te.teacher_name==u.teacher_name)?'checked':''}>${te.teacher_id }
						${te.teacher_name } ${te.ableSubject }
					</label>
				</c:forEach>
			</div>

		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-default btn-sm" id="modal">입력</button>
			<button type="button" class="btn btn-default btn-sm"
				data-dismiss="modal">취소</button>
		</div>
		<input type="hidden" id="os_id" name="os_id" value="${os_id}">
	</c:forEach>
</form>