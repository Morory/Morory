<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
<script type="text/javascript" src="input.js"></script>
</head>
<body>
	<h3>성적등록</h3>
	<form method="post" name="inputform" action="/Myjsp/GradeController?cmd=input&sub=do" onsubmit="return writeSave()">
		<table>
			<tr>
				<td width="150">코드</td>
				<td width="150">성명</td>
				<td width="150">점수</td>
			</tr>
			<tr>
				<td><input type="text" name="code"></td>
				<td><input type="text" name="name"></td>
				<td><input type="text" name="score"></td>
			</tr>
			<tr>
				<td colspan=2>
				<input type="submit" value="등록">
				<input type="reset"  value="다시작성">
				<input type="button" value="성적조회"
				onclick="document.location.href='/Myjsp/GradeController?cmd=check'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>