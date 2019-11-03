/*JS*/
$(document).ready(function(){
	$('.btn').click(function(){

		$(".navbar").css("opacity", "0.0");
		
		$(".navbar").css("transition", "0.5s");
	});
	
	$('*').on('hidden.bs.modal', function(){
		
		$(".navbar").css("opacity", "1.0");
		
		$(".navbar").css("transition", "0.2s");
	});
});

