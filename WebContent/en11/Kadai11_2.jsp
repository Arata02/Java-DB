<%@page import="en11.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kadai11_2</title>
</head>
<body>
<h3>Ex11_2.jsp</h3>
<%
	Item item = (Item)request.getAttribute("item");
%>

<p><%=item.toString() %></p>
</body>
</html>