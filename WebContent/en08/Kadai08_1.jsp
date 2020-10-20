<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>基本情報の表示</h3>
<table border="1">
	<tr>
		<td>名前</td>
		<td><%=request.getParameter("text1") %></td>
	</tr>
	<tr>
		<td>住所</td>
		<td><%=request.getParameter("radio1") %></td>
	</tr>
	<tr>
		<td>興味</td>
		<td><%
	String[] check = request.getParameterValues("check1");
	for(int i = 0; i < check.length; i++){
		out.println(check[i] + "<br>");
	}
%></td>
	</tr>
</table>
</body>
</html>