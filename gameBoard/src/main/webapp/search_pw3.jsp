<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./resources/css/member_join.css"
	type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
function findPw_email() {
    let memberId = $('#id').val();
    let memberName = $('#name').val();
    let memberEmail = $('#email').val();
    
    $.ajax({
        url: "find_pw_email.do",
        type: "GET",
        data: {"member_id": memberId,
        	   "member_name": memberName, 
        	   "member_email": memberEmail
        	   },
        success: function(data) {
            if (data && data.length > 0) { // 데이터가 있는 경우
            	var memberPw = data;
                alert("회원님의 비밀번호는 " + memberPw + " 입니다." + "\n메인페이지로 돌아가서 로그인해주세요");
                $('#member_id').val('');
                $('#member_name').val('');
                $('#member_email').val('');
            } else { // 데이터가 없는 경우
                alert("일치하는 회원 정보가 없습니다. 회원 정보를 확인해주세요!");
                $('#member_id').val('');    
            	$('#member_name').val('');
                $('#member_email').val('');
            }
        },
        error: function() {
            alert("서버와의 통신 중 오류가 발생했습니다.");
		}
    });
}

$(document).ready(function() {
    $('#next_button3').on('click', function() {
  	 findPw_email();
  });
});
</script>

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
        <p class="choice_m">회원정보에 등록한 이메일로 인증하기</p>
        <form id="search_form" method="post" action="" class="member_search_form">
            <div class="form_list">
   				<!-- 아이디 입력 -->
                <div class="form_item_user" id="divId">
                    <input type="text" id="id" name="id" placeholder="아이디" class="input" value="" maxlength="20" autocapitalize="off" />
                </div>
                <!-- 이름 입력 -->
                <div class="form_item user" id="divName">
                    <input type="text" id="name" name="name" placeholder="이름" class="input" value="" maxlength="40" />
                </div>
                <!-- 이메일 -->
                <div class="form_item email" id="divEmail">
                    <input type="email" id="email" name="email" placeholder="이메일 주소" class="input" value="" maxlength="100" />
                </div>
            </div>
            <div class="button_container3">
                <button type="button" id="next_button3" name="next_button3"><h2>확인</h2></button>
                <a href="./search_pw1.jsp"><button type="button" id="return_button3" name="return_button3"><h2>돌아가기</h2></button></a>
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