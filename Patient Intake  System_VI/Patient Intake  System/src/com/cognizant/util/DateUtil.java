package com.cognizant.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("deprecation")
public class DateUtil {
	private DateUtil() {
		super();
	}
	
	public static Date convertToDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		return(sdf.parse(date));
	}
	
	public static Date convertToBeforeTime(Date date) {
		int mm = date.getMinutes();
		date.setMinutes(mm-15);
		return(new Date(date.getTime() - 1000 * 15 * 60));
	}
	public static Date convertToAfterTime(Date date) {
		int mm = date.getMinutes();
		date.setMinutes(mm+15);		
		return(date);
	}
	
}
