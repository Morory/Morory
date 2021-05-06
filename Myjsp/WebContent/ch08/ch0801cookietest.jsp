<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				out.println(cookies[i].getName() + "<br />");
				out.println(cookies[i].getValue() + "<br />");
			}
		}
	%>
	
	<br><br>
	<a href="ch0801cookieset.jsp">cookie set</a>
</body>
</html>