package chapter04;

import java.util.Calendar;

public class CalenderClass {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();

		printDate(cal);
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11); // month(12)-1
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(2017,4,8);
		cal.add(Calendar.DATE, 1000);
		printDate(cal);
	}
	
	public static void printDate(Calendar cal) {
		String [] days = {"일","월","화","수","목","금","토"};
		String [] amPm = {"오전","오후"};
		// 년도
		int year = cal.get(Calendar.YEAR);
		// 월(0~11) + 1
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 오전 : 0 / 오후 : 1
		int am_pm = cal.get(Calendar.AM_PM);
		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int millisec = cal.get(Calendar.MILLISECOND);
		System.out.println(year + "-" + (month+1) + "-" + date + " " + days[day] + " || " + amPm[am_pm] + " " + hours + ":" + minutes + ":" + millisec);
	}
	
}
