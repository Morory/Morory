package osooiso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class Common {
	
	private static HashMap<String, Object> hm = new HashMap<String, Object>();
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "dev";
	private static String password = "123456";
	
	static Connection con = null;
	
	public static HashMap<String, Object> getHm() {
		return hm;
	}
	
	public static void dbconnect() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		con.setAutoCommit(true);
	}
	
}
