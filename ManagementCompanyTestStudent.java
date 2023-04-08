
import static org.junit.Assert.*;

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
public class ManagementCompanyTestStudent 
{
	private ManagementCompany company;

    @Before
    public void setUp() 
    {
        // create a new management company with a management fee of 10%
        company = new ManagementCompany("Adrian", "78787", 8);
        
        // add some properties to the company
        company.addProperty("Property1", "Chicago", 2000.0, "Adrian Carrasco", 0, 0, 10, 10);
        company.addProperty("Property2", "Chicago", 3000.0, "Adrian Carrasco", 5, 5, 5, 5);
    }
    
    @Test
    public void testGetMgmtFeePer() 
    {
        assertEquals(8, company.getMgmtFeePer(), 8 );
    }
    
    @Test
    public void testGetName() 
    {
        assertEquals("Adrian", company.getName());
    }
    
    @Test
    public void testGetNumProperties() 
    {
        assertEquals(2, company.getNumProperties());
    }
    
    @Test
    public void testGetProperties() 
    {
        Property[] properties = company.getProperties();
        assertEquals("Property1", properties[0].getPropertyName());
        assertEquals("Property2", properties[1].getPropertyName());
    }
    
    @Test
    public void testGetTotalRent() 
    {
        assertEquals(5000.0, company.getTotalRent(), 0.001);
    }
    
    @Test
    public void testGetHighestRentProperty() 
    {
        Property highestRentProperty = company.getHighestRentProperty();
        assertEquals("Property2", highestRentProperty.getPropertyName());
        assertEquals(3000.0, highestRentProperty.getRentAmount(), 0.001);
    }
    
    @Test
    public void testGetTaxID() 
    {
        assertEquals("78787", company.getTaxID());
    }
    
    @Test
    public void testToString() 
    {
    	double feeTotal = company.getTotalRent() * (company.getMgmtFeePer() / 100);
        assertEquals("List of the properties for Adrian, taxID: 78787\n Property1,Chicago,2000.0,Adrian Carrasco\n"
        		+ "Property2,Chicago,3000.0,Adrian Carrasco\nTotal management Fee: "+ feeTotal + "\n", company.toString());
    }

}
