/*
 * Class: CMSC203 
 * Instructor:
 * Description: This Alcohol subclass (of Beverage) holds all the values for an alcoholic drink.
 * Due: 5/2/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/

public class Alcohol extends Beverage 
{
    
    private boolean offeredInWeekend;
    private static final double WEEKEND_PRICE = 0.6;

    /**
     * simple constructor of Coffee instances
     * @param name
     * @param size
     * @param offeredInWeekend
     */
    public Alcohol(String name, Size size, boolean offeredInWeekend) 
    {
        super(name, Type.ALCOHOL, size);
        this.offeredInWeekend = offeredInWeekend;
    }

    /**
     * get offeredInWeekend value
     * @return offeredInWeekend
     */
    public boolean isOfferedInWeekend() 
    {
        return offeredInWeekend;
    }

    /**
     * set offeredInWeekend value
     * @param offeredInWeekend
     */
    public void setOfferedInWeekend(boolean offeredInWeekend) 
    {
        this.offeredInWeekend = offeredInWeekend;
    }

    /** a basic toString method that displays all the values of this Alcohol instance
     * return toString() the formatted string with values
     */
    @Override
    public String toString() 
    {
    	String output = super.toString();
        String weekendOffered = (offeredInWeekend) ? "yes" : "no";
        
        output += String.format("Offered in weekend: %s,\nPrice: $%.2f", weekendOffered, calcPrice());
        return output;
    }

    /** this equals() method checks if the other alcohol instance is equal to the called alcohol instance.
     * @return boolean true, if alcohol instances are equivalent. false, otherwise.
     */
    @Override
    public boolean equals(Beverage other) 
    {
    	if (other == null)
            return false;
        
        Alcohol otherAlcohol = (Alcohol) other;
        return super.equals(otherAlcohol) && offeredInWeekend == otherAlcohol.isOfferedInWeekend();
    }

    /* calcPrice calculates the price of the current Alcohol depending on size and weekend availability.
     * @return price the price of a Alcohol instance
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

        // add weekend cost
        if (isOfferedInWeekend()) price += WEEKEND_PRICE;

        return price;
    }
}
