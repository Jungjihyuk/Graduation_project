$(document).ready(function(){
	//type
	setTimeout(function(){
		var typed1 = new Typed('#typed1', {
		strings: ['그랑은 사람들과 동그랗게 어우러져 세상을 살라는 순수 우리말 입니다.'],
		typeSpeed: 100,
		fadeOut: false,
        cursorChar: ''
	});
	},3500)
	
	
	//페이지 로딩 시 제일 상단으로 스크롤 이동
	$("body,html").stop().animate({"scrollTop":0},1500,"swing");	
	$("article").eq(0).css({"background":"#DABFC9"});
	$("article").eq(1).css({"background":"#D7BFBF"});

	$(window).scroll(function(){
		
		//변수 scroll에 현재 화면을 스크롤한 거리의 수치를 저장
		var scroll = $(this).scrollTop();		
		
		for(var i=0; i<5; i++){
			//스크롤값과 박스의 z축 연동	
			$("section>article").eq(i).css({"transform":"translateZ("   + parseInt((-5000*i)+scroll)   +  "px)"});	
			//특정 스크롤 구간에서 스크롤 네비게이션과 박스 활성화
			if(scroll>=i*5000&&scroll<(i+1)*5000){
				$(".scrollNavi li").removeClass();
				$(".scrollNavi li").eq(i).addClass("on");
				$("article").removeClass();				
				$("article").eq(i).addClass("on");
			};
		};
		
		if(scroll>=-5000 && scroll<-10000){
			$("article").eq(2).hide();
		}
		
	});
	
	
	//스크롤 네비게이션 클릭 시 스크롤 이동
	$(".scrollNavi li").on("click",function(){
		var a = $(this).index();	
		$("body,html").stop().animate({"scrollTop":5000*a},1500,"swing");
		$(".page .content").hide();
	});
	
	$(".scrollNavi li").eq(1).on("click", function(){
		$(".page .content").hide();
	});
	
	$(".scrollNavi li").eq(2).on("click", function(){
		$(".page .content").hide();
	});
	
	/*1초마다 현재 시간 값 재설정*/
	var timer = setInterval(function(){
		var now = new Date();
		var hr = now.getHours();
		var min = now.getMinutes();
		var sec = now.getSeconds();
		
		//시간이 한자리 숫자일 때 앞에 0 붙이기
		if(hr >= 10){
			hNum = hr;
		}
		else{
			hNum = "0" + hr;
		}
		
		//분이 한자리 숫자일 때 앞에 0 붙이기
		if(min >= 10){
			mNum = min;
		}
		else{
			mNum = "0" + min;
		}
		
		//초가 한자리 숫자일 때 앞에 0 붙이기
		if(sec >= 10){
			sNum = sec;
		}
		else{
			sNum = "0" + sec;
		}
		
		$(".time p span").eq(0).text(hNum);
		$(".time p span").eq(1).text(mNum);
		$(".time p span").eq(2).text(sNum);
	},1000) //1초의 시간마다 안쪽의 구문을 반복 실행
	
	/*$(".btn a").eq(0).on("click", function(){
		$(".page .content").css({"background": "red"});
		$(".page .content").removeClass(".off");
		$(".page .content").show();
		$(".page .content").text("그랑은 사람들과 동그랗게 어우러져 세상을 살라는 순 우리말 입니다.");
	})
	$(".btn a").eq(1).on("click", function(){
		$(".page .content").css({"background": "blue"});
		$(".page .content").removeClass(".off");
		$(".page .content").show();
		$(".page .content").text("그랑입니다.");
	})
	$(".btn a").eq(2).on("click", function(){
		$(".page .content").css({"background": "green"});
		$(".page .content").removeClass(".off");
		$(".page .content").show();
		$(".page .content").text("그랑입니다.");
	})
	$(".btn a").eq(3).on("click", function(){
		$(".page .content").css({"background": "yellow"});
		$(".page .content").removeClass(".off");
		$(".page .content").show();
		$(".page .content").text("그랑입니다.");
	})*/
	
	
	
});















