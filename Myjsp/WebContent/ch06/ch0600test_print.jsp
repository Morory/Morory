<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>print page</title>
</head> 
<body>
<%
	@SuppressWarnings("unchecked")
	HashMap<String, Object> hm = (HashMap<String, Object>)request.getAttribute("hm");

	@SuppressWarnings("unchecked")
 	HashMap<String, Object> stu1 = (HashMap<String, Object>)hm.get("student1");
	
	@SuppressWarnings("unchecked")
 	HashMap<String, Object> stu2 = (HashMap<String, Object>)hm.get("student2");
%>
1번 학생<br>
학번 = <%= stu1.get("code") %> , 성명 = <%= stu1.get("name") %> , 학점 = <%= stu1.get("grade") %><br><br>
2번 학생<br>
학번 = <%= stu2.get("code") %> , 성명 = <%= stu2.get("name") %> , 학점 = <%= stu2.get("grade") %><br><br>

건수 = <%= hm.get("cnt") %> , 총점 = <%= hm.get("total") %> , 평균 = <%= hm.get("avg") %>
</body>
</html>