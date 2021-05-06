package ch11mvc2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class BoardService {
	
	public void listService(HttpServletRequest request) throws SQLException {
		
		String strPage = request.getParameter("page");
		int page;
		
		if(strPage == null)
			page = 1;
		else 
			page = Integer.parseInt(strPage);
		
		final int MAX_NUM = 10;
		ArticleDAO artiDao 					= null;
		Connection con 	  					= null;
		ArrayList<ArticleDTO> articleList	= null;
		int articleCount = 0;
		
		try {
			con = Common.getConnection();
			artiDao = new ArticleDAO(con);
			
			articleCount = artiDao.getArticleCount();
			
			articleList  = artiDao.getArticles(MAX_NUM*(page-1) + 1, MAX_NUM);
				
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		
		int pageLevel = (page - 1)/MAX_NUM;
		int totalPage = 
				articleCount%MAX_NUM == 0 ? articleCount/MAX_NUM : (articleCount/MAX_NUM) + 1;
		int start = (pageLevel*MAX_NUM) + 1;
		int end;
		boolean next = true;
		
		if( pageLevel == ((totalPage-1)/MAX_NUM) )
			end = totalPage;
		else
			end = start + 9;
		
		if( page == totalPage )
			next = false;
		
		request.setAttribute("articleList", articleList);
		request.setAttribute("articleCount", articleCount);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("page", page);
		request.setAttribute("next", next);
		
	}
	
	public void viewService(HttpServletRequest request) throws SQLException {
		
		String num = request.getParameter("num");
		
		ArticleDAO artiDao 					= null;
		ArticleDTO article 					= null;
		Connection con 	  					= null;
		
		try {
			con = Common.getConnection();
			artiDao = new ArticleDAO(con);
			
			artiDao.addReadCount(Integer.parseInt(num));
			
			article = artiDao.getSingleArticle(Integer.parseInt(num));
			
			con.commit();
		} catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
		
		request.setAttribute("article", article);
	}
	
	public void insertService(HttpServletRequest request) throws SQLException {
		
		ArticleDAO artiDao			= null;
		ArticleDTO article			= null;
		Connection con				= null;
		
		int num;
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		int re_num   = 
		request.getParameter("num").isEmpty() ? 0 : Integer.valueOf(request.getParameter("num"));
		int ref      =
		request.getParameter("ref").isEmpty() ? 1 :	Integer.valueOf(request.getParameter("ref"));
		int re_step  = 
		request.getParameter("re_step").isEmpty() ? 0 : Integer.valueOf(request.getParameter("re_step"));
		int re_level = 
		request.getParameter("re_level").isEmpty() ? 0 : Integer.valueOf(request.getParameter("re_level"));
		
		try {
			con = Common.getConnection();
			artiDao = new ArticleDAO(con);
			
			num = artiDao.getMaxNum() + 1;
			
			if(re_num != 0)
			{
				artiDao.updateRe_step(ref, re_step);
				re_step  = re_step  + 1;
				re_level = re_level + 1; 
			}
			else
				ref = num;
			
			article = new ArticleDTO();
			
			article.setNum(num);
			article.setWriter(request.getParameter("writer"));
			article.setEmail(request.getParameter("email"));
			article.setSubject(request.getParameter("subject"));
			article.setPasswd(request.getParameter("passwd"));
			article.setReg_date(reg_date);
			article.setRef(ref);
			article.setRe_step(re_step);
			article.setRe_level(re_level);
			article.setContent(request.getParameter("content"));
			article.setIp(request.getRemoteAddr());
			
			artiDao.insertArticle(article);
			
			con.commit();
		} catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
	
	}
	
	public void deleteService(HttpServletRequest request) throws SQLException {
		
		ArticleDAO artiDao			= null;
		ArticleDTO article			= null;
		Connection con				= null;
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		try { 
			con = Common.getConnection();
			artiDao = new ArticleDAO(con);
			
			article = artiDao.getSingleArticle(num);
			
			if(article == null)
				throw new BizException();
			
			if(article.getPasswd().equals(request.getParameter("passwd")))
				artiDao.deleteArticle(num);
			
			con.commit();
		} catch(BizException ex) {
		} catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
		
	}
	
	public void updateFormService(HttpServletRequest request) throws SQLException {
		
		ArticleDAO artiDao			= null;
		ArticleDTO article			= null;
		Connection con				= null;
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		try { 
			con = Common.getConnection();
			artiDao = new ArticleDAO(con);
			
			article = artiDao.getSingleArticle(num);
			
			if(article == null)
				throw new BizException();
			
			request.setAttribute("article", article);
		
		} catch(BizException ex) {	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
	
	public void updateService(HttpServletRequest request) throws SQLException {
		
		ArticleDAO artiDao			= null;
		ArticleDTO article			= null;
		Connection con				= null;
		
		int num = Integer.parseInt(request.getParameter("num"));
		String passwd = request.getParameter("passwd");
		
		try {
			con = Common.getConnection();
			artiDao = new ArticleDAO(con);
			
			article = artiDao.getSingleArticle(num);
			
			if(article == null)
				throw new BizException();
			
			if(passwd.equals(article.getPasswd()))
			{
				article = new ArticleDTO();
				
				article.setNum(num);
				article.setWriter(request.getParameter("writer"));
				article.setEmail(request.getParameter("email"));
				article.setSubject(request.getParameter("subject"));
				article.setPasswd(request.getParameter("passwd"));
				article.setContent(request.getParameter("content"));
				
				artiDao.updateArticle(article);
			}
	
			con.commit();
		} catch(BizException ex) {
		} catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
		
	}

}
