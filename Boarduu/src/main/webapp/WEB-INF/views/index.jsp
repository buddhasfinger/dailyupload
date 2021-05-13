<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
	tr td {border: 1px solid black;}
	.log {cursor: pointer ;}
</style>

</head>
<body>
	<h2>메인페이지  </h2>
	
	<c:choose>
		<c:when test="${session_flag ==null || session_flag =='fail' }">
			<a href="/login"><label class="log">로그인</label></a>
		</c:when>
		<c:otherwise>
			<a href="/logout"><label>로그아웃</label></a>
			<a href="/list"><label>게시판으로 이동</label></a>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>