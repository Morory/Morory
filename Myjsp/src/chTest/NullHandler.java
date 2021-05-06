package chTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {
	
	private final String FORM_VIEW  = "/chTest/gradeStart.jsp";
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}

}
