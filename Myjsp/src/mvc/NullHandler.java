package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {
	
	private final String FORM_VIEW = "/mvc/null.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return FORM_VIEW;
	}
	
	

}
