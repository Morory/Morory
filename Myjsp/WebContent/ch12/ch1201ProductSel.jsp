<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text.html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h2>EL 예제-상품선택</h2>
	<hr>
	1. 선택한 상품은 : ${param.sel} <br>
	<!-- %= request.getParamter("sel") --> 
	2. num1 + num2 = ${product.num1 + product.num2} <br>
	<!-- Ch1201Product product = (Ch1201Product)session.getAttribute("product");
		%=product.get -->	
	</div>
</body>
</html>