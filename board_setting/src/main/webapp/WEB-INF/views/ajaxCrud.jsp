<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<style>
	table{ width:1000px; height:100px; border: 1px solid black;}
</style>

<script>

	function board(){
		document.getElementById('resultShow').innerHTML="";
// 		document.getElementById('innerhtml').clear();
		var board="";
		board+='<h2>게시판</h2><br>'
		//location.href="/board/listAll";	
			$.ajax({
				
				url:"/board/listAll",
				type:"post",
				
				dataType:"json",
				data:{
					
				},
				success : function(data) {
					board+='<table><tr> '
					board+='<td>번호 </td><td>제목 </td><td>작성자 </td><td>날짜 </td></tr>'	 
					for(var i=0 in data){
						//alert(data[i].btitle);
						board+='<tr>'
						board+='<td>'+data[i].bid+'</td>'
						board+='<td>'+data[i].btitle+'</td>'
						board+='<td>'+data[i].bwriter+'</td>'
						board+='<td>'+data[i].bdate+'</td>'
						board+='</tr>'
					}
						board+='</table>'
						$('#resultShow').html(board);
							
				},
				error : function() {
					alert("게시판을 불러오는데 실패했습니다.");
				},
			});
		
		}
	function home(){
		var img="";
		img+= '<img src="../../resources/img/wooriict.png">'
		$('#resultShow').html(img);		
		}

</script>

</head>
<body>

	<ul class="nav nav-tabs">
	  <li role="presentation" class="active"><a href="javascript:void(0);" onclick="home();">Home</a></li>
	  <li role="presentation" ><a href="javascript:void(0);" onclick="board();">게시판</a></li>
	</ul>


	<div id="resultShow">
		<img src="../../resources/img/wooriict.png">
		
	</div>
	
<!-- 	<div id="innerhtml2"> -->
		
<!-- 	</div> -->
	
</body>
</html>
