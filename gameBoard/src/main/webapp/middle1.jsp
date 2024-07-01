<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<link rel="stylesheet" href="./resources/css/middle1.css"
	type="text/css">


<div id="box1">
	<div class="inner_box1">
		<h3 class="screen_out1">게시판1</h3>
		<ul class="list_news1">
			<li><a id="game_news"
				href="http://bbs.pubg.game.daum.net/gaia/do/pubg/competition/list?bbsId=PN001&amp;objCate1=223"
				class="link_card1"> <strong class="noto-demi tit_cate1">게임소식</strong>
					<span class="img_comm1">더보기</span>
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
				</div></li>
				
				
				<li><a id="today_board"
				href="http://bbs.pubg.game.daum.net/gaia/do/pubg/competition/list?bbsId=PN001&amp;objCate1=223"
				class="link_card1"> <strong class="noto-demi tit_cate1">오늘의 게시판</strong>
					<span class="img_comm1">더보기</span>
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
				</div></li>
		</ul>
	</div>
	<li>
	<div id= "main_logform">
	 <div class="login-form">
			<!-- 아이디 -->
			<label for = "main_id"></label>
			<input type ="text" id="main_id" name= "main_id" class ="input_id" title="아이디" placeholder="아이디"><br />
			<!-- 비밀번호 -->
			<label for ="main_password" ></label>
			<input type ="text" id="main_password" name ="main_password" class = "input_password"  title ="비밀번호" placeholder="비밀번호"  
			 	   maxlength="20">
			<!-- 로그인 버튼 -->
			<input type ="button" class="login_button" value= "로그인" onclick="alert('버튼이 클릭되었습니다!')" > <!-- 버튼이 작동하는지 확인.. -->
			
		<div class="option01">
			<input type="checkbox" id="keeplogin" name="keeplogin" class="chk_saveid" onmousedown="함수이름('받아들이는 인자자리');" onclick="함수이름('받아들이는 인자자리')" /> 
			<label for="keeplogin" class="set_saveid" onmousedown= "함수이름"('받아들이는 인자자리');">로그인 유지</label> </div>
		
		<span class="option02">
			<a href=# title="아이디 찾기">아이디</a> /
			<a href=# title="비밀번호 찾기">비밀번호 찾기</a> 
			<i class="bar">|</i> 
			<a href=# title="회원가입"><strong>회원가입</strong></a> 
		</span>
		</div>	
	</li>
 </div>
</div>

