<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:import url="top.jsp" />

<link rel="stylesheet" href="./resources/css/post.css" type="text/css">

<section>
	<div class="title">
        <h3>게임추천</h3>
    </div>
	<div class="form-container">
        <form action="insertSgpost.do" method="post"
        	enctype="multipart/form-data" onsubmit="return validateForm();">
        <input type="hidden" id="userId" name="userId"
        	value="<%= session.getAttribute("userId") %>">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="sgTitle" name="sgTitle" maxlength="16" oninput="updateCharCount()">
                <span class="char-count" id="charCount">0/16</span>
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="sgContent" name="sgContent" rows="8"></textarea>
            </div>
            
            <div class="frame">
        		<button type="submit" class="custom-btn btn"><span>작성 완료</span></button>
    		</div>
        </form>
    </div>
</section>

<script>
	function updateCharCount() {
    	var sgTitle = document.getElementById("sgTitle");
    	var charCount = document.getElementById("charCount");
    	var currentLength = sgTitle.value.length;

   		charCount.textContent = currentLength + "/16";

    	// 최대 글자 수(16자)에 도달하면 입력을 막음
    	if (currentLength >= 16) {
    		sgTitle.value = sgTitle.value.substring(0, 15);
    	}
	}
    function validateForm() {
        // 제목과 내용을 가져옵니다.
        var sgTitle = document.getElementById("sgTitle").value.trim();
        var sgContent = document.getElementById("sgContent").value.trim();
        
        // 제목이 비어 있는지 확인합니다.
        if (sgTitle === "") {
            alert("제목을 입력하세요");
            return false;
        }
        
        // 제목의 길이가 2자 이상인지 확인합니다.
        if (sgTitle.length < 2) {
            alert("제목을 2자 이상 입력하세요");
            return false;
        }
        
        // 내용이 비어 있는지 확인합니다.
        if (sgContent === "") {
            alert("본문 내용을 입력하세요");
            return false;
        }
        
        // 모든 검증을 통과하면 true를 반환하여 제출을 허용합니다.
        return true;
    }
</script>
