package ch11mvc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDAO {

	private Connection con = null;
	
	public ArticleDAO(Connection con) {
		this.con = con;		
	}
	
	public void insertArticle(ArticleDTO article) throws SQLException {
		
		PreparedStatement 		pstmt		= null;
		
		String SQL	= "INSERT INTO BOARD		"
					+ "( 						"
					+ "  NUM					"
					+ ", WRITER 				"
					+ ", EMAIL					"
					+ ", SUBJECT				"
					+ ", PASSWD					"
					+ ", REG_DATE 				"
					+ ", REF					"
					+ ", RE_STEP				"
					+ ", RE_LEVEL				"
					+ ", CONTENT				"
					+ ", IP						"
					+ ")						"
					+ "VALUES					"
					+ "(						"
					+ "  ?						"
					+ ", ?						"
					+ ", ?						"
					+ ", ?						"
					+ ", ?						"
					+ ", ?						"
					+ ", ?						"
					+ ", ?						"
					+ ", ?						"
					+ ", ?						"
					+ ", ?						"
					+ ")						"
					;
		
		pstmt = con.prepareStatement(SQL);
		
		pstmt.setInt(1, article.getNum());
		pstmt.setString(2, article.getWriter());
		pstmt.setString(3, article.getEmail());
		pstmt.setString(4, article.getSubject());
		pstmt.setString(5, article.getPasswd());
		pstmt.setTimestamp(6, article.getReg_date());
		pstmt.setInt(7, article.getRef());
		pstmt.setInt(8, article.getRe_step());
		pstmt.setInt(9, article.getRe_level());
		pstmt.setString(10, article.getContent());
		pstmt.setString(11, article.getIp());
		
		pstmt.executeUpdate();
		
		pstmt.close();
	}
	
	public int getMaxNum() throws SQLException {
		
		int max = 0;
		
		PreparedStatement		pstmt		= null;
		ResultSet				rs			= null;
		
		String SQL	= "SELECT MAX(NUM) MAX 		"
					+ "FROM   BOARD				"
					;
		
		pstmt = con.prepareStatement(SQL);
		rs	  = pstmt.executeQuery();
		
		if(rs.next())
			max = rs.getInt("MAX");
		
		return max;
	}
	
	public void updateArticle(ArticleDTO article) throws SQLException {
		
		PreparedStatement		pstmt		= null;
		
		String SQL	= "UPDATE BOARD  				"
				    + "SET	  WRITER 	= ?			"
				    + "		, EMAIL		= ?			"
				    + "		, SUBJECT	= ?			"
				    + "		, PASSWD    = ? 		"
				    + "		, CONTENT 	= ?			"
				    + "WHERE  NUM 		= ? 		"
				    ;
		
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, article.getWriter());
		pstmt.setString(2, article.getEmail());
		pstmt.setString(3, article.getSubject());
		pstmt.setString(4, article.getPasswd());
		pstmt.setString(5, article.getContent());
		pstmt.setInt(6, article.getNum());
		pstmt.executeUpdate();
		
		pstmt.close();	
	}
	
	public void updateRe_step(int ref, int re_step) throws SQLException {
		
		PreparedStatement		pstmt		= null;
		
		String SQL  = "UPDATE BOARD 				"
					+ "SET    RE_STEP = RE_STEP + 1 "
					+ "WHERE  REF = ?				"
					+ "AND    RE_STEP > ? 			"
					;
		
		pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, ref);
		pstmt.setInt(2, re_step);
		pstmt.executeUpdate();
		
		pstmt.close();
	}
	
	public int getArticleCount() throws SQLException {
		
		PreparedStatement 		pstmt		= null;
		ResultSet				rs			= null;
		int cnt = 0;
		
		String SQL 	= "SELECT COUNT(*) CNT		"
					+ "FROM   BOARD 			"
					;
		
		pstmt = con.prepareStatement(SQL);
		rs 	  = pstmt.executeQuery();
		
		if(rs.next())
			cnt = rs.getInt("CNT");
		
		rs.close();
		pstmt.close();
		
		return cnt;
		
	}
	
	public ArrayList<ArticleDTO> getArticles(int RNUM, int MAX_NUM) throws SQLException {
		
		ArrayList<ArticleDTO> articleList  	= new ArrayList<ArticleDTO>();
		ArticleDTO			  article 		= null;
		PreparedStatement 	  pstmt 		= null;
		ResultSet			  rs   			= null;
		
		
		String SQL 	= "SELECT *							" 
					+ "FROM ( SELECT ROWNUM RNUM		"
					+ "			 , O.*					"
					+ "		FROM ( SELECT *				"
					+ "			   FROM	  BOARD			"
					+ "			   ORDER  BY REF DESC	"
					+ "   				, RE_STEP ASC	" 
					+ "			 ) O					"
					+ "		)							" 
					+ "WHERE 	 RNUM   >=?		 		"
					+ "AND 	     ROWNUM <=?		 		"
					;
		
		pstmt = con.prepareStatement(SQL);
		
		pstmt.setInt(1, RNUM);
		pstmt.setInt(2, MAX_NUM);
		
		rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			do {
				article = new ArticleDTO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
				
				articleList.add(article);
			} while(rs.next());
		}
		
		rs.close();
		pstmt.close();
	
		return articleList;
	}
	
	public ArticleDTO getSingleArticle(int num) throws SQLException {
		ArticleDTO 			article 	= null;
		PreparedStatement 	pstmt 		= null;
		ResultSet			rs			= null;
		
		String SQL 		= "SELECT *			"
						+ "FROM   BOARD 	"
						+ "WHERE  NUM = ?	"
						;
		
		pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			article = new ArticleDTO();
			
			article.setNum(rs.getInt("num"));
			article.setWriter(rs.getString("Writer"));
			article.setEmail(rs.getString("email"));
			article.setSubject(rs.getString("subject"));
			article.setPasswd(rs.getString("passwd"));
			article.setReg_date(rs.getTimestamp("reg_date"));
			article.setReadcount(rs.getInt("readcount"));
			article.setRef(rs.getInt("ref"));
			article.setRe_step(rs.getInt("re_step"));
			article.setRe_level(rs.getInt("re_level"));
			article.setContent(rs.getString("content"));
			article.setIp(rs.getString("ip"));
		}
		
		rs.close();
		pstmt.close();
		
		return article;
	}
	
	public void addReadCount(int num) throws SQLException {
		PreparedStatement 		pstmt 	= null;
		
		String SQL 	= "UPDATE BOARD							"
					+ "SET    READCOUNT = READCOUNT + 1		"
					+ "WHERE  NUM = ?						"
					;
		
		pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, num);
		pstmt.executeUpdate();
		
		pstmt.close();
	}
	
	public void deleteArticle(int num) throws SQLException {
		
		PreparedStatement pstmt 			= null;
		
		String SQL 	= "DELETE FROM BOARD 		"
					+ "WHERE  NUM = ?			"
					;
		
		pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, num);
		pstmt.executeUpdate();
		
		pstmt.close();	
	}

}
