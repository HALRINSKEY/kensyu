<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

<h1>EL</h1>
<%@ page import="beans.*"%>
<%
ItemBean itemBean = new ItemBean("001", "商品1", 5500);
request.setAttribute("itemBean", itemBean);
%>

<hr>
商品ID：<c:out value="${itemBean.itemID}" /><br>
商品名：<c:out value="${itemBean.itemName}" /><br>
価格：<fmt:formatNumber value="${itemBean.itemPrice}" />
<hr>

<p>ID(EL式):${param.id}</p>
<p>ID(JSTL使用):<c:out value="${param.id}" /></p>
<p>ID(カンマ区切り):<fmt:formatNumber value="${param.id}"  /></p>

</body>
</html>