/*JS*/
$(document).ready(function(){
	
	$(".nav a, footer a[href='#start']").on('click', function(event) {
		
		// Make sure this.hash has a value before overriding default behavior
		if (this.hash !== "") {

			// Prevent default anchor click behavior
			event.preventDefault();

			// Store hash
			var hash = this.hash;

			// Using jQuery's animate() method to add smooth page scroll
			// The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
			$('html, body').animate({
				scrollTop : $(hash).offset().top
			}, 900, function() {

				// Add hash (#) to URL when done scrolling (default click behavior)
				window.location.hash = hash;
			});
		} // End if
	});
	

	$('.btn').click(function(){

		$(".navbar").css("opacity", "0.0");
		
		$(".navbar").css("transition", "0.5s");
	});
	
	$('*').on('hidden.bs.modal', function(){
		
		$(".navbar").css("opacity", "1.0");
		
		$(".navbar").css("transition", "0.2s");
	});
});









