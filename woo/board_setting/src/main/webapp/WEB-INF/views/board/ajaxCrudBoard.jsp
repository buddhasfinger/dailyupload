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

	$(document).ready(function(){
		boardList();
	});

	//닫기 버튼 누르면 Ajax 컨텐츠뷰 닫힘
	function btnClose(){
		$("#resultShow2").html("");
		}

	//컨텐츠 뷰
	function contentView(bid){
		$.ajax({
			url:"/contentView1",
			type:"post",
			//dataType:"json",
			data:{
				"bid":bid
			},
			success : function(data) {
		 		var html2="";
		 		html2+='<table><tr><th>번호</th></tr>'
		 		html2+='<tr><td>'+data.bid+'</td></tr>'	
		 		html2+='<tr><th>제목</th></tr>'
			 	html2+='<tr><td>'+data.btitle+'</td></tr>'
			 	html2+='<tr><th>작성자</th></tr>'
				html2+='<tr><td>'+data.bwriter+'</td></tr>'
				html2+='<tr><th>내용</th></tr>'
				html2+='<tr><td>'+data.bcontent+'</td></tr></table>'
				html2+='<input type="button" onclick="btnClose()" value="닫기">'
		 		$('#resultShow2').html(html2);
				
			},
			error : function() {
				alert("게시판을 불러오는데 실패했습니다.");
			},
		});

		}//contentView

	//글쓰기 저장 
	function writeCheck(btitle,bwriter,bcontent){
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

		$.ajax({
			url:"/board/writeCheck1",
			type:"post",
			data:{
				"btitle":btitle , "bwriter":bwriter, "bcontent":bcontent
			},
			success : function(data) {
				boardList();
			},
			error : function() {
				alert("게시판을 불러오는데 실패했습니다.");
			},
		});

		
		//document.form1.submit();
		}//writeCheck
	
	//글 쓰기 버튼 누르면 div에 보여주는 것
	function boardWrite(buttonClick){
		
		if(buttonClick==0 || buttonClick==null){
			var html2="";
			html2+= '<form action="/board/writeCheck1" name="form1"><table><tr>'
			html2+= '<th>제목</th>'
			html2+= '<td><input type="text" name="btitle" id="btitle" placeholder="제목을 입력해 주세요"></td></tr>'		
			html2+= '<tr><th>작성자</th>'
			html2+= '<td><input type="text" name="bwriter" id="bwriter" placeholder="작성자를 입력해 주세요"></td></tr>'
			html2+=	'<tr><th>내용</th>'
			html2+=	'<td><input type="text" name="bcontent" id="bcontent" placeholder="내용을 입력해 주세요"></td></tr>'	
			html2+= '</table><input type="button" onclick="writeCheck(btitle.value,bwriter.value,bcontent.value)" value="작성"></form>'
			$('#resultShow2').html(html2);
			document.getElementById("buttonClick").value="1";
		}else{
			$('#resultShow2').html("");
			document.getElementById("buttonClick").value="0";
		}
		
	}//boardWrite
	
	//글 삭제
	function boardDelete(bid){
		if(confirm("정말 삭제 하시겠습니까?")==true){
			$.ajax({
				url:"/board/boardDeleteAjax",
				type:"post",
				//dataType:"json",
				data:{
					"bid":bid
				},
				success : function(data) {
// 					location.reload();
					boardList();
					
				},
				error : function() {
					alert("게시판을 불러오는데 실패했습니다.");
				},
			});
			}else{
				return;
				}
		}//boardDelete

	
	//게시판 진입시 jquery
	function boardList(){
// 	$(function(){
		//document.getElementById('resultShow').innerHTML="";
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
						board+='<td><a href="javascript:void(0);" onclick="contentView('+data[i].bid+')" >'+data[i].btitle+'</a></td>'
						board+='<td>'+data[i].bwriter+'</td>'
						board+='<td>'+data[i].bdate+'&nbsp &nbsp<input type="button" onclick="boardDelete('+data[i].bid+')" value="삭제"></td>'
						board+='</tr>'
					}
						board+='</table>'
						board+='<input type="hidden" name="buttonClick" id="buttonClick" value="">'	
						board+='<input type="button" onclick="boardWrite(buttonClick.value)" value="글쓰기">'	
						$('#resultShow').html(board);
						
				},
				error : function() {
					alert("게시판을 불러오는데 실패했습니다.");
				},
			});
	}
// 	})//jquery
	
	function home(){
		var img="";
		img+= '<img src="../../resources/img/wooriict.png">'
		$('#resultShow').html(img);		
		}

	
</script>

<style>
	table{ width:1000px; height:100px; border: 1px solid black;}
</style>


</head>
<body>

<ul class="nav nav-tabs">
  <li role="presentation" class=""><a href="/" >Home</a></li>
  <li role="presentation" class="dropdown active" >
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


	<div id="resultShow">
	</div>
	<div id="resultShow2">
	</div>
</body>
</html>
