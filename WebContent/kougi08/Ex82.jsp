<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex82.jsp</title>
</head>
<body>
	<h3>Ex82.jsp</h3>
    <ul>
        <li>1行テキスト：<%=request.getParameter("text1")%></li>
        <li>パスワード：</li>
        <li>テキストエリア：</li>
        <li>ラジオボタン：<br>
        <input type="radio" name="radio1" value="apple" checked>りんご<br>
        <input type="radio" name="radio1" value="orange" checked>みかん
	<li>チェックボックス：<ul>
	<%
	String[] check = request.getParameterValues("check1");
	for(int i = 0; i < check.length; i++){
		out.println("<li>" + check[i] + "</li>");
	}
%></ul>
        <li>選択ボックス：</li>
    </ul>
   <%
   String str = request.getParameter("text1");
   if(str.equals("こんにちは")){
   out.println("こんにちは！<br>");
   }else{
   out.println("分かりません!<br>");
   }%>　NXZVC
</body>
</html>