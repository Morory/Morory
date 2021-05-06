<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ch07 : 에러페이지</title>
</head>
<body>
	<div align="center">
		<h2>처리중 문제가 발생했습니다</h2>
		<hr>
		<table>
			<tr bgcolor="pink">
				<td>관리자에게 문의해 주세요..<br> 빠른시일내 복구하겠습니다.
					<hr> <%=exception%>
					<hr>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>