<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String arr[] = { "불고기 백반", "오므라이스", "콩국수" };
	request.setAttribute("MENU", arr);
%> 
<jsp:forward page="ch1304LunchMenuView.jsp" />
<!-- http://localhost:8085/Myjsp/ch13/ch1304LunchMenu.jsp -->