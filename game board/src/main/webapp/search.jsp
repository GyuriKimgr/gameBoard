<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="top.jsp" />

<title>검색 결과</title>

<link rel="stylesheet" href="./resources/css/board.css" type="text/css">
<section>
	<div class="title">
        <h3>검색 결과</h3>
    </div>
<div class = "table-container">
    <table class = "wtable" border="1">
        <thead class = "wthead">
            <tr class = "wtr">
                <th class = "wth">글번호</th>
                <th class = "wth">제목</th>
                <th class = "wth">글쓴이</th>
                <th class = "wth">작성일</th>
                <th class = "wth">조회수</th>
            </tr>
        </thead>
        <tbody class = "wtbody">
            <c:choose>
                <c:when test="${empty FList}">
                    <!-- 빈 틀이 세로로 쭉 10개 -->
                    <c:forEach var="emptyRow" begin="1" end="10">
                        <tr class = "wtr">
                            <td class = "wtd">&nbsp;</td>
                            <td class = "wtd">&nbsp;</td>
                            <td class = "wtd">&nbsp;</td>
                            <td class = "wtd">&nbsp;</td>
                            <td class = "wtd">&nbsp;</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <!-- 실제 데이터 표시 -->
                    <c:forEach var="FpostList" items="${FList}">
                        <tr class = "wtr">
                            <td class = "wtd">${FpostList.fID}</td>
                            <td class = "wtd">${FpostList.fTitle}</td>
                            <td class = "wtd">${FpostList.userID}</td>
                            <td class = "wtd">${FpostList.fDate}</td>
                            <td class="wtd">&nbsp;</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</div>
</section>
