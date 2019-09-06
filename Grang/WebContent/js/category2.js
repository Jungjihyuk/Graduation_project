$(document).ready(function(){
	var list=new Array();
	var index=0;
	for(var i=1;i<58;i++){
		$(".interest"+i).on("click",function(){
			$(this).css("background-color","tomato");
			var $check=$(this);
			list[index]=$check.text();
		});
		$(".interest"+[i]).click(function(){
			$(this).off("click");
		})
	}
});