<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/loginform</title>
</head>
<body>
	<h1>로그인 폼 입니다.</h1>
	<form action="${pageContext.request.contextPath }/users/login.do" method="post">
		<input type="text" name="id" placeholder="아이디 입력..." />
		<button type="submit">로그인</button>
	</form>
</body>
</html>