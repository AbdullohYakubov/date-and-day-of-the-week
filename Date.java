public class Date{
    private int year;
    private int month;
    private int day;

    public Date(int _day, int _month, int _year){
        this.day = _day;
        this.month = _month;
        this.year = _year;
    }

    public void setYear(int _year){
        this.year = _year;
    }

    public void setMonth(int _month){
        this.month = _month;
    }

    public void setDay(int _day){
        this.day = _day;
    }

    public int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }

    public String toString(){
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean isNewMonth(){
        return this.day == 1;
    }

    public boolean isNewYear(){
        return this.day == 1 && this.isNewMonth();
    }

    public boolean isNewDecade(){
        return this.year % 10 == 0;
    }

    public boolean isNewCentury(){
        return this.year % 100 == 0;
    }

    public boolean isLeapYear(){
        return this.isNewCentury() ? this.year % 400 == 0 : this.year % 4 == 0;
    }

    public String dayOfWeek()
	 {
	 	String result = "unknown";
	 	
	 	// Century item
		// get the century by dividing the year by 100
		// get the remainder of that after dividing by 4
		// Subtract the result from 3.
		// Multiply the result of that by 2.
		// E.g. if the year is 1783, then the Century item should be 4.
	 	
	 	int century = year/100;
	 	
	 	int centuryItem = (3 - (century % 4))*2;
	 	
	 	System.out.println(centuryItem);
	 	
	 	// Year item
		// the year part is the last two digits of the year
		// Let x be the year part divided by 12
		// Let y be the remainder when the year part is divided by 12
		// Let z be y divided by 4
		// the year item is the sum of x, y and z
		// E.g. if the year is 1783, the year item is 19
	 	
	 	int yearPart = year % 100;
	 	
	 	int x = yearPart/12;
	 	int y = yearPart % 12;
	 	int z = y/4;
	 	
	 	int yearItem = x + y + z;
	 	
	 	System.out.println(yearItem);
	 	
	 	// Month item
		// each month has its own pre-defined score, which we can look up in a list.

	 	int[] monthScore = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 4, 5};
	 	int monthItem = monthScore[month-1];
	 	
	 	//System.out.println(monthItem);
	 	
	 	// Day item
		// if the year is a leap year, and the month is either January or February, then the day item is the day plus 6
		// otherwise it is just the day

		//E.g. the day item for 1 Jan 2024 is 7
	 	
	 	int dayItem = day;
	 	
	 	if(this.isLeapYear() && (month == 1 || month == 2))
	 	{
	 		dayItem = day + 6;
	 	}	
	 	
	 	System.out.println(dayItem);
	 	
	 	int total = (centuryItem + yearItem + monthItem + dayItem) % 7;
	 	
	 	System.out.println(total);
	 	
	 	switch(total)
	 	{
	 		case 0:
	 			result = "Sunday";
	 			break;
	 		case 1:
	 			result = "Monday";
	 			break;
	 		case 2:
	 			result = "Tuesday";
	 			break;
	 		case 3:
	 			result = "Wednesday";
	 			break;
	 		case 4:
	 			result = "Thursday";
	 			break;
	 		case 5:
	 			result = "Friday";
	 			break;
	 		case 6:
	 			result = "Saturday";
	 			break;
	 	}
	 	
	 	return result;
	 }

    public static void main(String[] args){
        Date date1 = new Date(1, 1, 1800);
        System.out.println(date1.dayOfWeek());
    }
}