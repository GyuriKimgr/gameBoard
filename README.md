## 게임 소통 커뮤니티 사이트 제작 🎮
- 사용자들이 여러 게임에 관한 공략, 모드, 추천에 관한 정보를 공유할 수 있는 플랫폼 사이트
- 게임 정보에 특화된 사이트를 제작하고자 함
- 스프링을 이용한 maven 프로젝트로 제작됨
- 프로젝트 개발 기간 : 2024.06.24~2024.08.27
- 개발 멤버 : 김규리, 이미지, 오승민, 전시유

## 기술 스택 🖥
|기술|이미지|
|:---:|---|
|CSS|![CSS3](https://img.icons8.com/color/48/000000/css3.png)|
|HTML|![HTML5](https://img.icons8.com/color/48/000000/html-5.png)|
|JavaScript|![JavaScript](https://img.icons8.com/color/48/000000/javascript.png)|
|Java|![Java](https://img.icons8.com/color/48/000000/java-coffee-cup-logo.png)|
|Spring|![Spring](https://img.icons8.com/color/48/000000/spring-logo.png)|
|Oracle|![Oracle](https://img.icons8.com/color/48/000000/oracle-logo.png)|
|Tomcat|![Tomcat](https://img.icons8.com/color/48/000000/tomcat.png)|


## 프로젝트 구조 🌳
```plaintext
├─gameBoard
│  ├─.settings
│  ├─spring_work
│  │  └─gameBoard
│  │      └─target
│  │          └─m2e-wtp
│  │              └─web-resources
│  │                  └─META-INF
│  │                      └─maven
│  │                          └─com.gameboard
│  │                              └─myapp
│  ├─src
│  │  ├─main
│  │  │  ├─java
│  │  │  │  └─com
│  │  │  │      └─gameboard
│  │  │  │          ├─biz
│  │  │  │          │  └─post
│  │  │  │          │      └─Impl
│  │  │  │          └─view
│  │  │  │              └─controller
│  │  │  ├─resources
│  │  │  │  ├─conf
│  │  │  │  └─mappings
│  │  │  └─webapp
│  │  │      ├─resources
│  │  │      │  ├─css
│  │  │      │  └─images
│  │  │      └─WEB-INF
│  │  │          └─config
│  │  └─test
│  │      └─resources
│  └─target
│      ├─classes
│      │  ├─com
│      │  │  └─gameboard
│      │  │      ├─biz
│      │  │      │  └─post
│      │  │      │      └─Impl
│      │  │      └─view
│      │  │          └─controller
│      │  ├─conf
│      │  └─mappings
│      ├─m2e-wtp
│      │  └─web-resources
│      │      └─META-INF
│      │          └─maven
│      │              └─com.springbook
│      │                  └─biz
│      └─test-classes
└─Servers
    ├─.settings
    └─Tomcat v9.0-config
```

## 기능 ✨

|회원가입|아이디 및 비번찾기|
|---|---|
| ![image](https://github.com/user-attachments/assets/8204ba4b-27cd-4113-809e-3868555d9a17) |![image](https://github.com/user-attachments/assets/5e0341a1-b614-4bf2-b42a-14b5d9b03aa6)|


|로그인| 로그아웃|
|---|---|
|![image](https://github.com/user-attachments/assets/39e8bac0-c71b-404b-a9aa-5d944272aa27)|![image](https://github.com/user-attachments/assets/51ebe91b-6dcf-4b8a-ae3e-f371ef81bb1a)|

|오늘의게시판|댓글|
|---|---|
|![image](https://github.com/user-attachments/assets/be1f6a37-9e9c-4045-ba39-aac1c8394a51)|![image](https://github.com/user-attachments/assets/5041486f-53a3-44d0-b404-9b6b2b7be698)|

|공지사항|
|---|
|![image](https://github.com/user-attachments/assets/1edc321c-525d-4e86-89d9-e6b749252e69)|

|게시물 작성|게시물 수정|게시물 삭제|
|---|---|---|
|![image](https://github.com/user-attachments/assets/664684c5-6b73-4a50-80bd-09e40c0dc451)|![image](https://github.com/user-attachments/assets/9fe21136-889e-4fc5-ad66-a580aa4a2ec0)|![image](https://github.com/user-attachments/assets/30466e5a-a38d-404f-93cf-1ca43e156fc9)|

|게시물 이미지 삽입|
|---|
|![image](https://github.com/user-attachments/assets/9c679eba-7055-45af-b594-258e44ddf280)|

## 설치 및 실행방법 💙
이 프로젝트는 Maven을 사용하여 관리되는 Spring 애플리케이션으로<br>
로컬 환경에서 프로젝트를 설치 및 실행할 시 다음과 같은 과정을 요구함

**1. 레포지토리 클론**
<br>**2. Java, Maven, Tomcat 설치 확인**
   - [Java 11](https://www.oracle.com/java/technologies/downloads/#java11) 이상 필요
   - [Maven](https://maven.apache.org/download.cgi) 필요
   - [Tomcat 9](https://tomcat.apache.org/download-90.cgi) 이상 필요

<br>**3. Oracle 데이터베이스 및 SQL Developer 설치**
   - [Oracle](https://www.oracle.com/database/technologies/)데이터베이스 필요
   - [Oracle SQL Developer](https://www.oracle.com/database/sqldeveloper/technologies/download/)필요

<br>**4. 데이터 베이스 설정**
<br>4-1) 게시판 테이블 생성
```sql
CREATE TABLE WT_BOARD_POST (
    wtID NUMBER PRIMARY KEY,
    wtTitle VARCHAR2(50) NOT NULL,
    userID VARCHAR2(50),
    wtDate VARCHAR2(50) NOT NULL,
    wtViews NUMBER DEFAULT 0,
    wtContent CLOB NOT NULL
);

CREATE TABLE MOD_BOARD (
    mID NUMBER PRIMARY KEY,
    mTitle VARCHAR2(50) NOT NULL,
    userID VARCHAR2(50),
    mDate VARCHAR2(50),
    mViews NUMBER DEFAULT 0,
    mContent CLOB NOT NULL
);

CREATE TABLE SG_BOARD_POST (
    sgID NUMBER PRIMARY KEY,
    sgTitle VARCHAR2(50) NOT NULL,
    userID VARCHAR2(50),
    sgDate VARCHAR2(50),
    sgViews NUMBER DEFAULT 0,
    sgContent CLOB NOT NULL
);

CREATE TABLE FAQ_BOARD_POST (
    fID NUMBER PRIMARY KEY,
    fTitle VARCHAR2(50) NOT NULL,
    userID VARCHAR2(50),
    fDate VARCHAR2(50),
    fViews NUMBER DEFAULT 0,
    fContent CLOB NOT NULL,
    answer CLOB,
    status VARCHAR2(50)
);

CREATE TABLE NOTICE (
    noticeID VARCHAR2(50) NOT NULL,
    boardType VARCHAR2(50) NOT NULL, -- 게시판 유형 (WT, MOD, SG, FAQ)
    noticeTitle VARCHAR2(50) PRIMARY KEY,
    noticeContent CLOB NOT NULL,
    noticeDate VARCHAR2(50),
    Manager_ID VARCHAR2(20) NOT NULL,
    noticeViews NUMBER DEFAULT 0
);

CREATE TABLE GAME_MEMBER (
    member_id VARCHAR2(50) NOT NULL,
    member_pw VARCHAR2(100) NOT NULL,
    member_name VARCHAR2(100) NOT NULL,
    member_email VARCHAR2(50) NOT NULL,
    member_birth VARCHAR2(50) NOT NULL,
    member_gender VARCHAR2(10) NOT NULL,
    member_nation VARCHAR2(10) NOT NULL,
    member_phone VARCHAR2(50) NOT NULL,
    member_join_date VARCHAR2(50) NOT NULL,
    member_id_check VARCHAR2(20),
    PRIMARY KEY (member_id)
);
```
<br>4-2) 댓글 및 이미지 테이블 생성
```sql
CREATE TABLE WT_BOARD_COMMENT (
    commentID NUMBER PRIMARY KEY,
    wtID NUMBER REFERENCES WT_BOARD_POST(wtID),
    userID VARCHAR2(50),
    commentDate DATE DEFAULT SYSDATE NOT NULL,
    commentContent CLOB NOT NULL
);

CREATE TABLE MOD_BOARD_COMMENT (
    mCommentID NUMBER PRIMARY KEY,
    mID NUMBER REFERENCES MOD_BOARD(mID),
    userID VARCHAR2(50),
    mCommentDate DATE DEFAULT SYSDATE NOT NULL,
    mCommentContent CLOB NOT NULL
);

CREATE TABLE SG_BOARD_COMMENT (
    sgCommentID NUMBER PRIMARY KEY,
    sgID NUMBER REFERENCES SG_BOARD_POST(sgID),
    userID VARCHAR2(50),
    sgCommentDate DATE DEFAULT SYSDATE NOT NULL,
    sgCommentContent CLOB NOT NULL
);

CREATE TABLE WT_BOARD_IMAGE (
    wtimageID NUMBER PRIMARY KEY,
    wtID NUMBER,
    wtimageUrl VARCHAR2(500),
    FOREIGN KEY (wtID) REFERENCES WT_BOARD_POST(wtID)
);

CREATE TABLE MOD_BOARD_IMAGE (
    mimageID NUMBER PRIMARY KEY,
    mID NUMBER,
    mimageUrl VARCHAR2(500),
    FOREIGN KEY (mID) REFERENCES MOD_BOARD(mID)
);

CREATE TABLE SG_BOARD_IMAGE (
    sgimageID NUMBER PRIMARY KEY,
    sgID NUMBER,
    sgimageUrl VARCHAR2(500),
    FOREIGN KEY (sgID) REFERENCES SG_BOARD_POST(sgID)
);

CREATE TABLE FAQ_BOARD_IMAGE (
    fimageID NUMBER PRIMARY KEY,
    fID NUMBER,
    fimageUrl VARCHAR2(500),
    FOREIGN KEY (fID) REFERENCES FAQ_BOARD_POST(fID)
);
```
<br>4-3) 시퀀스 생성
```sql
CREATE SEQUENCE SEQ_WT_BOARD_IMAGE;
CREATE SEQUENCE SEQ_SG_BOARD_IMAGE;
CREATE SEQUENCE SEQ_MOD_BOARD_IMAGE;
CREATE SEQUENCE SEQ_FAQ_BOARD_IMAGE;
```
<br>**5. 브라우저에서 확인**
- 해당 프로젝트는 http://localhost:8090/biz/index.jsp 주소에서 실행됨
