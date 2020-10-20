<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Kadai07_2.sjsp</p>
<%
double r = 4;
double h = 7;

out.println("<p>半径4,高さ7の円錐の体積は" + (Math.PI * Math.pow(r, 2.0) * h / 3.0) + "です.</p>");

out.println("<p>半径4,高さ7の円錐の体積は" + String.format("%.2f" ,(Math.PI * Math.pow(r, 2.0) * h / 3.0)) + "です.</p>");
%>
</body>
</html>