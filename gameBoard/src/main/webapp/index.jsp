<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:import url="top.jsp" />


<link rel="stylesheet" href="./resources/css/slide.css" type="text/css">

<section>
	<div class="rollingbanner">
        <div class="roller">
			<img src="./resources/images/덕.jpg">
			<img src="./resources/images/apex.jpg">
			<img src="./resources/images/raft.jpg">
			<img src="./resources/images/sa.jpg">
			<img src="./resources/images/다입.jpg">
			<img src="./resources/images/스타듀.png">
			<img src="./resources/images/전쟁.jpg">
			<img src="./resources/images/파피.png">
        </div>
    </div>
</section>

<c:import url="middle1.jsp" />
<c:import url="middle2.jsp" />
<c:import url="bottom.jsp" />


<script>
    window.addEventListener('DOMContentLoaded', function(){

        // 롤링 배너 복제본 생성
        let roller = document.querySelector('.roller');
        roller.id = 'roller1';

        let clone = roller.cloneNode(true);
        clone.id = 'roller2';
        document.querySelector('.rollingbanner').appendChild(clone); // 부착

        
        // 원본, 복제본 배너 위치 지정
        document.querySelector('#roller1').style.left = '0px';
        document.querySelector('#roller2').style.left =  '0px';


        // 인터벌 메서드로 애니메이션 생성
        let rollerWidth = document.querySelector('.roller').offsetWidth; // 회전 배너 너비값으로 변경
        let betweenDistance =1; // 이동 크기 - 정수여야 함

        // 롤링 시작
        function startRoller(){
            originalID = window.setInterval(betweenRollCallback, parseInt(1000/100), betweenDistance, document.querySelector('#roller1'));
            cloneID = window.setInterval(betweenRollCallback, parseInt(1000/100), betweenDistance, document.querySelector('#roller2'));
        }

        // 롤링 정지
        function stopRoller(){
            clearInterval(originalID);
            clearInterval(cloneID);
        }

        // 마우스 호버시 롤링이 멈추었다 벗어나면 다시 롤링이 되도록 처리
        document.getElementById('roller1').addEventListener('mouseover', stopRoller);
        document.getElementById('roller2').addEventListener('mouseover', stopRoller);
        document.getElementById('roller1').addEventListener('mouseout', startRoller);
        document.getElementById('roller2').addEventListener('mouseout', startRoller);

        // 인터벌 애니메이션 함수(공용)
        function betweenRollCallback(d, roller){
            let left = parseInt(roller.style.left) || 0;
            roller.style.left = (left - d) + 'px'; // 이동
            // 조건부 위치 리셋
            if(rollerWidth + (left - d) <= 0){
                roller.style.left= '0px';
            }
        }

        startRoller(); // 롤링 초기화
    });
</script>