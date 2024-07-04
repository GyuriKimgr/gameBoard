<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset id = "main_logform"> <!-- 폼 요소 그룹화  -->
	
		 <div class="login-form">
			<!-- 아이디 -->
			<label for = "main_id"></label>
			<input type ="text" id="main_id" name= "main_id" class ="input_id" title="아이디" placeholder="아이디"><br />
			<!-- 비밀번호 -->
			<label for ="main_password" ></label>
			<input type ="text" id="main_password" name ="main_password" class = "input_password"  title ="비밀번호" placeholder="비밀번호"  
			 	   maxlength="20"><br />
			<!-- 로그인 버튼 -->
			<input type = "button" calss="login_button" value= "로그인">
			
		<div class="option01">
			<input type="checkbox" id="keeplogin" name="keeplogin" class="chk_saveid" onmousedown="함수이름('받아들이는 인자자리');" onclick="함수이름('받아들이는 인자자리')" /> 
			<label for="keeplogin" class="set_saveid" onmousedown= "함수이름"('받아들이는 인자자리');">로그인 유지</label> </div>
		
		<span class="option02">
			<a href=# title="아이디 찾기">아이디</a> /
			<a href=# title="비밀번호 찾기">비밀번호 찾기</a> 
			<i class="bar">|</i> 
			<a href=# title="회원가입"><strong>회원가입</strong></a> 
		</span>
		</div>
	
	
</fieldset>
</body>
</html>