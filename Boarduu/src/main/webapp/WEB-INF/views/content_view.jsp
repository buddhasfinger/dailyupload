<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../../resources/css/style.css">
  <link rel="stylesheet" href="../../resources/css/read.css">
  <style type="text/css">
  	.mouseCursor {cursor:pointer;}
  </style>
  <script type="text/javascript">
  	function delete_check(){
  			alert('삭제기능 도나');
  		if(confirm("삭제 하시겠습니까?")){
  			location.href="./delete?page=${map.page }&bid=${map.boardDto.bid }&category=${map.category}&search=${map.search}";
  		}else{
  			return false;
  		}	
  	}
  </script>
</head>
<body>
<section>
    <h1>내용</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${board.btitle }</strong></td>
      </tr>
      <tr>
        <td>${board.lm_user }</td>
        <td>조회수</td>
        <td>${board.bhit }</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${board.bcontent }</td>
      </tr>
      <tr>
      	<td>파일첨부 </td>
        <td colspan="2" ><a href="../../resources/upload/${board.bfilename }" download>${board.bfilename }</a></td>
      </tr>
       <tr>
        <td colspan="3" class="article">
        	<img alt="" src="../../resources/upload/${board.bfilename }">
        </td>
      </tr>
<!--       <tr> -->
<!--         <td colspan="3"><strong>다음글</strong> <span class="separator">|</span> -->
<%--         <a href="./content_view?category=${map.category}&search=${map.search}&page=${map.page}&bid=${map.nextDto.bid}">${map.nextDto.btitle }</a></td> --%>
<!--       </tr> -->
<!--       <tr> -->
<!--         <td colspan="3"><strong>이전글</strong> <span class="separator">|</span>  -->
<%--         <a href="./content_view?category=${map.category}&search=${map.search}&bid=${map.preDto.bid }&page=${map.page}"> ${map.preDto.btitle }</a> --%>
<!--        </td> -->
<!--       </tr> -->
    </table>

    <a href="./list?category=${map.category}&search=${map.search}&page=${map.page }"><div class="list">목록</div></a>
    <div class="list mouseCursor"  onclick="delete_check()">삭제</div>
    <a href="modify_view?category=${map.category}&search=${map.search}&page=${map.page}&bid=${map.boardDto.bid}"><div class="list">수정</div></a>
    <a href="reply_view?category=${map.category}&search=${map.search}&page=${map.page}&bid=${map.boardDto.bid}"><div class="list">답변달기</div></a>
  </section>
</body>
</html>