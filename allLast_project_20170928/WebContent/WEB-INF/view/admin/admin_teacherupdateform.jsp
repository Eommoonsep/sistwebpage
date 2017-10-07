<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 모달창에 안에 보여지는 화면 구성 -->

<!-- 사진 삭제를 위한 hidden 폼 추가, submit버튼이 없다. -->
					<form action="adminteacherupdate_submit.it" method="POST" id="blindform">
						<div class="form-group">
							
							<input type="hidden"  id="teacher_id" name="teacher_id" value="${tea.teacher_id}">
							
							
							이름 :<input type="text" placeholder="" class="form-control"
								id="teacher_name" name="teacher_name" value="${tea.teacher_name}" required maxlength="20">

							주민번호 뒷자리 :<input type="text" placeholder="주민번호 뒷자리"
								class="form-control" id="teacher_ssn" name="teacher_ssn" value="${tea.teacher_ssn}" required
								maxlength="20"> 전화번호 :
								<input type="text"
								placeholder="PHONE" class="form-control" id="teacher_phone" name="teacher_phone"
								value="${tea.teacher_phone}" required maxlength="20">
						</div>
						<div class="form-group">

							<div class="subcheckbox2" style="border: 1px solid gray;">
							<!-- 
								<label><input type="checkbox" name="sub_001" value=" JAVA">sub_001 java</label><br> 
							 <label><input type="checkbox" name="sub_002" value="ORACLE">sub_002 Oracle</label><br> 
						    <label><input type="checkbox" name="sub_003" value="C언어">sub_003 c언어</label><br>
							<label><input type="checkbox" name="sub_004" value="정보보안">sub_004 정보보안</label><br> 
							<label><input type="checkbox" name="sub_005" value="HTML">sub_005 HTML/CSS/Javascript</label><br>
							 -->
							 <c:forEach var="s" items="${subjectlist}">
							 <label><input type="checkbox" id="subjects" name="subjects"     value="${s.subject_id}"  ${(fn:contains(tea.ableSubject, s.subject_name))?"checked=\"checked\"":""}  ${(s.noremovesubject==1)?"disabled=\"disabled\"":""}>${s.subject_id} ${s.subject_name}</label><br>
							 </c:forEach>
							 


							</div>
						</div>

						<div class="form-group" style="text-align: center;">변경하시겠습니까?</div>
						<div class="form-group" style="text-align: center;">
							<button type="submit" class="btn btn-default" >확인</button>
							<button type="reset" class="btn btn-default">취소</button>
						</div>
					</form>
