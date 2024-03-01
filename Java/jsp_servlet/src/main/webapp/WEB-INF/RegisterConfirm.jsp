<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>登録確認画面</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <h1>登録確認画面</h1>
    <form action="RegisterComplete.html" method="post">
      <fieldset>
        <legend>商品を確認してください</legend>
        <div class="con">
          <p class="prop">商品ID：</p>
          <p class="val">001</p>
        </div>
        <div class="con">
          <p class="prop">商品名：</p>
          <p class="val">商品1</p>
        </div>
        <div class="con">
          <p class="prop">価格：</p>
          <p class="val">5,500円</p>
        </div>
        <button type="submit">確定する</button>
      </fieldset>
    </form>
    <button onclick="history.back()">戻る</button>
  </body>
</html>
