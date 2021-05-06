<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" name="delForm" action="/Myjsp/BoardController?cmd=delete&sub=do&num=${ param.num }&page=${ param.page }">
		<table>
			<tr>
				<td><b>비밀번호를 입력해 주세요.</b></td>
			</tr>
			<tr>
				<td>
				<input type="password" name="passwd">
				<input type="hidden"   name="num" value=${ num }>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="글삭제">
					<input type="button" value="글목록"
					 onclick="document.location.href='/Myjsp/BoardController?cmd=list&page=${ param.page }'">
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>