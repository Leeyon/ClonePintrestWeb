<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ClonePintrest图片分享站</title>
<link rel="stylesheet" href="static/css/app.css" type="text/css" />
<script type="text/javascript" src="static/js/dev/jquery-2.1.1.js"></script>
<script type="text/javascript" src="static/js/dev/imagesloaded.pkgd.js"></script>
<script type="text/javascript" src="static/js/dev/masonry.pkgd.js"></script>
<script type="text/javascript"
	src="static/js/dev/jquery.infinitescroll.js"></script>
<script type="text/javascript" src="static/js/dev/jquery-ui.js"></script>
<script type="text/javascript" src="static/js/dev/app.js"></script>
</head>
<body>
	<div id="appHeader">
		<div style="min-width: 1024px; margin: 0px 10px;">
			<div id="siteTitle">ClonePintrest 图片分享站</div>
			<div id="siteLogin">登录</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<div id="appBody">
		<div style="min-width: 1024px; margin: 0px 10px;">
			<div id="container">
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/1.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/2.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/3.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/2.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/3.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/4.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/5.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/6.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/4.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/5.jpg">
					</img>
				</div>
				<div class="item">
					<img
						src="http://tympanus.net/Development/GridLoadingEffects/images/6.jpg">
					</img>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			//alert("start");

			//加载Massonry
			var $container = $('#container');

			var _columnWidth = $container.outerWidth() / 5

			$container.masonry();
			
			$container.imagesLoaded(function() {
				$container.masonry({
					columnWidth : _columnWidth,
					itemSelector : '.item',
				});
			});

		});
	</script>

</body>
</html>