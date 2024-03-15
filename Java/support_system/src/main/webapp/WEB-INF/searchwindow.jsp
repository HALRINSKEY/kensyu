<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
</head>

<body>

    <h1>SearchWindow</h1>

    <form action="SearchWindow" method="get">
			
		<label for="order_date">受付期間</label>		<input type="date"name="order_date_start"/> ~ <input type="date"name="order_date_end"/><br>
		<label for="end_date">修理完了期間</label>		<input type="date"name="end_date_start"/> ~ <input type="date"name="end_date_end"/><br>
		<label for="order_id">受付番号</label>			<input type="text"name="order_id"/><br>
		<label for="product_code">品名コード</label>	<input type="text"name="product_code"/><br>
		<label for="product_name">品名</label>			<input type="text"name="product_name"/><br>
		<label for="serial_no">シリアルNO</label>		<input type="text"name="serial_no"/><br>
		<label for="out_state">故障状況</label>			<input type="text"name="out_state"/><br>
		<label for="check_state">弊社確認事項</label>	<input type="text"name="check_state"/><br>
		<label for="repair_detail">修理内容</label>		<input type="text"name="repair_detail"/><br>
		<label for="disorder_repair">以上処置内容</label><input type="text"name="disorder_repair"/><br>

		<button type="submit">検索</button>
		
	</form>

	<c:forEach var="result" items="${resultList}" varStatus="status">
		<p>受付番号：<c:out value="${result.order_id}"/></p>
		<p>品名：<c:out value="${result.product_name}"/></p>
		<p>受付日：<c:out value="${result.order_date}"/></p>
		<p>修理完了日：<c:out value="${result.end_date}"/></p>
		<p>故障状況：<c:out value="${result.out_state}"/></p>

		
		<form class="detail" action="DetailWindow" method="post">
			<button type="submit">詳細</button>
		</form>

		<br>

	</c:forEach>
	
	<form class="change" action="ChangeWindow" method="post">
		<button type="submit">データインポート</button>
	</form>

</body>
</html>