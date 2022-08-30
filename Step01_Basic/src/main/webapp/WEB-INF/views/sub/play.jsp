<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/sub/play.do</title>
</head>
<body>
<div class="container">
	<h1>노는 페이지입니다.</h1>
	<p>신나게 놀아요~</p>
	<img src="../images/kim1.png"/>
	<img src="${pageContext.request.contextPath }/images/kim1.png"/>
	<ul>
		<li><a href="../home.do">인덱스로 가기</a></li> 
		<!-- 상대경로를 쓰고 싶으면 ../ 를 사용해야한다. -->
		<li><a href="${pageContext.request.contextPath }/study.do">공부하러 가보자</a></li>
		<li><a href="${pageContext.request.contextPath }/">인덱스로 돌아가기</a></li>
	</ul>
</div>
</body>
</html>