<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글쓰기</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="../../resources/css/style.css">
  <link rel="stylesheet" href="../../resources/css/write.css">
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
 	<c:choose>
		<c:when test="${session_flag == null || session_flag == 'fail'}"> <!-- sessionScope.session_flag이게 정석이다 -->
			<script type="text/javascript">
				alert('로그인을 필요로 하는 페이지입니다.');
				location.href = "/";
			</script>
		</c:when>
	</c:choose>
 
  	<script>
  	function checkAble(frm)
  	{	
  	    if( frm.check.checked == true ){
  		   frm.bpw.disabled = false; //false로 하면 반대
  		} else 
  		{
  		   frm.bpw.disabled = true; //true로 하면 반대
  		}
  	}

  	
			function writeCheck(){
    		alert('writeCheck'); 
    		if($("#btitle").val()==""){
    			alert('제목을 꼭 적어주세요'); 
    			$("#btitle").focus();
    			return false;
    		}
     		$.ajax({ 
				url:"/write", 
 				type:"post", 
				enctype:"multipart/form-data",
				data:
					new	FormData($('#writeForm')[0]), 
					processData:false,
					contentType:false, 
 					cache:false, 
					
 					success:function(data){  //받는 데이터 -->
						alert('게시판 등록이 완료되었습니다.'); 
						location.href="./list";
				}, 
 				error:function(){ 
 					alert("에러");
 				} 
			}); 
		}
     </script> 
  
  
</head>
<body>
<section>
    <h1>글쓰기</h1>
    <hr>

    <form action="./write" id="writeForm"  name="writeForm" method="post" enctype="multipart/form-data">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bname" id="bname" value="${session_nname }" readonly>
            <input type="hidden" name="lm_user" id="lm_user" value="${session_id }">
          </td>
        </tr>  
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle" id="btitle">
          </td>
        </tr>
        <tr>
          <th>비밀글 선택</th>
          <td>
          	<form>
          		<input type="checkbox" name="check" id="check" onclick="checkAble(this.form)">비밀글
           	 	<input type="text" name="bpw" id="bpw" disabled>
          	</form>
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bcontent" id="bcontent" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="button" onclick="writeCheck()" class="write">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='./list'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>