package ch11mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteHandler implements CommandHandler {
	
	private final String DELETE_FORM_VIEW = "/ch11mvc2/delete.jsp";
	private final String LIST_FORM_VIEW   = "BoardController?cmd=list";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 형식 요청일때
		if("form".equals(request.getParameter("sub")))
				return DELETE_FORM_VIEW;
		else
		{
			new BoardService().deleteService(request);
			
			try {
				
			if(request.getParameter("num").isEmpty())
				response.sendRedirect(LIST_FORM_VIEW + "&page=1");
			
				response.sendRedirect(LIST_FORM_VIEW);
			} catch(Exception e) {}
			
			return null;
		}
	}

}
