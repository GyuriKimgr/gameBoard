<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="top.jsp" />

<link rel="stylesheet" href="./resources/css/getpost.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
function confirmDelete(sgID) {
    if (confirm("정말로 삭제 하시겠습니까?")) {
        $.ajax({
            url: 'deleteSgpost.do',
            type: 'POST',
            data: { sgID: sgID },
            dataType: 'text',
            success: function(response) {
                console.log("Response: ", response);
                if (response === "deleteSuccess") {
                    alert("삭제가 완료되었습니다.");
                    window.location.href = './suggest.do';
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

function checkEditPermissionSG(sgID) {
    console.log("checkEditPermission 호출됨", "sgID:", sgID);
    if (confirm("정말로 수정하시겠습니까?")) {
        $.ajax({
            url: 'checkEditPermissionSG.do',
            type: 'GET',
            data: { sgID: sgID },
            dataType: 'text',
            success: function(response) {
                console.log("Response: ", response);
                var parts = response.split('|');
                if (parts[0] === "updateSuccess") {
                    alert("수정 권한이 확인되었습니다.");
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

function confirmDeleteComment(sgCommentID, sgID) {
    if (confirm("정말로 삭제 하시겠습니까?")) {
        $.ajax({
            url: 'deleteSgComment.do',
            type: 'POST',
            data: { sgCommentID: sgCommentID, sgID: sgID },
            dataType: 'text',
            success: function(response) {
                if (response === "deleteSgCommentSuccess") {
                    alert("삭제가 완료되었습니다.");
                    location.reload();
                } else if (response === "deleteSgCommentFailed") {
                    alert("삭제 권한이 없습니다.");
                }
            },
            error: function() {
                alert("삭제 요청 중 오류가 발생했습니다.");
            }
        });
    }
}

document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("#writeCommentForm");
    form.addEventListener("submit", function(event) {
        const sgCommentContent = document.getElementById("commentContent").value.trim();
        if (!sgCommentContent) {
            alert("댓글 내용을 입력해주세요.");
            event.preventDefault();
            return;
        }
        event.preventDefault();
        
        const userID = document.getElementById("userID").value.trim();

        const formData = new FormData(form);
        formData.append("userID", userID);

        fetch("addSgComment.do", {
            method: "POST",
            body: formData
        })
        .then(response => response.text())
        .then(response => {
        		const sgCommentDate = new Date().toLocaleString();
                let commentsContainer = document.querySelector("#commentsContainer");
                let newCommentDiv = document.createElement("div");
                newCommentDiv.classList.add("cmt_cont");

                newCommentDiv.innerHTML = `
                    <div class="cont_user">
                        <a href="#" class="user_name"><b>${userID}</b></a>
                        <span class="txt_date"> | ${sgCommentDate}</span>
                    </div>
                    <div class="cont_cmt">
                        <p class="txt_desc">${sgCommentContent}</p>
                        <span class="info_opt">
                            <span class="txt_writer">${userID}</span>
                            <button type="button" class="btn_delete"
                                onclick="confirmDeleteComment(${comment.sgCommentID}, ${formData.get('sgID')})">삭제</button>
                        </span>
                    </div>
                `;
                commentsContainer.appendChild(newCommentDiv);
                form.reset();
                location.reload();
        })
        .catch(error => {
            console.error("Error:", error);
            alert("댓글 추가 중 오류가 발생했습니다.");
        });
    });
});
document.addEventListener("DOMContentLoaded", function() {
    const textarea = document.getElementById("commentContent");
    const commentLimit = document.getElementById("comment_limit");

    const maxLength = 300;

    commentLimit.textContent = "0";

    textarea.addEventListener("input", function() {
        const currentLength = textarea.value.length;
        if (currentLength > maxLength) {
            textarea.value = textarea.value.substring(0, maxLength);
        }
        commentLimit.textContent = textarea.value.length;
    });
});
document.addEventListener("DOMContentLoaded", function() {
    const dropdownToggle = document.querySelector(".dropdown-toggle");
    const dropdownMenu = document.querySelector(".dropdown-menu");
    const dropdown = document.querySelector(".dropdown");
    let isOpen = false;

    dropdownToggle.addEventListener("click", function() {
        if (isOpen) {
            dropdown.classList.remove("open");
            dropdownToggle.style.backgroundColor = "#ca99e3";
            dropdownToggle.style.color = "#fff";
            isOpen = false;
        } else {
            dropdown.classList.add("open");
            dropdownToggle.style.backgroundColor = "#fff";
            dropdownToggle.style.color = "#ca99e3";
            isOpen = true;
        }
    });

    document.addEventListener('click', function(event) {
        if (!event.target.closest('.dropdown')) {
            dropdown.classList.remove('open');
            dropdownToggle.style.backgroundColor = "#ca99e3";
            dropdownToggle.style.color = "#fff";
            isOpen = false;
        }
    });

    dropdownMenu.querySelectorAll('li').forEach(item => {
        item.addEventListener('click', function() {
            const sortOrder = this.getAttribute('data-value');

            let comments = Array.from(document.querySelectorAll("#commentsContainer .cmt_cont"));

            comments.sort((a, b) => {
                const dateA = new Date(a.querySelector(".txt_date").textContent.trim().split('|')[1].trim());
                const dateB = new Date(b.querySelector(".txt_date").textContent.trim().split('|')[1].trim());
                return (sortOrder === "desc" ? dateB - dateA : dateA - dateB);
            });

            const commentsContainer = document.getElementById("commentsContainer");
            commentsContainer.innerHTML = "";
            comments.forEach(comment => commentsContainer.appendChild(comment));

            dropdown.classList.remove('open');
            dropdownToggle.style.backgroundColor = "#ca99e3";
            dropdownToggle.style.color = "#fff";
            isOpen = false;
        });
    });
});
</script>

<div class="inner_atc">
    <div class="tit_atc">
        <h3>게임추천</h3>
    </div>
    <div class="board_comm">
        <div class="view_head">
            <h4 class="tit_view">${post.getSgTitle()}</h4>
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
                    <dd class="cont_info">${post.getSgDate()}</dd>
                    <dt class="tit_info">조회수</dt>
                    <dd class="cont_info">${post.sgViews}</dd>
                </dl>
            </div>
        </div>
        <div class="view_cont">
            <div class="content">
                <p>${post.getSgContent()}</p>
                <c:if test="${not empty image.imageUrl}">
					<img
						src="${pageContext.request.contextPath}/resources/images/${image.imageUrl}"
						alt="게시글 이미지" class="post-image" />
				</c:if>
                
            </div>
        </div>
        <div class="view_btn">
            <div class="wrap_modify">
                <button type="button" class="btn_board btn_board1 edit_btn" onclick="checkEditPermissionSG(${post.sgID})">수정</button>
                <button type="button" class="btn_board btn_board1 delete_btn" onclick="confirmDelete(${post.sgID})">삭제</button>
            </div>
            <div class="wrap_page">
                <a href="suggest.do" class="btn_list"><span class="img_board">목록</span></a>
                <c:if test="${not empty nextPost}">
                    <a href="getSgpost.do?sgID=${nextPost.sgID}" class="btn_next"><span class="img_board">윗글</span></a>
                </c:if>
                <c:if test="${not empty prevPost}">
                    <a href="getSgpost.do?sgID=${prevPost.sgID}" class="btn_prev"><span class="img_board">아랫글</span></a>
                </c:if>
            </div>
        </div>
        <div class="view_cmt">
            <div class="cmt_head">
                <strong class="tit_cmt">댓글 <b>${SGcommentCounts}</b>개</strong>
                <form id="writeCommentForm" name="writeCommentForm" method="post">
                    <fieldset class="fld_cmt" style="padding: 25px">
                        <legend class="screen_out">댓글 작성 양식</legend>
                        <label for="commentContent" class="screen_out">댓글 작성</label>
                        <textarea id="commentContent" name="sgCommentContent" class="tf_cmt"
                            title="답글입력" cols="70" rows="2" placeholder="깨끗한 댓글 문화를 만듭시다."></textarea>
                        <div class="info_byte">
                            <span class="emph_g2" id="comment_limit">0</span> /300
                        </div>
                        <button type="submit" class="btn_register">등록</button>
                        <input type="hidden" name="sgID" value="${post.sgID}" />
                        <input type="hidden" id="userID" name="userID" value="${loggedInMemberId}" />
                    </fieldset>
                </form>
            </div>
            <div class="dropdown">
                <button class="dropdown-toggle">정렬 기준<span class="arrow">&#9650;</span></button>
                <ul class="dropdown-menu">
                    <li data-value="desc">최신순</li>
                    <li data-value="asc">오래된순</li>
                </ul>
            </div>
            <div class="list_cmt" id="commentsContainer">
                <c:forEach var="comment" items="${sgCommentList}">
                    <div class="cmt_cont">
                        <div class="cont_user">
                            <a href="#" class="user_name"><b>${comment.userID}</b></a>
                            <span class="txt_date"> | <fmt:formatDate value="${comment.sgCommentDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                        </div>
                        <div class="cont_cmt">
                            <p class="txt_desc">${comment.sgCommentContent}</p>
                            <span class="info_opt">
                                <span class="txt_writer">${comment.userID}</span>
                                <button type="button" class="btn_delete" onclick="confirmDeleteComment(${comment.sgCommentID}, ${post.sgID})">삭제</button>
                            </span>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
