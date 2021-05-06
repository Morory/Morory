package chTest;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckHandler implements CommandHandler {
	
	private final String INPUT_FORM_VIEW  = "/chTest/gradeInput.jsp";
	private final String OUTPUT_FORM_VIEW = "/chTest/gradeOutput.jsp"; 
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		GradeService svc = new GradeService();
		
		if(svc.checkGrdCntService() > 0)
		{
			svc.selectService(request);
			return OUTPUT_FORM_VIEW;
		}	
		else
			return INPUT_FORM_VIEW;
	}

}
