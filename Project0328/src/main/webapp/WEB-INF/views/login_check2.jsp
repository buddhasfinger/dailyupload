<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<c:choose>
			<c:when test="${session_flag==null || session_flag=='fail' }">
				<script>
					alert('아이디와 패스워드가 일치하지 않습니다. 다시 입력해 주세요')
					location.href="login";
				</script>
			</c:when>
			<c:otherwise>
				<script>
					alert('로그인 성공!');
					location.href="main";
				</script>
			</c:otherwise>
		
		</c:choose>
		
		
		
		
	</head>
	<body>
		<%-- <ul>
			<li><%out.println("ID"+request.getParameter("id")); %> </li>
		</ul> --%>
	</body>
</html>