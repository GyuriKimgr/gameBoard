<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="./resources/css/middle1.css" type="text/css">
<link rel="stylesheet" href="./resources/css/top.css" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).ready(function() {
        $('#login-form').submit(function(event) {
            event.preventDefault(); // �⺻ �� ���� ���� ����
            var xhr = new XMLHttpRequest();
            xhr.open('POST', './login.do', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

            xhr.onload = function() {
                if (xhr.status === 200) {
                    if (xhr.responseText === "success") {
                        window.location.reload(); // �α��� ���� �� ������ ���ΰ�ħ
                    } else {
                        alert("���̵� Ȥ�� ����� Ȯ�����ּ���."); // �α��� ���� �� �˷�â ǥ��
                    }
                } else {
                    alert("�α��� ��û ����");
                }
            };

            var formData = new FormData(document.getElementById('login-form'));
            var params = new URLSearchParams();
            formData.forEach((value, key) => {
                params.append(key, value);
            });

            console.log("�α��� ��û ������:", params.toString()); // ������ �α� �߰�

            xhr.send(params.toString());
        });
    });
</script>

<div class="box1">
<ul class="middle1">
	<li>
		<a href="#" class="link_card1"> 
			<strong class="title">���Ӽҽ�</strong>
			<span class="img_comm1">������</span>
        </a>
		<div class="news1">
			<a name="news_1" class="gamenews"
				href="https://www.gukjenews.com/news/articleView.html?idxno=3037747"
				event-order="0" event-description="TES ���� T1, �� ���� �� �ʴ� è�Ǿ� �ڸ� ����"
				event="click_news" news_type="��ȸ�ҽ�"
				news_title="TES ���� T1, �� ���� �� �ʴ� è�Ǿ� �ڸ� ����">
			              
				<div class="gamenews_1">
					<img
						src="https://pbs.twimg.com/media/GPdbQgCbQAAwBes?format=jpg&name=medium"
						class="news_img">
				</div> 
	            <strong class="tit1"> TES ���� T1, �� ���� �� �ʴ� è�Ǿ� �ڸ� ���� </strong> 
	            <span class="tit2">T1�� �߱� ���θ���(LPL)�� ��ȣ �� ��e������(TES)�� ���� E������ ������(EWC) �ʴ� è�Ǿ� �ڸ��� �ö���.</span>
			</a>
			<div class="group_tit1">
				<a name="news_1" class="gamenews"
					href="https://www.thisisgame.com/webzine/news/nboard/4/?utm_source=naver?utm_source?utm_source?
							utm_source?utm_source&utm_medium=outlink&utm_campaign=thisisgame&utm_content=85668&referer=coinsosik&category=1&n=189696"
			        event-order="1" event-description="��Ʋ ����Ʈ�޾� 3' ��� ����, 2024�� ������ ������ ��ƴ�"
			        event="click_news" news_type="���� ����"
			        news_title="��Ʋ ����Ʈ�޾� 3' ��� ����, 2024�� ������ ������ ��ƴ�"> 
			        <strong class="tit1">��Ʋ ����Ʈ�޾� 3' ��� ����, 2024�� ������ ������ ��ƴ�</strong>
				</a> 
				<a name="new_1" class="gamenews"
					href="https://www.thelec.kr/news/articleView.html?idxno=28711"
			        event-order="2" event-description="���� '��Ű��' 26�� ���...����ý����� ��Ȱ '�ºμ�"
			        vent="click_news" news_type="��ȸ�ҽ�" news_title="��Ű��">
			        <strong class="tit1">���� '��Ű��' 26�� ���...����ý����� ��Ȱ '�ºμ�</strong>
				</a>
			</div>
		</div>
	</li>

	<li>
		<a href="#" class="link_card1"> 
			<strong class="title">������ �Խ���</strong>
			<span class="img_comm1">������</span>
		</a>
        <div class="news1">
			<a name="news_1" class="gamenews"
				href="#"
				event-order="0" event-description="PGS 4 �׷� �������� ���̶���Ʈ"
				event="click_news" news_type="��ȸ�ҽ�"
				news_title="PGS 4 �׷� �������� ���̶���Ʈ">
				
				<div class="gamenews_1">
                    <img
					src="./resources/images/Today.jpg"
                       class="news_img">
				</div> 
				<strong class="tit1"> PGS 4 �׷� �������� ���̶���Ʈ</strong>
				<span class="tit2">���� �۷ι� �ø��� 4�� �׷� �������� ����Ʈ ������ ���� �ٷ� ���̶���Ʈ ������ ���� Ȯ���غ�����.</span>
			</a>
			<div class="group_tit1">
				<a name="news_1" class="gamenews"
					href="#"
					event-order="1" event-description="���� �۷ι� �ø��� 3(PGS 3)�� �Ұ��մϴ�!"
					event="click_news" news_type="��ȸ�ҽ�"
					news_title="���� �۷ι� �ø��� 3(PGS 3)�� �Ұ��մϴ�!"> <strong
					class="tit1">���� �۷ι� �ø��� 3(PGS 3)�� �Ұ��մϴ�!</strong>
				</a>
				<a name="news_1" class="gamenews"
					href="#"
					event-order="2" event-description="2024 PLS: Cup �ȳ�"
					event="click_news" news_type="��ȸ�ҽ�" news_title="2024 PLS: Cup �ȳ�">
					<strong class="tit1">2024 PLS: Cup �ȳ�</strong>
				</a>
			</div>
		</div> 
		</li>
		
<!-- �α��� �� -->
		<li>
		<c:choose>
            <c:when test="${not empty sessionScope.loggedInMember}">
                <!-- �α��� ���� -->
                <div class="welcome">
                    <h2>${sessionScope.loggedInMember}��, ȯ���մϴ�!</h2>
                    <form id="logout-form" method="post" action="./logout.do">
    					<input type="submit" value="Logout">
					</form>
                </div>
            </c:when>
            <c:otherwise>
            <!-- ��α��� ���� -->
            <div class="login">
               <h2>Simple Login</h2>
                <form method="post" action="./login.do" id="login-form">
                  <input type="text" name="member_id" placeholder="ID"> <input
                     type="password" name="member_pw" placeholder="Password">
                     
                  <label for="remember-check"> <input type="checkbox"
                     id="remember-check">���̵� �����ϱ�
                  </label>
                  
						<div class="find_wrap">
                                <a href="./search_id1.jsp" class="find_text">���̵� ã��</a> 
                                <span>��</span>
                                <a href="./search_pw1.jsp" class="find_text">��й�ȣ ã��</a>
                                <span>��</span>
                                <a href="./getJoinDate.do"><span  class="accent">ȸ������</span></a>
                         </div>
                  <input type="submit" value="Login">
               </form>
               </div>
                  </c:otherwise>
        </c:choose>
         </li>
      </ul>
   </div>