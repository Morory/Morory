package chTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradeDAO {
	
	private Connection con = null;
	
	public GradeDAO(Connection con) {
		this.con = con;
	}
	
	public int selectCntGrade() throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet		  rs	= null;
		int cnt = 0;
		
		String SQL = "SELECT COUNT(*) CNT 		"
				   + "FROM   SCORE 				"	
				   ;
		
		pstmt = con.prepareStatement(SQL);
		rs = pstmt.executeQuery();
		
		if(rs.next())
			cnt = rs.getInt("CNT");
		
		rs.close();
		pstmt.close();
		
		return cnt;
	}
	
	public GradeDTO selectSingleGrade(int code) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet		  rs    = null;
		GradeDTO		 grdDTO = null;
		
		String SQL = "SELECT * FROM SCORE WHERE CODE = ?";
		
		pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, code);
		rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			grdDTO = new GradeDTO();
			
			grdDTO.setCode(rs.getInt("CODE"));
			grdDTO.setName(rs.getString("NAME"));
			grdDTO.setScore(rs.getDouble("SCORE"));
		}
		
		rs.close();
		pstmt.close();
		
		return grdDTO;
	}
	
	public void insertGrade(GradeDTO grdDto) throws SQLException {
		
		PreparedStatement pstmt = null;
		
		String SQL = "INSERT INTO SCORE(CODE, NAME, SCORE) VALUES (?, ?, ?)";
		
		pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, grdDto.getCode());
		pstmt.setString(2, grdDto.getName());
		pstmt.setDouble(3, grdDto.getScore());
		
		pstmt.executeUpdate();
		
		pstmt.close();
	}
	
	public ArrayList<GradeDTO> getList() throws SQLException {
		
		PreparedStatement 	pstmt 	= null;
		ResultSet		  	rs 		= null;
		GradeDTO			grdDto  = null;
		ArrayList<GradeDTO> list	= new ArrayList<GradeDTO>();
		
		String SQL = "SELECT * FROM SCORE ORDER BY CODE";
		
		pstmt = con.prepareStatement(SQL);
		rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			do {
				grdDto = new GradeDTO();
				grdDto.setCode(rs.getInt("CODE"));
				grdDto.setName(rs.getString("NAME"));
				grdDto.setScore(rs.getDouble("SCORE"));
				
				list.add(grdDto);
			} while(rs.next());
		}
		
		rs.close();
		pstmt.close();
		
		return list;
		
	}

}
