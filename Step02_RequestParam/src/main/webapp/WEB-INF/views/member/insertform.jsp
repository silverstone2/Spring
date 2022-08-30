<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/insertform.jsp</title>
</head>
<body>
	<h1>회원 추가 폼입니다.</h1>
	<form action="${pageContext.request.contextPath }/member/insert.do" method="post">
		번호 <input type="text" name="num" /> <br />
		이름 <input type="text" name="name" /> <br />
		주소 <input type="text" name="addr" /> <br />
		<button type="submit">추가</button>
	</form>
	
	<form action="${pageContext.request.contextPath }/member/insert2.do" method="post">
		번호 <input type="text" name="num" /> <br />
		이름 <input type="text" name="name" /> <br />
		주소 <input type="text" name="addr" /> <br />
		<button type="submit">추가</button>
	</form>
	
	<form action="${pageContext.request.contextPath }/member/insert3.do" method="post">
		번호 <input type="text" name="num" /> <br />
		이름 <input type="text" name="name" /> <br />
		주소 <input type="text" name="addr" /> <br />
		<button type="submit">추가</button>
	</form>
</body>
</html>