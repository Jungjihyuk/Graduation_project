$(document).ready(function(){
	var index=0;
	var category="";
	for(var i=1;i<58;i++){
		$(".interest"+i).on("click",function(){
			$(this).css("background-color","tomato");
			var $check=$(this);
			var check="interest"+i;
			category=$check.text();
		});
		$(".interest"+[i]).click(function(){
			$(this).off("click");
		})
	}
});
