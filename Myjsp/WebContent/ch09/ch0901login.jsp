<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="login" class="ch09.Ch0901LoginBean" scope="page" />
<!-- ch09.Ch0901LoginBean login = new ch09.Ch0901LoginBean(); -->
<!--  -->
<jsp:setProperty name="login" property="*" />

<!-- 
<jsp:setProperty name="login" property="userid" param="userid" />
 -->
 <!-- login.setUserid(request.getParameter("userid")); -->
<!-- 
<jsp:setProperty name="login" property="passwd" param="passwd" />
 -->
<html>
<head>
<meta charset="UTF-8">
<title>ch09 : login.jsp</title>
</head>
<body>
<div align=center>
<h2>로그인 예제</h2>
<hr>
<%
	if(!login.checkUser()) {
		out.println("로그인 실패 !!");
	}
	else {
		out.println("로그인 성공 !!");
	}
%>

<hr>
사용자 아이디 : <jsp:getProperty name="login" property="userid" /><br>
<!-- login.getUserid(); -->
사용자 패스워드 : <jsp:getProperty name="login" property="passwd" />
</div>

</body>
</html>