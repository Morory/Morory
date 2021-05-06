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
	최대값 :
	<c:if test="${ param.NUM1 - param.NUM2 >= 0 }">
		${ param.NUM1 }
	</c:if>
	<c:if test="${ param.NUM1 - param.NUM2 < 0 }">
		${ param.NUM2 }
	</c:if>
</body>
</html>
<!-- http://localhost:8085/Myjsp/ch13/ch1303Maximum.jsp?NUM1=87&NUM2=57-->