<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
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
		<div class="search">
			<div class="search_input">
	    		<p>故障情報検索</p>

	    		<form action="SearchWindow" method="get">

					<c:set var="inputBean" value="${inputBean}"/>

					<div class="short_input">
					<label for="order_date">受付期間</label>		<input type="date"name="order_date_start" value="${inputBean.order_date_start}"/> <span>~</span> <input type="date"name="order_date_end" value="${inputBean.order_date_end}"/><br>
					<label for="end_date">修理完了期間</label>		<input type="date"name="end_date_start" value="${inputBean.end_date_start}"/> <span>~</span> <input type="date"name="end_date_end" value="${inputBean.end_date_end}"/><br>
					<label for="order_id">受付番号</label>			<input type="text"name="order_id" value="${inputBean.order_id}"/><br>
					<label for="product_code">品名コード</label>	<input type="text"name="product_code" value="${inputBean.product_code}"/><br>
					<label for="product_name">品名</label>			<input type="text"name="product_name" value="${inputBean.product_name}"/><br>
					<label for="serial_no">シリアルNO</label>		<input type="text"name="serial_no" value="${inputBean.serial_no}"/><br>
					</div>
					<div class="long_input">
					<label for="out_state">故障状況</label>			<input type="text"name="out_state" value="${inputBean.out_state}"/><br>
					<label for="check_state">弊社確認事項</label>	<input type="text"name="check_state" value="${inputBean.check_state}"/><br>
					<label for="repair_detail">修理内容</label>		<input type="text"name="repair_detail" value="${inputBean.repair_detail}"/><br>
					<label for="disorder_repair">以上処置内容</label><input type="text"name="disorder_repair" id="repair" value="${inputBean.disorder_repair}"/><br>
					</div>
					<div class="btn">
					<button type="submit">検索</button>
					</div>

				</form>
			</div>

			<div class="result">
			<!--検索結果-->
				<c:set var="count" value="${resultCount}"/>
				<c:if test="${count != null}">
					<div class="count">
					<p>検索結果</p>
					<div class="countnum"><p><c:out value="${count}"/>件</p></div>
					</div>
				</c:if>

				<c:forEach var="result" items="${resultList}" varStatus="status">

					<form class="detail" action="DetailWindow" method="post">

					<div class="result_list">
					<p>受付番号：<c:out value="${result.order_id}" /></p>
					<p>品名：<c:out value="${result.product_name}"/></p>
					<p>受付日：<c:out value="${result.order_date}"/></p>
					<p>修理完了日：<c:out value="${result.end_date}"/></p>
					<p class="detail">故障状況：<c:out value="${result.out_state}"/></p>
					</div>

					<input type="hidden" name="order_id" value="${status.current.order_id}"/>
						<div class="btn_result">
						<button type="submit">詳細</button>
						</div>
					</form>

					<br>

				</c:forEach>
			</div>
			
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

</body>
</html>