<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./resources/css/member_join.css"
	type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    function checkIdDuplicate() {
        let memberId = $('#member_id').val();
        $.ajax({
            url: "/checkIdDuplicate",
            type: 'GET',
            data: {"memberId": memberId},
            success: function(data) {
                if (data === "duplicate") {
                    alert("중복된 아이디입니다.");
                } else if (data === "available") {
                    alert("사용 가능한 아이디입니다.");
                } else {
                    alert("오류 발생: 유효하지 않은 응답입니다.");
                }
            },
            error: function(xhr, status, error) {
                alert("오류 발생: " + xhr.responseText);
            }
        });
    }

    $(document).ready(function() {
        $('#check_button').on('click', function() {
            checkIdDuplicate();
        });
    });
</script>
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
        <form id="join_form" method="post" action="memberJoin.do" class="member_join_form">
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
            	<input type="text" id="member_id" name="memberId" placeholder="아이디" class="input" value="" maxlength="20" autocapitalize="off"/>
            	<button type="button" id="check_button" name = "memberId_check" onclick = "checkIdDuplicate();"><h4>중복 확인</h4></button>
            	</div>   
                         
                <!-- 비밀번호 --> 
        	   	<div class="form_item lock password" id="divPasswd">
                <input type="password" id="pswd1" name="memberPw" placeholder="비밀번호" class="input" value="" maxlength="20" autocomplete="new-password" />
                </div>
                          
                <!-- 이메일 -->
                <div class="form_item email" id="divEmail">
                <input type="email" id="email" name="memberEmail" placeholder="이메일 주소 (본인 확인용)" class="input" value="" maxlength="100" />
                </div>
                       

				<!-- 이름 --> 
                <div class="form_item user" id="divName">
                <input type="text" id="name" name="memberName" placeholder="이름" class="input" value="" maxlength="40" />
                </div>
                            
  				<!-- 생년월일 -->
  				<div class="form_item calendar" id="divBirthday">
                <input type="text" id="birthdayInput" name = "memberBirth" placeholder="생년월일 8자리" class="input" value="" maxlength="10"/>
                </div>

				<!-- 성별, 외국인/내국인 유무 -->
                <div class="form_item adult" id="divIdentityGender">
                <ul class="adult_list" id="listIdentityGender">
                	<li class="radio_item">
                 		<input type="radio" id="identityGender1" name="memberGender" value="M" class="blind">
                        <label for="identityGender1">남자</label>
                    </li>
                    <li class="radio_item">
                        <input type="radio" id="identityGender2" name="memberGender" value="F" class="blind">
                        <label for="identityGender2">여자</label>
                    </li>
                    </ul>
                    <ul class="adult_list" id="listForeigner">
                                    <li class="radio_item">
                                        <input type="radio" id="foreigner1" name="memberNation" value="K" checked class="blind">
                                        <label for="foreigner1">내국인</label>
                                    </li>
                                    <li class="radio_item">
                                        <input type="radio" id="foreigner2" name="memberNation" value="F" class="blind">
                                        <label for="foreigner2">외국인</label>
                                    </li>
                                </ul>
                            </div>
                        
                            <!-- 휴대전화 -->
                            <div class="form_item phone" id="divPhoneNo">
                                <input type="tel" id="phoneNo" name="memberPhone" placeholder="휴대전화번호" class="input" value="" maxlength="16" />
                            </div>
   					</div>
   				</div>
   			   	<div class = "button_container" ></div>
   					<button type ="submit" id="join_button" name="join_button" ><h2>가입하기</h2></button>
   					<button type ="button" id= "return_button" name = "return_button"><h2>돌아가기</h2></button>
   				</div>
   			</form>  
</div>
