package ch06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Ch0607ScoreSvc {
	
	public String insert(HttpServletRequest request) {
		
		Map<String, Object> student = null;
		List<Map<String, Object>> cls = new ArrayList<Map<String, Object>>();
		Map<String, Object> hm = new HashMap<String, Object>();
		
		int code;
		String name;
		double score;
		
		int cnt = 0;
		double tot = 0;
		double avg;
		
		for (int i = 1; i <= 2; i++) {
			student = new HashMap<String, Object>();
			
			code = Integer.parseInt(request.getParameter("code" + i));
			name = request.getParameter("name" + i);
			score = Double.parseDouble(request.getParameter("score" + i));
			
			student.put("CODE", code);
			student.put("NAME", name);
			student.put("SCORE", score);
			
			cls.add(student);
			
			cnt++;
			tot += score;
		}
		
		avg = tot / cnt;
		
		hm.put("CLS", cls);
		hm.put("CNT", cnt);
		hm.put("TOT", tot);
		hm.put("AVG", avg);
		
		request.setAttribute("HM", hm);
		
		return "/ch06/ch0607ScoreView.jsp";
	}

}
