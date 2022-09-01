<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/todo/updateform.do</title>
</head>
<body>
<div class="container">
	<h1>일정 수정 폼</h1>
	<form action="${pageContext.request.contextPath }/todo/update.do" method="post">
		<input type="hidden" id="num" name="num" value="${dto.num }"/>
		<div>
			<label for="num">번호</label>
			<input type="text" id="num" name="num" value="${requestScope.dto.num }" disabled />
		</div>
		<div>
			<label for="content">일정</label>
			<input type="text" name="content" id="content" value="${dto.content }"/>
		</div>
		<div>
			<label for="regdate">일자</label>
			<input type="text" id="regdate" value="${requestScope.dto.regdate }" disabled />
		</div>
		<button type="submit">수정</button>
		<button type="reset">취소</button>
	</form>
</div>
</body>
</html>