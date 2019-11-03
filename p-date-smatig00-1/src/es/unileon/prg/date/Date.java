package es.unileon.prg.date;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	/*
	 * Constructor of the class
	 */
	public Date(int day, int month, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/*
	 * Empty constructor of the Date class passing a Date as a parameter 
	 */
	public Date(Date today) {
		this.year = today.getYear();
		this.month = today.getMonth();
		this.day = today.getDay();
	}

	/**
	 * Metodos get y set
	 */
	
	public int getDay() {
		return this.day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	

	public String toString() {
		return this.day + " / " + this.month + "/" + this.year;
	}
	
	/*
	 * isSame methods with IF
	 */
	public boolean isSameYearWithIf(int year) {
		if(this.year == year) return true;
		else return false;
	}
	
	public boolean isSameMonthWithIf(int month) {
		if(this.month == month) return true;
		else return false;
	}
	
	public boolean isSameDayWithIf(int day) {
		if(this.day == day) return true;
		else return false;
	}
	
	public boolean isSameWithIf(int year, int month, int day) {
		if((this.year == year) && (this.month == year) && (this.day == day)) return true;
		else return false;
	}
	
	/*
	 * isSame methods without IF
	 */
	public boolean isSameYearWithoutIf(int year) {
		return this.year == year;
	}
	
	public boolean isSameMonthWithoutIf(int month) {
		return this.month == month;
	}
	
	public boolean isSameDayWithoutIf(int day) {
		return this.day == day;
	}
	
	public boolean isSameWithoutIf(int year, int month, int day) {
		return ((this.year == year) && (this.month == year) && (this.day == day));
	}
	
	/*
	 * Method that returns the name of  the month
	 */
	public String getMonthName() {
		String monthName = null;
		
		switch(this.month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
			break;
		default:
			monthName = "Error. There is no month with that number";
		}
		
		return monthName;
	}
	
	/*
	 * Method that checks if  the day of  the month is right
	 */
	public boolean isDayRight(int day) {
		if((day > 0) && (day <= getDaysOfMonth(this.month))) return true;
		else return false;
	}

	/*
	 * Methot that returns the number of days a month has
	 */
	private int getDaysOfMonth(int month) {
		int days = 0;
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			days = 28;
			break;
		default:
			days = -1;
		}
		
		return days;
	}
	
	/*
	 * Method that returns the season of this month
	 */
	public String getSeasonName() {
		String seasonName = null;
		
		switch(this.month) {
		case 1:
		case 2:
		case 3:
			seasonName = "Winter";
			break;
		case 4:
		case 5:
		case 6:
			seasonName = "Spring";
			break;
		case 7:
		case 8:
		case 9:
			seasonName = "Summer";
			break;
		case 10:
		case 11:
		case 12:
			seasonName = "Fall";
			break;
		default:
			seasonName = "Error. There is no month with that number";
		}
		
		return seasonName;
	}
	
	/*
	 * For a date, return the months left until the end of the year.
	 */
	public String getMonthsLeft() {
		Date aux = new Date(this);
		StringBuffer monthsLeft = new StringBuffer();
		
		for(int i = this.month + 1; i <= 12; i++) {
			aux.setMonth(i);
			monthsLeft.append(aux.getMonthName() + "\n");
		}
		
		return monthsLeft.toString();
	}
	
	/*
	 * Write a method in Date class that returns the string version of a date.
	 */
	public String dateToString(int year, int month, int day) {
		String date = ("Date: " + day + " / " + month + " / " + year);
		
		return date;
	}
	
	/*
	 * For a date, returns all dates until the end of the month.
	 */
	public String getDaysLeftOfMonth() {
		Date aux = new Date(this);
		StringBuffer daysLeft = new StringBuffer();
		
		for(int i = aux.getDay() + 1; i <= getDaysOfMonth(month); i++) {
			aux.setDay(i);
			daysLeft.append(aux.toString() + "\n");
		}
		
		return daysLeft.toString();
	}
	
	/*
	 * For a date, returns the months with the same number of  days as the month of  this date.
	 */
	public String getMonthsSameDays() {
		Date aux = new Date(this);
		StringBuffer months = new StringBuffer();
		
		for(int i = 1; i <= 12; i++) {
			aux.setMonth(i);
			if(aux.getDaysOfMonth() == this.getDaysOfMonth()) {
				months.append(aux.getMonthName() + "\n");
			}
		}
		
		return months.toString();
	}

	/*
	 * Method that returns the number of days of the month of a given date.
	 */
	private int getDaysOfMonth() {
		return this.getDaysOfMonth(this.month);
	}
	
	/*
	 * For a date, count the number of  days since the first day of  the year (do not consider leap years).
	 */
	public int daysPast() {
		int count = 0;
		Date aux = new Date(1,1,this.year);
		
		for(int i = 1; i < this.month; i++) {
			count = count + getDaysOfMonth(i);
			aux.setMonth(i+1);
		}
		
		count = count + this.day - 1;
		
		return count;
	}
	
	/*
	 * Method that counts the number of  attempts needed to generate a random date equals to a given date (only inside the same year).
	 * WITH WHILE
	 */
	public int numRandomTriesEqualDateWithWhile() {
		int year = 0;
		int month = 0;
		int day = 0;
		int tries = 0;
		
		while(!this.isSameWithIf(year, month, day)) {
			year = this.year;
			month = (int)(Math.random() * 12) + 1;
			day = (int)(Math.random() * this.getDaysOfMonth(month)) + 1;
			tries++;
		}
		
		return tries;
	}
	
	/*
	 * Method that counts the number of  attempts needed to generate a random date equals to a given date (only inside the same year).
	 * WITH DO-WHILE
	 */
	public int numRandomTriesEqualDateWithDoWhile(){
		int year = 0;
		int month = 0;
		int day = 0;
		int tries = 0;
		
		do {
			year = this.year;
			month = (int)(Math.random() * 12) + 1;
			day = (int)(Math.random() * this.getDaysOfMonth(month)) + 1;
			tries++;
		}while(!this.isSameWithIf(year, month, day));
		
		return tries;
	}
	
	/*
	 * For a given date and knowing the day of the week of the first day of the year of that date, return the day of the week of the given date.
	 */
	public String dayOfWeek(int day) {
		int name;
		name = (daysPast() % 7 + day) % 7;
		
		return nameOfTheDay(name);
	}

	private String nameOfTheDay(int day) {
		String name;
		
		switch(day) {
		case 1:
			name = "Monday";
			break;
		case 2:
			name = "Tueday";
			break;
		case 3:
			name = "Wednesday";
			break;
		case 4:
			name = "Thursday";
			break;
		case 5:
			name = "Friday";
			break;
		case 6:
			name = "Saturday";
			break;
		case 7:
			name = "Sunday";
			break;
		default:
			name = "Error. The value entered does not correspond to any day";
		}
		
		return name;
	}
	
}
