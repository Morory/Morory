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
<% 
	@SuppressWarnings("unchecked")
	HashMap<String, Object> hm = (HashMap<String, Object>)request.getAttribute("HM");

	@SuppressWarnings("unchecked")
	ArrayList<HashMap<String, Object>> cls = (ArrayList<HashMap<String, Object>>)hm.get("CLS");
	
	for (int i = 0; i <= cls.size(); i++)
	{
		HashMap<String, Object> student = (HashMap<String, Object>)cls.get(i);
		
		out.println("CODE = " + student.get("CODE") + "<br>");
		out.println("NAME = " + student.get("NAME") + "<br>");
		out.println("SCORE = " + student.get("SCORE") + "<br>");
	}
	
	out.println("CNT = " + hm.get("CNT") + "<br>");
	out.println("TOT = " + hm.get("TOT") + "<br>");
	out.println("AVG = " + hm.get("AVG") + "<br>");
%>
</body>
</html>