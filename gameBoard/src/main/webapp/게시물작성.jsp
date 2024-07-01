<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="./resources/css/board.css" type="text/css">
<c:import url="top.jsp" />

<section>
	<form action="insertMember.do" method="post">
		<table border="1" width="600">
			<tr>
				<td align="center">글번호</td>
				<td><input type="hidden" name="custno" value="${id}">
					${id}</td>
			</tr>
			<tr>
				<td align="center">제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td align="center">내용</td>
				<td><textarea name="content" rows="5" cols="50"></textarea></td>
			</tr>
			<tr>
				<td align="center">글쓴이</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td align="center">작성일</td>
				<td><input type="text" name="jodindate"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
</section>

<c:import url="bottom.jsp" />