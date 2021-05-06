<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/Myjsp/style/list.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="item">
			<h2 id="h2">고객정보 페이지 단위로 보기 PAGE_NO = ${ page } NEXT = ${ next } TOTALPAGE = ${ totalPage }</h2>
		</div>
		<div class="item">
			<table>
				<tr>
					<td align="center" width="50">코드</td>
					<td align="center" width="100">성명</td>
					<td align="center" width="200">이메일</td>
					<td align="center" width="120">전화번호</td>
					<td align="center" width="100">체중</td>
					<td align="center" width="100">비고</td>
				</tr>
				<c:forEach var="cst" items="${ list }">
					<tr>
						<td id="td1" align="center">${ cst.code  }</td>
						<td align="left">${ cst.name   }</td>
						<td align="center">${ cst.email  }</td>
						<td align="center">${ cst.tel    }</td>
						<td align="right">${ cst.weight }</td>
						<td align="center"><a href="/Myjsp/CstController?cmd=view&code=${ cst.code }&page=${ page }">상세보기</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="item">
			<table>
				<tr>
					<td class="pagemove">
						<c:if test="${ page > 1 }">
							<a href="/Myjsp/CstController?cmd=list&page=${ page-1 }">
							이전페이지
							</a>
						</c:if>
					</td>
					<td>
						<c:forEach var="i" begin="${ start }" end="${ end }" >
							<c:if test="${ i == page }">
								<td class="pagebox">
									<span id="span1">
										${ i }
									</span>
								</td>	
							</c:if>
							<c:if test="${ i != page }">
								<td class="pagebox">
									<a href="/Myjsp/CstController?cmd=list&page=${ i }">${ i }</a>
								</td>
							</c:if>
						</c:forEach>
					</td>
					<td class="pagemove">
						<c:if test="${ next }">
							<a href="/Myjsp/CstController?cmd=list&page=${ page+1 }">
							다음페이지
							</a>
						</c:if>	
					</td>	
				</tr>
			</table>
		</div>
		<input type="button" value="night" onClick="
		  document.querySelector('body').style.backgroundColor='black';
		  document.querySelector('h2').style.color='white';
		  document.querySelector('table').style.color='white';
		  ">
		<input type="button" value="day" onClick="
		  document.querySelector('body').style.backgroundColor='white';
		  document.querySelector('h2').style.color='black';
		  document.querySelector('table').style.color='black';
		  ">
	</div>
</body>
</html>