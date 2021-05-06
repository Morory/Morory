<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="ch12.Ch1203ProductInfo" %>
<%
	Ch1203ProductInfo product = new Ch1203ProductInfo();
	product.setName("초코케이크 3호");
	product.setPrice(20000);
	request.setAttribute("PRODUCT", product);
	RequestDispatcher dispatcher = 
			request.getRequestDispatcher("ch1203ProductInfoView.jsp");
	dispatcher.forward(request, response);
%>
	