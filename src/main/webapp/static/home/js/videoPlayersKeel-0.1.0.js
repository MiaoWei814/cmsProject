/*!
 * A EVERY easy video player structure(for iframe) builder. 
 * @version 0.1.0 2018.12.28
 * 0.1.0 非常简单的视频播放，只需要在HTML标签中添加同值的"video-player-keel"和"video-shelf-keel"属性。
 * @author Liuyiyu
 */
$(function() {
	$("[video-player-keel]").each(function() {
		var $_videoPlayer = $(this);
		var videoPlayerName = $_videoPlayer.attr("video-player-keel");
		var videoParams = $_videoPlayer.attr("video-player-params").split(" ");
		var $_iframe = $('<iframe scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"></iframe>');
		var $_videos = $("[video-in-shelf="+videoPlayerName+"]");
		
		$_videos.on("click", function() {
			var videoArgs = $(this).attr("video-in-shelf-args").split(" ");
			
			// Concatenating real src...
			var _src = "";
			$.each(videoParams, function(index, elem) {
				_src = _src + "&" + videoParams[index] + "=" + videoArgs[index];
			});
			$_iframe.attr({
				src: $_videoPlayer.attr("video-player-src") + "?" + _src
			});
			
			$_videoPlayer.empty();
			$_videoPlayer.append($_iframe);
		});
	});
});