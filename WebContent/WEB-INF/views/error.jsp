<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出错了</title>
<link rel="stylesheet" href="static/css/login.css" type="text/css" />
<link rel="stylesheet" href="static/css/app.css" type="text/css" />
<script type="text/javascript" src="static/js/dev/jquery-2.1.1.js"></script>
</head>
<body>
	<div id="appHeader">
		<div style="min-width: 1024px; margin: 0px 10px;">
			<div id="siteTitle" class="hover">ClonePintrest图片分享站</div>
			<div id="menuItems"></div>
			<div style="clear: both"></div>
		</div>
	</div>
	<div id="appBody">
		<div style="min-width: 1024px; margin: 0px 10px;">
			<div id="container">
				<div id="errorPageContainer">
					<div id="errorPageText">
						<b>${errorMessage}，请<a href="javascript:history.back();">返回</a></b>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {

			var _data;

			var $siteTitle = $("#siteTitle");
			$siteTitle.click(_data, function() {
				window.location.href = "index.html";
			});

		});
	</script>

</body>
</html>