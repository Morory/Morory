package osooiso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Post {
	
	public Post() {
		
	}
	
	public int insertPost() {
		
		HashMap<String, Object> hm = Common.getHm();
		LoginDTO loginDto = (LoginDTO)hm.get("LoginDTO");
		PostDTO  postDto  = (PostDTO )hm.get("PostDTO" );
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String sInsert =  "INSERT INTO BBSCTT (						"
					   +  "  BBSCTT_NO								"
					   +  ", MBER_NO								"
					   +  ", BBSCTT_SJ								"
					   +  ", BBSCTT_CN								"
					   +  ", BBSCTT_DATE							"
					   +  ", PHOTO_ADRES 							"
					   +  ", INDICT_AT								"
					   +  ", HASHCD 								"
					   +  ")										"
					   +  "VALUES (									"
					   +  "  BBSCTT_NO_SEQ.NEXTVAL					"
					   +  ", ?										"
					   +  ", ?										"
					   +  ", ?										"
					   +  ", SYSDATE								"
					   +  ", ?  									"		
					   +  ", 'y'									"
					   +  ", ?  									"
					   +  ")										" ;
		
		int ret = 0;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sInsert);
			pstmt.setString(1, loginDto.getMberNo() );
			pstmt.setString(2, postDto.getTitle()      );
			pstmt.setString(3, postDto.getContents()   );
			pstmt.setString(4, postDto.getPhotoAddress());
			pstmt.setString(5, postDto.getCategory() + postDto.getHashcode() );
			
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
	
	public int updatePost() {
		
		HashMap<String, Object> hm = Common.getHm();
		PostDTO  postDto  = (PostDTO )hm.get("PostDTO" );
		LikesDTO likesDto = (LikesDTO) hm.get("LikesDTO");
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String sUpdatePost 	=  "UPDATE BBSCTT SET						"
							+  "  BBSCTT_SJ = ?							"
							+  ", BBSCTT_CN = ?							"
							+  "WHERE BBSCTT_NO = ?						"
							;
		
		int ret = 0;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sUpdatePost);
			pstmt.setString(1, postDto.getTitle()	 );
			pstmt.setString(2, postDto.getContents() );
			pstmt.setString(3, likesDto.getPostNo()  );
			
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
	
	public int deletePost() {
		HashMap<String, Object> hm = Common.getHm();
		LikesDTO likesDto = (LikesDTO) hm.get("LikesDTO");
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		String sUpdatePost 	=  "UPDATE BBSCTT SET						"
							+  "  INDICT_AT = 'n'						"
							+  "WHERE BBSCTT_NO = ?						"
							;
		
		int ret = 0;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sUpdatePost);
			pstmt.setString(1, likesDto.getPostNo()  );
			
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
