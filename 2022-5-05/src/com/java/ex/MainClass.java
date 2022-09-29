package com.java.ex;

import java.util.Calendar;

public class MainClass {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Singleton
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 월은 시작이 0부터
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		System.out.println("현재 시간입니다!");
		System.out.println(year + "년 " + month + "월 " + day + "일");
		System.out.println(hour + "시 " +  min + "분 " + sec + "초");
		
	}

}
