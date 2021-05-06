<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/Myjsp/style/view.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<form method="post" name="updateform" action="/Myjsp/CstController?cmd=update&page=${ param.page }">
			<div class="item">
			<table>
				<tr id="title">
					<td>
						<span>코 드</span>
					</td>
					<td>
						<span>이 름</span>
					</td>
					<td>
						<span>이메일</span>
					</td>
					<td>
						<span>전화번호</span>
					</td>
					<td>
						<span>체 중</span>
					</td>
				</tr>
				<tr>
					<td>
						<input class="item" readonly type="number" name="code" value=${ cst.code }>
					</td>
					<td>
						<input class="item" type="text" name="name" value=${ cst.name }>
					</td>
					<td>
						<input class="item" type="text" name="email" value=${ cst.email }>
					</td>
					<td>
						<input class="item" type="text" name="tel" value=${ cst.tel }>
					</td>
					<td>
						<input class="item" type="text" name="weight" value=${ cst.weight }>
					</td>
				<tr>
			</table>
			</div>
			<div class="item" >
			<input class="buttons" type="submit" value="수정" >
			<input class="buttons" type="reset" value="되돌리기">
			<input class="buttons" type="button" value="목록보기" onclick="window.location='/Myjsp/CstController?cmd=list&page=${ param.page }'">
			</div>
		</form>
	</div>
</body>
</html>