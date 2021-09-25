/*!popupKeel
 * A EVERY easy popup structure builder. 
 * @version 0.1.0 2019.04.10
 * 0.1.0 非常简单的弹出结构，只需要在HTML标签中添加"popup-source-keel"属性, 或添加一个含有"popup-keel"属性的标签。
 * 0.2.0 pupup-source-keel和pupup-source用JSON作为属性值。
 * 0.2.0 增加了两个回调方法：afterPopup和beforeClose。
 * @author Liuyiyu
 */

 $("body").append(
	'<style>'+
		'#popup-persistent-source-set {'+
			'display: none'+
		'}'+
		'[popup-keel] {'+
		  	'position: fixed;'+
		  	'width: 100%;'+
		  	'height: 100vh;'+
		  	'left: 0;'+
		  	'top: 0;'+
		  	'display: none;'+
		'}'+
		'[popup-keel] interlayer {'+
		  	'width: inherit;'+
		  	'height: inherit;'+
		  	'display: flex;'+
		'}'+
		'[popup-keel] wrapper {'+
		  	'display: flex;'+
		'}'+
		'[popup-keel] close, [popup-source] {'+
		  	'cursor: pointer;'+
		'}'+
	'</style>'
 );
$(function() {

	var defaultPupupSourceKeelOpts = {
		type: "instant",
		fadeInSpeed: 100,
		fadeOutSpeed: 100,
		afterFadeIn: null,
		beforeFadeOut: null 
	}
	
	// Add popup-persistent-source-set if body dont have one.
	// Better add this DOM manually.
	if ($("#popup-persistent-source-set").length == 0) {
		$("body").append('<div id="popup-persistent-source-set"></div>');
	}
	
	let popupNames = [];
	
	// Set up popup keels.
	$("[popup-source]").each(function() {
		
		let popupSourceKeelOpts, _popupSourceKeelOpts, popupSourceOpts, _popupSourceOpts;
		
		// Find keel opts on self.
		_popupSourceKeelOpts = $(this).attr("popup-source-keel");
		// Find keel opts on parent.
		if (!_popupSourceKeelOpts) {
			_popupSourceKeelOpts = $(this).parent().attr("popup-source-keel");
		}
		// Get opts.
		try {
			// popup-source-keel={"name":"yourName",...}
			popupSourceKeelOpts = JSON.parse(_popupSourceKeelOpts);
		} catch(e) {
			// popup-source-keel="yourName"
			popupSourceKeelOpts = {"name": _popupSourceKeelOpts};
		} finally {
			// Merge opts.
			popupSourceKeelOpts = $.extend({}, defaultPupupSourceKeelOpts, popupSourceKeelOpts);
		}
		
		// Check duplicate.
		if (popupNames.indexOf(popupSourceKeelOpts.name) < 0) {
			popupNames.push(popupSourceKeelOpts.name);
			// Add real popup keel to body.
			$("body").append('<div popup-keel="'+popupSourceKeelOpts.name+'"><interlayer><wrapper><content></content><close></close></wrapper></interlayer></div>');
		}
		
		// Find source opts on self.
		_popupSourceOpts = $(this).attr("popup-source");
		// Get opts.
		try {
			// popup-source={"source":"yourSource",...}
			popupSourceOpts = JSON.parse(_popupSourceOpts);
		} catch(e) {
			// popup-source="yourSource"
			popupSourceOpts = {"source": _popupSourceOpts};
		} finally {
			// Merge opts.
			popupSourceOpts = $.extend({}, popupSourceKeelOpts, popupSourceOpts);
		}
		console.log(popupSourceOpts);
		
		// Add open popup event listener.
		let $popupKeel = $("[popup-keel='"+popupSourceKeelOpts.name+"']");
		let $close$popupKeel = $popupKeel.find("close").andSelf();
		$(this).on("click", function() {
			
			// Eval source cloning...
			eval('$popupKeel.find("content").append(' + popupSourceOpts.source + ')');
			
			// Add custom close function to popup keel.
			$close$popupKeel.unbind().on("click", function() {
				// Eval extra function...
				eval(popupSourceOpts.beforeFadeOut);
				
				$popupKeel.fadeOut(popupSourceOpts.fadeOutSpeed, function() {
					
					if (popupSourceOpts.type == "persistent") {
						$("#popup-persistent-source-set").append($popupKeel.find("content").children());
					}
					// Use "instant" by default.
					else {
						$popupKeel.find("content").empty();
					}
				});
			});
			$popupKeel.find("content")
			
			// Open keel.
			$popupKeel.fadeIn(popupSourceOpts.fadeInSpeed, function() {
				// Eval extra function...
				eval(popupSourceOpts.afterFadeIn);
			});
		});
	});
	
	// Add close popup event listener fix.
	$("[popup-keel] content").on("click" ,function(event) {
		event.stopPropagation();
	});
});