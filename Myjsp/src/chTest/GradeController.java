package chTest;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GradeController")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		mainControl(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		mainControl(request, response);
	}
	
	private void mainControl(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String viewPage  = null;
		String cmd		 = request.getParameter("cmd");
		CommandHandler handler = null;
		
		if("check".equals(cmd))
			handler = new CheckHandler();
		else if("input".equals(cmd))
			handler = new InputHandler();
		else
			handler = new NullHandler();
		
		try {
			viewPage = handler.process(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(viewPage != null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
			
	}

}
