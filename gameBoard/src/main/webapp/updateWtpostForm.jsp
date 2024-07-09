<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="top.jsp" />
<link rel="stylesheet" href="./resources/css/post.css" type="text/css">

<section>
	<div class="title">
        <h3>공략게시판</h3>
    </div>
	<div class="form-container">
<form action="updateWtpost.do" method="post" enctype="multipart/form-data">
    <input type="hidden" name="wtID" value="${post.wtID}" /> <!-- 수정할 게시물의 ID를 hidden 필드로 전달 -->
   <div class="form-group">
        <label for="wtTitle">제목</label>
        <input type="text" id="wtTitle" name="wtTitle" value="${post.wtTitle}" /> <!-- 기존 제목을 입력 -->
    </div>
      <div class="form-group">
        <label for="wtContent">내용</label>
        <textarea id="wtContent" name="wtContent" rows="8">${post.wtContent}</textarea> <!-- 기존 내용을 입력 -->
    </div>
    <div class="frame">
        		<button type="submit" class="custom-btn btn"><span>수정 완료</span></button>
    		</div>
</form>
</div>
</section>


