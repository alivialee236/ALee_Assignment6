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
public class SizeTestStudent {

	@Test
	public void testSizeEnum() {
		
        assertEquals(Size.SMALL.toString(), "SMALL");
        assertEquals(Size.MEDIUM.toString(), "MEDIUM");
        assertEquals(Size.LARGE.toString(), "LARGE");
		
	}
}