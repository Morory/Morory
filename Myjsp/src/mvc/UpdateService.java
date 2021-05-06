package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateService {
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		
		ListDAO listDao = ListDAO.getInstance();
		
		Cst cst = new Cst();
		
		cst.setCode( Integer.parseInt(request.getParameter("code") ) );
		cst.setName( request.getParameter("name"));
		cst.setEmail( request.getParameter("email"));
		cst.setTel( request.getParameter("tel"));
		cst.setWeight( Double.parseDouble(request.getParameter("weight")));
		
		listDao.updateCst(cst);
	}

}
