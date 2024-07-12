<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./resources/css/member_join.css"
	type="text/css">
<div class="container">
    <div class="inner">
        <div class="search_content_header1">
            <h3 class="header-text">아이디 찾기</h3>
        </div>
        <h1 class="simple_logo4">
            <a href="index.jsp" class="link">
                <img src="./resources/images/로고3.png">
            </a>
        </h1>
    </div>
    <p class="choice_m">아래 방법 중 한 가지를 선택해주세요.</p>
    <form id="search_id" method="post" action="" class="search_id_form">
        <input type="hidden" id="" name="" value="">
        <input type="hidden" id="" name="" value="">
        <input type="hidden" id="" name="" value="">
        <input type="hidden" id="" name="" value="">

        <div class="form_content"> 
            <div class="choice">
                <div class="form_choice" id="choice">
                    <ul class="choice_list" id="">
                        <li class="choice_item">
                            <input type="radio" id="phone_choice" name="contact_choice" value="phone" class="blind">
                            <label for="phone_choice">
                                <a href="./search_id2.jsp"> 
                                    <img src="./resources/images/휴대폰아이콘2.png" class="phone_icon"> 
                                    <h4>휴대폰 인증하기</h4>
                                </a>
                            </label>
                        </li>
                        <li class="choice_item">
                            <input type="radio" id="email_choice" name="contact_choice" value="email" class="blind">
                            <label for="email_choice">
                                <a href="./search_id3.jsp">
                                    <img src="./resources/images/메시지아이콘2.png" class="email_icon">  
                                    <h4>이메일 인증하기</h4>
                                </a>
                            </label>
                        </li>
                    </ul>   
                </div>
            </div>
        </div>
    </form>  
</div>
