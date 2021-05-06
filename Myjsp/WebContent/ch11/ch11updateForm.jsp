<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ch11.Ch11BoardDBBean"%>
<%@ page import = "ch11.Ch11BoardDataBean" %>
<%@ include file="ch11color.jspf" %>
<html>
<head>
<title>게시판</title>
<link href="ch11style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="ch11script.js"></script>
</head>
<body bgcolor="<%=bodyback_c%>">
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	try{
		Ch11BoardDBBean dbPro = Ch11BoardDBBean.getInstance();
		Ch11BoardDataBean article = dbPro.updateGetArticle(num);
%>

<p>글수정</p>
<br>
<form method="post" name="writeform"
action="ch11updatePro.jsp?pageNum=<%=pageNum %>" onsubmit="return writeSave()">
<table>
	<tr>
		<td width="70" bgcolor="<%=value_c%>" align="center">이 름</td>
		<td align="left" width="330">
			<input type="text" size="10" maxlength="10" name="writer"
			value="<%=article.getWriter() %>" style="ime-mode:active;">
		<input type="hidden" name="num" value="<%=article.getNum() %>"></td>
	</tr>
	<tr>
		<td width="70" bgcolor="<%=value_c%>" align="center">제 목</td>
		<td align="left" width="330">
			<input type="text" size="40" maxlength="50" name="subject"
			value="<%=article.getWriter() %>" style="ime-mode:active;"></td>
	</tr>
		<tr>
		<td width="70" bgcolor="<%=value_c%>" align="center">Email</td>
		<td align="left" width="330">
			<input type="text" size="40" maxlength="30" name="email"
			value="<%=article.getWriter() %>" style="ime-mode:active;"></td>
	</tr>
		<tr>
		<td width="70" bgcolor="<%=value_c%>" align="center">내 용</td>
		<td align="left" width="330">
			<textarea name="content" rows="13" cols="40"
			style="ime-mode:active;"><%=article.getContent() %></textarea></td>
	</tr>
		<tr>
		<td width="70" bgcolor="<%=value_c%>" align="center">비밀번호</td>
		<td align="left" width="330">
			<input type="password" size="8" maxlength="12"
			name="passwd" style="ime-mode:inactive;">
		</td>
	</tr>
<tr>
	<td colspan=2 bgcolor="<%=value_c %>" align="center">
		<input type="submit" value="글수정">
		<input type="reset" value="다시작성">
		<input type="button" value="목록보기"
	onclick="document.location.href='ch11list.jsp?pageNum=<%=pageNum%>'">
	</td>
	</tr>
</table>
</form>
<%
}catch(Exception e){}%>
</body>
</html>