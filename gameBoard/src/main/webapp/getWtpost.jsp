<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="top.jsp" />

<link rel="stylesheet" href="./resources/css/getWtpost.css" type="text/css">

<section>
	<div class="title">
        <h3>공략게시판</h3>
    </div>
	<div class="post-container">
        <div class="post-header">
            <h2>${post.getWtTitle()}</h2> <!-- 게시물 제목 출력 -->
            <p class="author">작성자: ${post.getUserID()}</p> <!-- 작성자 출력 -->
            <p class="date">작성일: ${post.getWtDate()}</p> <!-- 작성일 출력 -->
        </div>
        <div class="post-content">
            <p>${post.getWtContent()}</p> <!-- 게시물 내용 출력 -->
        </div>
    </div>
</section>
