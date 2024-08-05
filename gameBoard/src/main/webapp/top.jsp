<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Community for Gamers</title>
<link rel="stylesheet" href="./resources/css/top.css" type="text/css">
<link rel="stylesheet" href="./resources/css/theme.css" type="text/css">
</head>
<body>

	<header>
	<div id = "site_logo">
  		<a href="./index.jsp" id = "logo">
         <img src="./resources/images/로고3.png" height="200px">
     	</a>
        <div id="menu">
            <ul>
                <li><a href="./walkThrough.do"><b>공략</b></a></li>
                <li><a href="./Mod.do"><b>모드</b></a></li>
                <li><a href="./suggest.do"><b>게임추천</b></a></li>
                <li><a href="./FAQ.do"><b>FAQ</b></a></li>
            <li>
	         <div id="theme">
	            <img src="./resources/images/아이콘1.png" height="30px" id="whiteModeButton">
	         </div> 
	         </li>
	         </ul>
	    </div>
   </div>

<script>
	let whiteModeButton = document.getElementById("whiteModeButton");
	let iswhiteMode = false; // 현재 다크 모드 여부를 추적하는 변수

	// 페이지 로드 시 localStorage에서 다크 모드 설정 읽기
	window.onload = function() {
		let whiteModeSetting = localStorage.getItem("whiteMode");
		// enabled : 특정 설정이나 기능이 활성화되어있음
		if (whiteModeSetting === "enabled") {
			document.body.classList.add("whiteMode");
			whiteModeButton.src = "./resources/images/아이콘2.png"; // 달 이미지로 변경
			iswhiteMode = true;
			}
    };

	// 버튼 클릭될 때 다크 모드 토글 함수 호출
	whiteModeButton.onclick = toggleWhiteMode;
	function toggleWhiteMode() {
		document.body.classList.toggle("whiteMode");
		iswhiteMode = !isWhiteMode;
		// localStorage에 다크 모드 설정 저장
		localStorage.setItem("whiteMode", iswhiteMode ? "enabled" : "disabled");
		// 아이콘 변경
		 whiteModeButton.src = isWhiteMode ? "./resources/images/아이콘2.png" : "./resources/images/아이콘1.png";
	}	
	
</script> 

</header>