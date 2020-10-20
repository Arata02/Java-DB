<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>赤坂見附</p>
<% for(int i = 1; i < 6; i++) {
			out.println("<p>赤坂見附" + i + "回</p>");
			}
		%>

<%! String getDate(){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	return sdf.format(new Date());
	}
	%>

	<p>本日は<%=getDate() %>です.</p>

	<p>ここに埋め込みます</p>

	<%@include file = "Ex72.jsp" %>

	<p>ここまで</p>
</body>
</html>