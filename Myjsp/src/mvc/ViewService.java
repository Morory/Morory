package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewService {
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		ListDAO listDao = ListDAO.getInstance();
		
		Cst cst = listDao.getCst(code);
		
		request.setAttribute("cst", cst);
	}

}
