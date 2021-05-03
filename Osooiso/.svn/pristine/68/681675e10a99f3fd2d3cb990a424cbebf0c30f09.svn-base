package osooiso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Login {
	
	public Login() {
	}
	
	public int login() {
		
		PreparedStatement pstmt  = null;
		ResultSet 			rs	 = null;
		
		LoginDTO loginDto = new LoginDTO();
		
		HashMap<String, Object> hm = Common.getHm();
		loginDto = (LoginDTO)hm.get("LoginDTO");
		
		if("admin".equals(loginDto.getEmail()) && "1234".equals(loginDto.getPw()))
		{
			return 99;
		}
		
		String sSelectSingle = "SELECT MBER_NO, PASSWORD FROM MBER WHERE EMAIL = ? AND MBER_AT = 'y'";
		
		try {
			Common.dbconnect();
			
			pstmt = Common.con.prepareStatement(sSelectSingle);
			pstmt.setString(1, loginDto.getEmail() );
			
			rs = pstmt.executeQuery();
			
			if( !rs.next() )
			{
				throw new BizException();
			}
			
			loginDto.setMberNo(rs.getObject(1).toString());
			
			if(loginDto.getPw().equals(rs.getObject(2)))
			{
				return 1;
			}
					
		}catch (BizException be) {
			return 0;
		} catch (Exception e) { e.printStackTrace();
		} finally {
			try { if( rs!= null ) rs.close();
			} catch (SQLException e1) {}
			try { if( pstmt!= null ) pstmt.close();
			} catch (SQLException e1) {}
			try { if( Common.con   != null ) Common.con .close();
			} catch (SQLException e1) {}
		}
		return -1;
		
		
	}
	
}

