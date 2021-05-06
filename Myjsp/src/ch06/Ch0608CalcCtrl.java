package ch06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ch0608CalcCtrl
 */
@WebServlet("/CalcCtrl")
public class Ch0608CalcCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainControl(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mainControl(request, response);
	}
	
	protected void mainControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		String viewPage = null;
		RequestDispatcher dispatcher;
		
		if ("input".equals(cmd))
		{
			viewPage = "ch06/ch0608calc.html";
		}
		else if("compute".equals(cmd))
		{
			viewPage = new Ch0608CalcSvc().compute(request);
		}
		
		try {
			if (viewPage != null) {
				dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		}catch (Throwable e) {
			throw new ServletException(e);
		}
		
	}

}
