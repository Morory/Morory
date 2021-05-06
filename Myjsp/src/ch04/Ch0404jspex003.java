package ch04;

import java.util.Date;

public class Ch0404jspex003 {

	public static void main(String[] args) {
//		System.out.println(new java.util.Date());
//		Date dt = new Date();
		Date dt = getDate();	// 스크립트릿
		System.out.println(dt); // 표현식
	}
	
	public static Date getDate() {
		Date dt = new Date();
		return dt;
	}

}
