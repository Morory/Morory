<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ch11.Ch11BoardDBBean"%>
<%@ page import="java.sql.Timestamp"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="article" class="ch11.Ch11BoardDataBean" scope="page">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>

<%
	article.setReg_date(new Timestamp(System.currentTimeMillis()));
	article.setIp(request.getRemoteAddr());

	Ch11BoardDBBean dbPro = Ch11BoardDBBean.getInstance();
	dbPro.insertArticle(article);

	response.sendRedirect("ch11list.jsp");
%>
