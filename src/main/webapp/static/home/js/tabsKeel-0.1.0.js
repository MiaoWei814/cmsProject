/*!tabsKeel
 * A EVERY easy tabs structure builder. 
 * @version 0.1.0 2018.12.03
 * 0.1.0 非常简单的选项卡结构，只需要在HTML标签中添加同值的"tabs-keel"和"tabs-panels-keel"属性。
 * @author Liuyiyu
 */

$(function() {
	$("body").append(
		'<style>'+
			'[tabs-keel] >.tab {'+
				'cursor: pointer;'+
			'}'+
			'[tabs-panels-keel] {'+
				'position: relative;'+
			'}'+
			'[tabs-panels-keel] >.tab-panel {'+
				'width: 100%;'+
				'height: 100%;'+
				'display: none;'+
			'}'+
			'[tabs-panels-keel] >.tab-panel.active {'+
				'display: block;'+
			'}'+
		'</style>'
	);
	$("[tabs-keel]").each(function() {
		var $_tabs = $(this);
		var _tabsName = $_tabs.attr("tabs-keel");
		var $_tabsPanels = $("[tabs-panels-keel="+_tabsName+"]");
		
		$_tabs.on("click", ">.tab", function() {
			$(this).siblings(".active").removeClass("active");
			$(this).addClass("active");
			
			if($_tabsPanels.length > 0) {
				$_tabsPanels.children(".tab-panel.active").removeClass("active");
				$_tabsPanels.children(".tab-panel").eq($(this).index("[tabs-keel="+_tabsName+"] >.tab")).addClass("active");
			}
		});
	});
});