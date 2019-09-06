<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/toggle.css">

<script type="text/javascript"> 
$(function() {
    $('.navbar-toggle').click(function(){
      $(this).toggleClass('active');
    }); 
});
</script>
<title>메뉴</title>
</head>
<body>
<div class="wrap">
	<nav class="navbar bg-dark navbar-dark">
		<div class="navbar-toggler navbar-toggle" data-toggle="collapse" data-target="#toogle-navbar">
			<i></i><i></i><i></i>
		</div>
		<h3 class="title">Grang</h3>
		<div class="collapse navbar-collapse" id="toogle-navbar">
			<ul class="navbar-nav">
				<li class="nav-item">
				<a class="nav-link" href="#">마이페이지</a>
				</li>
				 <li class="nav-item">
				<a class="nav-link" href="myFeed.act">내 게시물</a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="#">구독 목록</a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="show.up">관심사 변경</a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="logout.do">로그아웃</a>
				</li>
			</ul>
		</div>
	</nav>
</div>
<%@ include file="bottomMenu.jsp" %>
</body>
</html>