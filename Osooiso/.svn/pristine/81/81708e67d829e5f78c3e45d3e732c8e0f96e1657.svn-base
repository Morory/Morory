package osooiso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Profile {
	
	PreparedStatement pstmt  = null;
	PreparedStatement pstmt2 = null;
	ResultSet 			rs	 = null;

	public Profile() {
	}
	
	public void selectProfile() {
		HashMap<String, Object> hm = Common.getHm();;
		LoginDTO loginDto = (LoginDTO)hm.get("LoginDTO");;
		
		String sSelectSingle = "SELECT TELNM, NCNM, SRBDE FROM MBER WHERE MBER_NO = ?";
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sSelectSingle);
			pstmt.setString(1, loginDto.getMberNo() );
			
			rs = pstmt.executeQuery();
			
			if( !rs.next() )
			{
				throw new BizException();
			}
			
			loginDto.setTel(rs.getObject(1).toString());
			loginDto.setNickname(rs.getObject(2).toString());
			loginDto.setScDate(rs.getObject(3).toString());
			
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
	}
	
	public int updateProfile() {
		HashMap<String, Object> hm = Common.getHm();;
		LoginDTO loginDto = (LoginDTO)hm.get("LoginDTO");;
		
		String sSelectSingle = "SELECT * FROM MBER WHERE MBER_NO = ?";
		
		String sUpdate =  "UPDATE MBER SET PASSWORD = ?, TELNM = ?, NCNM = ? WHERE MBER_NO = ?";
		
		int ret = 0;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sSelectSingle);
			pstmt.setString(1, loginDto.getMberNo() );
			
			rs = pstmt.executeQuery();
			
			if( !rs.next() )
			{
				throw new BizException();
			}
			
			pstmt2 = Common.con.prepareStatement(sUpdate);
			pstmt2.setString(1, loginDto.getPw() );
			pstmt2.setString(2, loginDto.getTel() );
			pstmt2.setString(3, loginDto.getNickname() );
			pstmt2.setString(4, loginDto.getMberNo() );
			
			ret = pstmt2.executeUpdate();
			
		}catch (BizException be) {
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
		
		return ret;
	}

	
	public int leaveMember() {
		HashMap<String, Object> hm = Common.getHm();;
		LoginDTO loginDto = (LoginDTO)hm.get("LoginDTO");;
		
		String sSelectSingle = "SELECT * FROM MBER WHERE MBER_NO = ?";
		
		String sUpdate =  "UPDATE MBER SET MBER_AT = 'n' WHERE MBER_NO = ?";
		
		int ret = 0;
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sSelectSingle);
			pstmt.setString(1, loginDto.getMberNo() );
			
			rs = pstmt.executeQuery();
			
			if( !rs.next() )
			{
				throw new BizException();
			}
			
			pstmt2 = Common.con.prepareStatement(sUpdate);
			pstmt2.setString(1, loginDto.getMberNo() );
			
			ret = pstmt2.executeUpdate();
			
		}catch (BizException be) {
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
		
		return ret;
	}
}
