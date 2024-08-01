<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="./resources/css/middle2.css" type="text/css">
<link rel="stylesheet" href="./resources/css/top.css" type="text/css">

<div class="box">
    <ul class="middle2">
                <li>
                    <a class="link_card"> 
                        <strong class="title2">공략게시판</strong>
                        <span class="img_comm2">더보기</span>
                    </a>
                    <div class="news2">
                        <a class="gamenews2" href="#">
                            <div class="gamenews_2">
                                <img src="./resources/images/로고3.png" class="news2_img" alt="Image">
                            </div>
                            <c:if test="${not empty recentWtPosts}">
            				<c:forEach var="post" items="${recentWtPosts}">
                            	<strong class="tit3">${post.wtTitle}</strong>
                            </c:forEach>
        					</c:if>
                        </a>
                    </div>
                </li>

        <c:if test="${empty recentWtPosts}">
            <p>최근 게시물이 없습니다. 최근 게시물 개수: ${fn:length(recentWtPosts)}</p>
        </c:if>
    </ul>
</div>
	
<!--<li>
		<a href="#"  class="link_card"> 
			<strong class="title2">모드게시판</strong>
			<span class="img_comm2">더보기</span>
		</a>
   		<div class="news2">
			<a name="news_2" class="gamenews2"
				href="#"
                 event-order="0"
                 event-description="PUBG x 뉴진스 콜라보 및 경쟁전 개편 업데이트 안내"
                 event="click_news" news_type="업데이트"
                 news_title="PUBG x 뉴진스 콜라보 및 경쟁전 개편 업데이트 안내">
                    
                 <div class="gamenews_2">
					<img
						src="https://t1.kakaocdn.net/gamepub/pub-img/pubg/news_banner/news_banner_1718086901492_74.jpg"
                        class="news2_img">
                 </div>
                 <strong class="tit3"> PUBG x 뉴진스 콜라보 및 경쟁전 개편 업데이트 안내</strong>
                 <span class="tit4">배틀그라운드와 뉴진스의 콜라보레이션과 경쟁전 개편 그리고 건 플레이 조정 등 다양한 소식을 안내해 드립니다.</span>
			</a>
			<div class="group_tit">
				<a name="news_2" class="gamenews2"
					href="#"
                    event-order="1" event-description="6월 배틀그라운드 상점 업데이트 안내"
                    event="click_news" news_type="업데이트"
                    news_title="6월 배틀그라운드 상점 업데이트 안내">
                    <strong class="tit3">6월 배틀그라운드 상점 업데이트 안내</strong>
				</a>
				<a name="news_2" class="gamenews2"
                    href="#"
                    event-order="2"
                    event-description="에란겔 클래식의 귀환 및 연승 도전 시스템 업데이트 안내"
                    event="click_news" news_type="업데이트"
                    news_title="에란겔 클래식의 귀환 및 연승 도전 시스템 업데이트 안내">
                    <strong class="tit3">에란겔 클래식의 귀환 및 연승 도전 시스템 업데이트 안내</strong>
				</a> 
			</div>
		</div>
	</li>
	
	<li>
		<a href="#" class="link_card"> 
			<strong class="title2">추천게시판</strong>
			<span class="img_comm2">더보기</span>
		</a>
		<div class="news2">
			<a name="news_2" class="gamenews2"
				href="#"
                target="_black" event-order="0" event-description="6월 추가 특별 보급"
                event="click_news" news_type="GM소식" news_title="6월 추가 특별 보급">
                
                <div class="gamenews_2">
 					<img
						src="https://t1.kakaocdn.net/gamepub/pub-img/pubg/news_banner/news_banner_1718338299686_3.jpg"
                        class="news2_img">
				</div> 
				<strong class="tit3"> 6월 추가 특별 보급 </strong>
				<span class="tit4">최근 연달아 게임 이용에 불편을 겪게 하신 것에 대해 고개 숙여 사과드립니다. ​</span>
			</a>
			<div class="group_tit">
				<a name="news_2" class="gamenews2"
                    href="#"
                    event-order="1" event-description="배틀그라운드 x 뉴진스 콜라보레이션"
                    event="click_news" news_type="GM소식"
                    news_title="배틀그라운드 x 뉴진스 콜라보레이션">
                    <strong class="tit3">배틀그라운드 x 뉴진스 콜라보레이션</strong>
				</a>
				<a name="news_2" class="gamenews2"
                    href="#"
                    event-order="2" event-description="특별 보급 - 2024년 6월"
                    event="click_news" news_type="GM소식" news_title="특별 보급 - 2024년 6월">
                    <strong class="tit3">특별 보급 - 2024년 6월</strong>
                </a>
			</div>
		</div>
	</li>
</ul>
</div>-->