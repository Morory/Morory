<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>EL 예제-상품목록</h2>
		<hr>
		<form name=form1 method=post action=ch1201ProductSel.jsp>
			<jsp:useBean id="product" class="ch12.ch1201Product" scope="session" />
			<select name="sel">
				<%
					for (String item : product.getProductList()) {
						out.println("<option>" + item + "</option>");
					}
				%>
			</select> 
			<input type="submit" value="선택" />
		</form>
	</div>
</body>
</html>