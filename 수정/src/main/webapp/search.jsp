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
        	<c:forEach var="WtpostList" items="${WtList}">
                    <tr class="wtr">
                        <td class="wtd">${WtpostList.wtID}</td>
                        <td class="wtd">${WtpostList.wtTitle}</td>
                        <td class="wtd">${WtpostList.userID}</td>
                        <td class="wtd">${WtpostList.wtDate}</td>
                        <td class="wtd">&nbsp;</td>
                    </tr>
            </c:forEach>
        </tbody>
            
        <tbody class = "wtbody">
            <c:forEach var="ModList" items="${ModList}">
                <tr class = "wtr">
                    <td class = "wtd">${ModList.mID}</td>
                    <td class = "wtd">${ModList.mTitle}</td>
                    <td class = "wtd">${ModList.userID}</td>
                    <td class = "wtd">${ModList.mDate}</td>
                    <td class="wtd">&nbsp;</td>
                </tr>
            </c:forEach>
        </tbody>
            
        <tbody class = "wtbody">
            <c:forEach var="SgpostList" items="${SgList}">
                <tr class = "wtr">
                    <td class = "wtd">${SgpostList.sgID}</td>
                    <td class = "wtd">${SgpostList.sgTitle}</td>
                    <td class = "wtd">${SgpostList.userID}</td>
                    <td class = "wtd">${SgpostList.sgDate}</td>
                    <td class="wtd">&nbsp;</td>
                </tr>
            </c:forEach>
        </tbody>
        
        <tbody class = "wtbody">
            <c:forEach var="FpostList" items="${FList}">
                <tr class = "wtr">
                    <td class = "wtd">${FpostList.fID}</td>
                    <td class = "wtd">${FpostList.fTitle}</td>
                    <td class = "wtd">${FpostList.userID}</td>
                    <td class = "wtd">${FpostList.fDate}</td>
                    <td class="wtd">&nbsp;</td>
                </tr>
            </c:forEach>            
        </tbody>
    </table>
</div>
</section>
