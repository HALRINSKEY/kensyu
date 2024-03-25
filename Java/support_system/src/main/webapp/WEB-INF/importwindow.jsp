<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>インポート</title>
<link rel="stylesheet" href="./css/style_search.css">
</head>

<body>
	<header>
		<img src="./img/header_icon.png"/>
		<p>故障修理支援Webシステム</p>
		<div class="left">
			<div class="user_name">
				<p><c:out value="${user_name}"/></p>
			</div>
			<form class="logout" action="Index" method="post">
				<button type="submit">ログアウト</button>
			</form>
		</div>
	</header>

	<div class="container">
		<div class="import_container">
			<p>データインポート</p><br>

			<form  class="import" action="ImportWindow" method="post" enctype="multipart/form-data">
				<label for="import">故障修理データ（CSVファイル）</label><br>
				<div class="file_input">
				<label class="import_label" for="import"><span id="file-selected"></span></label><input type="file"name="csv_file" id="import"/><label for="import"><img src="./img/file_icon.png"></label><br>
				</div>
				<div class="btn">
				<button type="submit">インポート</button>
				</div>
			</form>
		</div>
	
	
		<div class="menu">
			<form class="change" action="ChangeSearchWindow" method="post">
				<button type="submit" id="change_search">故障情報検索</button>
			</form>
		
			<form class="change" action="ChangeImportWindow" method="post">
				<button type="submit" id="change_import">データインポート</button>
			</form>
		</div>
	</div>
	
<script src="./js/jquery.min.js"></script>
 <script>
	$('#import').bind('change', function () { var fileName = ''; fileName = $(this).val(); $('#file-selected').html(fileName); })
</script>
</body>
</html>