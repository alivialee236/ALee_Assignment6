/*
 * Class: CMSC203 CRN 30339
 * Instructor:Professor Grinberg
 * Description: Makes an application that creates orders through beverages 
 * and returns the prices of the total orders and monthly orders from the
 * prices of the drinks ordered by the customer
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Alivia Lee
*/
import static org.junit.Assert.*;
import org.junit.Test;
public class DayTestStudent {

	@Test
	public void testDayEnum() {
		
        assertEquals(Day.MONDAY.toString(), "MONDAY");
        assertEquals(Day.TUESDAY.toString(), "TUESDAY");
        assertEquals(Day.WEDNESDAY.toString(), "WEDNESDAY");
        assertEquals(Day.THURSDAY.toString(), "THURSDAY");
        assertEquals(Day.FRIDAY.toString(), "FRIDAY");
        assertEquals(Day.SATURDAY.toString(), "SATURDAY");
        assertEquals(Day.SUNDAY.toString(), "SUNDAY");
		
	}
}
