<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ログインフォーム</title>

<style>
body{
    background-color: #f0f0f0;
}

h1{
    text-align: center;
    font-size: 24px;
}

.msg{
    text-align: center;
}

.container{
    width: 800px;
    background-color: white;
    margin: 50px auto;
    border: 1px solid #000;
    padding: 30px;
}

form{
    width: 50%;
    margin: auto;
}

input{
	width: 380px;
    font-size: 16px;
    padding: 8px;
	margin: 0px auto;
}

button{
    width: 100%;
    background-color: #2096f3;
    color: #fff;
    padding: 12px;
    margin: 10px auto;
    border-radius: 3px;
    box-shadow: 0 0 8px rgba(0, 0, 0, .4);
    font-size: 16px;
}

</style>

</head>
<body>
	<div class="container">
		<h1>社員ID入力</h1>
		<p class="msg">
			※管理者は、<b>0000</b>と入れてください。
		</p>
		<form  class="inputbox" action="Member" method="post">
			
				<label for="member_id">社員ID：</label> <input type="text"
					name="member_id" />
				<br>
				<label for="password">パスワード：</label> <input type="password"
				name="password" />
				<button type="submit">ログイン</button>
			
		</form>
	</div>
</body>
</html>
