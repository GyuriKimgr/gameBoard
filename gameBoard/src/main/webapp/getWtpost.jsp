<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="top.jsp" />

<link rel="stylesheet" href="./resources/css/getWtpost.css"
	type="text/css">

<div class="inner_atc">
	<h3 class="tit_atc">공략 게시판</h3>
	<div class="board_comm">
		<div class="view_head">
			<h4 class="tit_view">${post.getWtTitle()}</h4>
			<div class="info_head">
				<dl class="writer_info">
					<dt class="tit_info">작성자</dt>
					<dd class="cont_info">
						<a href="#" class="link_writer"> <span
							class="ico_board_tier platinum3"> <span class="screen_out">플레티넘</span>
						</span> <span class="txt_writer">${post.getUserID()}</span>
						</a>
					</dd>
				</dl>
				<dl class="date_info">
					<dt class="tit_info">작성일</dt>
					<dd class="cont_info">${post.getWtDate()}</dd>
					<dt class="tit_info">조회수</dt>
					<%-- <dt class="cont_info">${post.getsearchCondition()}</dt> --%>
				</dl>
			</div>
			
		</div>
		<div class="view_cont">
			<div class="content"><p>${post.getWtContent()}</p></div>
		</div>


	</div>
</div>
