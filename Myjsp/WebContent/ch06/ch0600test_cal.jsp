<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<% 
	HashMap<String, Object> student = new HashMap<String, Object>();
	HashMap<String, Object> hm = new HashMap<String, Object>();	
	int cnt = 0;
	double total = 0.;
	double avg;

	for (int i=1; i<3; i++)
	{
		student = new HashMap<String, Object>();	
		int code = Integer.parseInt(request.getParameter("code"+i));
		String name = request.getParameter("name" + i);
		double grade = Double.parseDouble(request.getParameter("grade" + i));
	
		student.put("code", code);
		student.put("name", name);
		student.put("grade", grade);
		hm.put("student"+i, student);
		
		cnt++;
		total += grade;
	}
	
	avg = total/cnt;
	
	hm.put("cnt", cnt);
	hm.put("total", total);
	hm.put("avg", avg);
	
	request.setAttribute("hm", hm);
%>

<jsp:forward page="ch0600test_print.jsp"/>