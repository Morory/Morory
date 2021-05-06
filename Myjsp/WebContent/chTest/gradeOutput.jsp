<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 조회</title>
</head>
<body>
	<h3>성적조회</h3>
	<c:if test="${ !empty list }">
		<table border=1>
			<tr>
				<td width="50">코드</td>
				<td width="50">성명</td>
				<td width="50">점수</td>
			</tr>
			<c:forEach var="list" items="${ list }">
			<tr>
				<td>${ list.code }</td>
				<td>${ list.name }</td>
				<td>${ list.score }</td>
			</tr>
			</c:forEach>
		</table>
		건수 : ${ cnt } <br>
		총점 : ${ tot } <br>
		평균 : ${ avg } <br>
	</c:if>
	<input type="button" value="성적등록" 
	onclick="document.location.href='/Myjsp/GradeController?cmd=input&sub=form'">
</body>
</html>