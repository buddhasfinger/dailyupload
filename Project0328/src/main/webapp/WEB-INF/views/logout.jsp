<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% session.invalidate(); %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			alert('로그아웃을 하셨습니다.');
			location.href="/main";
<%-- 			location.href="<%=request.getParameter("redirect") %>"; --%>
		</script>
		
		
	</head>
	<body>
	</body>
</html>