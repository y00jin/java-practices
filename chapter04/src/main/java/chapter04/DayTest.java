package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DayTest {

	public static void main(String[] args) {
		
		Date now = new Date();
		printDate1(now);
		printDate2(now);
	}
	
	public static void printDate1(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd / hh시 mm분 ss초");
		String date = sdf.format(d);
		System.out.println(date);
	}
	
	public static void printDate2(Date d) {
		// 년도(+1900)
		int year = d.getYear();
		
		// 월(0~11m + 1)
		int month = d.getMonth();
		
		int date = d.getDate();
		
		int hours = d.getHours();
		
		int minutes = d.getMinutes();
		
		int seconds = d.getSeconds();

		System.out.println((year + 1900) +"-" + (month + 1) + "-" + date + " / " 
				+ hours + ":" + minutes + ":" + seconds);
	}
	
}
