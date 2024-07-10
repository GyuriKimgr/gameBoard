<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:import url="top.jsp" />

<link rel="stylesheet" href="./resources/css/post.css" type="text/css">

<section>
	<div class="title">
        <h3>게임추천</h3>
    </div>
	<div class="form-container">
        <form action="insertSgpost.do" method="post"
        	enctype="multipart/form-data">
        <input type="hidden" id="userId" name="userId"
        	value="<%= session.getAttribute("userId") %>">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="sgTitle" name="sgTitle">
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="sgContent" name="sgContent" rows="8"></textarea>
            </div>
            
            <div class="frame">
        		<button type="submit" class="custom-btn btn"><span>작성 완료</span></button>
    		</div>
        </form>
    </div>
</section>