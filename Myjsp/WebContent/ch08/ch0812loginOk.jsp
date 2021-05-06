<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id, pw;
	%>
	
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		if("abcde".equals(id) && "12345".equals(pw)) {
			session.setAttribute("id", id);
			response.sendRedirect("ch0812welcome.jsp");
		} else {
			response.sendRedirect("ch0812login.html");
		}
	%>
</body>
</html>