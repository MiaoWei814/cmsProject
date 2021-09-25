/* 2-up-vertical module for "itsource.cn"(PC) START */
/* @version 20190509 */

$(function() {
	$("#starteds.minority [tabs-keel=starteds]").on("click", ".tab", function() {
		alert($(this).html());
	});
	
	var bannerSwiper = new Swiper ('#ads.minority.swiper-container', {
	 	autoplay: { disableOnInteraction: false },
	    loop: true
  	});
  	$("#ads .swiper-slide")
	  	.mouseenter(function() {
	  		bannerSwiper.autoplay.stop();
	  	})
	  	.mouseleave(function() {
	  		bannerSwiper.autoplay.start();
	  	});
	  	
	var publicClasses = new Swiper ('#public-classes.minority .swiper-container', {
	 	autoplay: { disableOnInteraction: false },
	    loop: true
  	});
  	$("#public-classes .swiper-slide")
	  	.mouseenter(function() {
	  		publicClasses.autoplay.stop();
	  	})
	  	.mouseleave(function() {
	  		publicClasses.autoplay.start();
	  	});
	  	
	var videosSwiper = new Swiper ('#videos.minority .swiper-container', {
	 	autoplay: { disableOnInteraction: false },
	    loop: true
  	});
  	$("#videos .swiper-slide")
	  	.mouseenter(function() {
	  		videosSwiper.autoplay.stop();
	  	})
	  	.mouseleave(function() {
	  		videosSwiper.autoplay.start();
	  	});
	  	
	// If the blank area on the right is greater than browser's height.
	$("#center-left").imagesLoaded().progress(function(instance, image) {
		let _offsetTop = 20;
		if ($("#center-left").height()-$("#center-right").height() > $(window).height()) {
			
			// A hero from minority, is going to fill the blank.
			var $sticker = $(".minority.sticker");
			$("#center-right").append(
				$('<div id="route-of-hero"></div>')
					.height($("#center-left").height()-$("#center-right").height())
					.append($sticker.clone().addClass("sticky"))
			);
			$(".minority.sticky").stick_in_parent({offset_top:_offsetTop});
			
			$("#route-of-hero").waypoint({
			  	handler: function(direction) {
			  		if (direction == "down") {
				  		// hide sticky minority module.
				  		$("#route-of-hero").addClass("active");
			  		}
			  		else if (direction == "up") {
				  		// show sticky minority module.
				  		$("#route-of-hero").removeClass("active");
			  		}
			  	},
			  	offset: _offsetTop
			});
		}
	});
});

/* 2-up-vertical module for "itsource.cn"(PC) END */