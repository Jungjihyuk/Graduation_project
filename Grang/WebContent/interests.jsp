<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관심사 선택</title>
<link rel="stylesheet" href="css/category.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<!-- 
<script type="text/javascript" src="js/category3.js"></script>
 -->
<script type="text/javascript">
$(document).ready(function(){
	var category=null;
	for(var i=1;i<58;i++){
		$(".interest"+i).on("click",function(){
			$(this).css("background-color","tomato");
			var $check=$(this);
			var check="interest"+i;
			category=$check.text();	
			$(".check").on("click",function(){
				var request=new XMLHttpRequest();
				request.open("post","./insertInterests.do?interest="+encodeURIComponent(category), true);
				request.send();
			});
		});
		$(".interest"+[i]).click(function(){
			$(this).off("click");
		})
	}
});  
/*
function chooseInterests(category){
		var request=new XMLHttpRequest();
		request.open("post","./insertInterests.do?interest="+encodeURIComponent(category), true);
		request.send();
	}
 
 */
</script>
</head>
<body>
<div id="wrap">
	<div class="header">
		<span class="header_intro">최대 5가지 관심사를 선택해주세요.</span>
		<!-- <a href="#" onclick="chooseInterests();"><img src="images/check2.png" class="header_select"></img></a> -->
		<a href="selectAllBoard.act" class="check"><img src="images/check2.png" class="header_select"></img></a>
	</div>
	<div id="group">
		<ul>
			<li class="interest1" id="interest1">여행</li>
			<li class="interest2" id="interest2">자동차</li>
			<li class="interest3" id="interest3">Business</li>
			<li class="interest4" id="interest4">애완동물</li>
			<li class="interest5" id="interest5">경제</li>
			<li class="interest6" id="interest6">역사</li>
			<li class="interest7" id="interest7">Sports</li>
			<li class="interest8" id="interest8">과학</li>
			<li class="interest9" id="interest9">학교</li>
			<li class="interest10" id="interest10">음악</li>
			<li class="interest11" id="interest11">맛집</li>
			<li class="interest12" id="interest12">Apple</li>
			<li class="interest13" id="interest13">정치</li>
			<li class="interest14" id="interest14">유명인</li>
			<li class="interest15" id="interest15">배우</li>
			<li class="interest16" id="interest16">IT</li>
			<li class="interest17" id="interest17">광고</li>
			<li class="interest18" id="interest18">가족</li>
			<li class="interest19" id="interest19">자연</li>
			<li class="interest20" id="interest20">책</li>
			<li class="interest21" id="interest21">삼성</li>
			<li class="interest22" id="interest22">영화</li>
			<li class="interest23" id="interest23">연애</li>
			<li class="interest24" id="interest24">결혼</li>
			<li class="interest25" id="interest25">우주</li>
			<li class="interest26" id="interest26">뉴스</li>
			<li class="interest27" id="interest27">작가</li>
			<li class="interest28" id="interest28">드라마</li>
			<li class="interest29" id="interest29">취미</li>
			<li class="interest30" id="interest30">사진</li>
			<li class="interest31" id="interest31">가족</li>
			<li class="interest32" id="interest32">언어</li>
			<li class="interest33" id="interest33">Google</li>
			<li class="interest34" id="interest34">자연</li>
			<li class="interest35" id="interest35">문화</li>
			<li class="interest36" id="interest36">술</li>
			<li class="interest37" id="interest37">교육</li>
			<li class="interest38" id="interest38">애니메이션</li>
			<li class="interest39" id="interest39">패션</li>
			<li class="interest40" id="interest40">가수</li>
			<li class="interest41" id="interest41">대회</li>
			<li class="interest42" id="interest42">예술</li>
			<li class="interest43" id="interest43">게임</li>
			<li class="interest44" id="interest44">스마트폰</li>
			<li class="interest45" id="interest45">힙합</li>
			<li class="interest46" id="interest46">올림픽</li>
			<li class="interest47" id="interest47">건강</li>
			<li class="interest48" id="interest48">취업</li>
			<li class="interest49" id="interest49">생활용품</li>
			<li class="interest50" id="interest50">돈</li>
			<li class="interest51" id="interest51">커피</li>
			<li class="interest52" id="interest52">요리</li>
			<li class="interest53" id="interest53">심리</li>
			<li class="interest54" id="interest54">Puzzle</li>
			<li class="interest55" id="interest55">부동산</li>
			<li class="interest56" id="interest56">웹툰</li>
			<li class="interest57" id="interest57">날씨</li>
			<li class="interest57" id="interest58">음료</li>
		</ul>
	</div>
</div>

</body>
</html>