<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="top.jsp" %>

<link rel="stylesheet" href="./resources/css/getpost.css" type="text/css">
<link rel="stylesheet" href="./resources/css/theme.css" type="text/css">

<div class="inner_atc">
    <div class="tit_atc">
        <h3>공지사항</h3>
    </div>
    <div class="board_comm">
        <div class="view_head">
            <h4 class="tit_view">${notice.noticeTitle}</h4>
            <div class="info_head">
                <dl class="writer_info">
                    <dt class="tit_info">작성자</dt>
                    <dd class="cont_info">
                        <a href="#" class="link_writer"><span class="txt_writer">${notice.managerID}</span></a>
                    </dd>
                </dl>
                <dl class="date_info">
                    <dt class="tit_info">작성일</dt>
                    <dd class="cont_info">${notice.noticeDate}</dd>
                    <dt class="tit_info">조회수</dt>
                    <dd class="cont_info">${notice.noticeViews}</dd>
                </dl>
            </div>
        </div>
        <div class="view_cont">
            <div class="content">
                <p>${notice.noticeContent}</p>
            </div>
        </div>

        <div class="view_btn">
            <div class="wrap_modify">
                <a href="updateNoticeForm.do?noticeID=${notice.noticeID}" class="btn_board btn_board1 edit_btn">수정</a>
                <button type="button" class="btn_board btn_board1 delete_btn" onclick="confirmDelete(${notice.noticeID})">삭제</button>
            </div>
            <div class="wrap_page">
                <a href="walkThrough.do" class="btn_list"><span class="img_board">목록</span></a>
            </div>
        </div>

        <!-- 댓글 부분 -->
        <div class="view_cmt">
            <div class="cmt_head">
                <strong class="tit_cmt">댓글 <em class="emph_g2"><span class="screen_out">총 갯수</span></em></strong>
                <form action="addComment.do" id="writeCommentForm" name="writeCommentForm" method="post">
                    <fieldset class="fld_cmt" style="padding: 25px">
                        <legend class="screen_out">댓글 작성 양식</legend>
                        <label for="commentContent" class="screen_out">댓글 작성</label>
                        <textarea id="commentContent" name="commentContent" class="tf_cmt" title="답글입력" cols="70" rows="2" class="desc_cmt" placeholder="댓글 작성 시 타인에 대한 배려와 책임을 담아주세요."></textarea>
                        <div class="info_byte">
                            <span class="screen_out">입력된 바이트 수 : </span> <span class="emph_g2" id="comment_limit">0</span> / 600 bytes (한글 300자) <span class="txt_bar">|</span> <a href="#" class="link_rule" target="_blank">댓글 운영정책</a>
                        </div>
                        <button type="submit" class="btn_register">등록</button>
                        <input type="hidden" name="noticeID" value="${notice.noticeID}" />
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
                            <span class="info_opt">
                                <span class="txt_date"><fmt:formatDate value="${comment.commentDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
                                <form action="deleteComment.do" method="post" style="display: inline;">
                                    <input type="hidden" name="commentID" value="${comment.commentID}" />
                                    <input type="hidden" name="noticeID" value="${notice.noticeID}" />
                                    <button type="submit" class="btn_delete">삭제</button>
                                </form>
                            </span>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<script>
    function confirmDelete(noticeID) {
        if (confirm("정말로 삭제 하시겠습니까?")) {
            window.location.href = 'deleteNotice.do?noticeID=' + noticeID;
        }
    }

    document.addEventListener("DOMContentLoaded", function() {
        const form = document.querySelector("form");
        form.addEventListener("submit", function(event) {
            const commentContent = document.getElementById("commentContent").value.trim();

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
                const commentContent = formData.get("commentContent");
                const commentDate = new Date().toLocaleString();
                let commentsContainer = document.querySelector("#commentsContainer");
                let newDiv = document.createElement("div");
                newDiv.className = "cmt_cont";
                newDiv.innerHTML = `
                    <div class="cont_user">
                        <a href="#" class="user_name">사용자</a>
                    </div>
                    <div class="cont_cmt">
                        <p class="txt_desc">${commentContent}</p>
                        <span class="info_opt">
                            <span class="txt_date">${commentDate}</span>
                            <form action="deleteComment.do" method="post" style="display: inline;">
                                <input type="hidden" name="commentID" value="${commentID}" />
                                <input type="hidden" name="noticeID" value="${formData.get("noticeID")}" />
                                <button type="submit" class="btn_delete">삭제</button>
                            </form>
                        </span>
                    </div>
                `;
                commentsContainer.appendChild(newDiv);

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

<%@ include file="bottom.jsp" %>
