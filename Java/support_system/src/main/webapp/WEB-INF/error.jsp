<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラーページ</title>
<link rel="stylesheet" href="./css/style_search.css">
</head>
<body>
	<header>
		<img src="./img/header_icon.png"/>
		<p>故障修理支援Webシステム</p>
		<div class="left">
			<form class="logout" action="Index" method="post">
				<button type="submit">ログアウト</button>
			</form>
		</div>
	</header>
	
	<div class="error_container">
		<div class="error_title">
			<p>エラーページ</p>
		</div>
		<div class="error_msg">
        	<p><c:out value="${error_msg}"/></p>
        </div>
        <div class="back_btn">
			<a href="javascript:history.back();">戻る</a>
		</div>
	</div>
</body>
</html>