<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	안녕하세요, <c:out value="${param.ID}" default="guest" />님
</body>
</html>
<!-- http://localhost:8085/Myjsp/ch13/ch1302Heelo.jsp -->
<!-- http://localhost:8085/Myjsp/ch13/ch1302Hello.jsp?ID=lts -->