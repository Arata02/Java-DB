<%@page import="kougi11.Exam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex11_1.jsp</title>
</head>
<body>
<h3>Ex11_1.jsp</h3>

<%
	Exam ex = (Exam)request.getAttribute("ex");
%>

<p><%=ex.getName()%>, 点数=<%=ex.getPoint() %>, 評価=<%=ex.getResult() %></p>

</body>
</html>