<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="top.jsp" />

<title>게임추천</title>

<link rel="stylesheet" href="./resources/css/board.css" type="text/css">
<section>
	<div class="title">
        <h3>게임추천</h3>
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
                <c:when test="${empty SgList}">
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
                    <c:forEach var="SgpostList" items="${SgList}">
                        <tr class = "wtr">
                            <td class = "wtd">${SgpostList.sgID}</td>
                            <td class = "wtd">${SgpostList.sgTitle}</td>
                            <td class = "wtd">${SgpostList.userID}</td>
                            <td class = "wtd">${SgpostList.sgDate}</td>
                            <td class="wtd">&nbsp;</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
    </div>
    <div class="frame">
    	<a href="getSgID.do"  class="custom-btn btn"><span>게시물 작성</span></a>
    </div>
</section>

<c:import url="bottom.jsp" />
