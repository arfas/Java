//Name:Mohammed Arfa Adeeb


import java.util.Scanner;

public class Weekday_calc {

    



	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to MCIS5103's fantastic birth-o-meter!");
		System.out.println();
		System.out.println("All you have to do is enter your birth date, and it will");
		System.out.println("tell you the day of the week on which you were born.");
		System.out.println();
		System.out.println("Some automatic tests....");
		System.out.println("12 10 2003 => " + weekday(12,10,2003));
		System.out.println(" 2 13 1976 => " + weekday(2,13,1976));
		System.out.println(" 2 13 1977 => " + weekday(2,13,1977));
		System.out.println(" 7  2 1974 => " + weekday(7,2,1974));
		System.out.println(" 1 15 2003 => " + weekday(1,15,2003));
		System.out.println("10 13 2000 => " + weekday(10,13,2000));
		System.out.println();

		System.out.println("Now it's your turn!  What's your birthday?");
		System.out.print("Birth date (mm dd yyyy): ");
		int mm = keyboard.nextInt();
		int dd = keyboard.nextInt();
		int yyyy = keyboard.nextInt();

		// put a function call for weekday() here
		System.out.println("You were born on "+weekday(mm,dd,yyyy));
                
                
	}


	public static String weekday( int mm, int dd, int yyyy )
	{
		int yy, total,rem;
		String date = "";
                

              yy= yyyy-1900;
              total= (yy/4) + yy +dd;
              total = monthOffset(mm) + total;
              boolean leapyear = is_leap(yyyy);
              if (leapyear == true)
              {
                  if (mm == 1 || mm == 2)
                      total = total -1;
              }
              int weekday = total%7;
              weekday_name(weekday);
      		date = weekday_name(weekday)+", "+month_name(mm) + " " +dd+", "+ yyyy;
      
      		return date;
        }

public static String weekday_name( int day )
	{
		String result = null;
            if (day == 1)
      		{
      			result = "Sunday";
      		}
      		else if (day == 2)
      		{
      			result = "Monday";
      		}
              else if (day == 3)
      		{
      			result = "Tuesday";
      		}
              else if (day == 4)
      		{
      			result = "Wednesday";
      		}
              else if (day == 5)
      		{
      			result = "Thursday";
      		}
              else if (day == 6)
      		{
      			result = "Friday";
      		}
              else if (day == 7)
      		{
      			result = "Saturday";
      		}
              else if (day == 0)
      		{
      			result = "Saturday";
      		}
      		else
              {
                  result= "ERROR!";
              }
      		return result;
          }
         

public static String month_name( int month )
	{
		String result = null;
           
            if (month==1)
                  result="January";
              if (month==2)
                  result="Febuary";
              if (month==3)
                  result="March";
      		if (month==4)
                  result="April";
              if (month==5)
                  result="May";
              if (month==6)
                  result="June";
              if (month==7)
                  result="July";
              if (month==8)
                  result="August";
              if (month==9)
                  result="September";
              if (month==10)
                  result="October";
              if (month==11)
                  result="November";
              if (month==12)
                  result="December";
              
              else if (month<1 || month>12)
                  result="error";
              
		
		return result;
	}


	

	// paste your functions from MonthName, WeekdayName, and MonthOffset here
	public static int monthOffset( int month ) {
		int result=0 ;
           
      		if (month==1)
                  result=1;
              if (month==2)
                  result=4;
              if (month==3)
                  result=4;
      		if (month==4)
                  result=0;
              if (month==5)
                  result=2;
              if (month==6)
                  result=5;
              if (month==7)
                  result=0;
              if (month==8)
                  result=3;
              if (month==9)
                  result=6;
              if (month==10)
                  result=1;
              if (month==11)
                  result=4;
              if (month==12)
                  result=6;
              else if (month< 1 || month>12)
                  result=-1;
      		
		return result;
	}


	
	public static boolean is_leap( int year )
	{
		// years which are evenly divisible by 4 are leap years,
		// but years divisible by 100 are not leap years,
		// though years divisible by 400 are leap years
		boolean result;

		if ( year%400 == 0 )
			result = true;
		else if ( year%100 == 0 )
			result = false;
		else if ( year%4 == 0 )
			result = true;
		else
			result = false;
		
		return result;
	}
}