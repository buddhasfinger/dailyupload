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
	function bpwCheck(){
		alert('비번 확인중');
		$.ajax({
			url:"/bpwCheck",
			type:"get",
			data:{
				bpw:$("#bpw").val(),bid:${bid} //보내는 데이터
			},
			contentType:"application/json",
			success:function(data){  //받는 데이터
				alert(data);
				if(data==0){
					alert("비밀번호 일치");
					opener.parent.location='/content_view?bid='+${bid};
					window.close();
				}else{
					alert("Password가 일치하지 않습니다.");
					$("#bpw").val().focus();
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
			<td><label for="bpw">패스워드 : </label></td>
			<td><input type="password" name="bpw" id="bpw"> </td>
		</tr>
	</table>
	<input type="button" onclick="bpwCheck()" value="확인"><br>
</body>
</html>