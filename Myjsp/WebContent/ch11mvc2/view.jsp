<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>글번호</td><td>${ article.num }</td>
			<td>조회수</td><td>${ article.readcount }</td>
		</tr>
		<tr>
			<td>작성자</td><td>${ article.writer }</td>
			<td>작성일</td><td>${ article.reg_date }</td>
		</tr>
		<tr>
			<td>글제목</td><td>${ article.subject }</td>
		</tr>
		<tr>
			<td>글내용</td><td>${ article.content }</td>
		</tr>
		<tr>
			<td colspan="4">
			<input type="button" value="글수정"
			onclick="document.location.href='/Myjsp/BoardController?cmd=update&num=${ article.num }&sub=form&page=${ param.page }'">
			<input type="button" value="글삭제"
			onclick="document.location.href='/Myjsp/BoardController?cmd=delete&num=${ article.num }&sub=form&page=${ param.page }'">
			<input type="button" value="답글쓰기"
			onclick="document.location.href='/Myjsp/BoardController?cmd=comment&num=${ article.num }&sub=form&page=${ param.page }&ref=${ article.ref }&re_step=${ article.re_step }&re_level=${ article.re_level }'">		
			<input type="button" value="글목록" 
			onclick="document.location.href='/Myjsp/BoardController?cmd=list&page=${ param.page }'">
			</td>
		</tr>
	</table>
</body>
</html>