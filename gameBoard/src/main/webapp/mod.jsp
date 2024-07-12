<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="top.jsp" />

<title>모드게시판</title>

<link rel="stylesheet" href="./resources/css/board.css" type="text/css">
<section>
	<div class="title">
        <h3>모드게시판</h3>
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
                <c:when test="${empty ModList}">
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
                    <c:forEach var="ModList" items="${ModList}">
                        <tr class = "wtr">
                            <td class = "wtd">${ModList.mID}</td>
                            <td class = "wtd"><a href="getMod.do?mID=${ModList.mID}">${ModList.mTitle}</td>
                            <td class = "wtd">${ModList.userID}</td>
                            <td class = "wtd">${ModList.mDate}</td>
                            <td class="wtd">${ModpostList.mViews}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
    </div>
    <div class="frame">
     	<a href="getMID.do" class="custom-btn btn"><span>게시물 작성</span></a>
    </div>  
    <div id="search">
		<input type="text" id="search-box" placeholder="검색...">
		<button type="button" id="search-button">검색</button>
	</div>
    
<script>
	//게시판 검색
	document.getElementById("search-button").addEventListener("click", function() {
    // 검색어 입력란에서 검색어 가져오기
    var searchKeyword = document.getElementById("search-box").value.trim();
    
    // 검색어가 비어있지 않을 때만 요청 보내기
    if (searchKeyword !== "") {
        // URL 생성: searchFpost.do?searchCondition=title&searchKeyword={검색어}
      let url = "searchMod.do?searchCondition=title&searchKeyword=" + encodeURIComponent(searchKeyword);
      
        // GET 요청 보내기
        window.location.href = url;
    }
});
</script>
</section>

<c:import url="bottom.jsp" />
