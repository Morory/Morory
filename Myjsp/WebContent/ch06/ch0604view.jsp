<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	String viewPageURI = null;
	
	if ("A".equals(code)) {
		viewPageURI = "ch0604a.jsp";
	} else if ("B".equals(code)) {
		viewPageURI = "ch0604b.jsp";
	} else if ("C".equals(code)) {
		viewPageURI = "ch0604c.jsp";
	}
%>
<jsp:forward page="<%= viewPageURI %>" />
	