<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ClonePintrest图片分享站</title>
<link rel="stylesheet" href="static/css/login.css" type="text/css" />
<link rel="stylesheet" href="static/css/app.css" type="text/css" />
<script type="text/javascript" src="static/js/dev/jquery-2.1.1.js"></script>
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
			<div id="container" style="position:relative;">
				<form method="POST" enctype="multipart/form-data" action="/ClonePintrestWeb/upload.html">
					File to upload: <input type="file" name="file"><br />
					Name: <input type="text" name="name"><br /> <br /> <input
						type="submit" value="Upload"> Press here to upload the
					file!
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			//alert("start");
			var _data;

		});
	</script>

</body>
</html>