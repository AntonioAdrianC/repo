import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {
	
	private Order order1, order2;
	private Customer customer;
	
	@Before
	public void setUp() 
	{
		customer = new Customer("Adrian Carrasco", 19);
		order1 = new Order(1, Day.THURSDAY, customer);
		order2 = new Order(9, Day.SUNDAY, customer);

	}

	@Test
	public void testGenerateRandNumber() 
	{
		int number = order1.generateRandNumber();
		assertTrue(number >= 10000 && number <= 90000);
	}
	
	@Test
	public void testAddNewBeverage() 
	{
		order1.addNewBeverage("Latte", Size.MEDIUM, true, false);
		assertEquals(1, order1.getBeverageList().size());
		
		order1.addNewBeverage("Protein Shake", Size.MEDIUM, 0, true);
		assertEquals(2, order1.getBeverageList().size());
		
		order1.addNewBeverage("Alcohol", Size.LARGE);
		assertEquals(3, order1.getBeverageList().size());
	}
	
	@Test
	public void testGetOrderNumber() 
	{
		assertEquals(order1.getOrderNumber(), order1.getOrderNumber());
	}
	
	@Test
	public void testGetOrderTime() 
	{
		assertEquals(order1.getOrderTime(), 1);
	}
	
	@Test
	public void testGetOrderDay() 
	{
		assertEquals(order1.getOrderDay(), Day.THURSDAY);
	}
	
	@Test
	public void testGetCustomer() 
	{
		assertEquals("Adrian Carrasco", order1.getCustomer().getName());
		assertEquals(19, order1.getCustomer().getAge());
	}
	
	@Test
	public void testGetBeverageList() 
	{
		order1.addNewBeverage("Latte", Size.MEDIUM, true, false);
		assertEquals("Latte", order1.getBeverageList().get(0).getName());
	}
	
	@Test
	public void testIsWeekend() 
	{
		assertFalse(order1.isWeekend());
		assertTrue(order2.isWeekend());
	}
	
	@Test
	public void testGetBeverage() 
	{
		order1.addNewBeverage("Latte", Size.MEDIUM, true, false);
		assertEquals(order1.getBeverage(0).getName(), "Latte");
		assertNull(order1.getBeverage(1));
	}
	
	@Test
	public void testCalcOrderTotal() 
	{
		order1.addNewBeverage("Latte", Size.MEDIUM, true, false);
		order1.addNewBeverage("Long island", Size.SMALL);
		assertEquals(order1.calcOrderTotal(), 5.50, 0.01);
	}
}
