<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.LoginBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<%=bean.getLoginInfo() %><br>
 検索ツール
 <form  method="GET" action="KeyServlet">
 	従業員ID<input name="userid" type="text" ><br>
	<input type="submit" value="従業員表示">
</form>
<br>
全データ表示
<form  method="GET" action="AllServlet">
	<input type="submit" value="全従業員表示">
</form>

</body>
</html>