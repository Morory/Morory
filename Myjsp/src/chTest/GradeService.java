package chTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class GradeService {
	
	public int checkGrdCntService() throws SQLException {
		
		GradeDAO grdDao = null;
		Connection con  = null;
		int cnt = 0;
		
		try {
			con 	= Common.getConnection();
			grdDao 	= new GradeDAO(con);
			
			cnt = grdDao.selectCntGrade();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		
		return cnt;
	}
	
	public void inputGrdService(HttpServletRequest request) throws SQLException {
		
		GradeDAO grdDao = null;
		GradeDTO grdDto = null;
		Connection con  = null;
		
		try {
			con		= Common.getConnection();
			grdDao  = new GradeDAO(con);
			int code = Integer.parseInt(request.getParameter("code"));
		
			grdDto = grdDao.selectSingleGrade(code);
			if(grdDto != null)
				throw new BizException();
			
			grdDto = new GradeDTO();
			grdDto.setCode(Integer.parseInt(request.getParameter("code")));
			grdDto.setName(request.getParameter("name"));
			grdDto.setScore(Double.parseDouble(request.getParameter("score")));
			
			grdDao.insertGrade(grdDto);
			
			con.commit();
		} catch(BizException e) {	
			System.out.println("코드 중복");
		} catch(Exception e) {
			e.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
		
	}
	
	public void selectService(HttpServletRequest request) throws SQLException {
		
		GradeDAO grdDao = null;
		Connection con  = null;
		ArrayList<GradeDTO> list = null;
		int cnt;
		double tot = 0.;
		double avg;
		
		try {
			con 	= Common.getConnection();
			grdDao 	= new GradeDAO(con);
			
			list = grdDao.getList();
			
			if(list == null)
				throw new BizException();
			
			for(int i = 0; i < list.size(); i++)
			{
				tot += list.get(i).getScore();
			}
			
			cnt = list.size();
			avg = tot / cnt;
			
			tot = Math.round(tot*100.)/100.;
			avg = Math.round(avg*100.)/100.;
			
			request.setAttribute("list", list);
			request.setAttribute("cnt", cnt);
			request.setAttribute("tot", tot);
			request.setAttribute("avg", avg);
			
		} catch(BizException e) {
			System.out.println("자료 없음");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		
	}
}
