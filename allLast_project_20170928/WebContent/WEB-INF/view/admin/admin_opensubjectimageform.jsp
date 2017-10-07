<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="b" items="${booklist}">
<div class="modal-header">
	<h4>${b.textbook_name}</h4>
</div>
<div class="modal-body">
	<form role="form" method="post" action="">
		<div class="form-group">
			<img src="${pageContext.request.contextPath}/img/${b.textbook_file}"
				alt="${pageContext.request.contextPath}/img/${b.textbook_file}" style=" width:90%;">
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default btn-sm"
		data-dismiss="modal">CLOSE</button>
</div>
</c:forEach>