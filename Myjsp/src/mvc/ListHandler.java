package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListHandler implements CommandHandler {
	
	private final String FORM_VIEW = "/mvc/list.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		new ListService().service(request, response);
		
		return FORM_VIEW;
	}

}
