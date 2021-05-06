package ch06;

import javax.servlet.http.HttpServletRequest;

public class Ch0608CalcSvc {
	
	public String compute(HttpServletRequest request) {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String op	 = request.getParameter("operator");
		
		int result = new Calc().getResult(num1, num2, op);
		
		request.setAttribute("result", result);
			
		return "/ch06/ch0608calcview.jsp";	
	}

}
