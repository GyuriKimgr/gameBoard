<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:import url="top.jsp" />

<link rel="stylesheet" href="./resources/css/post.css" type="text/css">

<section>
	<div class="title">
        <h3>공략게시판</h3>
    </div>
	<div class="form-container">
        <form action="insertWtpost.do" method="post">
        <input type="hidden" id="userId" name="userId"
        	value="<%= session.getAttribute("userId") %>">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" required value = "&{wtTitle}">
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="content" name="content" rows="8" required value = "&{wtContent}"></textarea>
            </div>
        </form>
    </div>
    
    <div class="frame">
        <button type="submit" class="custom-btn btn"><span>작성 완료</span></button>
    </div>
</section>