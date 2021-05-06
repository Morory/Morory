package chTest;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputHandler implements CommandHandler {
	
	private final String INPUT_FORM_VIEW  = "/Myjsp/chTest/gradeInput.jsp";
	private final String OUTPUT_FORM_VIEW = "GradeController?cmd=check"; 

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		if("do".equals(request.getParameter("sub")))
		{
			new GradeService().inputGrdService(request);
			response.sendRedirect(OUTPUT_FORM_VIEW);
			return null;
		}
		else
			response.sendRedirect(INPUT_FORM_VIEW);
			return null;
		
	}

}
