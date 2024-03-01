<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>登録画面</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<h1>登録画面</h1>
	<form action="RegisterConfirm.html" method="post">
		<fieldset>
			<legend>商品を登録してください</legend>
			<div class="reg">
				<label>商品ID：</label><input type="text" name="itemID" />
			</div>
			<div class="reg">
				<label>商品名：</label><input type="text" name="itemName" />
			</div>
			<div class="reg">
				<label>価格(円)：</label><input type="number" value="0" step="100"
					name="itemPrice" />
			</div>
			<button type="submit">送信</button>
		</fieldset>
	</form>
</body>
</html>
