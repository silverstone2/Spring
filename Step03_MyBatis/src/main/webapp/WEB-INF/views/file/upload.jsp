<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/upload.jsp</title>
</head>
<body>
	<h1>업로드된 파일의 정보</h1>
	<p>title : <strong>${title }</strong></p>
	<p>fileSize : <strong>${fileSize }</strong></p>
	<p>orgFileName : <strong>${orgFileName }</strong></p>
	<p>saveFileName : <strong>${saveFileName }</strong></p>
	<p>savePath : <strong>${savePath }</strong></p>
</body>
</html>