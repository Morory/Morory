<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<%@ page errorPage="error.jsp" %>
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name Parameter : <%= request.getParameter("name").toUpperCase() %>
<%--
	getParameter()메소드에 전달된 값이 null인데 toUpperCase()메소드를 사용하였으므로 500
	(서버 내부 에러) 발생 
	예를 들어 divide by 0등 JSP 내부에서 예외가 발생하는 경우가 해당됨
 --%>
</body>
</html>