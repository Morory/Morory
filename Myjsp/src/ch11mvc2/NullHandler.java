package ch11mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {
	
	private final String FORM_VIEW = "/ch11mvc2/list.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		new BoardService().listService(request);
		
		return FORM_VIEW;
	}
	
}
