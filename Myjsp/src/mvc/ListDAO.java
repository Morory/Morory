package mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ListDAO {
	
	private static ListDAO instance = new ListDAO();
	
	public static ListDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:/comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	public int getCstCount() throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int nCnt = 0;
		
		String SQLcnt 	= "SELECT COUNT(*)	"
						+ "FROM   CUSTOMER	" ;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(SQLcnt);
			rs = pstmt.executeQuery();
			
			if ( rs.next() )
				nCnt = rs.getInt(1);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		
		return nCnt;
	}
	
	public List<Cst> getCstList(int startNo, int MAXCNT) throws Exception {
		
		List<Cst> cstList = new ArrayList<Cst>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String SQL 	 	= "SELECT *								"
						+ "FROM ( SELECT ROWNUM RNUM			"
						+ "			 , O.*						"
						+ "		FROM ( SELECT *					"
						+ "			   FROM   CUSTOMER			"
						+ "			   ORDER  BY CODE ASC		"
						+ "			 ) O						"
						+ "	  )									"
						+ "WHERE  RNUM >= ?						"
						+ "AND    ROWNUM <= ?					" ;
		
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, MAXCNT);
			
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				do {	
					Cst cst = new Cst();
					cst.setCode(rs.getInt("CODE"));
					cst.setName(rs.getString("NAME"));
					cst.setEmail(rs.getString("EMAIL"));
					cst.setTel(rs.getString("TEL"));
					cst.setWeight(rs.getDouble("WEIGHT"));
					
					cstList.add(cst);
				} while(rs.next());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		
		return cstList;
	}
	
	public Cst getCst(int code) {
		Cst cst = new Cst();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String SQL = "SELECT CODE   			"
				   + "	   , NAME				"
				   + "	   , EMAIL				"
				   + "	   , TEL				"
				   + "	   , WEIGHT				"
				   + "FROM   CUSTOMER			"
				   + "WHERE  CODE = ?			"
				   ;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, code);
			
			rs = pstmt.executeQuery();
			
			if ( rs.next() )
			{
				cst.setCode(rs.getInt("CODE"));
				cst.setName(rs.getString("NAME"));
				cst.setEmail(rs.getString("EMAIL"));
				cst.setTel(rs.getString("TEL"));
				cst.setWeight(rs.getDouble("WEIGHT"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		} 
		
		return cst;
	}
	
	public int updateCst(Cst cst) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		
		String SQL = "UPDATE CUSTOMER SET					"
				   + "  NAME 	 = ?						"
				   + ", EMAIL    = ?						"
				   + ", TEL 	 = ? 						"
				   + ", WEIGHT   = ? 						"
				   + "WHERE CODE = ?						"
				   ;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, cst.getName());
			pstmt.setString(2, cst.getEmail());
			pstmt.setString(3, cst.getTel());
			pstmt.setDouble(4, cst.getWeight());
			pstmt.setInt(5, cst.getCode());
			
			 rs = pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		} 
		
		return rs;
	}
}
