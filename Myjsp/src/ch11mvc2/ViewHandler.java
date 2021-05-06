package ch11mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewHandler implements CommandHandler {
	
	private final String FORM_VIEW = "/ch11mvc2/view.jsp";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new BoardService().viewService(request);
		
		return FORM_VIEW;
	}

}
