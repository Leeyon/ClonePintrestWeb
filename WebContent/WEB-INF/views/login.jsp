<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle}</title>
<link rel="stylesheet" href="static/css/login.css" type="text/css" />
<script type="text/javascript" src="static/js/dev/jquery-2.1.1.js"></script>
</head>
<body>
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
				<input id="txtLoginPass" class="textFloat textInput" type="password" />
				<div style="clear: left;"></div>
			</div>
			<div class="btnItem">
				<input id="btnLogin" class="btn" type="button" value="登录" />
			</div>
		</div>
		<div id="registerArea">
			<div class="sectionTitle">用户注册</div>
			<div class="textItem">
				<div id="txtRegistName" class="textFloat textTitle">用户名：</div>
				<input class="textFloat textInput" type="text" />
				<div style="clear: left;"></div>
			</div>
			<div class="textItem">
				<div class="textFloat textTitle">密码：</div>
				<input id="txtRegistPass" class="textFloat textInput"
					type="password" />
				<div style="clear: left;"></div>
			</div>
			<div class="btnItem">
				<input id="btnRegist" class="btn" type="button" value="注册" />
			</div>
		</div>
		<div style="clear: left;"></div>
	</div>

	<script type="text/javascript">
		$(function() {
			//alert("start");
			var _data;

			var $loginBtn = $("#btnLogin");

			$loginBtn.click(_data, function() {
				var _name = $("#txtLoginName").val();
				var _pass=$("#txtLoginPass").val();
				alert(_name+_pass);
			});

		});
	</script>

</body>
</html>