<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
//		Enumeration<String> enumeration = session.getAttributeNames();
//		while(enumeration.hasMoreElements()) {
//			String sName = enumeration.nextElement().toString();
//			String sValue = (String)session.getAttribute(sName);
//			
//			if(sValue.equals("abcde"))
//				session.removeAttribute(sName);
//		}
	
//		session.removeAttribute("id");		//세션은 살려두고 "id" 속성만 없애기
		session.invalidate();				//세션자체를 삭제 
	%>
	
	<a href="ch0812sessiontest.jsp">세션내용 보기</a>
</body>
</html>