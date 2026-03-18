package assignment2_exercises;

import java.time.LocalDate;

public class ZuneBug {


	private static boolean isLeapYear (int year) {
		if ((year % 4 == 0) && (year % 100 != 0))
			return true;
		if (year % 400 == 0)
			return true;
		return false;
										
	}

	public /*@ pure @*/ static int oracle (int inputDays) {
		
		LocalDate date = LocalDate.of(1980, 1, 1);
		LocalDate oracleDate = date.plusDays(inputDays);
    		
		return  oracleDate.getYear();
	}

	
	/*@ requires days > 0;
	ensures (\result == oracle(days));
	@*/
	public static int currentYear (int days) {
		int year = 1980;
		while (days > 365) {
			if (isLeapYear(year)) {
				if (days > 366) {
					days -= 366;
					year += 1;
				}	
				
			} else {
					days -= 365;
					year += 1;
			}				
		}					
		return year;
	}	

}
