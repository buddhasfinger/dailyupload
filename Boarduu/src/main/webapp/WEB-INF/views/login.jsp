<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
	tr td {border: 1px solid black;}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function loginCheck(){
		alert('로그인 합니다');
		$.ajax({
			url:"/loginCheck",
			type:"get",
			data:{
				id:$("#id").val(),pw:$("#pw").val() //보내는 데이터
			},
			contentType:"application/json",
			success:function(data){  //받는 데이터
				if(data.loginCheck==1){
					alert("로그인 성공");
					location.href="/";
				}else{
					alert("ID 와 Password가 일치하지 않습니다.");
					$("#id").val().focus();
				}
			
			},
			
			error:function(){
				alert("에러");
			}
		});
	}
	
</script>


</head>
<body>
	<h2> 로그인  </h2>
	
	<table>
		<tr> 
			<td><label for="id">아이디 : </label> </td>
			<td><input type="text" name="id" id="id" required> </td>
		</tr>
		<tr> 
			<td><label for="pw">패스워드 : </label></td>
			<td><input type="password" name="pw" id="pw" required> </td>
		</tr>
	</table>
	<input type="button" onclick="loginCheck()" value="확인"><br>
	<label for="keep"><input type="checkbox" name="keep" id="keep" value="keepOk">로그인 상태 유지 </label>
</body>
</html>