<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラーページ</title>
</head>
<body>
<header>
	<p><c:out value="${user_name}"/></p>
		
	<form class="logout" action="Index" method="post">
		<button type="submit">ログアウト</button>
	</form>
</header>

<body>
		<h1>eroor page</h1>
        <p><c:out value="${error_msg}" /></p>
        <a href="javascript:history.back();">戻る</a>
</body>
</html>