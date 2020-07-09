import java.text.DecimalFormat;

/**
 * A simple date record with day/month/year fields.
 * There is no validation in this class.
 * 
 * @author la, lz
 */
public class Date {
	//Fields
	private int day; 	//1..31
	private int month; 	//1..12
	private int year; 	
	
	//Constructors
	/** Creates a new instance of Date with date 01/01/2001 */
	public Date() {
		day = 1;
		month = 1;
		year = 2001;		
	}
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	//Methods
	/** @return the day */
	public int getDay() {
		return day;
	}

	/** @param day the day to set */
	public void setDay(int day) {
		this.day = day;
	}

	/** @return the month */
	public int getMonth() {
		return month;
	}

	/** @param month the month to set */
	public void setMonth(int month) {
		this.month = month;
	}

	/** @return the year */
	public int getYear() {
		return year;
	}

	/** @param year the year to set */
	public void setYear(int year) {
		this.year = year;
	}
	
	/** Get Date Format from the combination of @param Day, Month, Year and @return dd/mm/yyyy */
	public String getDateString() {
		DecimalFormat f = new DecimalFormat("00"); //used to ensure 1 outputs as 01
		return f.format(day) + "/" + f.format(month) + "/" + year;
	}
	
	@Override
	public String toString() {
		return "Date:[day=" + day + ", month=" + month + ", years=" + year + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Date other = (Date) obj;
		
		return this.day == other.day && this.month == other.month
				&& this.year == other.year;
	}
}
