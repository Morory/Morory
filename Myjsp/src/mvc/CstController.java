package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/CstController")
public class CstController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainControl(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainControl(request, response);
	}
	
	private void mainControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		CommandHandler handler = null;
		
		if( cmd == null)
			handler = new NullHandler();
		else if( "list".equals(cmd) )
			handler = new ListHandler();
		else if ( "view".equals(cmd) )
			handler = new ViewHandler();
		else if ( "update".equals(cmd))
			handler= new UpdateHandler();
		
		try {
			String viewPage = handler.process(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} catch (Throwable e) {
			throw new ServletException(e);
		}
	}

}
