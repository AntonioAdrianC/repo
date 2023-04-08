
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

public class PlotTestStudent 
{
	private Plot plot1, plot2, plot3;
	private Plot plot4, plot5, plot6, plot7, plot8;

	@Before
	public void setUp() throws Exception 
	{
		plot1 = new Plot(0, 0, 5, 3);
		plot2 = new Plot(2, 2, 3, 1);
		plot3 = new Plot(1, 3, 3, 3);
		plot4 = new Plot(3, 7, 3, 2);
		plot5 = new Plot(5, 5, 5, 5);
		plot6 = new Plot(8, 4, 1 ,3);
		plot7 = new Plot(4, 4, 4 ,4);
		plot8 = new Plot(4, 0, 5, 5);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = null;
		plot2 = null;
		plot3 = null;
	}

	@Test
	public void testEncompassess() 
	{
		assertTrue(plot1.encompasses(plot2)); // plot2 is entirely inside plot1
		assertFalse(plot1.encompasses(plot3)); // plot3 is within plot1
		assertFalse(plot6.encompasses(plot5)); // plot5 is overlapping, but not emcompassing
		assertFalse(plot6.encompasses(plot4)); // plot4 is overlapping, but not emcompassing
	}
	
	@Test
	public void testOverLap() 
	{
		
		assertTrue(plot3.overlaps(plot1)); 
		assertFalse(plot2.overlaps(plot1)); 
		assertTrue(plot6.overlaps(plot5));
		assertTrue(plot7.overlaps(plot8));
		assertTrue(plot8.overlaps(plot1));
	}

	@Test
	public void testToString() 
	{
		assertEquals("2,2,3,1",plot2.toString());
	}

}
