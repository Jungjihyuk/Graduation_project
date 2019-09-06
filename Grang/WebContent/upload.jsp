<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/feed.css" rel="stylesheet">
<link href="css/upload.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	var sel_files=[];
	$(document).ready(function(){
		$("#input_imgs").on("change",handleImgsFilesSelect);	
	});
	function handleImgsFilesSelect(e){
		var files=e.target.files;
		var filesArr=Array.prototype.slice.call(files);
		
		filesArr.forEach(function(f){
			if(!f.type.match("image.*")){
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}
			sel_files.push(f);
			
			var reader=new FileReader();
			reader.onload=function(e){
				var img_html="<img src=\"" +e.target.result+"\" />";
				$(".imgs_wrap").append(img_html);
			}
			reader.readAsDataURL(f);
		});
	}
</script>
<title>게시물 올리기</title>
</head>
<body>

<div class="wrap">
	<div class="header">
		<a href="myMenu.jsp" class="button menu"><img src="images/menubar.png"></a>
		<span class="title">Grang</span>
		<!-- <div class="myfeed">
			<button class="myboard">내 게시물</button>
		</div>		
		<div class="pick">
			<button class="mypick">찜</button>
		</div> -->
	</div>
	<!-- 피드방이 5개 이상부터는 화살표를 눌러서 새로운 리스트를 볼 수 있게 -->

	<div class="board_upload">
		<form action="uploadBoard.act" enctype="multipart/form-data" method="post">
			<div class="form">
            <ul class="tabs">
                <li class="active" data-panel="content">게시글</li>
                <li data-panel="photo">사진</li>
                <li data-panel="hash">해시</li>
            </ul>
            <div id="content" class="panel active">
            	<h5>카테고리 선택</h5>
            	<input type="text" name="category">
            	<textarea class="board_content" name="content" placeholder="당신의 생각을 공유해봐요!" style="width:300px; height:100px"></textarea>
            </div>
            <div id="photo" class="panel">
            	<div>
					<div class="imgs_wrap">
				
					</div>
				</div>
				<div class="photo_upload">
					<p class="title">추가할 사진을 선택해주세요.<p>
					<input type="file" id="input_imgs" name="photo" multiple/>
				</div>
            </div><!-- 사진 업로드시 파일 크기와 관계없이 정해진 사이즈에 맞춰 보여주기 추가 -->
            <div id="hash" class="panel">
            	<h4>해시태그달기</h6><br>
				<input type="text" name="hash">
            </div>
        </div>
		<input type="submit" value="작성하기" class="register-button">
		<!-- 입력 값 없이 작성하기를 눌렀을 때 빈칸을 채우라는 alert창 띄우기 추가 -->
		</form>
 
        <script type="text/javascript">
            $(document).ready(function() {
 
                $(".tabs li").on("click", function(e) {
 
                    var $contents = $(this).closest(".form");
 
                    $contents.find(".tabs li.active").removeClass("active");
 
                    $(this).addClass("active");
 
                    $contents.find(".panel.active").hide();
                    $contents.find(".panel.active").removeClass("active");
 
                    var panelToShow = $(this).data("panel");
 
                    $("#" + panelToShow).show();
                    $("#" + panelToShow).addClass("active");
                });
            });
        </script>
	</div>
	
	<hr> 
	<%@ include file="bottomMenu.jsp" %>
</div>

</body>
</html>