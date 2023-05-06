import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class BevShopTestStudent 
{
    
    private BevShop bevShop;
    
    @Before
    public void setUp() 
    {
        bevShop = new BevShop();
        
    }
    
    @Test
    public void testStartNewOrder() 
    {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        Order currentOrder = bevShop.getCurrentOrder();
        assertEquals(currentOrder.getOrderTime(), 10);
        assertEquals(currentOrder.getOrderDay(), Day.MONDAY);
        assertEquals(currentOrder.getCustomer().getName(), "John");
        assertEquals(currentOrder.getCustomer().getAge(), 25);
    }
    
    @Test
    public void testProcessSmoothieOrder() 
    {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processSmoothieOrder("Strawberry", Size.LARGE, 3, true);
        assertEquals(7.0, bevShop.totalOrderPrice(0), 0.01);
    }
    
    @Test
    public void testProcessCoffeeOrder() 
    {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
        assertEquals(2.50, bevShop.totalOrderPrice(0), 0.01);
    }
    
    @Test
    public void testProcessAlcoholOrder() 
    {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
        assertEquals(3.0 ,bevShop.totalOrderPrice(0), 0.01);
    }
    
    @Test
    public void testSortOrders() 
    {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        int highest = bevShop.getCurrentOrder().getOrderNumber();
        bevShop.startNewOrder(8, Day.TUESDAY, "Jane", 30);
        int lowest = bevShop.getCurrentOrder().getOrderNumber();

        bevShop.sortOrders();        
        if(lowest > highest )
        {
        	int temp = highest;
        	highest = lowest;
        	lowest = temp;
        }
        
        Order expected = bevShop.getOrderAtIndex(1);
        assertEquals(expected, bevShop.getOrderAtIndex(bevShop.findOrder(highest)));
    }
    
    @Test
    public void testTotalMonthlySale() 
    {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processSmoothieOrder("Strawberry", Size.LARGE, 3, true);
        bevShop.startNewOrder(8, Day.TUESDAY, "Jane", 30);
        bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
        double total = bevShop.totalMonthlySale();
        assertEquals(9.5, total, 0.01);
    }
    
    @Test
    public void testTotalNumOfMonthlyOrders() 
    {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.startNewOrder(8, Day.TUESDAY, "Jane", 30);
        int numOrders = bevShop.totalNumOfMonthlyOrders();
        assertEquals(2, numOrders);
    }
    
    @Test
    public void testIsValidAge() 
    {
        assertTrue(bevShop.isValidAge(21));
        assertFalse(bevShop.isValidAge(18));
    }

    @Test
    public void testIsEligibleForMore() 
    {
    	bevShop.startNewOrder(10, Day.FRIDAY, "John", 25);
        bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
        bevShop.processAlcoholOrder("Beer2", Size.MEDIUM);
        assertTrue(bevShop.isEligibleForMore());
        bevShop.processAlcoholOrder("Beer3", Size.MEDIUM);
        bevShop.processAlcoholOrder("Beer4", Size.MEDIUM);

        assertFalse(bevShop.isEligibleForMore());
    }

    @Test
    public void testIsValidTime() 
    {
        assertTrue(bevShop.isValidTime(10));
        assertFalse(bevShop.isValidTime(5));
        assertTrue(bevShop.isValidTime(22));
    }

    @Test
    public void testGetMaxNumOfFruits() 
    {
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() 
    {
        assertEquals(21, bevShop.getMinAgeForAlcohol());
    }

    @Test
    public void testIsMaxFruit() 
    {
        assertTrue(bevShop.isMaxFruit(5));
        assertFalse(bevShop.isMaxFruit(3));
    }

    @Test
    public void testGetMaxOrderForAlcohol() 
    {
        assertEquals(3, bevShop.getMaxOrderForAlcohol());
    }

    @Test
    public void testGetNumOfAlcoholDrink() 
    {
    	bevShop.startNewOrder(10, Day.FRIDAY, "John", 25);
        bevShop.processAlcoholOrder("Beer1", Size.MEDIUM);
        bevShop.processAlcoholOrder("Beer2", Size.MEDIUM);
        assertEquals(2, bevShop.getNumOfAlcoholDrink());
    }

    @Test
    public void testFindOrder() 
    {
    	bevShop.startNewOrder(10, Day.FRIDAY, "John", 25);
    	// the copy messes up the ID
    	Order orderFound = bevShop.getCurrentOrder();
    	
        assertEquals(-1, bevShop.findOrder(000000));
        int orderIndex = bevShop.findOrder(orderFound.getOrderNumber());
        assertEquals(0, orderIndex);
    }

    @Test
    public void testTotalOrderPrice() 
    {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processSmoothieOrder("Banana", Size.SMALL, 1, true);
        assertEquals(4.0, bevShop.totalOrderPrice(0), 0.01);
    }
	
	@Test
	public void testGetCurrentOrder() 
	{
		bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
		assertNotNull(bevShop.getCurrentOrder());
		assertEquals(Day.MONDAY, bevShop.getCurrentOrder().getOrderDay());
	}
	
	@Test
	public void testGetOrderAtIndex() 
	{
		bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
		assertEquals(10, bevShop.getOrderAtIndex(0).getOrderTime());
		assertEquals(Day.MONDAY, bevShop.getOrderAtIndex(0).getOrderDay());
	}


}
