<%@page import="bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.EmployeeDispAllBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=bean.getLoginInfo() %><br>
実行結果<br><br>
<table border=1>
<tr>
<th> EmployeeID     </th>
<th> EmployeeName   </th>
<th> Height         </th>
<th> Email          </th>
<th> Weigh          </th>
<th> HireFiscalYear </th>
<th> Birthday       </th>
<th> BloodType      </th>
</tr>

<%
	for( EmployeeBean emp: bean.geteList()){
%>

<tr>
 <td align="center"> <%=emp.getEmployeeID() %>     </td>
 <td align="center"> <%=emp.getEmployeeName() %>   </td>
 <td align="center"> <%=emp.getHeight() %>         </td>
 <td align="center"> <%=emp.geteMail() %>          </td>
 <td align="center"> <%=emp.getWeight() %>         </td>
 <td align="center"> <%=emp.getHireFiscalYear() %> </td>
 <td align="center"> <%=emp.getBirthday() %>       </td>
 <td align="center"> <%=emp.getBloodType() %>      </td>
</tr>

<%}%>
</table>
</body>
</html>