<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<style>
table {
	text-align: left;
}
</style>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">


	//TEST6
	$(document).ready(function(){
			//test11();
		var html3="";
		html3+= '<form><input type="text" name="num3" id="num3" ><input type="button" onclick="showResult(num3.value)" value="선택"></form>'
		$('#resultShow3').html(html3);
		
	});

	//TEST6 결과표시
	function showResult(num3){
		var html4="";
		html4 +='<table><tr>'
		for(var i=1;i<=num3;i++){
					html4 +='<td>'+i+'</td>'	
				if((i%4)==0){
					html4 +='</tr><tr>'
				}
			}//for
				if((num3%4)==1){
					html4 += '<td>X</td><td>X</td><td>X</td>'
				}else if((num3%4)==2){
					html4 += '<td>X</td><td>X</td>'
				}else if((num3%4)==3){
					html4 += '<td>X</td>'
				}
			html4 += '</tr></table>'

		$("#resultShow4").html(html4);
		}//showResult
		
		
// 	//TEST6 결과표시
// 	function showResult(num3){
// 		var temp = num3-1;
// 		var line = temp/4;
// 		var html4="";
// 		html4 +='<table>'
// 		for(var i=0;i<=line;i++){
// 			html4 += '<tr><td>야<td><td>야<td><td>야<td><td>야<td></tr>'	
// 			}//for
// 			html4 += '</table>'

// 		$("#resultShow4").html(html4);
// 		}//showResult

	//구구단 계산
	function gugudan(dan){
		var html1="";
		for(var i=1;i<=9;i++){
				var rs = dan*i;
				html1+='<h5>'+dan+'X'+i+'='+rs+'</h5>'
			}
				$("#resultShow").html(html1);
		
		}//gugudan

	//색깔변경하기
	function colorChoice(num,color){
		if(num ==null || num=='' || color==null || color==''){
				alert('변경할 색상을 선택해 주세요');
			}
		$("#words").children().css('color','black');
		//$("#words:nth-child(1)").css('color','red');
		//$("#color option").clear();
		//$(this).css('color','black');
		//document.getElementById('words').style.color='';
		switch(num){
			case '1':
				switch(color){
					case 'red':
						document.getElementById('first').style.color='red';
						break;
					case 'blue':
						document.getElementById('first').style.color='blue';
						break;
					case 'yellow':
						document.getElementById('first').style.color='yellow';
						break;
					case 'green':
						document.getElementById('first').style.color='green';
						break;
				}
				break;
			case '2':
				switch(color){
					case 'red':
						document.getElementById('second').style.color='red';
						break;
					case 'blue':
						document.getElementById('second').style.color='blue';
						break;
					case 'yellow':
						document.getElementById('second').style.color='yellow';
						break;
					case 'green':
						document.getElementById('second').style.color='green';
						break;
				}
				break;
			case '3':
				switch(color){
					case 'red':
						document.getElementById('third').style.color='red';
						break;
					case 'blue':
						document.getElementById('third').style.color='blue';
						break;
					case 'yellow':
						document.getElementById('third').style.color='yellow';
						break;
					case 'green':
						document.getElementById('third').style.color='green';
						break;
				}
				break;
			case '4':
				switch(color){
					case 'red':
						document.getElementById('forth').style.color='red';
						break;
					case 'blue':
						document.getElementById('forth').style.color='blue';
						break;
					case 'yellow':
						document.getElementById('forth').style.color='yellow';
						break;
					case 'green':
						document.getElementById('forth').style.color='green';
						break;
				}
				break;

			}//switch
		}//colorChoice


		//전체선택
		function ChkChk(){
			if($("#allChk").is(':checked')){
					$("input[name=Chk]").prop("checked",true);
				}else{
					$("input[name=Chk]").prop("checked",false);
					}
			}//ChkChk


		//삭제(체크박스 된 것 전부)	
		function SelectDel(){
			//alert('123');
			var checkRow ="";
			$("input[name=Chk]:checked").each(function(){
				checkRow=checkRow + $(this).val()+",";
				});
				checkRow = checkRow.substring(0,checkRow.lastIndexOf(","));
				
			if(checkRow==''){
				alert('삭제할 대상을 선택하세요.');
				return false;
			}else{
				alert(checkRow);
				}
				colsole.log("### checkRow => {}"+checkRow);
			}//SelectDel
			
</script>

<style>
	table tr td {border: 1px solid black;}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="/">Home</a></li>
		<li role="presentation" class="active"><a href="/board/crudBoard">게시판</a></li>
		<li role="presentation" class=""><a href="/wooTest3">플젝3</a></li>
	</ul>
	<h1>TEST2 - 구구단</h1>
	<div id="">
		<form>
			<select id="guguSel" name="guguSel">
				<option selected>선택</option>
				<option id="guguOpt" name="guguOpt" value="1">1단</option>
				<option id="guguOpt" name="guguOpt" value="2">2단</option>
				<option id="guguOpt" name="guguOpt" value="3">3단</option>
				<option id="guguOpt" name="guguOpt" value="4">4단</option>
				<option id="guguOpt" name="guguOpt" value="5">5단</option>
				<option id="guguOpt" name="guguOpt" value="6">6단</option>
				<option id="guguOpt" name="guguOpt" value="7">7단</option>
				<option id="guguOpt" name="guguOpt" value="8">8단</option>
				<option id="guguOpt" name="guguOpt" value="9">9단</option>

			</select> <input type="button" onclick="gugudan(guguSel.value)" value="계산"><br>
		</form>
	</div>
	<div id="resultShow"></div>
	<br>
	<br>
	<br>
	<br>

	<h1>TEST4 - 색상변경</h1>
	<div id="words">
		<span id="first">첫번째</span><br> <span id="second">두번째</span><br>
		<span id="third">세번째</span><br> <span id="forth">네번째</span><br>
	</div>
	<form>
		<select id="num" name="num">
			<option id="" value="" selected>선택</option>
			<option name="order" id="order" value="1">첫번째</option>
			<option name="order" id="order" value="2">두번째</option>
			<option name="order" id="order" value="3">세번째</option>
			<option name="order" id="order" value="4">네번째</option>
		</select> <select id="color" name="color">
			<option id="" value="" selected>선택</option>
			<option name="colorOrder" id="colorOrder" value="red">빨강</option>
			<option name="colorOrder" id="colorOrder" value="blue">파랑</option>
			<option name="colorOrder" id="colorOrder" value="yellow">노랑
			</option>
			<option name="colorOrder" id="colorOrder" value="green">초록</option>
		</select> <input type="button" onclick="colorChoice(num.value,color.value)"
			value="변경">
	</form>
	<br>
	<br>
	<br>
	<br>

	<h1>게시판</h1>
	<form>
		<table>
			<tr>
				<td><input type="checkbox" id="allChk" name="allChk" onclick="ChkChk()"><label for="allChk">전체선택</label></td>
				<td><label>번호</label></td>
				<td><label>제목</label></td>
				<td><label>작성자</label></td>
				<td><label>날짜</label></td>
			</tr>
			<tr colspan="5">
				<td><input type="button" onclick="SelectDel()" value="선택삭제"></td>
			</tr>
			<tr>
				<td><input type="checkbox" id="Chk" name="Chk" value="128"></td>
				<td><input type="hidden" name="bid" id="bid" value="128"><label>128</label></td>
				<td><label>서울사이버 대학을 다니고 나의 성공시대 시작됐따</label></td>
				<td><label>바비킴</label></td>
				<td><label>2021-05-31</label><input type="button" onclick="contentDel(bid.value)" value="삭제"></td>
			</tr>
			<tr>
				<td><input type="checkbox" id="Chk" name="Chk" value="127"></td>
				<td><input type="hidden" name="bid" id="bid" value="127"><label>127</label></td>
				<td><label>공뭔 시헙 합격은 에듀윌</label></td>
				<td><label>서경석</label></td>
				<td><label>2021-05-30</label><input type="button" onclick="contentDel(bid.value)" value="삭제"></td>
			</tr>
			<tr>
				<td><input type="checkbox" id="Chk" name="Chk" value="126"></td>
				<td><input type="hidden" name="bid" id="bid" value="126"><label>126</label></td>
				<td><label>서울에서 가장 가까운 대학!</label></td>
				<td><label>목원대</label></td>
				<td><label>2021-05-29</label><input type="button" onclick="contentDel(bid.value)" value="삭제"></td>
			</tr>
			<tr>
				<td><input type="checkbox" id="Chk" name="Chk" value="125"></td>
				<td><input type="hidden" name="bid" id="bid" value="125"><label>125</label></td>
				<td><label>호국요람의 중심</label></td>
				<td><label>논산훈련소</label></td>
				<td><label>2021-05-28</label><input type="button" onclick="contentDel(bid.value)" value="삭제"></td>
			</tr>
			<tr>
				<td><input type="checkbox" id="Chk" name="Chk" value="124"></td>
				<td><input type="hidden" name="bid" id="bid" value="124"><label>124</label></td>
				<td><label>요식업 사관학교</label></td>
				<td><label>치킨대학</label></td>
				<td><label>2021-05-27</label><input type="button" onclick="contentDel(bid.value)" value="삭제"></td>
			</tr>
			<tr>
				<td><input type="checkbox" id="Chk" name="Chk" value="123"></td>
				<td><input type="hidden" name="bid" id="bid" value="123"><label>123</label></td>
				<td><label>로드FC 챔피언 양성소</label></td>
				<td><label>안양일번가</label></td>
				<td><label>2021-05-26</label><input type="button" onclick="contentDel(bid.value)" value="삭제"></td>
			</tr>
		</table>
	</form><br><br><br><br><br>


	<h1>TEST6</h1>
	<div id="resultShow3">
	</div>
	<div id="resultShow4">
	</div>
	
	<br><br><br><br><br>
</body>
</html>