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
			String str = cookies[i].getName();
			if("cookieN".equals(str)) {
				out.println("name : " + cookies[i].getName() + " deleted! <br />");
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	%>
	
	<br><br>
	<a href="ch0801cookietest.jsp">쿠키확인</a>
</body>
</html>