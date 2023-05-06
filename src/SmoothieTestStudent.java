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

public class SmoothieTestStudent 
{

    // Declare some Smoothie objects to use in our tests
    private Smoothie smoothie1, smoothie2, smoothie3;

    @Before
    public void setUp() 
    {
        smoothie1 = new Smoothie("Fruit Blast", Size.SMALL, 2, false);
        smoothie2 = new Smoothie("Protein Power", Size.LARGE, 3, true);
        smoothie3 = new Smoothie("Berry Burst", Size.MEDIUM, 1, false);
    }

    @Test
    public void testEquals() 
    {
        // test equal objects
        Smoothie smoothie0 = new Smoothie("Fruit Blast", Size.SMALL, 2, false);
        assertTrue(smoothie1.equals(smoothie0));
    }

    @Test
    public void testCalcPrice() 
    {
        // test small smoothie1 
        assertEquals(3.0, smoothie1.calcPrice(), 0.01);

        // test medium smoothie2 
        smoothie3.setSize(Size.MEDIUM);
        assertEquals(3.50, smoothie3.calcPrice(), 0.01);

        // test large smoothie3 
        assertEquals(7.0, smoothie2.calcPrice(), 0.01);
    }
    
    @Test
	public void testToString() 
	{
		String expected = "Name: Fruit Blast,\nType: SMOOTHIE,\nSize: SMALL,\nNumber of Fruits: 2,\nProtein Powder?: no,\nPrice: $3.00";
		assertEquals(expected, smoothie1.toString());
	}
    
    @Test
	public void testGetNumFruits() 
	{
	    assertEquals(2, smoothie1.getNumFruits());
	}

	@Test
	public void testSetNumFruits() 
	{
	    smoothie1.setNumFruits(3);
	    assertEquals(3, smoothie1.getNumFruits());
	}
	
	@Test
	public void testGetHasProtein() 
	{
	    assertEquals(false, smoothie1.getHasProtein());
	}

	@Test
	public void testSetHasProtein() 
	{
		smoothie1.setHasProtein(true);
	    assertEquals(true, smoothie1.getHasProtein());
	}
}
