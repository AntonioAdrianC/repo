import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayTestStudent
{

	@Test
	void testDay() 
	{
		assertTrue(Day.MONDAY == Day.MONDAY);
		assertFalse(Day.TUESDAY == Day.WEDNESDAY);
		assertFalse(Day.THURSDAY == Day.FRIDAY);
		assertFalse(Day.SATURDAY == Day.SUNDAY);
	}

}
