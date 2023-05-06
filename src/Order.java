import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> 
{

    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverageList;

    public Order(int orderTime, Day orderDay, Customer customer) 
    {
        this.orderNumber = generateRandNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = customer;
        this.beverageList = new ArrayList<>();
    }

    public Order(int orderNum, int orderTime, Day orderDay, Customer customer) 
    {
        this.orderNumber = orderNum;
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = customer;
        this.beverageList = new ArrayList<>();
    }
    
	public int generateRandNumber() 
    {
        Random rand = new Random();
        return rand.nextInt(80001) + 10000;
    }

    @Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
    {
    	try
    	{
			if (beverageList.size() >= 10)
		    	throw new TooManyBeveragesException();
    	} catch(TooManyBeveragesException e)
    	{
    		System.out.println(e.getMessage());
    	} 

    	Coffee outputCoffee = new Coffee(bevName, size, extraShot, extraSyrup);
        beverageList.add(outputCoffee);
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size) 
	{
    	try
    	{
			if (beverageList.size() >= 10)
		    	throw new TooManyBeveragesException();
	        if (customer.getAge() < 21) throw new TooYoungException();       
	        if (findNumOfBeveType(Type.ALCOHOL) >= 3) throw new TooManyAlcoholException();
		} catch(TooManyBeveragesException e)
    	{
    		System.out.println(e.getMessage());
    	} catch(TooManyAlcoholException e)
    	{
    		System.out.println(e.getMessage());
    	} catch(TooYoungException e)
    	{
    		System.out.println(e.getMessage());
    	}        
    	
    	Alcohol outputAlcohol = new Alcohol(bevName, size, isWeekend());
    	beverageList.add(outputAlcohol);
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
    	try
    	{
			if (beverageList.size() >= 10)
		    	throw new TooManyBeveragesException();
    	} catch(TooManyBeveragesException e)
    	{
    		System.out.println(e.getMessage());
    	} 
    	
    	Smoothie outputSmoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
        beverageList.add(outputSmoothie);
		
	}

    public int getOrderNumber() 
    {
        return orderNumber;
    }

    public int getOrderTime() 
    {
        return orderTime;
    }

    public Day getOrderDay() 
    {
        return orderDay;
    }

    public Customer getCustomer() 
    {
        return new Customer(customer.getName(), customer.getAge());
    }

    public ArrayList<Beverage> getBeverageList() 
    {
        return new ArrayList<>(beverageList);
    }

    @Override
    public String toString() 
    {
        String output = String.format("Name: %s,\nAge: &s,\n", customer.getName(), customer.getAge());
        output += String.format("Order Number: %s,\nOrder Time: %s,\nOrderDay: %s", orderNumber, orderTime, orderDay);
        output += "Beverage List: %s\n";
        for(Beverage b : beverageList)
        	output += b.toString();
        
        return output;
    }

    /** this method checks the item numbers of two order instances.
     * return 0, if same. 1, if this.orderNumber is greater. -1, otherwise.
     */
    @Override
    public int compareTo(Order otherBev) 
    {
        if (this.orderNumber == otherBev.getOrderNumber()) 
            return 0;
        else if (this.orderNumber > otherBev.getOrderNumber())
            return 1;
        else 
            return -1;
        
    }

    /** this methods checks if the day of the order instance falls on the weekend.
     * return weekend true, if it is the weekend, false, otherwise
     */
	@Override
	public boolean isWeekend() 
	{
		boolean weekend = false; 
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
			weekend = true;
		return weekend;
	}

	/** this method returns the beverage found on itemNum in beverageList.
	 * @return bev the beverage found at item number. null, if it does not excess.
	 */
	@Override
	public Beverage getBeverage(int itemNo) 
	{
		// searching for item number. if for loop
		try
		{
			return beverageList.get(itemNo);
		} catch(IndexOutOfBoundsException e)
		{
			return null;
		}
	}
	
	/** this method returns the total price of current order.
	 * @return total the total amount the order cost
	 */
	@Override
	public double calcOrderTotal() 
	{
		double total = 0.0;
		for(Beverage b : beverageList)
			total += b.calcPrice();

		return total;
	}
	
	/** this method returns the amount of a specified type within beverageList.
	 * @return total the total amount of beverage with that type
	 */
	@Override
	public int findNumOfBeveType(Type type) 
	{
		int total = 0;
		
		for(Beverage b : beverageList)
			if(b.getType() == type) total++;
		
		return total;
	}

	public int getTotalItems() 
	{
		int total = 0;
		for(Beverage b : beverageList) total++;
		return total;
	}
}
