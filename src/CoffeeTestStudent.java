/*
 * Class: CMSC203 
 * Instructor:
 * Description: This is a JUnit test for the Smoothie class.
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

public class CoffeeTestStudent 
{
	private Coffee coffee1, coffee2, coffee3;
	@Before
	public void setUp()
	{
		coffee1 = new Coffee("Latte", Size.SMALL, true, true);
		coffee2 = new Coffee("Cappacio", Size.MEDIUM, true, false);
		coffee3 = new Coffee("Frappe", Size.LARGE, false, false);
	}

	@Test
	public void testGetExtraShot() 
	{
		assertEquals(true, coffee1.getExtraShot());
	}

	@Test
	public void testGetExtraSyrup() 
	{
		assertEquals(true, coffee1.getExtraSyrup());
	}

	@Test
	public void testSetExtraShot() 
	{
		coffee1.setExtraShot(false);
		assertEquals(false, coffee1.getExtraShot());
	}

	@Test
	public void testSetExtraSyrup() 
	{
		coffee1.setExtraSyrup(false);
		assertEquals(false, coffee1.getExtraSyrup());
	}

	@Test
	public void testCalcPrice() 
	{
		// test small smoothie1 
        assertEquals(3.0, coffee1.calcPrice(), 0.01);

        // test medium smoothie2 
        assertEquals(3.50, coffee2.calcPrice(), 0.01);

        // test large smoothie3 
        assertEquals(4.0, coffee3.calcPrice(), 0.01);
	}

	@Test
	public void testToString() 
	{
		String expected = "Name: Latte,\nType: COFFEE,\nSize: SMALL,\nExtra Shot?: yes,\nExtra Syrup?: yes,\nPrice: $3.00";
		assertEquals(expected, coffee1.toString());
	}

	@Test
	public void testEquals() 
	{
		assertTrue(coffee1.equals(coffee1));
		assertFalse(coffee2.equals(coffee3));
	}
}
