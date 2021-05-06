package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewHandler implements CommandHandler {
	
	private final String FORM_VIEW = "/mvc/view.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		new ViewService().service(request, response);
		
		return FORM_VIEW;
	}

}
