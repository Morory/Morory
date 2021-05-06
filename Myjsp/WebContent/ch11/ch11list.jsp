<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ch11.Ch11BoardDBBean" %>
<%@ page import = "ch11.Ch11BoardDataBean" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ include file= "ch11color.jspf" %>

<%!int pageSize = 10;
	SimpleDateFormat sdf = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm");%>

<%
	String pageNum = request.getParameter("pageNum");

	if (pageNum == null) {
		pageNum = "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage - 1) * pageSize + 1;
	//LTS int endRow = currentPage * pageSize;
	int count = 0;
	//Lts int number = 0;
	List<Ch11BoardDataBean> articleList = null;
	
	Ch11BoardDBBean dbPro = Ch11BoardDBBean.getInstance();
	count = dbPro.getArticleCount();
	
	if (count > 0) {
		articleList = dbPro.getArticles(startRow, pageSize);
	}
	
	//LTS number = count-(currentPage-1)*pageSize;
%>
<html>
<head>
<link href="ch11style.css" rel="stylesheet" type="text/css">
<title>게시판</title>
</head>
<body bgcolor="<%=bodyback_c%>">
<p>글목록(전체 글:<%=count %>)</p>

<table>
	<tr>
		<td align="right" bgcolor="<%=value_c %>">
			<a href="ch11writeForm.jsp">글쓰기</a>
		</td>
	</tr>
</table>

<% if (count == 0) { %>

<table>
<tr>
	<td align="center">
		게시판에 저장된 글이 없습니다.
	</td>
</table>

<% } else { %>
<table>
	<tr height="30" bgcolor="<%=value_c%>">
		<td align="center" width="50" >번 호</td>
		<td align="center" width="250" >제   목</td>
		<td align="center" width="100" >작성자</td>
		<td align="center" width="150" >작성일</td>
		<td align="center" width="50" >조 회</td>
		<td align="center" width="100" >IP</td>
	</tr>
<%
	for (int i = 0; i < articleList.size(); i++) {
		Ch11BoardDataBean article = articleList.get(i);
%>
	<tr height="30">
		<td width="50">
			<%--LTS 
			<%=number %>
			--%>
			<%=article.getNum() %>
		</td>
		<td width="250" align="left">
<%
	int wid=0;
	if(article.getRe_level()>0){
		wid=5*(article.getRe_level());
%>
	<img src="images/level.png" width="<%=wid%>" height="16">
	<img src="images/re.png">		
<%	}%>

	<a href="ch11content.jsp?num=<%=article.getNum() %>&pageNum=<%=currentPage %>">
	<%=article.getSubject() %></a>

<% if(article.getReadcount()>=5){ %>
	<img src="images/hot.png" border="0" height="16"><%} %></td>
	<td width="100" align="left">
		<a href="mailto:<%=article.getEmail() %>">
			<%=article.getWriter() %></a></td>
	<td width="150"><%= sdf.format(article.getReg_date()) %></td>
	<td width="50"><%=article.getReadcount() %></td>
	<td width="100"><%=article.getIp() %></td>
	</tr>
<%} %>	
</table>
<%} %>

<%
	if (count > 0) {
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
	int startPage = 1;
	
	if (currentPage % 10 != 0)
		startPage = (int)(currentPage/10)*10 + 1;
	else
		startPage = ((int)(currentPage/10)-1)*10 + 1;
	
	int pageBlock = 10;
		int endPage = startPage + pageBlock - 1;
		if (endPage > pageCount) endPage = pageCount;
		
		if (startPage > 10) { %>
			<a href="ch11list.jsp?pageNum=<%= startPage - 10 %>">[이전]</a>
<% 		}
		
		for (int i = startPage ; i <= endPage; i++) { %>
			<a href="ch11list.jsp?pageNum=<%= i %>">[<%= i %>]</a>
<% 		}
		
		if ( endPage < pageCount) {	  %>			
			<a href="ch11list.jsp?pageNum=<%= startPage + 10 %>">[다음]</a>
<%
		}
	}
%>	


</body>
</html>