package aula9.ex3;

import java.util.Calendar;

public class Date {
	private int day;
	private int month;
	private int year;
    private static Date today;

	public static Date today() {
		Calendar cal = Calendar.getInstance();
        today = new Date(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH), cal.get(Calendar.YEAR));
        return today;
	}
	
	public Date(int d, int m, int y) {
		assert validateDate(d, m, y);
		this.day = d;
		this.month = m;
		this.year = y;
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public boolean equals(Object d) {
		if (d == null)
			return false;
		if (this.getClass() != d.getClass())
			return false;
		return this.day == ((Date)d).getDay() && this.month == ((Date)d).getMonth() && this.year == ((Date)d).getYear();
	}
	
	private boolean validateDate(int d, int m, int y) {
		boolean to_return = true;
		
		if (y < 0) to_return = false;
		else {
			if (m < 1 && m > 12) to_return = false;
			switch(m) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if (d < 1 || d > 31) to_return = false;
					break;
				case 2:
					if ( ((d < 1 || d > 28) && !leapYear(y)) || (((d < 1 || d > 29) && leapYear(y))) ) to_return = false;
					break;
				case 4: case 6: case 9: case 11:
					if (d < 1 || d > 30) to_return = false;
					break;
			}
		}
		return to_return;
	}
	
	private boolean leapYear(int y) {
		if ((y % 4 == 0 && !(y % 100 == 0)) || (y % 400 == 0)) return true;
		else return false;
	}
}
