/*
 * Class: CMSC203 
 * Instructor:
 * Description: This is a JUnit test for the Beverage abstract class.
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

public class BeverageTestStudent 
{
	// a Beverage object to use in tests
    private Beverage bev1;

    @Before
    public void setUp() 
    {
    	bev1 = new Coffee("Latte", Size.MEDIUM, true, false);
    }
    
	@Test
	public void testCalcPrice() 
	{
	    assertEquals(3.5, bev1.calcPrice(), 0.001);
	}

	@Test
	public void testEquals() 
	{
	    Beverage bev2 = new Coffee("Latte", Size.MEDIUM, true, false);
	    assertEquals(true, bev1.equals(bev2));
	}

	@Test
	public void testGetBasePrice() 
	{
	    assertEquals(2.0, bev1.getBasePrice(), 0.001);
	}

	@Test
	public void testGetSizePrice() 
	{
	    assertEquals(1.0, bev1.getSizePrice(), 0.001);
	}

	@Test
	public void testGetName() 
	{
	    assertEquals("Latte", bev1.getName());
	}

	@Test
	public void testGetType() 
	{
	    assertEquals(Type.COFFEE, bev1.getType());
	}

	@Test
	public void testGetSize() 
	{
	    assertEquals(Size.MEDIUM, bev1.getSize());
	}

	@Test
	public void testSetName() 
	{
	    bev1.setName("Cappuccino");
	    assertEquals("Cappuccino", bev1.getName());
	}

	@Test
	public void testSetType() 
	{
	    bev1.setType(Type.ALCOHOL);
	    assertEquals(Type.ALCOHOL, bev1.getType());
	}

	@Test
	public void testSetSize() 
	{
	    bev1.setSize(Size.SMALL);
	    assertEquals(Size.SMALL, bev1.getSize());
	}

}