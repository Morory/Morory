package ch11mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListHandler implements CommandHandler {

	private final String VIEW_PAGE = "/ch11mvc2/list.jsp";
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		new BoardService().listService(request);
		
		return VIEW_PAGE;
	}

}
