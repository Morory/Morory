<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<h2> DBCP 테스트 </h2>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int cnt;
	
	try {
//		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
//		String dbId    = "dev";
//		String dbPass  = "123456";
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		Context initCtx = new InitialContext();
//		Context envCtx = (Context) initCtx.lookup("java:/comp/env");
//		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		DataSource ds = (DataSource)initCtx.lookup("java:/comp/env/jdbc/jsp");
		conn = ds.getConnection();
		
		out.println("정상적으로 연결되었습니다. <br><br>");
		
		pstmt = conn.prepareStatement("select count(*) from customer");
		rs = pstmt.executeQuery();
		
		if (rs.next())
			cnt = rs.getInt(1);
		else
			cnt = 0;
		
		out.println("customer 테이블에 row가 " + cnt + " 건 있습니다.");
	
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	rs.close();
	pstmt.close();
	conn.close();
%>