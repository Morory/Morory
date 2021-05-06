package ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ch0400mmmm
 */
@WebServlet("/mmmm")
public class ch0400mmmm extends HttpServlet {
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
		
		// 컨텐츠 타입 선언 및 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		// 웹브라우저 출력을 위한 PrintWriter 객체 확보
		PrintWriter out = response.getWriter();
		//HTML 형식으로 브라우저 출력 컨텐츠 작성
		
		String bookTitle = "JSP 프로그래밍";
		String author = "홍길동";
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset=\"UTF-8\"><TITLE>HTML 문서의 제목</TITLE>");
		out.println("<body>");
		out.println("<b>" + bookTitle + "</b>("  + author + ")입니다.");
		out.println("</body>");
		out.println("</html>");
	
	}

}
