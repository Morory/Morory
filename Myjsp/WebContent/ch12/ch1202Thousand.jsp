<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int sum = 0;
	for (int cnt = 1; cnt <= 1000; cnt++)
		sum += cnt;
	//pageContext.setAttribute("RESULT", new Integer(sum));
	pageContext.setAttribute("RESULT", 123);
	request.setAttribute("RESULT", sum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1부터 1000까지 더한 결과는? ${RESULT}
</body>
</html>