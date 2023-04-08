public class Property 
{
	private String propertyName;
	private String city;
	private double rentalAmt;
	private String owner;
	private Plot ownedPlot;

	// default constructor.
	public Property() 
	{
		propertyName = "";
		city = "";
		rentalAmt = 0.0;
		owner = "";
		ownedPlot = new Plot();
	}

	/**
	  constructor for Property class. creates new plot too
	@param propertyName. 
	@param city. 
	@param rentAmt. 
	@param owner. 
	*/
	public Property(String propertyName, String city, double rentAmt, String owner) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentalAmt = rentAmt;
		this.owner = owner;
		ownedPlot = new Plot();
	}
	/**
	  constructor for Property class. creates new plot too
	@param propertyName. 
	@param city. 
	@param rentAmt. 
	@param owner. 
	@param x. 
	@param y. 
	@param width. 
	@param depth. 
	*/
	public Property(String propertyName, String city, double rentAmt, String owner, int x, int y, int width, int depth) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentalAmt = rentAmt;
		this.owner = owner;
		ownedPlot = new Plot(x, y, width, depth);
	}
	/**
	copy constructor for Property class.
	@param otherProperty
	*/
	public Property(Property otherProperty) 
	{
		propertyName = otherProperty.getPropertyName();
		city = otherProperty.getCity();
		rentalAmt = otherProperty.getRentAmount();
		owner = otherProperty.getOwner();
		ownedPlot = new Plot(otherProperty.getPlot());
	}
	/**
	gets city value in the property instance.
	@return city.
	*/
	public String getCity() 
	{
		return city;
	}
	/**
	gets owner value in the property instance.
	@return owner.
	*/
	public String getOwner() 
	{
		return owner;
	}
	/**
	gets name value in a property instance.
	@return propertyName
	*/
	public String getPropertyName() 
	{
		return propertyName;
	}
	/**
	gets plot value in a property instance.
	@return ownedPlot 
	*/
	public Plot getPlot() 
	{
		return ownedPlot;
	}
	/**
	gets rental amount in a property instance.
	@return rentalAmt
	*/
	public double getRentAmount() 
	{
		return rentalAmt;
	}
	/**
	sets city value in a property instance.
	@param city.
	*/
	public void setCity(String city) 
	{
		this.city = city;
	}
	/**
	sets owner value in a property instance.
	@param owner.
	*/
	public void setOwner(String owner) 
	{
		this.owner = owner;
	}
	/**
	sets name value in a property instance.
	@param propertyName.
	*/
	public void setPropertyName(String propertyName) 
	{
		this.propertyName = propertyName;
	}
	/**
	sets plot variable in a property instance.
	@param plot.
	*/
	public void setPlot(Plot plot) 
	{
		this.ownedPlot = plot;
	}

	/**
 	sets rental amount in a property instance.
 	@param rentAmt.
	 */
	public void setRentAmount(double rentAmt) 
	{
	    this.rentalAmt = rentAmt;
	}

	/**
 	Returns a string representation of a Property instance.
 	@return toString()
	 */
	public String toString() 
	{
	    return this.propertyName + "," + this.city + "," + this.owner + "," + this.rentalAmt;
	}
}
