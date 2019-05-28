<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="error" class="bean.LoginBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<font color=red>
<%=error.getMessage() %>
</font>

<br>
<br>
ユーザー名を入力してください。

<form  method="POST" action="LoginServlet">
	ユーザーID<input name="userId" type="text" ><br>

	<input type="submit" value="ログイン">
</form>

</body>
</html>