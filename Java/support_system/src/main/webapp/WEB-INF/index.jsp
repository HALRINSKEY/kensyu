<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="./css/style_index.css">
</head>
<body>
</head>

<body>
	<header>
		<img src="./img/header_icon.png"/>
		<p>故障修理支援Webシステム</p>
	</header>
	<div class="container">
		<form  class="inputbox" action="SearchWindow" method="post">
			<div class="id">
				<label for="member_id">ID</label><input id="member_id" type="text"name="user_id"value="0001" maxlength="64" pattern="^[a-zA-Z0-9]+$" />
			</div>
			<br>
			<div class="pass">
				<label for="password">パスワード</label><input id="password" type="password"name="password"value="pass1"maxlength="64" pattern="^[a-zA-Z0-9]+$" />
				<div class="button">
					<input type="button" id="button" value="表示" onclick="pushHideButton();">
				</div>
			</div>
			<p><button type="submit">ログイン</button></p>
			
			
		</form>
	</div>

	<script>
      function pushHideButton() {
        var txtPass = document.getElementById("password");
        var btnPass = document.getElementById("button");
        if (txtPass.type === "text") {
          txtPass.type = "password";
          btnPass.value = "表示";
        } else {
          txtPass.type = "text";
          btnPass.value = "非表示";
        }
      }
    </script>

</body>
</html>