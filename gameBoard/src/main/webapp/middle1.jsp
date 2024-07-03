<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<link rel="stylesheet" href="./resources/css/middle1.css"
	type="text/css">


<div class="box1">
	<div class="inner_box1">
		<h3 class="screen_out1">게시판1</h3>
		<ul class="list_news1">

			<li><a id="game_news"
				href="http://bbs.pubg.game.daum.net/gaia/do/pubg/competition/list?bbsId=PN001&amp;objCate1=223"
				class="link_card1"> <strong class="noto-demi tit_cate1">게임소식</strong>
					<span class="img_comm1">더보기</span>
			</a> </a>
				<div class="card_info1">

					<a name="a_new_competition" class="link_thumb1"
						href="https://bbs.pubg.game.daum.net/gaia/do/pubg/competition/read?bbsId=PN001&amp;articleId=3543&amp;objCate1=223"
						event-order="0" event-description="PGS 4 그룹 스테이지 하이라이트"
						event="click_news" news_type="대회소식"
						news_title="PGS 4 그룹 스테이지 하이라이트">
						<div class="wrap_thumb1">
							<img
								src="https://t1.kakaocdn.net/gamepub/pub-img/pubg/news_banner/news_banner_1717741626073_39.png"
								class="thumb_g1" alt="">
						</div> <strong class="card_tit1"> PGS 4 그룹 스테이지 하이라이트 </strong> <span
						class="desc_thumb1">펍지 글로벌 시리즈 4의 그룹 스테이지 베스트 순간을 지금 바로
							하이라이트 영상을 통해 확인해보세요.</span>
					</a>
					<div class="group_tit1">

						<a name="a_new_competition" class="link_thumb1"
							href="https://bbs.pubg.game.daum.net/gaia/do/pubg/notice/read?articleId=3521&amp;bbsId=PN001&amp;pageIndex=1"
							event-order="1" event-description="펍지 글로벌 시리즈 3(PGS 3)를 소개합니다!"
							event="click_news" news_type="대회소식"
							news_title="펍지 글로벌 시리즈 3(PGS 3)를 소개합니다!"> <strong
							class="card_tit1">펍지 글로벌 시리즈 3(PGS 3)를 소개합니다!</strong>
						</a> <a name="a_new_competition" class="link_thumb1"
							href="https://bbs.pubg.game.daum.net/gaia/do/pubg/competition/read?articleId=3506&amp;bbsId=PN001&amp;objCate1=223&amp;pageIndex=1"
							event-order="2" event-description="2024 PLS: Cup 안내"
							event="click_news" news_type="대회소식" news_title="2024 PLS: Cup 안내">
							<strong class="card_tit1">2024 PLS: Cup 안내</strong>
						</a>


					</div>
				</div></li>


			<li><a id="today_board"
				href="http://bbs.pubg.game.daum.net/gaia/do/pubg/competition/list?bbsId=PN001&amp;objCate1=223"
				class="link_card1"> <strong class="noto-demi tit_cate1">오늘의
						게시판</strong> <span class="img_comm1">더보기</span>
			</a>
				<div class="card_info1">

					<a name="a_new_competition" class="link_thumb1"
						href="https://bbs.pubg.game.daum.net/gaia/do/pubg/competition/read?bbsId=PN001&amp;articleId=3543&amp;objCate1=223"
						event-order="0" event-description="PGS 4 그룹 스테이지 하이라이트"
						event="click_news" news_type="대회소식"
						news_title="PGS 4 그룹 스테이지 하이라이트">
						<div class="wrap_thumb1">
							<img
								src="https://t1.kakaocdn.net/gamepub/pub-img/pubg/news_banner/news_banner_1717741626073_39.png"
								class="thumb_g1" alt="">
						</div> <strong class="card_tit1"> PGS 4 그룹 스테이지 하이라이트 </strong> <span
						class="desc_thumb1">펍지 글로벌 시리즈 4의 그룹 스테이지 베스트 순간을 지금 바로
							하이라이트 영상을 통해 확인해보세요.</span>
					</a>
					<div class="group_tit1">

						<a name="a_new_competition" class="link_thumb1"
							href="https://bbs.pubg.game.daum.net/gaia/do/pubg/notice/read?articleId=3521&amp;bbsId=PN001&amp;pageIndex=1"
							event-order="1" event-description="펍지 글로벌 시리즈 3(PGS 3)를 소개합니다!"
							event="click_news" news_type="대회소식"
							news_title="펍지 글로벌 시리즈 3(PGS 3)를 소개합니다!"> <strong
							class="card_tit1">펍지 글로벌 시리즈 3(PGS 3)를 소개합니다!</strong>
						</a> <a name="a_new_competition" class="link_thumb1"
							href="https://bbs.pubg.game.daum.net/gaia/do/pubg/competition/read?articleId=3506&amp;bbsId=PN001&amp;objCate1=223&amp;pageIndex=1"
							event-order="2" event-description="2024 PLS: Cup 안내"
							event="click_news" news_type="대회소식" news_title="2024 PLS: Cup 안내">
							<strong class="card_tit1">2024 PLS: Cup 안내</strong>
						</a>
					</div>


				</div> <!-- 로그인 폼 -->
			<li>
				<div class="login-wrapper">
					<h2>Simple Login</h2>
					<form method="post" action="서버의url" id="login-form">
						<input type="text" name="userName" placeholder="ID"> <input
							type="password" name="userPassword" placeholder="Password">

						<label for="remember-check"> <input type="checkbox"
							id="remember-check">아이디 저장하기
						</label>
						
						<ul class="find_wrap" id="find_wrap_KR" style="display: block;">
                                <li><a target="_blank" id="idinquiry" href="https://nid.naver.com/user2/api/route?m=routeIdInquiry&amp;lang=ko_KR" class="find_text">아이디 찾기</a> </li>
                                <li><a target="_blank" id="pwinquiry" href="https://nid.naver.com/user2/api/route?m=routePwInquiry&amp;lang=ko_KR" class="find_text">비밀번호 찾기</a> </li>
                                <li><a target="_blank" id="join" href="https://nid.naver.com/user2/V2Join?m=agree&amp;lang=ko_KR&amp;realname=N" class="find_text"><span  class="accent">회원가입</span></a></li>
                         </ul>
						

						<input type="submit" value="Login">
					</form>
					</div>

			</li>

		</ul>
	</div>
</div>