<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" href="./resources/css/middle2.css"
	type="text/css">
<link rel="stylesheet" href="./resources/css/top.css" type="text/css">


<div class="box">
	<ul class="middle2">
		<li><a href="./walkThrough.do" class="link_card"> <strong
				class="title2"> 공략게시판 </strong> <span class="img_comm2">더보기</span>
		</a>
		
			<div class="news2">
				<div class="news2_top">
					<img src="./resources/images/Guide.jpg" class="news2_img">
				</div>
				<c:if test="${not empty recentWtPosts}">
					<c:forEach var="post" items="${recentWtPosts}">
						<div class="contents">
							<strong class="tit3">${post.wtTitle}</strong>
							<div>
								<strong class="tit4">${post.wtContent}</strong>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty recentWtPosts}">
					<p>최근 게시물이 없습니다. 최근 게시물 개수: ${fn:length(recentWtPosts)}</p>
				</c:if>
			</div></li>



		<li><a href="./Mod.do" class="link_card"> <strong
				class="title2"> 모드게시판 </strong> <span class="img_comm2">더보기</span>
		</a>
			<div class="news2">
				<div class="news2_top">
					<img src="./resources/images/Mod.jpg" class="news2_img">
				</div>
				<c:if test="${not empty recentMdPosts}">
					<c:forEach var="post" items="${recentMdPosts}">
						<div class="contents">
							<strong class="tit3">${post.mTitle}</strong>
							<div>
								<strong class="tit4">${post.mContent}</strong>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty recentMdPosts}">
					<p>최근 게시물이 없습니다. 최근 게시물 개수: ${fn:length(recentMdPosts)}</p>
				</c:if>
			</div></li>
			
			

		<li><a href="./suggest.do" class="link_card"> <strong
				class="title2"> 추천게시판 </strong> <span class="img_comm2">더보기</span>
		</a>
			<div class="news2">
				<div class="news2_top">
					<img src="./resources/images/Suggest.jpg" class="news2_img">
				</div>
				<c:if test="${not empty recentSgPosts}">
					<c:forEach var="post" items="${recentSgPosts}">
						<div class="contents">
							<strong class="tit3">${post.sgTitle}</strong>
							<div>
								<strong class="tit4">${post.sgContent}</strong>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty recentSgPosts}">
					<p>최근 게시물이 없습니다. 최근 게시물 개수: ${fn:length(recentSgPosts)}</p>
				</c:if>
			</div></li>
	</ul>
</div>
