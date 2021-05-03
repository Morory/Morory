package osooiso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Likes {
	
	public Likes() {
		
	}
	
	public int likes() {
		LikesDTO likesDto = new LikesDTO();
		
		HashMap<String, Object> hm = Common.getHm();
		likesDto = (LikesDTO)hm.get("LikesDTO");
		
		PreparedStatement pstmt  = null;
		PreparedStatement pstmt2  = null;
		PreparedStatement pstmt3  = null;
		PreparedStatement pstmt4  = null;
		ResultSet 			rs	 = null;
		ResultSet 			rs2	 = null;
		
		int ret = 0;
		
		String sSelectSingles = "SELECT *         			"  
							  +	"FROM   RECOMEND			" 
							  +	"WHERE  MBER_NO   = ?		" 
							  +	"AND    BBSCTT_NO = ?		"
							  ;
		
		String sInsertLikes = "INSERT INTO RECOMEND		"  
							+ "(						" 
							+ "  MBER_NO				" 
							+ ", BBSCTT_NO				"  
							+ ", RECOMEND_AT			"  
							+ ")						"  
							+ "VALUES					"  
							+ "(						"  
							+ "  ?						"  
							+ ", ?						"  
							+ ", 'y'					" 
							+  ")"
							  ;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sSelectSingles);
			pstmt.setString(1, likesDto.getMberNo() );
			pstmt.setString(2, likesDto.getPostNo() );
			
			rs = pstmt.executeQuery();
			
			if( rs.next() )
			{
				String sSelectR = "SELECT *         			"  
								+	"FROM   RECOMEND			" 
								+	"WHERE  MBER_NO   = ?		" 
								+	"AND    BBSCTT_NO = ?		"
								+   "AND    RECOMEND_AT = 'y'	"
								;
				
				String sUpdateLikes = "UPDATE RECOMEND SET		"  
									+ "RECOMEND_AT = 'y'		" 
									+ "WHERE MBER_NO = ?		" 
									+ "AND   BBSCTT_NO = ?		"  
									;
				
				pstmt3 = Common.con.prepareStatement(sSelectR);
				pstmt3.setString(1, likesDto.getMberNo() );
				pstmt3.setString(2, likesDto.getPostNo() );
				
				rs2 = pstmt3.executeQuery();
				
				if( rs2.next() )
				{
					throw new BizException();
				}
				
				pstmt4 = Common.con.prepareStatement(sUpdateLikes);
				pstmt4.setString(1, likesDto.getMberNo() );
				pstmt4.setString(2, likesDto.getPostNo() );
				
				ret = pstmt4.executeUpdate();
				
				if(ret > 0)
				{
					return 1;
				}

			}
			
			pstmt2 = Common.con.prepareStatement(sInsertLikes);
			pstmt2.setString(1, likesDto.getMberNo() );
			pstmt2.setString(2, likesDto.getPostNo() );
			
			ret = pstmt2.executeUpdate();
			
			if(ret > 0)
			{
				return 1;
			}
					
		}catch (BizException be) {
			return -1;
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( rs!= null ) rs.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( pstmt2!= null ) pstmt2.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
		
		return 0;
		
	}
	
	public int unlikes() {
		LikesDTO likesDto = new LikesDTO();
		
		HashMap<String, Object> hm = Common.getHm();
		likesDto = (LikesDTO)hm.get("LikesDTO");
		
		PreparedStatement pstmt  = null;
		PreparedStatement pstmt2  = null;
		ResultSet 			rs	 = null;
		
		int ret = 0;
		
		String sSelectSingles = "SELECT *         			"  
							  +	"FROM   RECOMEND			" 
							  +	"WHERE  MBER_NO   = ?		" 
							  +	"AND    BBSCTT_NO = ?		"
							  + "AND    RECOMEND_AT = 'y'	"
							  ;
		
		String sUpdateUnlikes = "UPDATE RECOMEND SET		"  
							+ "RECOMEND_AT = 'n'		" 
							+ "WHERE MBER_NO = ?		" 
							+ "AND   BBSCTT_NO = ?		"  
							;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sSelectSingles);
			pstmt.setString(1, likesDto.getMberNo() );
			pstmt.setString(2, likesDto.getPostNo() );
			
			rs = pstmt.executeQuery();
			
			if( !rs.next() )
			{
				throw new BizException();
			}
			
			pstmt2 = Common.con.prepareStatement(sUpdateUnlikes);
			pstmt2.setString(1, likesDto.getMberNo() );
			pstmt2.setString(2, likesDto.getPostNo() );
			
			ret = pstmt2.executeUpdate();
			
			if(ret > 0)
			{
				return 1;
			}
					
		}catch (BizException be) {
			return -1;
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( rs!= null ) rs.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( pstmt2!= null ) pstmt2.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
		
		return 0;
	}
	
	public boolean checkLikes() {
		LikesDTO likesDto = new LikesDTO();
		LoginDTO loginDto = new LoginDTO();
		
		HashMap<String, Object> hm = Common.getHm();
		likesDto = (LikesDTO)hm.get("LikesDTO");
		loginDto = (LoginDTO)hm.get("LoginDTO");
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String sSelectSingles = "SELECT *         			"  
							  +	"FROM   RECOMEND			" 
							  +	"WHERE  MBER_NO   = ?		" 
							  +	"AND    BBSCTT_NO = ?		"
							  + "AND    RECOMEND_AT = 'y'	"
							  ;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sSelectSingles);
			pstmt.setString(1, loginDto.getMberNo() );
			pstmt.setString(2, likesDto.getPostNo() );
			
			rs = pstmt.executeQuery();
			
			if( rs.next() )
			{
				return true;
			}
			
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( rs!= null ) rs.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
		
		return false;
	}
	
	public int countLikes() {
		int cnt = 0;
		
		LikesDTO likesDto = new LikesDTO();
		
		HashMap<String, Object> hm = Common.getHm();
		likesDto = (LikesDTO)hm.get("LikesDTO");
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String sSelectSingles = "SELECT COUNT(*)         	"  
							  +	"FROM   RECOMEND			" 
							  +	"WHERE  BBSCTT_NO = ?		"
							  + "AND    RECOMEND_AT = 'y'	"
							  ;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sSelectSingles);
			pstmt.setString(1, likesDto.getPostNo() );
			
			rs = pstmt.executeQuery();
			
			if( rs.next() )
			{
				cnt = Integer.parseInt(rs.getString(1));
			}
			
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( rs!= null ) rs.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
		
		return cnt;
	}

}
