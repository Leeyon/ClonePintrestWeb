<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

				<c:choose>

					<c:when test="${not empty photos}">
						<c:forEach var="photoViewModel" items="${photos}">
							<div class="item">
								<img src="${photoViewModel.thumbnailPath}" />
								<div class="itemText">由${photoViewModel.userDisplayName}分享</div>
							</div>
						</c:forEach>
						
						<script type="text/javascript">
						$(function() {
							//alert("start");
							var _data;

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

							var $loginBtn = $("#siteLogin");

							$loginBtn.click(_data, function() {
								window.location.href = "login.html";
							});

						});
					</script>
						
					</c:when>

					

					<c:otherwise>
					
					<div id="errorPageText">尚未上传任何照片哦</div>
					
					<script type="text/javascript">
						$(function() {
							//alert("start");
							var _data;

							var $loginBtn = $("#siteLogin");

							$loginBtn.click(_data, function() {
								window.location.href = "login.html";
							});

						});
					</script>
					
					
				</c:otherwise>

				</c:choose>

			</div>
		</div>
	</div>


</body>
</html>