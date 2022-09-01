<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/todo/list.jsp</title>
</head>
<body>
<div class="container">

	
	<h1>회원 목록입니다.</h1>
	
	<ul>
		<li><a href="${pageContext.request.contextPath }/todo/insertform.do">회원 추가</a></li>
	</ul>
	
	<table border="1" class="table table-hover">
		<thead>
			<tr>
				<th>번 호</th>
				<th>할 일</th>
				<th>일 자</th>
				<th>수 정</th>
				<th>삭 제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${requestScope.list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.content }</td>
					<td>${tmp.regdate }</td>
					<td>
						<a href="${pageContext.request.contextPath }/todo/updateform.do?num=${tmp.num }">수정</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/todo/delete.do?num=${tmp.num }">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>