/*!h5CustomValidityKeel
 * A EVERY easy HTML5 validation message customizer. 
 * @version 0.1.2 2019.06.19
 * 0.1.0 非常简单的HTML5表单验证信息自定义工具，只需要在HTML标签中给from的属性"custom-validity-keel"(总)和input的属性"custom-validity"(分)添加一个JSON格式的键值对，对应validity中的键值对。
 * 0.1.1 修改初始化的事件：("[type='submit']").one("click" -> ("[type='submit']").ready
 * 0.1.1 添加radio例外。
 * 0.1.2 已可用于textarea。
 * @author Liuyiyu
 */

$(function() {
	let allocateValidationMessage = function($input, messages) {
		for(let key in messages.validity) {
			if ($input.get(0).validity[key]) {
				// Setup validation message.
				$input.get(0).setCustomValidity(messages.validity[key]);
				// Setup placeholder text.
				if(messages.placeholder) {
					if(messages.placeholder == "sync") {
						$input.attr({"placeholder":messages.validity[key]});
					}
					else {
						$input.attr({"placeholder":messages.placeholder[key]});
					}
				}
				break;
			}
			else {
				$input.get(0).setCustomValidity("");
			}
		}
	}
	$("form[custom-validity-keel]").each(function() {
		let $form = $(this);
		let generalMessages = JSON.parse($form.attr("custom-validity-keel")||"{}");
		
		$form.find("input[custom-validity], textarea").each(function() {
			let $input = $(this);
			let messages = $.extend(true, {}, generalMessages, JSON.parse($(this).attr("custom-validity")||"{}"));

			// Initilize checking...
			$form.find("[type='submit']").ready(function() {
				allocateValidationMessage($input, messages);
			});
			
			// Normalize checking...
			$input.on("blur input", function() {
				allocateValidationMessage($input, messages);
			});
			// Add an exception for radio.
			if ($input.attr("type") == "radio") {
				$("input[type='radio'][name='"+$input.attr("name")+"']").on("click", function() {
					$input.get(0).setCustomValidity("");
				});
			}
		});
	});
});