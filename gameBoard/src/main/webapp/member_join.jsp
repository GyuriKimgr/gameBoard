<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./resources/css/member_join.css"
	type="text/css">

<div class="container">
    <div class="inner">
    	<div class="search_content_header">
			<h3 class="header-text">회원가입</h3>
		</div>
        <h1 class="simple_logo4">
            <a href="index.jsp" class="link">
                <img src="./resources/images/로고3.png"> 
 			</a>
 		</h1>
 	</div>
	<div class="content">
        <form id="join_form" method="post" action="" class="memaber_join_form">
           	<input type="hidden" id="token_sjoin" name="token_sjoin" value="">
          	<input type="hidden" id="nid_kb2" name="nid_kb2" value="">
            <input type="hidden" id="joinMode" name="joinMode" value="">
          	<input type="hidden" id="encPswd" name="encPswd" value="">
          	<input type="hidden" id="encKey" name="encKey" value="">
            <input type="hidden" id="birthday" name="birthday" value="">

            <div class="form_content">	
            	<div class="form_list">  
            	<!-- 아이디 -->   
            	<div class="form_item_user" id="divId">
            	<input type="text" id="user_id" name="id" placeholder="아이디" class="input" value="" maxlength="20" autocapitalize="off"/>
            	<button type="button" id="check_button"><h4>중복 확인</h4></button>
            	</div>   
                         
                <!-- 비밀번호 --> 
        	   	<div class="form_item lock password" id="divPasswd">
                <input type="password" id="pswd1" name="pswd1" placeholder="비밀번호" class="input" value="" maxlength="20" autocomplete="new-password" />
                </div>
                          
                          <!-- 이메일 -->
                            <div class="form_item email" id="divEmail">
                               <input type="email" id="email" name="email" placeholder="이메일 주소 (본인 확인용)" class="input" value="" maxlength="100" />
                            </div>
                       

							<!-- 이름 --> 
                            <div class="form_item user" id="divName">
                                <input type="text" id="name" name="name" placeholder="이름" class="input" value="" maxlength="40" />
                            </div>
                            
                            <!-- 생년월일 -->
                            <div class="form_item calendar" id="divBirthday">
                                <input type="text" id="birthdayInput" placeholder="생년월일 8자리" class="input" value="" maxlength="10"/>
                            </div>

							<!-- 성별, 외국인/내국인 유무 -->
                            <div class="form_item adult" id="divIdentityGender">
                                <ul class="adult_list" id="listIdentityGender">
                                    <li class="radio_item">
                                        <input type="radio" id="identityGender1" name="identityGender" value="M" class="blind">
                                        <label for="identityGender1">남자</label>
                                    </li>
                                    <li class="radio_item">
                                        <input type="radio" id="identityGender2" name="identityGender" value="F" class="blind">
                                        <label for="identityGender2">여자</label>
                                    </li>
                                </ul>
                                <ul class="adult_list" id="listForeigner">
                                    <li class="radio_item">
                                        <input type="radio" id="foreigner1" name="foreigner" value="K" checked class="blind">
                                        <label for="foreigner1">내국인</label>
                                    </li>
                                    <li class="radio_item">
                                        <input type="radio" id="foreigner2" name="foreigner" value="F" class="blind">
                                        <label for="foreigner2">외국인</label>
                                    </li>
                                </ul>
                            </div>
                        
                            <!-- 휴대전화 -->
                            <div class="form_item phone" id="divPhoneNo">
                                <input type="tel" id="phoneNo" name="phoneNo" placeholder="휴대전화번호" class="input" value="" maxlength="16" />
                            </div>
   					</div>
   				</div>
   						
   			</form>  
   			<div class = "button_container" ></div>
   				<div type ="button" id="join_button" name="join_button" ><h2>가입하기</h2></div>
   				<div type ="button" id= "return_button" name = "return_button"><h2>돌아가기</h2></div>
   			</div>
   			
		</div>
