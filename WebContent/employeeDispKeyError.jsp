<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.EmployeeDispKeyBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
if(bean.getErrorC() == 1)
{%>
<font color=red>ユーザーIDには、半角数字を入力してください。</font>
<%}else if(bean.getErrorC() == 2){%>
<font color=red>ユーザーIDは1～<%= bean.getCount() %>までの数字を入力してください。</font>
<%} %>
<br><br>
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