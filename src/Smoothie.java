/*
 * Class: CMSC203 
 * Instructor:
 * Description: This Smoothie subclass (of Beverage) holds all the values for a smoothie drink.
 * Due: 5/2/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Adrian Carrasco
*/
public class Smoothie extends Beverage 
{
    private final double COST_PER_FRUITS =  0.50;
    private final double COST_OF_PROTEIN = 1.50;
    private int numFruits;
    private boolean hasProtein;

    /**
     * simple constructor of Smoothie instance
     * @param name
     * @param size
     * @param numFruits
     * @param hasProtein
     */
    public Smoothie(String name, Size size, int numFruits, boolean hasProtein) 
    {
        super(name,Type.SMOOTHIE, size);
        this.numFruits = numFruits;
        this.hasProtein = hasProtein;
    }

    /**
     * gets the numValue value
     * @return numFruits
     */
    public int getNumFruits() 
    {
        return numFruits;
    }
    
    /**
     * sets the hasProtein value
     * @return hasProtein
     */
    public boolean getHasProtein() 
    {
        return hasProtein;
    }

    /**
     * sets the numFruits value
     * @param numFruits
     */
    public void setNumFruits(int numFruits) 
    {
        this.numFruits = numFruits;
    }

    /**
     * sets the hasProtein value
     * @param hasProtein
     */
    public void setHasProtein(boolean hasProtein) 
    {
        this.hasProtein = hasProtein;
    }

    /**
     * toString() is a basic formatted string that spits out all the values of this Smoothie instance.
     */
    @Override
    public String toString() 
    {
        String output = super.toString();
    	String addedProtein = getHasProtein() ? "yes" : "no";;
    	
    	output += String.format("Number of Fruits: %d,\nProtein Powder?: %s,\nPrice: $%.2f", numFruits, addedProtein, calcPrice());
    	
        return output;
    }

    /** the equal() methods returns a boolean argument if both smoothie objects are equivalent. 
     * @return isEqual a boolean variable representing if the Smoothie object is equivalent to otherSmoothie.
     */
    @Override
    public boolean equals(Beverage otherSmoothie) 
    {
    	boolean isEqual = false;
        if (otherSmoothie == null || !(otherSmoothie instanceof Smoothie))
            return isEqual;
        
        Smoothie output = (Smoothie) otherSmoothie;
        return super.equals(output) && numFruits == output.getNumFruits() && hasProtein == output.getHasProtein();
    }

    /** calcPrice calculates the price of the current Smoothie depending on size, fruit amount, and protein add-on.
     * @return price this is the total price of the smoothie.
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

        // add fruit amount cost
        price += getNumFruits() * COST_PER_FRUITS;

        // add protein power cost
        if (getHasProtein()) price += COST_OF_PROTEIN;

        return price;
    }
}
