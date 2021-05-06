package ch11mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateHandler implements CommandHandler {
	
	private final String UPDATE_FORM_VIEW = "/ch11mvc2/write.jsp";
	private final String LIST_FORM_VIEW = "BoardController?cmd=list";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if("form".equals(request.getParameter("sub")))
		{
			new BoardService().updateFormService(request);;
			return UPDATE_FORM_VIEW;
		}
		else 
		{
			new BoardService().updateService(request);
			
			try {
				
			if(request.getParameter("num").isEmpty())
				response.sendRedirect(LIST_FORM_VIEW + "&page=1");
			
				response.sendRedirect(LIST_FORM_VIEW);
			} catch(Exception e) {}
			
			return null;
		}
	}

}
