<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Kadai07_1.jsp</p>
<% for(int i = 25; i <= 50; i++) {
	if(i % 3 == 0 && i % 5 != 0 ){
	out.println("<p>"+ i + "</p>");
			}
}
		%>
</body>
</html>