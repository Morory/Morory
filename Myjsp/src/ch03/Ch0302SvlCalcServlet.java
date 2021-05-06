package ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ch0302SvlCalcServlet
 */
@WebServlet("/SvlCalcServlet")
public class Ch0302SvlCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int		num1 = Integer.parseInt(request.getParameter("num1"));
		int		num2 = Integer.parseInt(request.getParameter("num2"));
		String  op	 = request.getParameter("operator");
		
//		int result = 0;
//		
//		if(op.equals("+")) {
//			result = num1 + num2;
//		}
//		else if(op.equals("-")) {
//			result = num1 - num2;
//		}
//		else if(op.equals("*")) {
//			result = num1 * num2;
//		}
//		else if(op.equals("/")) {
//			result = num1 / num2;
//		}
		
		int result = calc(num1, num2, op);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println(num1 + op + num2 + "=" + result);
		out.println("</body>");
		out.println("</html>");
		
		return;
	}
	
	protected int calc(int num1, int num2, String op) {
		
		int result = 0;
		
		if(op.equals("+")) {
			result = num1 + num2;
		}
		else if(op.equals("-")) {
			result = num1 - num2;
		}
		else if(op.equals("*")) {
			result = num1 * num2;
		}
		else if(op.equals("/")) {
			result = num1 / num2;
		}
		
		return result;
	}
}
