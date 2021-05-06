<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${param.NAME}의 주소는? ${ADDRESS[param.NAME]} <br>
	<%= request.getParameter("NAME") %>의 주소는? 
	<% 
		@SuppressWarnings("unchecked")
		HashMap<String, String> address = (HashMap<String, String>)request.getAttribute("ADDRESS");
	%>
	<%= address.get("Thomas") %>
	<br>
	${param.NAME}의 주소는? ${ADDRESS.Thomas} <br>
	${param.NAME}의 주소는? ${ADDRESS["Thomas"]} <br>
</body>
</html>