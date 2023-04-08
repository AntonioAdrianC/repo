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

public class Plot 
{
	private int y;
	private int x;
	private int width;
	private int depth;

	// default constructor.
	public Plot()
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;

	}
	
	/**
	 constructor for Plot class.
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * copy constructor for Plot class.
	 * @param otherPlot
	 */
	public Plot(Plot otherPlot)
	{
		x = otherPlot.getX();
		y = otherPlot.getY();
		width = otherPlot.getWidth();
		depth = otherPlot.getDepth();
	}
	
	/**
	 * the encompasses method
	 * checks if the called plot envelops the referenced plot.
	 * @param otherPlot. this is the plot that *should* be within the called plot.
	 * @return true, if the referenced plot is in the called plot. false, if the referenced plot is not within the called plot.
	 */
	public boolean encompasses(Plot otherPlot)
	{
		// we only need the top and side line of each plot to determine if otherPlot is smaller
		// we are getting the lines by adding x/y with width/depth, respectfully. this gives a value that we can use to see how big a value is.
		int topLine1 = x + width, sideLine1 = y + depth;
		int topLine2 = otherPlot.getX() + otherPlot.getWidth(), sideLine2 = otherPlot.getY() + otherPlot.getDepth();
		
		// if the side and top line from otherPlot have a lower value, then main Plot is emcompessing otherPlot.
		if (topLine1 >= topLine2 && sideLine1 >= sideLine2 
			// making sure if the lines are the same value, it checks if the referenced plot has a greater or equal x and y.
			// if its bigger we can assume it's within the main plot. this is mostly safegaurding.
			&& x <= otherPlot.getX() && y <= otherPlot.getY()) 
			return true;
		return false;
	}
	
	/**
	 * the overlaps methods
	 * checks if any corner of the referenced plot is touching the called plot.
	 * @param otherPlot. the other plot.
	 * @return true if otherPlot is inside the called plot.
	 */
	public boolean overlaps(Plot otherPlot)
	{
		// we are getting the lines by adding x/y with width/depth, respectfully. this gives a value that we can use to see how big a value is.
		int topLine1 = x + width, sideLine1 = y + depth;
		int topLine2 = otherPlot.getX() + otherPlot.getWidth(), sideLine2 = otherPlot.getY() + otherPlot.getDepth();
		
		// we are checking that each line is not the same value. if they are the same value, then one is within completely.
		if((otherPlot.getX() <= x + width || otherPlot.getY() <= y + depth) && topLine2 != topLine1 && sideLine2 != sideLine1)
			return true;
		return false;
	}
	
	/**
	 * a getter method that returns the value of the depth instance variable.
	 * @return the value of the depth instance variable.
	 */
	public int getDepth()
	{
		
		return depth;
	}
	
	/**
	 * a getter method that returns the value of the width instance variable.
	 * @return the value of the width instance variable.
	 */
	public int getWidth()
	{
		
		return width;
	}
	
	/**
	 * a getter method that returns the value of the x instance variable.
	 * @return the value of the x instance variable.

	 */
	public int getX()
	{
		
		return x;
	}
	
	/**
	gets the Y value in a plot instance.
 	@param y.
	 */
	public int getY()
	{
		
		return y;
	}
	
	/**
	sets the Y value in a plot instance.
 	@param y.
	 */
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	/**
	sets the Y value in a plot instance.
 	@param y.
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	sets the Y value in a plot instance.
 	@param y.
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	sets the Y value in a plot instance.
 	@param y.
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * a regular toString() method.
	 * @return string that displays all the values
	 */
	public String toString()
	{
		return x + "," + y + "," + width + "," + depth;
	}
}
