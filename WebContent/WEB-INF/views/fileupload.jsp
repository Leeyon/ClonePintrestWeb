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
			<div id="siteTitle" class="hover">ClonePintrest 图片分享站</div>
			<div id="menuItems">
				<div id="siteUserName">当前用户：${user.displayName}</div>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<div id="appBody">
		<div style="min-width: 1024px; margin: 0px 10px;">
			<div id="container">
				<div id="loginPageContainer">
					<form id="formImageUpload"  method="POST" enctype="multipart/form-data"
						action="/ClonePintrestWeb/upload.html">
						选择你要上传的文件： <input type="file" name="file" id="btnFile"/>
						<input type="hidden" name="uid" value="${user.id}"></input>
						<div>
						<input type="submit" value="上传"  id="btnSubmit"/> </div>
					</form>
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