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
            </ul>
	         <div id="theme">
	            <img src="./resources/images/아이콘1.png" height="30px" id="darkModeButton">
	         </div> 
	    </div>
   </div>

<script>
	let darkModeButton = document.getElementById("darkModeButton");
	let isDarkMode = false; // 현재 다크 모드 여부를 추적하는 변수

	// 페이지 로드 시 localStorage에서 다크 모드 설정 읽기
	window.onload = function() {
		let darkModeSetting = localStorage.getItem("darkMode");
		// enabled : 특정 설정이나 기능이 활성화되어있음
		if (darkModeSetting === "enabled") {
			document.body.classList.add("darkMode");
			darkModeButton.src = "./resources/images/아이콘2.png"; // 달 이미지로 변경
			isDarkMode = true;
			}
    };

	// 버튼 클릭될 때 다크 모드 토글 함수 호출
	darkModeButton.onclick = toggleDarkMode;
	function toggleDarkMode() {
		document.body.classList.toggle("darkMode");
		isDarkMode = !isDarkMode;
		// localStorage에 다크 모드 설정 저장
		localStorage.setItem("darkMode", isDarkMode ? "enabled" : "disabled");
		// 아이콘 변경
		 darkModeButton.src = isDarkMode ? "./resources/images/아이콘2.png" : "./resources/images/아이콘1.png";
	}	
	
</script> 

</header>