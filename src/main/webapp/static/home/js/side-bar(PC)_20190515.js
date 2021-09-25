/* side-bar module for "itsource.cn"(PC) START */
/* @version 20190515 */

$(function() {
	
	// Add splitter.
	$("#side-bar .wrapper:not(:first-child)").before('<div class="splitter"></div>');
	
	
	/* Show and hide side-bar's categories menu */
	
	var _mouse_in_sideBar_categoriesMenuTrigger = false;
	var _mouse_in_sideBar_categoriesMenu = false;
	
	$("#side-bar .more").on("mouseenter", function() {
		_mouse_in_sideBar_categoriesMenuTrigger = true;
		$("#side-bar_more").removeClass("deactivated");
	});
	$("#side-bar_more").on("mouseenter", function() {
		_mouse_in_sideBar_categoriesMenu = true;
	});
	
	$("#side-bar .more").on("mouseleave", function() {
		_mouse_in_sideBar_categoriesMenuTrigger = false;
		setTimeout(function() {
			if (!_mouse_in_sideBar_categoriesMenu)
				$("#side-bar_more").addClass("deactivated");
		}, 1);
	});
	$("#side-bar_more").on("mouseleave", function() {
		_mouse_in_sideBar_categoriesMenu = false;
		if (!_mouse_in_sideBar_categoriesMenuTrigger)
			$("#side-bar_more").addClass("deactivated");
	});

});

/* side-bar module for "itsource.cn"(PC) END */