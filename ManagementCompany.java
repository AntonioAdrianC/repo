
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

public class ManagementCompany 
{
	public static final int MAX_PROPERTY = 5;
	private static final int MGMT_DEPTH = 10;
	private static final int MGMT_WIDTH = 10;
	private Property[] properties;
	private Plot mgmPlot;
	private int numProperties;
	private String mgmtCompanyName;
	private String taxID;
	private double mgmtFeePercentage;
	
	/**
	 * default constructor.       
	 */
	public ManagementCompany() 
	{
		properties = new Property[MAX_PROPERTY];
		mgmPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		numProperties = 0;
		mgmtCompanyName = "";
		taxID = "000000";
		mgmtFeePercentage = 0.0;
	}

	/**
	 * constructor for ManagementCompany class.
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) 
	{
		properties = new Property[MAX_PROPERTY];
		mgmPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		numProperties = 0;
		mgmtCompanyName = name;
		this.taxID = taxID;
		mgmtFeePercentage = mgmFee;
	}

	/**
	 * another constructor for ManagementCompany class.
	 * @param name 
	 * @param taxID 
	 * @param mgmFee
	 * @param x 
	 * @param y 
	 * @param width 
	 * @param depth 
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) 
	{
		properties = new Property[MAX_PROPERTY];
		mgmPlot = new Plot(x, y, width, depth);
		numProperties = 0;
		mgmtCompanyName = name;
		this.taxID = taxID;
		mgmtFeePercentage = mgmFee;
	}

	/**
	 * copy constructor for ManagementCompany class.
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) 
	{
		properties = new Property[MAX_PROPERTY];
		mgmPlot = new Plot(otherCompany.mgmPlot);
		numProperties = otherCompany.numProperties;
		mgmtCompanyName = otherCompany.mgmtCompanyName;
		taxID = otherCompany.taxID;
		mgmtFeePercentage = otherCompany.mgmtFeePercentage;
		
		for (int i = 0; i < numProperties; i++)
			properties[i] = new Property(otherCompany.properties[i]);
	
	}

	/**
	adds a new property with property name, city, rent amount, owner, and default plot.
	@param propertyName
	@param city
	@param rentAmt 
	@return index of the property. -1, if properties is full. -2, if property is null. 
	-3, if otherProperty encompasses with current Property. -4, if if otherProperty overlaps with current Property.
	 */
	public int addProperty( String propertyName, String city, double rentAmt, String owner)
	{
		if (numProperties == MAX_PROPERTY)
	        return -1; // property array is full
	    else
	    {
	        Property property = new Property(propertyName, city, rentAmt, owner);
	        if (!mgmPlot.encompasses(property.getPlot()))
	            return -3; // property is not within management plot
	        else 
	        {
	            for (int i = 0; i < numProperties; i++)
	                if (properties[i].getPlot().overlaps(property.getPlot()))
	                    return -4; // property overlaps with existing property

	            properties[numProperties] = property;
	            numProperties++;
	            return numProperties - 1;
	        }
	    }
	}
	
	/** 
	adds a new property with property name, city, rent amount, owner, and plot dimensions.
	@param propertyName 
	@param city
	@param rentAmt
	@param owner
	@param x
	@param y
	@param width 
	@param depth 
	@return index of the property. -1, if properties is full. -2, if property is null. 
	-3, if otherProperty encompasses with current Property. -4, if if otherProperty overlaps with current Property.
	*/
	public int addProperty( String propertyName, String city, double rentAmt, String owner, int x, int y, int width, int depth)
	{
		if (numProperties == MAX_PROPERTY)
	        return -1; // property array is full
	    else
	    {
	        Property property = new Property(propertyName, city, rentAmt, owner, x, y, width, depth);
	        if (!mgmPlot.encompasses(property.getPlot()))
	            return -3; // property is not within management plot
	        else 
	        {
	            for (int i = 0; i < numProperties; i++)
	                if (properties[i].getPlot().overlaps(property.getPlot()))
	                    return -4; // property overlaps with existing property

	            properties[numProperties] = property;
	            numProperties++;
	            return numProperties - 1;
	        }
	    }
	}
	/**
	adds a new property to properties using another Property instance.
	@param otherProperty
	@return index of the property. -1, if properties is full. -2, if property is null. 
	-3, if otherProperty encompasses with current Property. -4, if if otherProperty overlaps with current Property.
	*/
	public int addProperty(Property otherProperty)
	{
		if (numProperties == MAX_PROPERTY) return -1; // property array is full
		else if(otherProperty == null) return -2;
	    else 
	    {
	        Property property = new Property(otherProperty.getPropertyName(), otherProperty.getCity(), otherProperty.getRentAmount(), otherProperty.getOwner(), otherProperty.getPlot().getX(), otherProperty.getPlot().getY(), otherProperty.getPlot().getWidth(), otherProperty.getPlot().getDepth());
	        if (!mgmPlot.encompasses(property.getPlot())) return -3; // property is not within management plot 
	        else 
	        {
	            for (int i = 0; i < numProperties; i++) 
	                if (properties[i].getPlot().overlaps(property.getPlot())) return -4; // property overlaps with existing property
	            properties[numProperties] = property;
	            numProperties++;
	            return numProperties - 1;
	        }
	    }
	}
	/**

	checks if the management fee percentage is valid (between 0 and 100).
	@return true if the management fee percentage is valid, false otherwise
	*/
	public boolean isManagementFeeValid()
	{
		return (mgmtFeePercentage >= 0 && mgmtFeePercentage <= 100);

	}
	/**

	checks if the list of properties is full.
	@return true if properties is full, false otherwise
	*/
	public boolean isPropertiesFull()
	{
		return (numProperties == MAX_PROPERTY);
	}
	/**
	removes the last property in properties.
	*/
	public void removeLastProperty()
	{
		if (numProperties > 0) 
		{
	        properties[numProperties - 1] = null;
	        numProperties--;
	    }
	}
	
	/**
	returns the total monthly rent in properties.
	@return totalRent
	*/
	public double getTotalRent() 
	{
		double totalRent = 0;
		
		for (int i = 0; i < numProperties; i++ ) 
			totalRent += properties[i].getRentAmount();
		
		return totalRent;
	}
	
	/**
	returns the property with the highest monthly rent.
	@return highestRentProperty
	*/
	public Property getHighestRentProperty()
	{
		if (numProperties == 0)
	        return null;
	    else 
	    {
	        Property highestRentProperty = properties[0];
	        for (int i = 1; i < numProperties; i++) 
	        {
	            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) 
	                highestRentProperty = properties[i];
	        }
	        return highestRentProperty;
	    }
	}
	
	/**
	gets management fee percentage of a managementCompany instance.
	@return mgmtFeePercentage
	*/
	public double getMgmtFeePer() 
	{
		return mgmtFeePercentage;
	}
	
	/**
	gets the name of a managementCompany instance.
	@return the name of the management company
	*/
	public String getName() 
	{
		return mgmtCompanyName;
	}
	
	/**
	gets the plot of a managementCompany instance.
	@return the plot owned by the management company
	*/
	public Plot getPlot() 
	{
		return mgmPlot;
	}
	
	/**
	gets the list of properties of a managementCompany instance.
	@return properties array
	*/
	public Property[] getProperties() 
	{
		return properties;
	}
	
	/**
	gets the number of properties of a managementCompany instance.
	@return  numProperties int
	*/
	public int getNumProperties() 
	{
		return numProperties;
	}
	
	/**
	gets the tax ID of a managementCompany instance.
	@return taxID of the management company as a string
	*/
	public String getTaxID() 
	{
		return taxID + "";
	}
	
	/**
	sets management fee percentage of a managementCompany instance.
	@param mgmtFeePercentage
	*/
	public void setMgmtFeePer(double mgmtFeePercentage) 
	{
		this.mgmtFeePercentage = mgmtFeePercentage;
	}
	
	/**
	sets the name of a managementCompany instance.
	@param the name of the management company
	*/
	public void setName(String mgmtCompanyName) 
	{
		this.mgmtCompanyName = mgmtCompanyName;
	}
	
	/**
	sets the plot of a managementCompany instance.
	@param the plot owned by the management company
	*/
	public void setPlot(Plot mgmPlot) 
	{
		this.mgmPlot = new Plot(mgmPlot);
	}
	
	/**
	sets the list of properties of a managementCompany instance.
	@param properties array
	*/
	public void setProperties(Property[] properties) 
	{
		this.properties = properties;
	}
	
	/**
	sets the number of properties of a managementCompany instance.
	@param  numProperties int
	*/
	public void setNumProperties(int numProperties) 
	{
		this.numProperties = numProperties;
	}
	
	/**
	sets the tax ID of a managementCompany instance.
	@param newTaxID 
	*/
	public void setTaxID(String taxID) 
	{
		this.taxID = taxID;
	}
	
	
	public String toString()
	{
		String s = "List of the properties for " + mgmtCompanyName + ", taxID: " + taxID + "\n";
	    for (int i = 0; i < numProperties; i++) 
	    {
	        s += properties[i].toString() + "\n";
	    }
	    
	    double totalFee = 0.0;
	    for (Property p : properties)
	    	totalFee += p.getRentAmount() * mgmtFeePercentage;
	    s += "Total management Fee: " + totalFee + "\n";
	    return s;
	}

}
