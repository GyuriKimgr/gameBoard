<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="top.jsp" />

<link rel="stylesheet" href="./resources/css/getpost.css"
	type="text/css">

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
				</dl>
			</div>

		</div>
		<div class="view_cont">
			<div class="content">
				<p>${post.getSgContent()}</p>
			</div>
		</div>


		<div class="view_btn">
			<div class="wrap_modify">
				<a href="updateSgpostForm.do?sgID=${post.sgID}"
					class="btn_board btn_board1 edit_btn">수정</a>
				<button type="button" class="btn_board btn_board1 delete_btn"
					onclick="confirmDelete(${post.sgID})">삭제</button>


			</div>
			<div class="wrap_page">
				<a href="suggest.do" class="btn_list"><span
					class="img_board">목록</span></a> <a href="nextArticle?depth=764727516987391&amp;pageIndex=1&amp;articleId=${post.sgID}&amp;bbsId=PC002"
                    class="btn_next"><span class="img_board">윗글</span></a>
                <a href="prevArticle?depth=764727516987391&amp;pageIndex=1&amp;articleId=${post.sgID}&amp;bbsId=PC002"
                    class="btn_prev"><span class="img_board">아랫글</span></a>
			</div>
		</div>


		<script>
		function confirmDelete(sgID) {
    		if (confirm("정말로 삭제 하시겠습니까?")) {
        		window.location.href = 'deleteSgpost.do?sgID=' + sgID;
    		}
		}
		</script>
		
	</div>
</div>