<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	
	<style>
		table {text-align:left;}
	</style>
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	function contentlist(){
		location.href="/board/crudBoard";
		}

	function modifyView(bid){
		location.href="/board/modifyView?bid="+bid;
		}
	function boardDelete(bid){
		location.href="/board/boardDelete?bid="+bid;
		}
	
</script>
</head>
<body>
	<ul class="nav nav-tabs">
	  <li role="presentation" ><a href="/" >Home</a></li>
	  <li role="presentation" class="active"><a href="/board/crudBoard" >게시판</a></li>
	</ul>
<h1>
	게시글 상세
</h1>
	
	<table>
		<tr>
			<th>번호</th>
			<td>${vo.bid } </td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.btitle } </td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.bwriter } </td>
		</tr>
		<tr>
			<th colspan="2">내용</th>
		</tr>
		<tr>
			<td colspan="2">${vo.bcontent }</td>
		</tr>
	</table>
	<input type="button" onclick="modifyView('${vo.bid}')" value="수정">
	<input type="button" onclick="boardDelete('${vo.bid}')" value="삭제">
	<input type="button" onclick="contentlist()" value="목록">
</body>
</html>