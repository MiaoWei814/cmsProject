/* header module for "itsource.cn"(PC) START */
/* @version 20181022 */

$(function() {
	
	// Add splitter.
	$("#categories-menu [category]:not(:last-child)").after('<div class="splitter">│</div>')
	
	
	/* Show and hide categories menu */
	
	var _mouse_in_categoriesMenuTrigger = false;
	var _mouse_in_categoriesMenu = false;
	
	$("#categories-menu-trigger").on("mouseenter", function() {
		_mouse_in_categoriesMenuTrigger = true;
		$("#categories-menu").removeClass("deactivated");
	});
	$("#categories-menu").on("mouseenter", function() {
		_mouse_in_categoriesMenu = true;
	});
	
	$("#categories-menu-trigger").on("mouseleave", function() {
		_mouse_in_categoriesMenuTrigger = false;
		setTimeout(function() {
			if (!_mouse_in_categoriesMenu)
				$("#categories-menu").addClass("deactivated");
		}, 1);
	});
	$("#categories-menu").on("mouseleave", function() {
		_mouse_in_categoriesMenu = false;
		if (!_mouse_in_categoriesMenuTrigger)
			$("#categories-menu").addClass("deactivated");
	});
});

/* header module for "itsource.cn"(PC) END */