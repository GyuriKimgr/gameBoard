<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="top.jsp" />

<link rel="stylesheet" href="./resources/css/getpost.css"
	type="text/css">
<link rel="stylesheet" href="./resources/css/theme.css" type="text/css">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

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
						<a href="#" class="link_writer"> <span class="txt_writer">${post.getUserID()}</span>
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
				<a href="updateWtpostForm.do?wtID=${post.wtID}"
					class="btn_board btn_board1 edit_btn">수정</a>
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


<div class="view_cmt">
			<div class="cmt_head">
				<strong class="tit_cmt">댓글 <em class="emph_g2"><span
						class="screen_out">총 갯수</span></em></strong>
				<form action="addComment.do" id="writeCommentForm"
					name="writeCommentForm" method="post">
					<fieldset class="fld_cmt" style="padding: 25px">
						<legend class="screen_out">댓글 작성 양식</legend>
						<label for="commentContent" class="screen_out">댓글 작성</label>
						<textarea id="commentContent" name="commentContent" class="tf_cmt"
							title="답글입력" cols="70" rows="2" class="desc_cmt" placeholder = "댓글 작성 시 타인에 대한 배려와 책임을 담아주세요."></textarea>
						<div class="info_byte">
							<span class="screen_out">입력된 바이트 수 : </span> <span
								class="emph_g2" id="comment_limit">0</span> / 600 bytes (한글
							300자) <span class="txt_bar">|</span> <a href="#"
								class="link_rule" target="_blank">댓글 운영정책</a>
						</div>
						<button type="submit" class="btn_register">등록</button>
						<input type="hidden" name="wtID" value="${post.wtID}" />
					</fieldset>
				</form>
			</div>

			<div class="list_cmt" id="commentsContainer">
				<c:forEach var="comment" items="${commentList}">

					<div class="cmt_cont">
						<div class="cont_user">
							<a href="#" class="user_name">${comment.userID}</a>
						</div>
						<div class="cont_cmt">
							<p class="txt_desc">${comment.commentContent}</p>

							<span class="info_opt"> <span class="txt_date"><fmt:formatDate
										value="${comment.commentDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
								<form action="deleteComment.do" method="post"
									style="display: inline;">
									<input type="hidden" name="commentID"
										value="${comment.commentID}" /> <input type="hidden"
										name="wtID" value="${wtID}" />

									<button type="submit" class="btn_delete">삭제</button>
								</form>
							</span>
						</div>
					</div>
				</c:forEach>
			</div> 
		</div>

<%-- 
<!-- 댓글 추가 폼 -->
    <h3>댓글 추가</h3>
    <form action="addComment.do" method="post">
        <input type="hidden" name="wtID" value="${post.wtID}" />
        <table>
            <tr>
                <td><label for="userID">사용자 ID:</label></td>
                <td><input type="text" name="userID" id="userID" required /></td>
            </tr>
            <tr>
                <td><label for="commentContent">댓글 내용:</label></td>
                <td><textarea name="commentContent" id="commentContent" rows="4" cols="50" required></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="댓글 추가" />
                </td>
            </tr>
        </table>
    </form>
    
    <!-- 댓글 목록 -->
    <h3>댓글 목록</h3>
    <c:if test="${not empty commentList}">
        <table border="1">
            <thead>
                <tr>
                    <th>댓글 ID</th>
                    <th>사용자 ID</th>
                    <th>댓글 날짜</th>
                    <th>댓글 내용</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="comment" items="${commentList}">
                    <tr>
                        <td>${comment.commentID}</td>
                        <td>${comment.userID}</td>
                        <td>${comment.commentDate}</td>
                        <td>${comment.commentContent}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty commentList}">
        <p>댓글이 없습니다.</p>
    </c:if> --%>







<%--

	<div class="view_cmt">
			<div class="cmt_head">
				<strong class="tit_cmt">댓글 <em class="emph_g2"><span
						class="screen_out">총 갯수</span></em></strong>
				<form action="commentWrite.do" id="writeCommentForm"
					name="writeCommentForm" method="post">
					<fieldset class="fld_cmt" style="padding: 25px">
						<legend class="screen_out">댓글 작성 양식</legend>
						<label for="comment" class="screen_out">댓글 작성</label>
						<textarea id="comment" name="commentContent" class="tf_cmt"
							title="답글입력" cols="70" rows="2"></textarea>
						<div class="desc_cmt">댓글 작성 시 타인에 대한 배려와 책임을 담아주세요.</div>
						<div class="info_byte">
							<span class="screen_out">입력된 바이트 수 : </span> <span
								class="emph_g2" id="comment_limit">0</span> / 600 bytes (한글
							300자) <span class="txt_bar">|</span> <a href="#"
								class="link_rule" target="_blank">댓글 운영정책</a>
						</div>
						<button type="submit" class="btn_register">등록</button>
						<input type="hidden" name="postID" value="${post.wtID}" />
					</fieldset>
				</form>
			</div>

			<div class="list_cmt" id="commentsContainer">
				<c:forEach var="comment" items="${comments}">

					<div class="cmt_cont">
						<div class="cont_user">
							<a href="#" class="user_name">${comment.userId}</a>
						</div>
						<div class="cont_cmt">
							<p class="txt_desc">${comment.content}</p>

							<span class="info_opt"> <span class="txt_date"><fmt:formatDate
										value="${comment.createdDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
								<a href="#" class="btn_recomm img_board">추천</a> <span
								id="gaia_recommendCount_" class="num_recomm"></span> <a href="#"
								class="btn_reply">댓글</a> <a href="#" class="btn_report">신고</a> <!-- 댓글 삭제 폼 -->
								<form action="deleteComment" method="post"
									style="display: inline;">
									<input type="hidden" name="commentId"
										value="${comment.commentId}" /> <input type="hidden"
										name="postId" value="${post.wtID}" />

									<button type="submit" class="btn_delete">삭제</button>
								</form>
							</span>
						</div>
					</div>
				</c:forEach>
			</div> 
		</div>
 --%>

</div>
</div>

<script>




function confirmDelete(wtID) {
	if (confirm("정말로 삭제 하시겠습니까?")) {
	window.location.href = 'deleteWtpost.do?wtID=' + wtID;
	}
}




document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("form");
    form.addEventListener("submit", function(event) {
        const userID = document.getElementById("userID").value.trim();
        const commentContent = document.getElementById("commentContent").value.trim();

        if (!userID) {
            alert("사용자 ID를 입력해주세요.");
            event.preventDefault();
            return;
        }

        if (!commentContent) {
            alert("댓글 내용을 입력해주세요.");
            event.preventDefault();
            return;
        }

        event.preventDefault(); // 폼 제출을 막음

        const formData = new FormData(form);
        fetch("addComment.do", {
            method: "POST",
            body: formData
        })
        .then(response => response.text())
        .then(response => {
                // 댓글 목록에 새로운 댓글을 동적으로 추가
                const commentID = Date.now(); // 댓글 ID를 임시로 현재 시간으로 설정
                const userID = formData.get("userID");
                const commentContent = formData.get("commentContent");
                const commentDate = new Date().toLocaleString();
                let tableBody = document.querySelector("table tbody");
                let newRow = document.createElement("tr");
                let newTdcommentID = document.createElement("td");
                let newTduserID = document.createElement("td");
                let newTdcommentContent = document.createElement("td");
                let newTdcommentDate = document.createElement("td");

                newTdcommentID.innerText = commentID
                newTdcommentID.style = 'display:none'
                newTduserID.innerText = userID
                newTdcommentContent.innerText = commentContent
                newTdcommentDate.innerText = commentDate
                console.log(newTdcommentID)
                console.log(newTduserID)
                console.log(newTdcommentContent)
                console.log(newTdcommentDate)

                //newRow.innerHTML += `
                //    <td>${commentID}</td>
                //    <td>${userID}</td>
                //    <td>${commentContent}</td>
                //    <td>${commentDate}</td>
                //`;
                newRow.appendChild(newTdcommentID);
                newRow.appendChild(newTduserID);
                newRow.appendChild(newTdcommentContent);
                newRow.appendChild(newTdcommentDate);
                tableBody.appendChild(newRow);

                // 폼 필드를 초기화
                form.reset();

        })
        .catch(error => {
            console.error("Error:", error);
            alert("댓글 추가 중 오류가 발생했습니다.");
        });
    });
});

		</script>