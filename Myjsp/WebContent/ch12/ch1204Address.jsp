<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("Edgar", "보스턴");
	map.put("Thomas", "오하이오");
	map.put("John", "워싱턴");
	request.setAttribute("ADDRESS", map);
	RequestDispatcher dispatcher = 
		request.getRequestDispatcher("ch1204AddressView.jsp?NAME=Thomas");
	dispatcher.forward(request, response);
%>