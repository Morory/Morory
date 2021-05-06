<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글쓰기</h2>
	<form method="post" name="writeform" action="/Myjsp/BoardController?cmd=${ param.cmd }&sub=submit&page=${ param.page }">
		<input type="hidden" name="num" value=${ param.num }>
		<input type="hidden" name="ref" value=${ param.ref }>
		<input type="hidden" name="re_step" value=${ param.re_step }>
		<input type="hidden" name="re_level" value=${ param.re_level }>
		
		<table>
			<tr>
				<td><a href="/Myjsp/BoardController?cmd=list&page=${ param.page }">글목록</a></td>
			</tr>
			<tr>
				<td>이 름</td>
				<c:if test="${ 'update' == param.cmd }"><td><input type="text" name="writer" value="${ article.writer }"></td></c:if>
				<c:if test="${ 'update' != param.cmd }"><td><input type="text" name="writer"></td></c:if>
			</tr>
			<tr>
				<td>제 목</td>
				<c:if test="${ 'update' == param.cmd }"><td><input type="text" name="subject" value="${ article.subject }"></td></c:if>
				<c:if test="${ 'comment'== param.cmd }"><td><input type="text" name="subject" value="[답변]"></td></c:if>
				<c:if test="${ 'write'  == param.cmd }"><td><input type="text" name="subject"></td></c:if>
			</tr>	
			<tr>
				<td>Email</td>
				<c:if test="${ 'update' == param.cmd }"><td><input type="text" name="email" value="${ article.email }"></td></c:if>
				<c:if test="${ 'update' != param.cmd }"><td><input type="text" name="email"></td></c:if>
			</tr>
			<tr>
				<td>내 용</td>
				<c:if test="${ 'update' == param.cmd }"><td><input type="text" name="content" value="${ article.content }"></td></c:if>
				<c:if test="${ 'update' != param.cmd }"><td><input type="text" name="content"></td></c:if>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan=2>
				<input type="submit" value="글 등록">
				<input type="reset"  value="다시작성">
				<input type="button" value="목록보기" onClick="document.location.href='/Myjsp/BoardController?cmd=list&page=${ param.page }'">
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>