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

<script>
	function boardlist(){
		location.href="/board/crudBoard";
		}

	function modifyCheck(){
		if($("#btitle").val()==""){
			alert('제목을 입력 해주세요');
			$("#btitle").focus();
			return false;
			}
		if($("#bwriter").val()==""){
			alert('작성자를 입력 해주세요');
			$("#bwriter").focus();
			return false;
			}
		if($("#bcontent").val()==""){
			alert('내용을 입력 해주세요');
			$("#bcontent").focus();
			return false;
			}

		document.form1.submit();
		}
	
</script>

</head>
<body>
	<ul class="nav nav-tabs">
	  <li role="presentation" ><a href="/" >Home</a></li>
	  <li role="presentation" class="active"><a href="/board/crudBoard" >게시판</a></li>
	</ul>
<h1>
	게시글 작성
</h1>
	<form action="/board/modifyCheck" name="form1">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="btitle" id="btitle" placeholder="제목을 입력해 주세요" value="${vo.btitle }"> </td>
				<td><input type="hidden" name="bid" value="${vo.bid }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bwriter" id="bwriter" placeholder="작성자를 입력해 주세요" value="${vo.bwriter }"> </td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="bcontent" id="bcontent" placeholder="내용을 입력해 주세요" value="${vo.bcontent }"> </td>
			</tr>
		</table>
		<input type="button" onclick="modifyCheck()" value="수정">
		<input type="button" onclick="boardlist()" value="목록">
	</form>
</body>
</html>