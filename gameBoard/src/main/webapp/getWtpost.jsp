<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="top.jsp" />
<link rel="stylesheet" href="./resources/css/getpost.css"
	type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
function confirmDelete(wtID) {
    if (confirm("정말로 삭제 하시겠습니까?")) {
        $.ajax({
            url: 'deleteWtpost.do',
            type: 'POST',
            data: { wtID: wtID },
            dataType: 'text',
            success: function(response) {
            	console.log("Response: ", response);
                if (response === "deleteSuccess") {
                    alert("삭제가 완료되었습니다.");
                    window.location.href = './walkThrough.do';
                } else if (response === "deleteFailed") {
                    alert("삭제 권한이 없습니다.");
                }
            },
            error: function() {
                alert("삭제 요청 중 오류가 발생했습니다.");
            }
        });
    }
}

function checkEditPermission(wtID) {
    console.log("checkEditPermission 호출됨", "wtID:", wtID);
    if (confirm("정말로 수정하시겠습니까?")) {
        $.ajax({
            url: 'checkEditPermission.do',
            type: 'GET',
            data: { wtID: wtID },
            dataType: 'text',
            success: function(response) {
                console.log("Response: ", response);
                var parts = response.split('|');
                if (parts[0] === "updateSuccess") {
                    alert("수정 권한이 확인되었습니다.");
                    // 서버에서 반환된 URL로 페이지 이동
                    window.location.href = parts[1];
                } else if (parts[0] === "updateFailed") {
                    alert("수정 권한이 없습니다.");
                }
            },
            error: function(xhr, status, error) {
                console.log("AJAX Error: ", status, error);
                alert("수정 요청 중 오류가 발생했습니다.");
            }
        });
    }
}
</script>


<div class="inner_atc">
	<div class="tit_atc">
        <h3>공략게시판</h3>
    </div>
	<div class="board_comm">
		<div class="view_head">
			<h4 class="tit_view">${post.getWtTitle()}</h4>
			<div class="info_head">
				<dl class="writer_info">
					<dt class="tit_info">글쓴이</dt>
					<dd class="cont_info">
						<a href="#" class="link_writer"> 
							<span class="txt_writer">${post.getUserID()}</span>
						</a>
					</dd>
				</dl>
				<dl class="date_info">
					<dt class="tit_info">작성일</dt>
					<dd class="cont_info">${post.getWtDate()}</dd>
					<dt class="tit_info">조회수</dt>
					<dd class="cont_info">${post.wtViews}</dd>
				</dl>
			</div>
		</div>
		<div class="view_cont">
			<div class="content">
				<p>${post.getWtContent()}</p>
			</div>
		</div>


		<div class="view_btn">
			<div class="wrap_modify">
				<button type="button" class="btn_board btn_board1 edit_btn" 
            		onclick="checkEditPermission(${post.wtID})">수정</button>
				<button type="button" class="btn_board btn_board1 delete_btn"
					onclick="confirmDelete(${post.wtID})">삭제</button>
			</div>
			
			<div class="wrap_page">
				<a href="walkThrough.do" class="btn_list"><span
					class="img_board">목록</span></a>

				<%-- 다음 게시물 링크 --%>
				<c:if test="${not empty nextPost}">
					<a href="getWtpost.do?wtID=${nextPost.wtID}" class="btn_next"><span
						class="img_board">윗글</span></a>
				</c:if>

				<%-- 이전 게시물 링크 --%>
				<c:if test="${not empty prevPost}">
					<a href="getWtpost.do?wtID=${prevPost.wtID}" class="btn_prev"><span
						class="img_board">아랫글</span></a>
				</c:if>
			</div>
			</div>
	</div>
</div>
