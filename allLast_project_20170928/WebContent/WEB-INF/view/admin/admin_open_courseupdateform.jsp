<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form role="form" method="post" action="admin_opencourseupdate.it">
	<div class="form-group">
		<c:forEach var="u" items="${updatelist}">
		<c:set var="u.course_name" value="${u.course_name}"/>
		<c:set var="u.room_name" value="${u.room_name}"/>
		
		<label for="course_id"> 과정 :</label>
		<div class="form-group">

			<select class="form-control" id="course_id" name="course_id" >
				<c:forEach var="c" items="${course}">
					<option value="${c.course_id}" ${(c.course_name==u.course_name)?'selected':''}>${c.course_id} ${c.course_name}</option>
				</c:forEach>
			</select>
		</div>
		
		
		<label for="oc_begin"> 과정개설날짜 :</label> <input type="text"
			class="form-control" id="oc_begin" name="oc_begin"
			required="required" value="${u.oc_begin}"> <label for="oc_end">과정종강날짜
			:</label> <input type="text" class="form-control" id="oc_end" name="oc_end"
			required="required" value="${u.oc_end}"> <label for="room_id">
			사용 강의실 :</label>
		
		<div class="form-group" id="update2">

			<select class="form-control" id="room_id" name="room_id">
				<c:forEach var="r" items="${room}">
					<option value="${r.room_id}" ${(r.room_name==u.room_name)?'selected':''}>${r.room_name}</option>
				</c:forEach>
			</select> <input type="hidden" id="oc_id" name="oc_id" value="${oc_id}">
		</div>
		<div class="modal-footer" style="text-align: center;">
			<h4>수정하시겠습니까?</h4>
			<button type="submit" class="btn btn-default btn-sm">등록</button>
			<button type="button" class="btn btn-default btn-sm"
				data-dismiss="modal">취소</button>
		</div>
		</c:forEach>
	</div>
</form>