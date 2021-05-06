<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5장 인덱스</title>
</head>
<body>
5장의 인덱스 페이지:
<br>
memberId 파라미터 값: <%= request.getParameter("memberId") %> <br>
ctxName 파라미터 값: <%= application.getInitParameter("ctxName") %>
</body>
</html>