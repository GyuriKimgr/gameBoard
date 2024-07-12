<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./resources/css/member_join.css"
	type="text/css">
 
	
<div class="container">
    <div class="inner">
        <div class="search_content_header">
            <h3 class="header-text">비밀번호 찾기</h3>
        </div>
        <h1 class="simple_logo4">
            <a href="index.jsp" class="link">
                <img src="./resources/images/로고3.png">
            </a>
        </h1>
    </div>

    <div class="form_content">
        <p class="choice_m">비밀번호를 찾고자하는 아이디를 입력해주세요.</p>
        <form id="search_form" method="post" action="search_pw1.do" class="member_search_form">
            <div class="form_list">
                <!-- 아이디 입력 -->
                <div class="form_item_user" id="divId">
                    <input type="text" id="user_id" name="id" placeholder="아이디" class="input" value="" maxlength="20" autocapitalize="off" />
                </div>

                <!-- 이름 입력 -->
                <div class="form_item user" id="divName">
                    <input type="text" id="name" name="name" placeholder="이름" class="input" value="" maxlength="40" />
                </div>
            </div>
            <div class="button_container3">
                <button type="button" id="next_button3" name="next_button3" onclick="findPw()"><h2>다음</h2></button>
                <a href="./index.jsp">
                    <button type="button" id="return_button3" name="return_button3"><h2>돌아가기</h2></button>
                </a>
            </div>
        </form>
        <div class="link_wrap">
            <span class="link_text">
                아이디가 기억나지 않는다면?
                <a href="./search_id1.jsp" class="link_id"><div class="txt">아이디 찾기</div></a>
            </span>
        </div>
    </div>
</div>