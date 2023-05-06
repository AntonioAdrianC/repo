/*
 * Class: CMSC203 
 * Instructor:
 * Description: This Coffee subclass (of Beverage) holds all the values for a coffee drink.
 * Due: 5/2/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/

public class Coffee extends Beverage 
{
    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_COST = 0.5;

    /**
     * simple constructor of Coffee instance
     * @param name
     * @param size
     * @param extraShot
     * @param extraSyrup
     */
    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) 
    {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    /**
     * gets extraShot value
     * @return extraShot
     */
    public boolean getExtraShot() 
    {
        return extraShot;
    }

    /**
     * gets extraSyrup value
     * @return extraSyrup
     */
    public boolean getExtraSyrup() 
    {
        return extraSyrup;
    }
    
    /**
     * sets extraShot value
     * @param extraShot
     */
    public void setExtraShot(boolean extraShot) 
    {
        this.extraShot = extraShot;
    }

    /**
     * sets extraSyrup value
     * @param extraSyrup
     */
    public void setExtraSyrup(boolean extraSyrup) 
    {
        this.extraSyrup = extraSyrup;
    }

    /* calcPrice calculates the price of the current Coffee depending on size, extra shot of espresso, and extra syrup.
     * @return price the price of Coffeee instance.
     */
    @Override
    public double calcPrice() 
    {
        double price = BASE_PRICE;

        // add size cost
        switch (getSize()) 
        {
            case MEDIUM:
                price += SIZE_UP_PRICE;
                break;
            case LARGE:
                price += SIZE_UP_PRICE * 2;
                break;
            default:
                break;
        }

        // add extra shot cost
        if (getExtraShot()) price += EXTRA_COST;

        // add extra syrup cost
        if (getExtraSyrup()) price += EXTRA_COST;

        return price;
    }

    /** a basic toString method that displays all the values of this Coffee instance
     * @return output the formatted string
     */
    @Override
    public String toString() 
    {
    	String output = super.toString();
    	String isExtraShot = getExtraShot() ? "yes" : "no";
    	String isExtraSyrup = getExtraSyrup() ? "yes" : "no";;
    	
    	output += String.format("Extra Shot?: %s,\nExtra Syrup?: %s,\nPrice: $%.2f", isExtraShot, isExtraSyrup, calcPrice());
    	
        return output;
    }

    /**
     * this equals() method checks if the other beverage is equal to the called beverage.
     * @return coffeeEquals if the objects are equivalent, return true. otherwise, return false.
     */
    @Override
    public boolean equals(Beverage other) 
    {
    	if (other == null) 
            return false;
  
        Coffee otherCoffee = (Coffee) other;
        return super.equals(otherCoffee) && extraShot == otherCoffee.getExtraShot() && extraSyrup == otherCoffee.getExtraSyrup();
    }
}
