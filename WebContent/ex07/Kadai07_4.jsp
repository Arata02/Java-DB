<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Calendar" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Kadai07_04.jsp</p>
<p>誕生日：1996年11月28日</p>
<%
int year = 1996;
int month = 11;
int day = 28;
int year_today;
int month_today;
int day_today;
int pAge;

    Calendar calendar = Calendar.getInstance();
    year_today = calendar.get(Calendar.YEAR);
    month_today = calendar.get(Calendar.MONTH) + 1;
    day_today = calendar.get(Calendar.DAY_OF_MONTH);

    pAge = (year_today - year) - 1;
    if(month_today < month) -- pAge;

    else{
        if(month_today == month){
            if(day < day_today) -- pAge;
        }
    }

%>

<%! String getDate(){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	return sdf.format(new Date());
	}
	%>

<p>本日は<%=getDate() %>現在で<%=pAge %>歳です!</p>
</body>
</html>