package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateHandler implements CommandHandler {
	
	private final String FORM_VIEW = "CstController?cmd=list";

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		new UpdateService().service(request, response);
		
		return FORM_VIEW + "&page=" + request.getParameter("page");
	}

}
