<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Viw_boardBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>


<link href="css/feed.css" rel="stylesheet">
<link href="css/search.css" rel="stylesheet">

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Grang Feed</title>
<script type="text/javascript">
//var request=new XMLHttpRequest();
function searchFunction(){
	var hash=document.getElementById("hash").value;
	//request.open("post","GrangT/searchHash.act?hash="+encodeURIComponent(document.getElementById("hash").value),true);
	//request.open("post","/searchHash.act",true);
	//request.send("hash"+encodeURIComponent(hash));
	//request.send(null);
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
    
    
    //Do not include! This prevents the form from submitting for DEMO purposes only!
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
<!-- 
var request=new XMLHttpRequest();
	function searchFunction(){
		request.open("Post","./search.act?hash="+encodeURIComponent(document.getElementById("hash").value),true);
		//request.onreadystatechange=searchProcess;
		request.send(null);
	}
	function searchProcess(){
		
	}
	window.onload=function(){
		searchFunction();
	}
 -->
</head>
<body>

<div id="wrapper">

	<div class="header">
		<a href="myMenu.jsp" class="button menu"><img src="images/menubar.png"></a>
		<span class="title">Grang</span>
	</div>
	
	<!-- 뉴스피드 보여주기  -->
	
	
<div class="feed">
	<c:forEach var="board" items="${list}">
		<div class="board_header">
			<span class="board_user">${board.userName}</span><span class="board_category">${board.category}</span><span class="board_present">${board.present}</span>
		</div>
		<div class="board_photo">
			<a href=""><img src="/GrangT/upload/${board.photoRealName}"></a>
		</div>
		<div class="board_hash"><span class="board_hash">#${board.hash}</span></div>
		<div class="board_content">
			<p>${board.content}</p>
		</div>
		<br>
		<hr>
	</c:forEach>	
	
	
	<div class="blank"></div>
</div>
	
	<input type="button" value="관심 게시물 보기" class="show_more" onclick="location.href='userBoard.act'">

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