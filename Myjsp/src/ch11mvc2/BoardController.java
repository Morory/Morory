package ch11mvc2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainControl(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainControl(request, response);
	}
	
	protected void mainControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		CommandHandler handler = null;
		
		if(cmd == null)
			handler = new NullHandler();
		else if("list".equals(cmd))
			handler = new ListHandler();
		else if("view".equals(cmd))
			handler = new ViewHandler();
		else if("write".equals(cmd))
			handler = new WriteHandler();
		else if("delete".equals(cmd))
			handler = new DeleteHandler();
		else if("update".equals(cmd))
			handler = new UpdateHandler();
		else if("comment".equals(cmd))
			handler = new CommentHandler();
		
		String viewPage = null;
		
		try {
			viewPage = handler.process(request, response);
			if(viewPage != null)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
