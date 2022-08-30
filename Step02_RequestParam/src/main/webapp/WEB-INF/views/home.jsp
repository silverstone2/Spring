<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>인덱스 페이지입니다.</h1>
		
		<form action="${pageContext.request.contextPath }/send.do" method="post">
			<input type="text" name="msg" placeholder="할말 입력..." />
			<button type="submit">전송</button>
		</form>
		
		<form action="${pageContext.request.contextPath }/send2.do" method="post">
			<input type="text" name="msg" placeholder="할말 입력..." />
			<button type="submit">전송</button>
		</form>
		
		
		<h2>post 방식 요청</h2>
		<form action="${pageContext.request.contextPath }/add.do" method="post">
			<input type="text" name="content" placeholder="내용입력..." />
			<button type="submit">추가</button>
		</form>
		
		<h2>get 방식 요청</h2>
		<form action="${pageContext.request.contextPath }/add.do" method="get">
			<input type="text" name="content" placeholder="내용입력..." />
			<button type="submit">추가</button>
		</form>
		
		
		<ul>
			<li><a href="${pageContext.request.contextPath }/member/insertform.do">회원 추가하러 가기</a></li>
		</ul>
		
		<h2>공지사항</h2>
      		<ul>
         		<c:forEach var="tmp" items="${requestScope.noticeList }">
            		<li>${tmp }</li>
         		</c:forEach>
    		</ul>
	</div>
</body>
</html>