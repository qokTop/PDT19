package com.addressbook.logic;

import java.util.Random;
import java.util.logging.Logger;

public class RandomDate {
	
	private static Logger log = Logger.getLogger(RandomDate.class.getName());
	
	private boolean isLeapYear(int year) {
		boolean flag = false;
		if (year%4 == 0)
			if (year%100 == 0)
				if (year%400 == 0)
					flag = true;
				else flag = false;
			else flag = false;
		else flag = false;
		log.info("Is it leap-year? " + flag);
		return flag;
	}
	
	/**
	 * format of date: day Month year (e.g. 1 January 2000)
	 * @param minYear
	 * @param maxYear
	 * @return
	 */
	public String getRandomDateAsString(int minYear, int maxYear) {		
		Random rand = new Random();
		
		int yyyy = rand.nextInt((maxYear - minYear) + 1) + minYear;
		
		String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int mm = rand.nextInt(12);
		
		int dd;
		if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) 
			dd = rand.nextInt(31) + 1;
		if (mm == 4 || mm == 6 || mm == 9 || mm == 11) 
			dd = rand.nextInt(30) + 1;
		if (mm == 2 && isLeapYear(yyyy))
			dd = rand.nextInt(29) + 1;
		else dd = rand.nextInt(28) + 1;	
		log.info("Random date is: " + Integer.toString(dd) + " " + month[mm] + " " + Integer.toString(yyyy));
		return Integer.toString(dd) + " " + month[mm] + " " + Integer.toString(yyyy);		
	}
	
	/**
	 * format of date: day Month year (e.g. 1 January 2000)
	 * @param date
	 * @return
	 */
	public String getDayFromDate (String date) {
		String dd = "";
		char space = ' ';
		int i = 0;
		while (date.charAt(i) != space) {
			dd = dd + date.charAt(i);
			i++;
		}
		log.info("Day: " + dd);
		return dd;
	}
	
	/**
	 * format of date: day Month year (e.g. 1 January 2000)
	 * @param date
	 * @return
	 */
	public String getMonthFromDate (String date) {
		String month = "";
		char space = ' ';
		int i = 0;
		while (date.charAt(i) != space)
			i++;
		i++;
		while (date.charAt(i) != space) {
			month = month + date.charAt(i);
			i++;
		}
		log.info("Month: " + month);
		return month;
	}
	
	/**
	 * format of date: day Month year (e.g. 1 January 2000)
	 * @param date
	 * @return
	 */
	public String getYearFromDate (String date) {
		String yyyy = "";
		char space = ' ';
		int i = 0;
		while (date.charAt(i) != space)
			i++;
		i++;
		while (date.charAt(i) != space)
			i++;
		i++;
		while (date.length() != i) {
			yyyy = yyyy + date.charAt(i);
			i++;
		}
		log.info("Year: " + yyyy);
		return yyyy;
	}
}
