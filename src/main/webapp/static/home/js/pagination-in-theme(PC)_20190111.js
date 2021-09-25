/* pagination-in-theme module for "itsource.cn"(PC) START */
/* @version 20190111 */

$(function() {
	$(".pagination-in-theme")
		.on("click", ".index:not(.active)", function() {
			alert($(this).html());
		})
		.on("click", ".prev", function() {
			alert("前一页");
		})
		.on("click", ".next", function() {
			alert("后一页");
		});
});

/* pagination-in-theme module for "itsource.cn"(PC) END */