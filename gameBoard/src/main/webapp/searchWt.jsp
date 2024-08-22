<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="top.jsp" />

<title>검색 결과</title>


<link rel="stylesheet" href="./resources/css/board.css" type="text/css">



<section>
	<div class="title">
		<h3>검색 결과</h3>
	</div>
	<div class="table-container">
		<table class="wtable" border="1">
			<thead class="wthead">
				<tr class="wtr">
					<th class="wth">글번호</th>
					<th class="wth">제목</th>
					<th class="wth">글쓴이</th>
					<th class="wth">작성일</th>
					<th class="wth">조회수</th>
				</tr>
			</thead>

			<tbody class="wtbody">
				<c:choose>
					<c:when test="${empty WtList}">
						<tr class="wtr">
							<td colspan="5">내용이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="WtpostList" items="${WtList}">
							<tr class="wtr">
								<td class="wtd">${WtpostList.wtID}</td>
								<td class="wtd"><a
									href="getWtpost.do?wtID=${WtpostList.wtID}">
										${WtpostList.wtTitle} </a> <a>[<c:out
										value="${WTcommentCounts[WtpostList.wtID]}" />]</a></td>
								<td class="wtd">${WtpostList.userID}</td>
								<td class="wtd">${WtpostList.wtDate}</td>
								 <td class="wtd">${WtpostList.wtViews}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</section>
