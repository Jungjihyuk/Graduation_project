<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Grang</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="js/vegas/vegas.min.css">
    <link href="https://fonts.googleapis.com/css?family=Charmonman" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="js/prefixfree.min.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<script type="text/javascript" src="js/svg.js"></script>
	<script type="text/javascript" src="js/FakeSmile-master/FakeSmile-master/smil.check.js"></script>
	<script type="text/javascript" src="js/FakeSmile-master/FakeSmile-master/smil.user.js"></script>
	<script src="js/vegas/vegas.min.js"></script>
	<!--<script>
        $(function(){
            $('.page').vegas({
                slides:[
                    {src: 'images/food1.png'},
                    {src: 'images/food2.png'},
                    {src: 'images/food3.png'}
                ],
                delay: 3500
            });
        });
    </script>-->
<script type="text/javascript">

function checkPwd(){
  var f1=document.forms[0];	
  var pw1 = f1.password.value;
  var pw2 = f1.passwordchk.value;
  if(pw1!=pw2){
   document.getElementById('checkPwd').style.color = "red";
   document.getElementById('checkPwd').innerHTML = "동일한 비밀번호를 입력하세요."; 
  }else{
   document.getElementById('checkPwd').style.color = "black";
   document.getElementById('checkPwd').innerHTML = "비밀번호가 일치합니다."; 
  }
 }
 
</script>
</head>
<body>
    <div id="wrap">
        <section class="visual">
        	<h2 class="blind">cover</h2>
        	<div class="svg_wrap">
        		<svg version="1.1" id="svg1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
				 y="0px" viewBox="0 0 1200 560" style="enable-background:new 0 0 1200 560;" xml:space="preserve">
					<text id="XMLID_1_" transform="matrix(1 0 0 1 251.9621 311.5278)" class="st0 st1">Grang</text>
				</svg>
        	</div>
        </section>
        <!--배경화면-->
        <div id="bg"></div>
        <!--로고-->
        <div class="logo">
            GRANG
        </div>
         <!-- 스크롤 네비게이션 -->
		<ul class="scrollNavi">
			<li class="on"><span></span><em>Grang</em></li>
			<li><span></span><em>Start</em></li>
			<li><span></span><em>Login</em></li>
		</ul><!-- 메뉴 위치를 바꾸거나 start, login 버튼을 눌렀을 때 위치 변경하기 -->
        <!--시계-->
        <figure class="time">
            <p>
                <span>00</span> : <span>00</span> : <span>00</span>
            </p>
        </figure><!-- 모바일 버전에서는 시계 사이즈를 줄이고 위치도 바꿔주는게 좋을거 같음. -->
        <!--박스 그룹-->
        <section>
            <article class="on page">
                <!--<p class="content off"></p>
                버튼
				<div class="btn">
					<a href="#" class="on"><img src="images/person1.png" alt="person_icon1"></a>
					<a href="#"><img src="images/person2.png" alt="person_icon2"></a>
					<a href="#"><img src="images/person3.png" alt="person_icon3"></a>
					<a href="#"><img src="images/person4.png" alt="person_icon4"></a>
				</div>-->
           	<svg id="svg2">
                  <path d="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" stroke="#784950" stroke-width="3" fill="none"/>
                    <circle cx="0" cy="0" r="5" style="fill:#90406E; fill-opacity:0.5; stroke:none;">
                    <animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="14s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="6" style="fill:red; fill-opacity:0.5; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="13s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="7" style="fill:#D4453B; fill-opacity:0.3; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="12s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="10" style="fill:#8DA05E; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="11s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="9" style="fill:#F8605C; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="10s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="12" style="fill:#67ACC4; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="9s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="11" style="fill:#F4B66B; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="8s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="8" style="fill:#242E78; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="7s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="8" style="fill:#F4B66B; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="6s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="5" style="fill:#6A4C4A; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="5s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="11" style="fill:#CFE5D8; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="4s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="9" style="fill:#BB1069; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="3s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
					<circle cx="0" cy="0" r="6" style="fill:#E468B1; fill-opacity:0.7; stroke:none;">
						<animateMotion path="M200,100 A50,50 0 0 1 300 100 A50,50 0,0,1 400,100 Q400,200 300,250 Q200,200 200,100" dur="6s" repeatCount="indefinite" rotate="auto" additive="sum"/>
					</circle>
            </svg>
            <div class="main_text">
            	<span id="typed1"></span><!-- 모바일 버전에서는 글자가 짤림. -->
            </div>
            </article>
            <article id="start">
                <h2>그랑 시작하기</h2>
                <form action="signup.do" id="join_form" method="post" autocomplete=off>
                  <input type="text" name="userName" class="name" placeholder="Name"> <br>
                  <input type="email" name="id" class="email" placeholder="email (ID)"> <br>
                  <input type="password" name="password" class="pwd" placeholder="Password"> <br>
                  <input type="password" name="passwordchk" class="pwdchk" placeholder="Password Check" onkeyup="checkPwd()">
              	  <div id="checkPwd"></div>
              	  <input type="submit" value="시작하기" >
                </form>
            </article>
            <article id="login">
                <h2>로그인</h2>
                <form action="login.do" id="login_form" method="post" autocomplete=off>
                  <input type="text" name="id" class="id2" placeholder="email (ID)"> <br>
                  <input type="password" name="password" class="pwd2" placeholder="Password">
                  <input type="submit" value="Login">
              	</form>
            </article>
        </section>
        <!--footer-->
        <div id="footer">
            <span class="copyright">&copy; Copyright 2018 Computer Science's &nbsp;Senier Project &nbsp; Yongin Univ. </span>
            <span>Kim Dae Sung / Son Ye Jun / Jeong Ji Hyeok / Hyeon Yu Jin / Park Han Su</span>
        </div>
    </div>
    <script src="js/vivus.min.js"></script>
    <script src="js/typed.js"></script>
</body>
</html>