package com.liscer.algorithms.chapter1_2;

import java.util.Date;

public class SmartDate {
	
	private final int year;
	private final int month;
	private final int day;
	
	public SmartDate(int y,int m,int d){
		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (d >0 && d <=31) {
				year = y;
				month = m;
				day = y;
			}else {
				throw new IllegalArgumentException("illegalDate");
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (d>0 && d<=30) {
				year = y;
				month = m;
				day =d;
			}else {
				throw new IllegalArgumentException("Illegal date");
			}
			break;
		case 2:
			if (y % 4 ==0 && y %100 !=0 || y %400 == 0) {
				if (d>0 && d <=29) {
					year = y;
					month =m;
					day = d;
				}else {
					throw new IllegalArgumentException("Illegaldate");
				}
			}else {
				if (d >0 && d <=28) {
					year = y;
					month = m;
					day = d;
				}else {
					throw new IllegalArgumentException("Illegaldate");
				}
			}
			break;

		default:
			throw new IllegalArgumentException("Illegaldate");
		}
	}

	public String dayOfTheWeek() {
		int month = this.month;
		int year = this.year;
		int day = this.day;
		if (month <=2) {
			year--;
			month+=12;
		}
		int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year 
				/ 100 + year / 400) % 7;
		switch (week) {
		case 0:
			return "Monday";
		case 1:
			return "Tuesday";
		case 2:
			return "Wednesday";
		case 3:
			return "Thursday";
		case 4:
			return "Friday";
		case 5:
			return "Saturday";
		case 6:
			return "Sunday";
		default:
			return null;
		}
	}
	
	
	@Override
	public String toString() {
		return "SmartDate [year=" + year + ", month=" + month + ", day=" + day
				+ "]";
	}

	public static void main(String[] args) {
		SmartDate smartDate = new SmartDate(2006, 4, 4);
		System.out.println(smartDate.dayOfTheWeek());
		System.out.println(smartDate);

	}

}
