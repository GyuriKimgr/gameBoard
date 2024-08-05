<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="./resources/css/middle1.css" type="text/css">
<link rel="stylesheet" href="./resources/css/top.css" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).ready(function() {
        $('#login-form').submit(function(event) {
            event.preventDefault(); // 기본 폼 제출 동작 방지
            var xhr = new XMLHttpRequest();
            xhr.open('POST', './login.do', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

            xhr.onload = function() {
                if (xhr.status === 200) {
                    if (xhr.responseText === "success") {
                        window.location.reload(); // 로그인 성공 시 페이지 새로고침
                    } else {
                        alert("아이디 혹은 비번을 확인해주세요."); // 로그인 실패 시 알럿창 표시
                    }
                } else {
                    alert("로그인 요청 실패");
                }
            };

            var formData = new FormData(document.getElementById('login-form'));
            var params = new URLSearchParams();
            formData.forEach((value, key) => {
                params.append(key, value);
            });

            console.log("로그인 요청 데이터:", params.toString()); // 디버깅용 로그 추가

            xhr.send(params.toString());
        });
    });
</script>

<div class="box1">
<ul class="middle1">
	<li>
		<a href="#" class="link_card1"> 
			<strong class="title">게임소식</strong>
			<span class="img_comm1">더보기</span>
        </a>
		<div class="news1">
			<a name="news_1" class="gamenews"
				href="https://www.gukjenews.com/news/articleView.html?idxno=3037747"
				event-order="0" event-description="TES 꺽은 T1, 롤 사우디 컵 초대 챔피언 자리 꿰차"
				event="click_news" news_type="대회소식"
				news_title="TES 꺽은 T1, 롤 사우디 컵 초대 챔피언 자리 꿰차">
			              
				<div class="gamenews_1">
					<img
						src="https://pbs.twimg.com/media/GPdbQgCbQAAwBes?format=jpg&name=medium"
						class="news_img">
				</div> 
	            <strong class="tit1"> TES 꺽은 T1, 롤 사우디 컵 초대 챔피언 자리 꿰차 </strong> 
	            <span class="tit2">T1이 중국 프로리그(LPL)의 강호 팀 톱e스포츠(TES)를 꺾고 E스포츠 월드컵(EWC) 초대 챔피언 자리에 올랐다.</span>
			</a>
			<div class="group_tit1">
				<a name="news_1" class="gamenews"
					href="https://www.thisisgame.com/webzine/news/nboard/4/?utm_source=naver?utm_source?utm_source?
							utm_source?utm_source&utm_medium=outlink&utm_campaign=thisisgame&utm_content=85668&referer=coinsosik&category=1&n=189696"
			        event-order="1" event-description="리틀 나이트메어 3' 출시 연기, 2024년 내에는 만나기 어렵다"
			        event="click_news" news_type="게임 연기"
			        news_title="리틀 나이트메어 3' 출시 연기, 2024년 내에는 만나기 어렵다"> 
			        <strong class="tit1">리틀 나이트메어 3' 출시 연기, 2024년 내에는 만나기 어렵다</strong>
				</a> 
				<a name="new_1" class="gamenews"
					href="https://www.thelec.kr/news/articleView.html?idxno=28711"
			        event-order="2" event-description="신작 '쿠키런' 26일 출격...데브시스터즈 부활 '승부수"
			        vent="click_news" news_type="대회소식" news_title="쿠키런">
			        <strong class="tit1">신작 '쿠키런' 26일 출격...데브시스터즈 부활 '승부수</strong>
				</a>
			</div>
		</div>
	</li>

	<li>
		<a href="#" class="link_card1"> 
			<strong class="title">오늘의 게시판</strong>
			<span class="img_comm1">더보기</span>
		</a>
        <div class="news1">
			<a name="news_1" class="gamenews"
				href="#"
				event-order="0" event-description="PGS 4 그룹 스테이지 하이라이트"
				event="click_news" news_type="대회소식"
				news_title="PGS 4 그룹 스테이지 하이라이트">
				
				<div class="gamenews_1">
                    <img
					src="./resources/images/Today.jpg"
                       class="news_img">
				</div> 
				<strong class="tit1"> PGS 4 그룹 스테이지 하이라이트</strong>
				<span class="tit2">펍지 글로벌 시리즈 4의 그룹 스테이지 베스트 순간을 지금 바로 하이라이트 영상을 통해 확인해보세요.</span>
			</a>
			<div class="group_tit1">
				<a name="news_1" class="gamenews"
					href="#"
					event-order="1" event-description="펍지 글로벌 시리즈 3(PGS 3)를 소개합니다!"
					event="click_news" news_type="대회소식"
					news_title="펍지 글로벌 시리즈 3(PGS 3)를 소개합니다!"> <strong
					class="tit1">펍지 글로벌 시리즈 3(PGS 3)를 소개합니다!</strong>
				</a>
				<a name="news_1" class="gamenews"
					href="#"
					event-order="2" event-description="2024 PLS: Cup 안내"
					event="click_news" news_type="대회소식" news_title="2024 PLS: Cup 안내">
					<strong class="tit1">2024 PLS: Cup 안내</strong>
				</a>
			</div>
		</div> 
		</li>
		
<!-- 로그인 폼 -->
		<li>
		<c:choose>
            <c:when test="${not empty sessionScope.loggedInMember}">
                <!-- 로그인 상태 -->
                <div class="welcome">
                    <h2>${sessionScope.loggedInMember}님, 환영합니다!</h2>
                    <form id="logout-form" method="post" action="./logout.do">
    					<input type="submit" value="Logout">
					</form>
                </div>
            </c:when>
            <c:otherwise>
            <!-- 비로그인 상태 -->
            <div class="login">
               <h2>Simple Login</h2>
                <form method="post" action="./login.do" id="login-form">
                  <input type="text" name="member_id" placeholder="ID"> <input
                     type="password" name="member_pw" placeholder="Password">
                     
                  <label for="remember-check"> <input type="checkbox"
                     id="remember-check">아이디 저장하기
                  </label>
                  
						<div class="find_wrap">
                                <a href="./search_id1.jsp" class="find_text">아이디 찾기</a> 
                                <span>ㅣ</span>
                                <a href="./search_pw1.jsp" class="find_text">비밀번호 찾기</a>
                                <span>ㅣ</span>
                                <a href="./getJoinDate.do"><span  class="accent">회원가입</span></a>
                         </div>
                  <input type="submit" value="Login">
               </form>
               </div>
                  </c:otherwise>
        </c:choose>
         </li>
      </ul>
   </div>