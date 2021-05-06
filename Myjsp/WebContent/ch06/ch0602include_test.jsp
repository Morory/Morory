<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ch06 : include 지시어 테스트</title>
</head>
<body>
	<div align="CENTER">
	<h2> include 지시어 테스트</h2>
	<hr>
	
	<%@ include file="ch0602menu.jsp" %>
	<p>
	<table>
		<tr>
			<td><font size=-1><%@include file="ch0602news.jsp" %></font></td>
			<td width="20">&nbsp;</td>
			<td><font size=-1><%@include file="ch0602shopping.jsp" %></font></td>
		</tr>	
	</table>
	</div>
</body>
</html>