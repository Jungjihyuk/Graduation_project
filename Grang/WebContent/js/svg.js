$(document).ready(function(){
	var timerID = setInterval(function(){
		var $svg_wrap = $(".svg_wrap");
		$svg_wrap.fadeOut();
	},3000);
});