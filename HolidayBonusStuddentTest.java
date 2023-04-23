
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: a junit class to test hoildayBonus class 
 * Due: 4/22/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/

public class HolidayBonusStuddentTest 
{
	@Test
	void testCalculateHolidayBonus() 
	{
		double[][] salesData = {{1000.0, 2000.0, 3000.0}, {4000.0, 5000.0}, {6000.0, 7000.0, 8000.0, 9000.0}};
		double[] expectedOutput = {3000.0, 9000.0, 4000.0};
		double[] actualOutput = HolidayBonus.calculateHolidayBonus(salesData);
		assertArrayEquals(expectedOutput, actualOutput);
	}

	@Test
	void testCalculateTotalHolidayBonus() 
	{
		double[][] salesData = {{1000.0, 2000.0, 3000.0}, {4000.0, 5000.0}, {6000.0, 7000.0, 8000.0, 9000.0}};
		double expectedTotal = 16000.0;
		double actualTotal = HolidayBonus.calculateTotalHolidayBonus(salesData);
		assertEquals(expectedTotal, actualTotal, 0.001);
	}


}
