<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細表示</title>
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
	
		<div class="result_detail">
			<div class="title">
			<p>詳細表示</p>
			</div>

			<div class="detail_info">
			<p>受付番号：<c:out value="${detailBean.order_id}"/></p>
			<p>受付日：<c:out value="${detailBean.order_date}"/></p>
			<p>修理完了日：<c:out value="${detailBean.end_date}"/></p>
			<p>品名：<c:out value="${detailBean.product_name}"/></p>
			<p>品名コード：<c:out value="${detailBean.product_code}"/></p>
			<p>シリアルNO：<c:out value="${detailBean.serial_no}"/></p>
			</div>
			<div class="detail_container">
			<p>故障状況</p>
			<p><c:out value="${detailBean.out_state}"/></p>
			<p>弊社確認事項</p>
			<p><c:out value="${detailBean.check_state}"/></p>
			<p>修理内容</p>
			<p><c:out value="${detailBean.repair_detail}"/></p>
			<p>異常処置内容</p>
			<p><c:out value="${detailBean.disorder_repair}"/></p>
			</div>
			<div class="back_btn">
			<a href="javascript:history.back();">戻る</a>
			</div>
		</div>

	<div class="menu">
		<form class="change">
			<button type="submit" id="change_search">故障情報検索</button>
		</form>

		<form class="change" action="ChangeImportWindow" method="post">
			<button type="submit" id="change_import">データインポート</button>
		</form>
	</div>
	
	</div>
</body>
</html>