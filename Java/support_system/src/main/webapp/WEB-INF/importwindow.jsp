<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>インポート画面</title>
</head>
<body>
</head>

<body>
	<div class="container">
		<h1>file import</h1>

		<form  class="import" action="ImportWindow" method="post" enctype="multipart/form-data">
			
			<label for="member_id">故障修理データ（CSVファイル）</label><input type="file"name="csv_file" />
			<button type="submit">インポート</button>
			
		</form>
	</div>

</body>
</html>