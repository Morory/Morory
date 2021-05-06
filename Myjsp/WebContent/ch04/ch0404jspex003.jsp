<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%!
	public Date getDate() {
		Date dt = new Date();
		return dt;
	}
%>
<%
	Date dt = getDate();
//	java.util.Date now = new java.util.Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재시각</title>
</head>
<body>
현재시각 : <%= dt %>
</body>
</html>