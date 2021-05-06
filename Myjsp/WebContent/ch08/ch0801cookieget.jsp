<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Cookie[] cookies = request.getCookies();
	
		for(int i=0; i<cookies.length; i++) {
//			String str = cookies[i].getName();
//			if(str.equals("cookieN")) {
//				out.println("cookies[" + i + "] name : " + cookies[i].getName() + "<br />");
//				out.println("cookies[" + i + "] value : " + cookies[i].getValue() + "<br />");
//				out.println("=================<br />");
//			}
			
			out.println("cookies[" + i + "] name : " + cookies[i].getName() + "<br />");
			out.println("cookies[" + i + "] value : " + cookies[i].getValue() + "<br />");
			out.println("=========================<br />");
		}
	%>
	
	<br><br>
	<a href="ch0801cookiedel.jsp">cookie delete</a>
</body>
</html>