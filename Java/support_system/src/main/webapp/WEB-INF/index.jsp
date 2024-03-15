<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
</head>

<body>
	<div class="container">
		<h1>社員ID入力</h1>

		<form  class="inputbox" action="SearchWindow" method="post">
			
			<label for="member_id">ID</label><input type="text"name="user_id"value="0001" />
			<br>
			<label for="password">パスワード</label><input type="password"name="password"value="pass1" />
			<button type="submit">ログイン</button>
			
		</form>
	</div>

</body>
</html>