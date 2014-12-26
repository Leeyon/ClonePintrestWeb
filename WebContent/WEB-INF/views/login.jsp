<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle}</title>
<link rel="stylesheet" href="static/css/login.css" type="text/css" />
<link rel="stylesheet" href="static/css/app.css" type="text/css" />
<script type="text/javascript" src="static/js/dev/jquery-2.1.1.js"></script>
</head>
<body>
	<div id="appHeader">
		<div style="min-width: 1024px; margin: 0px 10px;">
			<div id="siteTitle">ClonePintrest 图片分享站</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<div id="appBody">
		<div style="min-width: 1024px; margin: 0px 10px;">
			<div id="container">
				<div id="loginPageContainer">
					<div id="loginArea">
						<div class="sectionTitle">用户登录</div>
						<div class="textItem">
							<div class="textFloat textTitle">用户名：</div>
							<input id="txtLoginName" class="textFloat textInput" type="text" />
							<div style="clear: left;"></div>
						</div>
						<div class="textItem">
							<div class="textFloat textTitle">密码：</div>
							<input id="txtLoginPass" class="textFloat textInput"
								type="password" />
							<div style="clear: left;"></div>
						</div>
						<div class="btnItem">
							<input id="btnLogin" class="btn" type="button" value="登录" />
						</div>
					</div>
					<div id="registerArea">
						<div class="sectionTitle">用户注册</div>
						<div class="textItem">
							<div class="textFloat textTitle">用户名：</div>
							<input id="txtRegisterName" class="textFloat textInput"
								type="text" />
							<div style="clear: left;"></div>
						</div>
						<div class="textItem">
							<div class="textFloat textTitle">昵称：</div>
							<input id="txtRegisterNickName" class="textFloat textInput"
								type="text" />
							<div style="clear: left;"></div>
						</div>
						<div class="textItem">
							<div class="textFloat textTitle">密码：</div>
							<input id="txtRegisterPass" class="textFloat textInput"
								type="password" />
							<div style="clear: left;"></div>
						</div>
						<div class="btnItem">
							<input id="btnRegister" class="btn" type="button" value="注册" />
						</div>
					</div>
					<div style="clear: left;"></div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {

			var _data;
			var _loginUrl = "Auth.html";
			var _registerUrl = "Register.html";

			var $loginBtn = $("#btnLogin");
			var $registerButton = $("#btnRegister");

			$loginBtn.click(_data, function() {

				var _name = $("#txtLoginName").val();
				var _pass = $("#txtLoginPass").val();

				$.post(_loginUrl, {
					"name" : _name,
					"pass" : _pass
				}, function(jsonData) {
					var resultObj = $.parseJSON(jsonData);
					//登录成功
					if (resultObj.apiStatus == 1) {
						window.location.href = "user.html?uid="
								+ resultObj.data.id;
					} else {
						alert(resultObj.message);
					}
				});

			});

			$registerButton.click(_data, function() {

				var _name = $("#txtRegisterName").val();
				var _pass = $("#txtRegisterPass").val();
				var _displayName = $("#txtRegisterNickName").val();

				$.post(_registerUrl, {
					"name" : _name,
					"pass" : _pass,
					"displayName" : _displayName
				}, function(jsonData) {
					var resultObj = $.parseJSON(jsonData);
					alert(resultObj.message);
				});
			});

		});
	</script>

</body>
</html>