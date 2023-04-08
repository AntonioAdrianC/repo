
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Professor Gary Thai
 * Class: Plot
 * Description: This class represents a plot with a position, width and 
 * depth. It provides methods to check if one plot encompasses another plot and if two plots overlap each other.
 * Due: 4/6/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco.
*/

class PropertyTestStudent 
{
	Property propertyOne;

	@BeforeEach
	void setUp() throws Exception 
	{
		propertyOne = new Property("Glacier Lakes", "Silver Spring", 3160.00, "Adrian Carrasco");
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		propertyOne = null;
	}

	@Test
	void testGetPropertyName() 
	{
		assertEquals("Glacier Lakes", propertyOne.getPropertyName());
	}

	@Test
	void testGetRentAmount() 
	{
		assertEquals(3160.00, propertyOne.getRentAmount());
	}

	@Test
	void testGetPlot() 
	{
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	void testToString() 
	{
		assertEquals("Glacier Lakes,Silver Spring,Adrian Carrasco,3160",propertyOne.toString());
	}

}
