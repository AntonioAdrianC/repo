import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface {

    private int numOfAlcDrinks;
    private ArrayList<Order> ordersList;
    private double totalMonthlySale;
    private Order currentOrder;

    public BevShop() 
    {
        numOfAlcDrinks = 0;
        ordersList = new ArrayList<>();
        totalMonthlySale = 0;
        currentOrder = null;
    }
    
    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge)
    {
    		
        try
        {
        	if (!isValidTime(time)) 
                throw new IllegalArgumentException("Invalid time: " + time);
            if (!isValidAge(customerAge))
                throw new TooYoungException();
        } catch (IllegalArgumentException e)
        {
        	System.out.println(e);
        } catch (TooYoungException e)
        {
        	System.out.println(e);
        }
        currentOrder = new Order(time, day, new Customer(customerName, customerAge));
        ordersList.add(currentOrder);
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) 
    {
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
    {
    	currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) 
    {
    	try
    	{
		    if (isEligibleForMore()) 
		    {
		    	currentOrder.addNewBeverage(bevName, size);
		    	numOfAlcDrinks++;
		    } else 
		    {
		    	throw new TooManyAlcoholException();
		    }
    	} catch (TooManyAlcoholException e)
    	{
    		System.out.println(e.getMessage());
    	}
        
    }

    @Override
	public void sortOrders() 
	{
    	Collections.sort(ordersList);
				
	}
    
    @Override
    public String toString() 
    {
        String output = "";
        for (Order o : ordersList) {
            output += o.toString() + "\n";
        }
        output += String.format("Total monthly sale: $%.2f", totalMonthlySale);

        return output;
    }

    @Override
    public boolean isValidAge(int age) 
    {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() 
    {
        return getNumOfAlcoholDrink() <= MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isValidTime(int time) 
    {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() 
    {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() 
    {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) 
    {
        return numOfFruits >= MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() 
    {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() 
    {
        return numOfAlcDrinks;
    }

	@Override
	public int findOrder(int orderNo) 
	{
		int index = 0;
		for(Order o : ordersList)
		{
			if(o.getOrderNumber() == orderNo) 
				return index;
			index++;
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) 
	{
		// finding the index of the order with findOrder, then getting it from array list index. calctotal.
		double total = getOrderAtIndex(findOrder(orderNo)).calcOrderTotal();
		return total;
	}

	@Override
	public double totalMonthlySale() 
	{
		double total = 0.0;
		for(Order o : ordersList)
			total += o.calcOrderTotal();
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() 
	{
		int index = 0;
		for(Order o : ordersList) index++;
		
		return index;
	}

	@Override
	public Order getCurrentOrder() 
	{
		return new Order(currentOrder.getOrderNumber(), currentOrder.getOrderTime(), currentOrder.getOrderDay(), currentOrder.getCustomer());
	}

	@Override
	public Order getOrderAtIndex(int index) 
	{
		int i = 0;
		for(Order o : ordersList)
		{
			if(i == index) return o;
			i++;
		}
		return null;
	}

}
