<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex81.jsp</title>
</head>
<body>
<table border="1">
	<tr>
		<td>year</td>
		<td><%=request.getParameter("year") %></td>
	</tr>
	<tr>
		<td>month</td>
		<td><%=request.getParameter("month") %></td>
	</tr>
	<tr>
		<td>day</td>
		<td><%=request.getParameter("day") %></td>
	</tr>
</table>
</body>
</html>