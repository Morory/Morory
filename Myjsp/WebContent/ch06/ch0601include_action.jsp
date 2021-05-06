<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ch06 : include action 테스트</title>
</head>
<body>
	<h2>include_action.jsp에서 footer.jsp 호출</h2>
	<HR>
	include_action.jsp에서 출력한 메시지 입니다.
	<BR>

	<%
		request.setAttribute("name", "이태수");
	%>
	<jsp:include page="ch0601footer.jsp">
		<jsp:param value="test@test.net" name="email" />
		<jsp:param value="000-000-0000" name="tel" />
	</jsp:include>
</body>
</html>