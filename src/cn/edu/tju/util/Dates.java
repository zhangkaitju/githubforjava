package cn.edu.tju.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Helper class to deal with dates
 * 
 */
public class Dates {

	private SimpleDateFormat simpleDateFormat;

	public Dates() {
		simpleDateFormat = new SimpleDateFormat();
	}

	public Dates(String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
	}

	public String format(Date date) {
		return simpleDateFormat.format(date);
	}

	public Date format(String date) {
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
