<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script>
	function boardWrite(){
		location.href="/board/write";
		}
</script>

<style>
	table{ width:1000px; height:100px; border: 1px solid black;}
</style>


</head>
<body>
<ul class="nav nav-tabs">
  <li role="presentation" class=""><a href="/" >Home</a></li>
  <li role="presentation" class="dropdown active">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#"  role="button" aria-expanded="false">
      게시판 <span class="caret"></span>
    </a>
    <ul class="dropdown-menu" role="menu">
      	<li role="presentation" ><a href="/board/crudBoard" >게시판 목록</a></li>
      	<li role="presentation" ><a href="/board/ajaxCrudBoard" >게시판 목록 Ajax</a></li>
    </ul>
  </li>
  <li role="presentation" class=""><a href="/" >계산기</a></li>
</ul>

	<h2>게시판</h2><br>
	<div id="resultShow">
		<table>
			<tr>
				<td>번호 </td>
				<td>제목 </td>
				<td>작성자 </td>
				<td>날짜 </td>
			</tr>
			
			<c:forEach var="dto" items="${list}">  
				<tr> 
					<td>${dto.bid} </td>
					<td><a href="/contentView?bid=${dto.bid }">${dto.btitle }</a> </td>
					<td>${dto.bwriter } </td>
					<td>${dto.bdate } </td>
				</tr>
			</c:forEach>
		</table>
	</div>
			<input type="button" onclick="boardWrite()" value="글쓰기">
	
</body>
</html>
