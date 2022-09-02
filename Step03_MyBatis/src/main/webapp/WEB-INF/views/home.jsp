<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
	<div class="container">
		<h1>인덱스 페이지 입니다.</h1>
		<ul>
	      	<li><a href="${pageContext.request.contextPath }/member/list.do">회원 목록 보기</a></li>
	      	<li><a href="${pageContext.request.contextPath }/todo/list.do">할일 목록 보기</a></li>
	      	<li><a href="${pageContext.request.contextPath }/send.do">json 테스트</a></li>
	      	<li><a href="${pageContext.request.contextPath }/send2.do">json 테스트2</a></li>
	      	<li><a href="${pageContext.request.contextPath }/send3.do">json 테스트3</a></li>
	      	<li><a href="${pageContext.request.contextPath }/send4.do">json 테스트4</a></li>
	      	<li><a href="${pageContext.request.contextPath }/play.do">놀러가기(로그인 필요)</a></li>
	      	<li><a href="${pageContext.request.contextPath }/sub/play2.do">딴데서 놀기(로그인필요)</a></li>
      	</ul>
      
		<c:choose>
	      	<c:when test="${empty sessionScope.id }">
	      		 <form action="${pageContext.request.contextPath }/users/login.do" method="post">
			      	<input type="text" name="id" placeholder="아이디 입력..." />
			      	<button type="submit">로그인</button>
			      </form>
	      	</c:when>
	      	<c:otherwise>
	      		<p>
	      			<strong>${id }</strong>님 로그인중...
	      			<a href="${pageContext.request.contextPath }/users/logout.do">로그아웃</a>
	      		</p>
	      	</c:otherwise>
      	</c:choose>
 	
 		<h1>파일 업로드 폼</h1>
 		<form action="${pageContext.request.contextPath }/file/upload.do" method="post" enctype="multipart/form-data">
 			<input type="text" name="title" placeholder="설명입력..."/><br />
 			<input type="file" name="myFile"/>
 			<button type="submit">업로드</button>
 		</form>
      
		<h2>공지사항</h2>
		<ul>
			<c:forEach var="tmp" items="${requestScope.noticeList }">
				<li>${tmp }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>