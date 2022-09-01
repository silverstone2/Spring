<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/todo/delete.jsp</title>
</head>
<body>
	<div class="container">
		<h1>알림</h1>
		<p>
			<strong>${param.num }</strong> 번째 일정을 삭제했습니다.
			<a href="${pageContext.request.contextPath }/todo/list.do">목록 보기</a>
		</p>
	</div>
</body>
</html>