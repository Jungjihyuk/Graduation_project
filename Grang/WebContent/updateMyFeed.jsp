<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Viw_boardBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<link href="css/search.css" rel="stylesheet">
<link href="css/updateMyFeed.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Grang Feed</title>
<script type="text/javascript">
function searchFunction(){
	var hash=document.getElementById("hash").value;
	window.open("./searchHash.act?hash="+encodeURIComponent(document.getElementById("hash").value),"_self");
}
$(function () {
    $('a[href="#search"]').on('click', function(event) {
        event.preventDefault();
        $('#search').addClass('open');
        $('#search > form > input[type="search"]').focus();
    });
    
    $('#search, #search button.close').on('click keyup', function(event) {
        if (event.target == this || event.target.className == 'close' || event.keyCode == 27) {
            $(this).removeClass('open');
        }
    });
    
    $('form').submit(function(event) {
        event.preventDefault();
        return false;
    })
});

$(function() {
	$('.navbar-toggle').click(function(){
		$(this).toggleClass('active');
	}); 
});
</script>

</head>
<body>

<div id="wrapper">

	<div class="header">
		<a href="myMenu.jsp" class="button menu"><img src="images/menubar.png"></a>
		<span class="title">Grang</span>
	</div>
	
	<!-- 뉴스피드 보여주기  -->
	
<div class="feed">
		<c:forEach var="board" items="${Ulist}">
		<form action="BoardUS.act" method="post">		
			<div class="board_header">
				<input type="hidden" name="boardNum" value="${board.boardNum}">
				카테고리: <input type="text" name="category" value="${board.category}">
			</div>
			<!-- 
			<div class="board_photo">
				<img src="/GrangT/upload/${board.photoRealName}">
			</div>
			 -->
			<div class="board_hash">
				해시태그: <input type="text" name="hash" value="${board.hash}">
			</div>
			<div class="board_content">
				게시글<br>
				<input type="text" name="content" value="${board.content}">
			</div>
			<br>
			<hr>
			<input type="submit" value="수정하기" class="register-button">
			<div class="blank"></div>	
		</form>
		</c:forEach>	
	
	<div class="blank"></div>
</div>

	<%@ include file="bottomMenu.jsp" %>
	<div id="search">
    	<button type="button" class="close">×</button>
    	
       	<input type="search" id="hash" placeholder="해시 검색" />
       	<button type="submit" class="btn btn-primary" onclick="searchFunction();" >검색</button>
    	<!-- 
    	<form action="searchHash.act" method="post">
       	 	<input type="search" id="hash" placeholder="해시 검색" />
       		<button type="submit" class="btn btn-primary" onclick="searchFunction();" >검색</button>
    	</form>
    	 -->
	</div>
</div>	


</body>
</html>