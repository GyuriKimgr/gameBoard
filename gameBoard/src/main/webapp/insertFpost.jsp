<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:import url="top.jsp" />

<link rel="stylesheet" href="./resources/css/post.css" type="text/css">

<section>
	<div class="title">
        <h3>FAQ</h3>
    </div>
	<div class="form-container">
        <form action="insertFpost.do" method="post"
        	enctype="multipart/form-data">
        <input type="hidden" id="userId" name="userId"
        	value="<%= session.getAttribute("userId") %>">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="fTitle" name="fTitle" maxlength="16" oninput="updateCharCount()">
                <span class="char-count" id="charCount">0/16</span>
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="fContent" name="fContent" rows="8"></textarea>
            </div>
            
            <div class="frame">
        		<button type="submit" class="custom-btn btn"><span>작성 완료</span></button>
    		</div>
        </form>
    </div>
</section>

<script>
	function updateCharCount() {
		var fTitle = document.getElementById("fTitle");
		var charCount = document.getElementById("charCount");
		var currentLength = fTitle.value.length;

		charCount.textContent = currentLength + "/16";

		// 최대 글자 수(16자)에 도달하면 입력을 막음
		if (currentLength >= 16) {
			fTitle.value = fTitle.value.substring(0, 15);
		}
	}
    function validateForm() {
        // 제목과 내용을 가져옵니다.
        var fTitle = document.getElementById("fTitle").value.trim();
        var fContent = document.getElementById("fContent").value.trim();
        
        // 제목이 비어 있는지 확인합니다.
        if (fTitle === "") {
            alert("제목을 입력하세요");
            return false;
        }
        
        // 제목의 길이가 2자 이상인지 확인합니다.
        if (fTitle.length < 2) {
            alert("제목을 2자 이상 입력하세요");
            return false;
        }
        
        // 내용이 비어 있는지 확인합니다.
        if (fContent === "") {
            alert("본문 내용을 입력하세요");
            return false;
        }
        
        // 모든 검증을 통과하면 true를 반환하여 제출을 허용합니다.
        return true;
    }
</script>
