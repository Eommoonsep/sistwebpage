 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
 <body> 
	<!-- Modal -->
	<div id="gradeModal" class="modal fade" role="dialog">

		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h1>배점 입력 POINT >> </h1>
					
					<h4>출결은 최소 20 점 이상이고</h4>
					<h4>출결, 필기, 실기의 합은 100 점 입니다</h4>
				</div>
				<div class="modal-body">
					<form role="form" method="post" action="">
						<div class="form-group">
							<label for="SUBJECT_NAME"> 출결 :</label> <input type="text"
								class="form-control" id="SUBJECT_NAME" name="SUBJECT_NAME"
								placeholder="" required="required">
						</div>
						<div class="form-group">
							<label for="SUBJECT_NAME"> 필기 :</label> <input type="text"
								class="form-control" id="SUBJECT_NAME" name="SUBJECT_NAME"
								placeholder="" required="required">
						</div>
						<div class="form-group">
							<label for="SUBJECT_NAME"> 실기 :</label> <input type="text"
								class="form-control" id="SUBJECT_NAME" name="SUBJECT_NAME"
								placeholder="" required="required">
						</div>
						<div class="form-group">
							<label for="SUBJECT_NAME"> 시험날짜 :</label> <input type="text"
								class="calender" id="SUBJECT_NAME" name="SUBJECT_NAME"
								placeholder="" required="required">
						</div>
						<div class="form-group">
							<label for="ROOM_COUNT"> 시험문제 :</label>
							<input type="file" class="form-control" id="pic_filename"
								name="pic_filename" required="required">
						</div>
						

					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default btn-sm"
						id="">입력</button>
					<button type="button" class="btn btn-default btn-sm"
						data-dismiss="modal">취소</button>
				</div>
			</div>

		</div>

	</div>
</body>
</html>
