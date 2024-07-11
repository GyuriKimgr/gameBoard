<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="top.jsp" />
<link rel="stylesheet" href="./resources/css/post.css" type="text/css">

<section>
	<div class="title">
        <h3>공략게시판</h3>
    </div>
	<div class="form-container">
<form action="updateMod.do" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
    <input type="hidden" name="mID" value="${post.mID}" /> <!-- 수정할 게시물의 ID를 hidden 필드로 전달 -->
   <div class="form-group">
        <label for="mTitle">제목</label>
        <input type="text" id="mTitle" name="mTitle" value="${post.mTitle}" /> <!-- 기존 제목을 입력 -->
    </div>
      <div class="form-group">
        <label for="mContent">내용</label>
        <textarea id="mContent" name="mContent" rows="8">${post.mContent}</textarea> <!-- 기존 내용을 입력 -->
    </div>
    <div class="frame">
        		<button type="submit" class="custom-btn btn"><span>수정 완료</span></button>
    		</div>
</form>
</div>
</section>

<script>
    function validateForm() {
        // 제목과 내용을 가져옵니다.
        var mTitle = document.getElementById("mTitle").value.trim();
        var mContent = document.getElementById("mContent").value.trim();
        
        // 제목이 비어 있는지 확인합니다.
        if (mTitle === "") {
            alert("제목을 입력하세요");
            return false;
        }
        
        // 제목의 길이가 2자 이상인지 확인합니다.
        if (mTitle.length < 2) {
            alert("제목을 2자 이상 입력하세요");
            return false;
        }
        
        // 내용이 비어 있는지 확인합니다.
        if (mContent === "") {
            alert("본문 내용을 입력하세요");
            return false;
        }
        
        // 모든 검증을 통과하면 true를 반환하여 제출을 허용합니다.
        return true;
    }
</script>


