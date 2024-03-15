<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>登録完了画面</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <h1>登録完了画面</h1>
      <fieldset>
        <legend>以下の商品を登録しました</legend>
        <div class="con">
          <p class="prop">商品ID：</p>
          <p class="val"><c:out value="${itemBean.itemID}" /></p>
        </div>
        <div class="con">
          <p class="prop">商品名：</p>
          <p class="val"><c:out value="${itemBean.itemName}" /></p>
        </div>
        <div class="con">
          <p class="prop">価格：</p>
          <p class="val"><fmt:formatNumber value="${itemBean.itemPrice}" /></p>
        </div>
      </fieldset>
      <p></p>
    <a href="Register">登録画面に戻る</a>
  </body>
</html>

