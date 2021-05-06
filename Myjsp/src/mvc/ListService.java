package mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListService {
		
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String strPage = request.getParameter("page");
		int page;
		boolean next;
		int totalPage;
		int nCnt;
		
		int pageLevel;
		
		int start;
		int end;
		
		final int MAXCNT = 10;
		
		List<Cst> list = new ArrayList<Cst>();
		ListDAO listDao = ListDAO.getInstance();
		
		if (strPage == null)
		{
			page = 1;
		}
		else
		{
			page = Integer.parseInt(strPage);
		}
		
		nCnt = (int) listDao.getCstCount();
		
		if ( (nCnt % MAXCNT) > 0 )
			totalPage = (nCnt / MAXCNT) + 1; 
		else
			totalPage = nCnt / MAXCNT;
		
		if ( page < totalPage )
			next = true;
		else
			next = false;
		
		pageLevel = (page - 1)/10;
		
		start = (pageLevel*10) + 1;
		
		if( pageLevel == ((totalPage-1)/10) )
			end = totalPage;
		else
			end = start + 9;
		
		list = (List<Cst>) listDao.getCstList((page - 1)*MAXCNT + 1, MAXCNT);
		
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("page", page);
		request.setAttribute("next", next);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
	}

}
