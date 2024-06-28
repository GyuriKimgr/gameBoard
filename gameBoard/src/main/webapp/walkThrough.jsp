<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:import url="top.jsp" />
<link rel="stylesheet" href="./resources/css/walkThrough.css" type="text/css">
<div class = "title"><h3>공략게시판</h3></div>
<body>
<table border="1">
    <thead>
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>${post.id}</td>
                <td><a href="view.jsp?id=${post.id}">${post.title}</a></td>
                <td>${post.author}</td>
                <td>${post.date}</td>
                <td>${post.views}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
