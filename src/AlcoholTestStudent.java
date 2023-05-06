
import org.junit.Before;
/*
 * Class: CMSC203 
 * Instructor:
 * Description: This is a JUnit test for the Alcohol class.
 * Due: 5/2/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/
import org.junit.*;
import static org.junit.Assert.*;

public class AlcoholTestStudent 
{
	Alcohol alcoholicDrink1, alcoholicDrink2, alcoholicDrink3;

	@Before
    public void setUp() 
    {
		alcoholicDrink1 = new Alcohol("Beer", Size.SMALL, false);
		alcoholicDrink2 = new Alcohol("Screwdriver", Size.MEDIUM, true);
		alcoholicDrink3 = new Alcohol("Long Island Iced Tea", Size.LARGE, true);
    }
	
	@Test
	public void testAlcoholToString() {
	    String expected = "Name: Beer,\nType: ALCOHOL,\nSize: SMALL,\nOffered in weekend: no,\nPrice: $2.00";
	    assertEquals(expected, alcoholicDrink1.toString());
	}

	@Test
	public void testAlcoholEquals() 
	{
	    assertTrue(alcoholicDrink1.equals(alcoholicDrink1));
	    assertFalse(alcoholicDrink2.equals(alcoholicDrink3));
	}

	@Test
	public void testAlcoholCalcPrice() 
	{
	    assertEquals(2.0, alcoholicDrink1.calcPrice(), 0.01);
	    assertEquals(3.60, alcoholicDrink2.calcPrice(), 0.01);
	    assertEquals(4.60, alcoholicDrink3.calcPrice(), 0.01);
	}

    @Test
    public void testGettersAndSetters() 
    {
        assertEquals(false, alcoholicDrink1.isOfferedInWeekend());
        
      
        alcoholicDrink1.setOfferedInWeekend(true);
        assertEquals(true, alcoholicDrink1.isOfferedInWeekend());
    }

}
