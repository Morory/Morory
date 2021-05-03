package osooiso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Comment {
	
	public Comment() {
		
	}
	
	public int insertComment() {
		
		HashMap<String, Object> hm = Common.getHm();
		LoginDTO loginDto = (LoginDTO)hm.get("LoginDTO");
		CommentDTO commentDto  = (CommentDTO )hm.get("CommentDTO" );
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String sInsert =  "INSERT INTO BBSCTT (					"
					+  "  BBSCTT_NO								"
					+  ", UP_BBSCTT_NO							"
					+  ", MBER_NO								"
					+  ", BBSCTT_CN								"
					+  ", INDICT_AT								"
					+  ", BBSCTT_DATE							"
					+  ")										"
					+  "VALUES (								"
					+  "  BBSCTT_NO_SEQ.NEXTVAL					"
					+  ", ?										"
					+  ", ?										"
					+  ", ?										"
					+  ", 'y'									"
					+  ", SYSDATE								"
					+  ")										" ;
		
		int ret = 0;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sInsert);
			pstmt.setString(1, commentDto.getUpBbscttNo()	);
			pstmt.setString(2, loginDto.getMberNo()		);
			pstmt.setString(3, commentDto.getContents()		);
			
			ret = pstmt.executeUpdate();
			
		}catch (BizException be) {
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( rs!= null ) rs.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
		
		return ret;
	}
	
	public int UpdateComment() {
		
		HashMap<String, Object> hm = Common.getHm();
//		LoginDTO loginDto = (LoginDTO)hm.get("LoginDTO");
		CommentDTO commentDto  = (CommentDTO )hm.get("CommentDTO" );
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String sInsert =  "UPDATE bbsctt					\r\n" + 
						  "SET bbsctt_cn = ?				\r\n" + 
						  "where bbsctt_no = ?					" ;
		
		int ret = 0;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sInsert);
			pstmt.setString(1, commentDto.getContents()		);
			pstmt.setString(2, commentDto.getUpBbscttNo()	);
			
			ret = pstmt.executeUpdate();
			
		}catch (BizException be) {
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( rs!= null ) rs.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
		
		return ret;
	}
	
	public int DeleteComment() {
		
		HashMap<String, Object> hm = Common.getHm();
//		LoginDTO loginDto = (LoginDTO)hm.get("LoginDTO");
		CommentDTO commentDto  = (CommentDTO )hm.get("CommentDTO" );
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String sInsert =  "UPDATE bbsctt\r\n" + 
						  "SET bbsctt_cn = '@삭제된 글 입니다.'\r\n" + 
						  "where bbsctt_no = ?" ;
		
		int ret = 0;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sInsert);
			pstmt.setString(1, commentDto.getUpBbscttNo()	);
			
			ret = pstmt.executeUpdate();
			
		}catch (BizException be) {
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( rs!= null ) rs.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
		
		return ret;
	}
}
