<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h2>글목록(전체글:${ articleCount })</h2>
	
	<input type="button" value="글쓰기" onclick="document.location.href='/Myjsp/BoardController?cmd=write&sub=form&page=${ page }'">

	<table>
		<tr>
			<td>번 호</td>
			<td>제 목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회</td>
			<td>IP</td>
		</tr>
		<c:forEach var="arti" items="${ articleList }">
		<tr>
			<td>${ arti.num }</td>
			<td><a href="/Myjsp/BoardController?cmd=view&num=${ arti.num }&page=${ page }">${ arti.subject }</a></td>
			<td>${ arti.writer }</td>
			<td>${ arti.reg_date }</td>
			<td>${ arti.readcount }</td>
			<td>${ arti.ip }</td>
		</tr>	
		</c:forEach>
		<tr>
			<td>
				<c:if test="${ page > 1}">
				<a href="/Myjsp/BoardController?cmd=list&page=${ page - 1 }">이전페이지</a>
				</c:if>
			</td>
			<c:forEach var="i" begin="${ start }" end="${ end }" >
			<c:if test="${ i == page }">
				<td>${ i }</td>
			</c:if>
			<c:if test="${ i != page }">
				<td><a href="/Myjsp/BoardController?cmd=list&page=${ i }">${ i }</a></td>	
			</c:if>
			</c:forEach>
			<c:if test="${ next }">
				<td><a href="/Myjsp/BoardController?cmd=list&page=${ page + 1 }">다음페이지</a></td>
			</c:if>
		</tr>
	</table>
</body>
</html>