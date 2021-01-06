(function($) {

	$(".toggle-password").click(function() {

		$(".toggle-icon").toggleClass("far fas");
		var input = $($(this).attr("toggle"));
		if (input.attr("type") == "password") {
			input.attr("type", "text");
		} else {
			input.attr("type", "password");
		}
	});


})(jQuery);